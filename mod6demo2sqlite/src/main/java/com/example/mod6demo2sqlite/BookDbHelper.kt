package com.example.mod6demo2sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BookDbHelper(context: Context) : SQLiteOpenHelper(
    context,
    BookContract.DATABASE_NAME,
    null,
    BookContract.DATABASE_VERSION
) {
    override fun onCreate(
        db: SQLiteDatabase
//        db: SQLiteDatabase? if not mock
    ) {
//        if (db != null) {
        db.execSQL(BookContract.SQL_CREATE_ENTRIES);
//        }
    }

    override fun onUpgrade(
//        db: SQLiteDatabase?,
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL(BookContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}