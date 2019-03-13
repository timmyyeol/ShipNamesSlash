package com.timmyyeol.shipnamesslash;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "userstore2.db"; //
    private static final int SCHEMA = 1; // версия базы данных
    static final String TABLE = "users";
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LIFES = "lifes";
    public static final String COLUMN_LEVELS = "levels";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE users (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_LIFES
                + " INTEGER, " + COLUMN_LEVELS + " INTEGER);");
        // добавление начальных данных
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_LIFES, "3");
        cv.put(DatabaseHelper.COLUMN_LEVELS, "1");
        db.insert(DatabaseHelper.TABLE, null, cv);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);
    }
}