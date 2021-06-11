package com.dicoding.gitapp.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.LOGIN
import com.dicoding.gitapp.database.DatabaseContract.UserColumns.Companion.TABLE_NAME
import java.sql.SQLException

class UserHelper(context: Context) {
    private var databaseHelper: Helper = Helper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME
        private var INSTANCE: UserHelper? = null

        fun getInstance(context: Context): UserHelper =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: UserHelper(context)
                }
    }

    @Throws(SQLException::class)
    fun open() {
        database = databaseHelper.writableDatabase
    }

    fun queryAll(): Cursor {
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                "$LOGIN ASC"
        )
    }

    fun queryById(login: String): Cursor {
        return database.query(DATABASE_TABLE, null, "$LOGIN = ?", arrayOf(login), null, null, null, null)
    }

    fun insert(values: ContentValues?): Long {
        return database.insert(DATABASE_TABLE, null, values)
    }

    fun update(login: String, values: ContentValues?): Int {
        return database.update(DATABASE_TABLE, values, "$LOGIN = ?", arrayOf(login))
    }

    fun deleteById(login: String): Int {
        return database.delete(DATABASE_TABLE, "$LOGIN = '$login'", null)
    }
}