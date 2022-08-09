package com.example.sunshine_recycview_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunshine_recycview_app.models.sunshine;

import java.util.List;

public class recycview_adapter extends RecyclerView.Adapter<recycview_adapter.recycview_adapterHolder>{

    private static final int VIEW_TYPE_1 = 1;
    private static final int VIEW_TYPE_2 = 2;
    private clickItemMenu clickItemMenu;

    public interface clickItemMenu{
        void onClickItemMenu(sunshine sunshine);
    }

    private List<sunshine> list;

    public recycview_adapter(List<sunshine> list , clickItemMenu clickItemMenu) {
        this.list = list;
        this.clickItemMenu = clickItemMenu;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return VIEW_TYPE_1;
        else return VIEW_TYPE_2;
    }

    @NonNull
    @Override
    public recycview_adapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = viewType == VIEW_TYPE_1 ? R.layout.item_recycview : R.layout.items_recycview;
        View view = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new recycview_adapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recycview_adapterHolder holder, int position) {
        sunshine sunshine = list.get(position);

        holder.img.setImageResource(sunshine.getImg());
        holder.day.setText(sunshine.getDay());
        holder.weather.setText(sunshine.getWeather());
        holder.hightT.setText(sunshine.getHightT());
        holder.lowT.setText(sunshine.getLowT());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickItemMenu.onClickItemMenu(sunshine);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class recycview_adapterHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView day , weather , hightT , lowT;
        private ConstraintLayout constraintLayout;

        public recycview_adapterHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_items);
            day = itemView.findViewById(R.id.day_items);
            hightT = itemView.findViewById(R.id.hightT_items);
            lowT = itemView.findViewById(R.id.lowT_items);
            weather = itemView.findViewById(R.id.weather_items);
            constraintLayout = itemView.findViewById(R.id.item);
        }
    }
}
