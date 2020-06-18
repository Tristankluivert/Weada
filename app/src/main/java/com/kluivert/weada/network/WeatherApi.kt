package com.kluivert.weada.network

import com.kluivert.weada.data.Current
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "http://api.weatherstack.com/"
const val API_KEY = "fe639f4dae008e046fac9795bbf91e55"

interface WeatherApi {

    @GET(value = "current")
    fun getCurrentWeatherAsync(
        @Query(value = "query") location: String,
        @Query(value = "lang") language: String = "en"
    ): Deferred<Current>

}