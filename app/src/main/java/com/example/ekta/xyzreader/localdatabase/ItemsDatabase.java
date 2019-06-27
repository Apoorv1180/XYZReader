package com.example.ekta.xyzreader.localdatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemsDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "xyzreader.db";
    private static final int DATABASE_VERSION = 2;

    public ItemsDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ItemsProvider.Tables.ITEMS + " ("
                + ItemsContractField.ItemsColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ItemsContractField.ItemsColumns.SERVER_ID + " TEXT,"
                + ItemsContractField.ItemsColumns.TITLE + " TEXT NOT NULL,"
                + ItemsContractField.ItemsColumns.AUTHOR + " TEXT NOT NULL,"
                + ItemsContractField.ItemsColumns.BODY + " TEXT NOT NULL,"
                + ItemsContractField.ItemsColumns.THUMB_URL + " TEXT NOT NULL,"
                + ItemsContractField.ItemsColumns.PHOTO_URL + " TEXT NOT NULL,"
                + ItemsContractField.ItemsColumns.ASPECT_RATIO + " REAL NOT NULL DEFAULT 1.5,"
                + ItemsContractField.ItemsColumns.PUBLISHED_DATE + " TEXT NOT NULL"
                + ")" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ItemsProvider.Tables.ITEMS);
        onCreate(db);
    }
}
