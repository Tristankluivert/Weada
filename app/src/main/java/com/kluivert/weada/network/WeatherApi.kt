package com.kluivert.weada.network


import com.kluivert.weada.data.WeatherLocation
import com.kluivert.weada.utils.Constants.Companion.APP_ID
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query




interface WeatherApi {

    @GET("weather?")
    fun getCurrentWeather(
        @Query("q") location: String,
     @Query("appid") appid : String = APP_ID
    ): Response<WeatherLocation>



}