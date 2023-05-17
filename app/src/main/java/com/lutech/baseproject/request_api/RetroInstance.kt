package com.lutech.baseproject.request_api

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object {

        var baseUrl = "https://gorest.co.in/public/v2/"


        fun getRetrofitInstance(): Retrofit {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder().baseUrl(baseUrl).client(client.build())
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}