package com.example.mod7demo1retrofitapi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("/v1/forecast")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String,
        @Query("hourly") hourly: String
    ): WeatherResponse;


    companion object {
        private val BASE_URL = "https://api.open-meteo.com/";

        private val moshi by lazy {
//            instance of Moshi
            Moshi.Builder().add(KotlinJsonAdapterFactory()).build();
        }

        val weatherApiService: WeatherApiService by lazy {
//            instance of service
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(WeatherApiService::class.java)
        }
    }
}