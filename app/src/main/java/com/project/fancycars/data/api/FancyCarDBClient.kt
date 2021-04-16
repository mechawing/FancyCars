package com.project.fancycars.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//not given the base url, so assuming this is right
const val BASE_URL = "http://myfancycar"

object FancyCarDBClient {

    //singleton instance of Retrofit client, making it thread safe as well
    @Volatile
    private var INSTANCE: Retrofit? = null

    //returns the retrofit instance
    fun getClient(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return INSTANCE ?: synchronized(this) {
            val temp = Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            INSTANCE = temp
           temp
        }
//            .create(FancyCarDBInterface::class.java)
    }
    //this will return the service I want
    fun<T> getService(service: Class<T>): T{
        return getClient().create(service)
    }

}

