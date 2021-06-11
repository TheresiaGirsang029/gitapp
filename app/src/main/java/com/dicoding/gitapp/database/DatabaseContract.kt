package com.dicoding.gitapp.database

import android.net.Uri
import android.provider.BaseColumns

object DatabaseContract {

    const val AUTHORITY = "com.dicoding.gitapp"
    const val SCHEME = "content"

    class UserColumns: BaseColumns {
        companion object {
            const val TABLE_NAME = "user_favorite"
            const val LOGIN = "login"
            const val NAME = "name"
            const val LOCATION = "location"
            const val REPOSITORY = "repository"
            const val COMPANY = "company"
            const val FOLLOWERS = "followers"
            const val FOLLOWING = "following"
            const val AVATAR_URL = "avatar_url"

            val CONTENT_URI: Uri = Uri.Builder().scheme(SCHEME)
                    .authority(AUTHORITY)
                    .appendPath(TABLE_NAME)
                    .build()
        }
    }

}