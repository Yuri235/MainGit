package com.example.admin_user.wordbook.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin-user on 05.10.17.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Word_Book";
    private static final int DB_Version = 1;

    public static final String ID = "_id";
    public static final String TABLE_NAME = "Word_Book_Table";
    public static final String ENGLISH_WORD = "English_word";
    public static final String RUSSIAN_WORD = "Russian_word";






    public DBHelper(Context context) {
        super(context, DB_NAME , null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(" +	ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE," +
                        ENGLISH_WORD + " TEXT NOT NULL," +
                        RUSSIAN_WORD + " TEXT NOT NULL" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop databse" + DB_NAME);

        onCreate(sqLiteDatabase);
    }
}
