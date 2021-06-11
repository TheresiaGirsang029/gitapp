package com.dicoding.gitapp.api

import com.dicoding.gitapp.models.DataUser
import com.dicoding.gitapp.models.DataUserAPI
import com.dicoding.gitapp.models.ItemUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubUsersService {
    @GET("search/users")
    @Headers("Authorization:token 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")

    fun getSearchUsers(
            @Query("q") query: String
    ): Call<DataUserAPI>

    @GET("users/{id}")
    @Headers("Authorization:token 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")

    fun getDetailUser(
            @Path("id") id: String
    ): Call<DataUser>

    @GET("users/{id}/followers")
    @Headers("Authorization:token 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")

    fun getUsersFollowers(
            @Path("id") id: String
    ): Call<List<ItemUser>>

    @GET("users/{id}/following")
    @Headers("Authorization:token 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")

    fun getUsersFollowing(
            @Path("id") id: String
    ): Call<List<ItemUser>>
}