package com.dicoding.gitapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private const val BASE_URL = "https://api.github.com/"

    fun userRepositories(): GithubUsersService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(GithubUsersService::class.java)
    }
}