package com.kluivert.weada.network


import com.kluivert.weada.data.WeatherLocation
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://www.metaweather.com/api/location/"


interface WeatherApi {

    @GET("search?")
    fun getCurrentWeather(
        @Query("query") location: String
    ): Call<List<WeatherLocation>>

}