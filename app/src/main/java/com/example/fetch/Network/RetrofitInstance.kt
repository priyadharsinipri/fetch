package com.example.fetch.Network

import com.example.fetch.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy{
        Retrofit.Builder().baseUrl(Constants.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build()
    }

    val api :ListApi by lazy{
        retrofit.create(ListApi::class.java)
    }
}