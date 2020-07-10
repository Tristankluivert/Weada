package com.kluivert.weada.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.kluivert.weada.data.WeatherLocation
import com.kluivert.weada.network.RetrofitInstance
import com.kluivert.weada.network.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeadaRepo()  {

   val showProgress = MutableLiveData<Boolean>()



    fun changeState(){
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }


    fun currentWeada(location: String){

        showProgress.value = true

        RetrofitInstance.api.getCurrentWeather(location)

        /*val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(WeatherApi::class.java)
        service.getCurrentWeather(location,appid).enqueue(object : Callback<List<WeatherLocation>>{
            override fun onFailure(call: Call<List<WeatherLocation>>, t: Throwable) {
            showProgress.value = false
                Toast.makeText(application, "Failed",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<WeatherLocation>>, response: Response<List<WeatherLocation>>) {
                   showProgress.value = false

                Log.d("Repo","Response : ${Gson().toJson(response.body())}")
            }
        })*/




    }





}