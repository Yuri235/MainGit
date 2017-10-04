package com.example.admin_user.dbspinner.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin-user on 03.10.17.
 */




public class DBHelper extends SQLiteOpenHelper {
    private static final int DATA_BASE_VERSION = 1;
    private static final String DATA_BASE_NAME = "ZOO22";

    public static final String TABLE_NAME = "Zoo_Table22";
    public static final String TYPES_ANIMALS = "Types_animals";
    public static final String KEY_ID = "_id";




    public DBHelper(Context context) {
        super(context,DATA_BASE_NAME , null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "("
                + KEY_ID + " integer primary key autoincrement, "
                + TYPES_ANIMALS +" text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exist" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
