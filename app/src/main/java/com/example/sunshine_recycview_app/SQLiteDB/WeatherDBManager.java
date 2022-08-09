package com.example.sunshine_recycview_app.SQLiteDB;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.sunshine_recycview_app.models.sunshine;

import java.util.ArrayList;
import java.util.List;

public class WeatherDBManager {

    private WeatherDBHelper dbHelper;

    public WeatherDBManager(Context context) {
        this.dbHelper = new WeatherDBHelper(context);
    }

    public void insertWeather(sunshine item){
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(WeatherContract.FeedEntry.COLUMN_NAME_TYPE , item.getWeather());
        values.put(WeatherContract.FeedEntry.COLUMN_NAME_DATE , item.getDay());
        values.put(WeatherContract.FeedEntry.COLUMN_NAME_MAX_TEMP , item.getHightT());
        values.put(WeatherContract.FeedEntry.COLUMN_NAME_MIN_TEMP , item.getLowT());
        values.put(WeatherContract.FeedEntry.COLUMN_NAME_IMG , item.getImg());
        // Insert the new row, returning the primary key value of the new row
        db.insert(WeatherContract.FeedEntry.TABLE_NAME, null, values);
        db.close();
    }

//    public List<sunshine> getWeatherModel (){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                BaseColumns._ID,
//                WeatherContract.FeedEntry.COLUMN_NAME_TYPE,
//                WeatherContract.FeedEntry.COLUMN_NAME_DATE,
//                WeatherContract.FeedEntry.COLUMN_NAME_MAX_TEMP,
//                WeatherContract.FeedEntry.COLUMN_NAME_MIN_TEMP,
//                WeatherContract.FeedEntry.COLUMN_NAME_IMG,
//        };
//
//        // Filter results WHERE "id" = 'inserted id'
//        String selection = WeatherContract.FeedEntry._ID + " = ?";
//        //String[] selectionArgs = {String.valueOf(WeatherContract.FeedEntry._ID)};
//
//        Cursor cursor = db.query(
//                WeatherContract.FeedEntry.TABLE_NAME,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                selection,              // The columns for the WHERE clause
//                null,          // The values for the WHERE clause
//                null,                   // don't group the rows
//                null,                   // don't filter by row groups
//                null               // The sort order
//        );
//        List itemIds = new ArrayList<>();
//        while(cursor.moveToNext()) {
//            long itemId = cursor.getLong(
//                    cursor.getColumnIndexOrThrow(WeatherContract.FeedEntry._ID));
//            itemIds.add(itemId);
//        }
//        cursor.close();
//        return itemIds;
//    }
//

    public List<sunshine> getAll() {
        List<sunshine>  List = new ArrayList<>();
        String query = "SELECT * FROM Weather";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            sunshine sunshine = new sunshine(cursor.getString(cursor.getColumnIndexOrThrow(WeatherContract.FeedEntry.COLUMN_NAME_DATE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(WeatherContract.FeedEntry.COLUMN_NAME_DATE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(WeatherContract.FeedEntry.COLUMN_NAME_MAX_TEMP)),
                    cursor.getString(cursor.getColumnIndexOrThrow(WeatherContract.FeedEntry.COLUMN_NAME_MIN_TEMP)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(WeatherContract.FeedEntry.COLUMN_NAME_IMG)) );
            List.add(sunshine);
            cursor.moveToNext();
        }
        return List;
    }
}
