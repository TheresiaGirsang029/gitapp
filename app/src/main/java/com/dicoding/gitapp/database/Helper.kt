package com.dicoding.gitapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.AVATAR_URL
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.COMPANY
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.FOLLOWERS
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.FOLLOWING
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.LOCATION
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.LOGIN
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.NAME
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.REPOSITORY
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.TABLE_NAME

internal class Helper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "dbgitapp"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_TABLE_FAVORITE_USER = "CREATE TABLE $TABLE_NAME" +
                " $LOGIN TEXT PRIMARY KEY," +
                " $NAME TEXT," +
                " $LOCATION TEXT," +
                " $REPOSITORY INTEGER," +
                " $COMPANY TEXT," +
                " $FOLLOWERS INTEGER," +
                " $FOLLOWING INTEGER," +
                " $AVATAR_URL INTEGER)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_FAVORITE_USER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}