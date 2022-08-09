package com.example.sunshine_recycview_app.SQLiteDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WeatherDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + WeatherContract.FeedEntry.TABLE_NAME + " (" +
                    WeatherContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    WeatherContract.FeedEntry.COLUMN_NAME_TYPE + " TEXT," +
                    WeatherContract.FeedEntry.COLUMN_NAME_DATE + " TEXT," +
                    WeatherContract.FeedEntry.COLUMN_NAME_MAX_TEMP + " TEXT," +
                    WeatherContract.FeedEntry.COLUMN_NAME_MIN_TEMP + " TEXT," +
                    WeatherContract.FeedEntry.COLUMN_NAME_IMG + " INTEGER)" ;


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + WeatherContract.FeedEntry.TABLE_NAME;

    public WeatherDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
