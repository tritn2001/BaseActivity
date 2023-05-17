package com.lutech.baseproject.request_api

import com.lutech.baseproject.model.User
import com.lutech.baseproject.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getListUser(): Call<List<User>>

    @GET("users")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json"
    )
    fun searchUser(@Query("name") searchText: String): Call<List<User>>


    @GET("users/{id}")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json"
    )
    fun getUserByID(@Path("id") id: String): Call<User>


    @POST("users")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 61e948fe775c8f19f9c47f54f908a901828938b0b243c60f1a9d6367eebb2b7b"
    )
    fun createUser(@Body param: User): Call<User>

    @PATCH("users/{id}")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 61e948fe775c8f19f9c47f54f908a901828938b0b243c60f1a9d6367eebb2b7b"
    )
    fun updateUser(@Path("id") userID: String, @Body param: User): Call<User>

    @DELETE("users/{id}")
    @Headers(
        "Accept:application/json",
        "Content-Type:application/json",
        "Authorization: Bearer 61e948fe775c8f19f9c47f54f908a901828938b0b243c60f1a9d6367eebb2b7b"
    )
    fun deleteUser(@Path("id") userID: String): Call<User>

}