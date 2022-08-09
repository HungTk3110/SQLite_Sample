package com.example.sunshine_recycview_app.SQLiteDB;

import android.provider.BaseColumns;

public class WeatherContract {

    public WeatherContract() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "Weather";
        public static final String COLUMN_NAME_TYPE = "weather_type";
        public static final String COLUMN_NAME_DATE = "address";
        public static final String COLUMN_NAME_MAX_TEMP = "max_temp";
        public static final String COLUMN_NAME_MIN_TEMP = "min_temp";
        public static final String COLUMN_NAME_IMG = "img";
    }
}
