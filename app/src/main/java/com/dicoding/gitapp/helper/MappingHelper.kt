package com.dicoding.gitapp.helper

import android.database.Cursor
import com.dicoding.gitapp.database.DatabaseContract
import com.dicoding.gitapp.models.DataUser

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<DataUser> {
        val notesList = ArrayList<DataUser>()

        notesCursor?.apply {
            while (moveToNext()) {
                val login = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.LOGIN))
                val name = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.NAME))
                val location = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.LOCATION))
                val repository = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.REPOSITORY))
                val company = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.COMPANY))
                val followers = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWERS))
                val following = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.FOLLOWING))
                val avatar_url = getString(getColumnIndexOrThrow(DatabaseContract.UserColumns.AVATAR_URL))
                notesList.add(DataUser(avatar_url, login, name, location, repository, company, followers, following))
            }
        }

        return notesList
    }
}