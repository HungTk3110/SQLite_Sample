package com.example.sunshine_recycview_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunshine_recycview_app.models.sunshine;

public class DetailActivity extends AppCompatActivity {
    private com.example.sunshine_recycview_app.models.sunshine sunshine;
    private ImageView imageView;
    private TextView day , weather , hight ,low ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        sunshine = (sunshine) i.getSerializableExtra("object");

        imageView = findViewById(R.id.img);
        day = findViewById(R.id.day);
        weather = findViewById(R.id.weather);
        hight = findViewById(R.id.hightT);
        low = findViewById(R.id.lowT);

        imageView.setImageResource(sunshine.getImg());
        day.setText(sunshine.getDay());
        weather.setText(sunshine.getWeather());
        hight.setText(sunshine.getHightT());
        low.setText(sunshine.getLowT());
    }
}