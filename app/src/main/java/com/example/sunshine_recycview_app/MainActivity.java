package com.example.sunshine_recycview_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sunshine_recycview_app.SQLiteDB.WeatherDBHelper;
import com.example.sunshine_recycview_app.SQLiteDB.WeatherDBManager;
import com.example.sunshine_recycview_app.models.sunshine;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //putDataToDB();
        recyclerView  = findViewById(R.id.recycview);


        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        com.example.sunshine_recycview_app.recycview_adapter recycview_adapter = new recycview_adapter(getlist(), new recycview_adapter.clickItemMenu() {
            @Override
            public void onClickItemMenu(sunshine sunshine) {
                goToDetailActivity(sunshine);
            }
        });
        recyclerView.setAdapter(recycview_adapter);

    }


    private void goToDetailActivity(sunshine sunshine) {
        startActivity(new Intent(this,DetailActivity.class).putExtra("object",sunshine));
    }

    private void putDataToDB() {
        WeatherDBManager dbManager = new WeatherDBManager(this);
        List<sunshine> list = new ArrayList<>();
        list.add(new sunshine("Hôm nay", "Có nắng", "34°", "26°", R.drawable.art_clear));
        list.add(new sunshine("Ngày mai", "Có mưa", "30°", "24°", R.drawable.art_light_rain));
        list.add(new sunshine("thứ tư", "Hưởng nắng", "32°", "26°", R.drawable.art_light_clouds));
        list.add(new sunshine("thứ năm", "Mưa Rông", "29°", "26°", R.drawable.art_rain));
        list.add(new sunshine("thứ sáu", "Trời lạnh", "10°", "2°", R.drawable.art_snow));
        for (int i = 0; i < list.size(); i++) {
            dbManager.insertWeather(list.get(i));
            //}
        }
    }
    private List<sunshine> getlist() {

        WeatherDBManager dbManager = new WeatherDBManager(MainActivity.this);
        return  dbManager.getAll();
    }
}