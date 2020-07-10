package com.kluivert.weada.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.kluivert.weada.data.WeatherLocation
import com.kluivert.weada.repository.WeadaRepo
import com.kluivert.weada.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class WeadaViewModel(val repo: WeadaRepo) : ViewModel(){



    val currentWeather : MutableLiveData<Resource<WeatherLocation>> = MutableLiveData()

    fun getWeather(location : String) = viewModelScope.launch {
         currentWeather.postValue(Resource.Loading())
        val response = repo.currentWeada(location)
       //currentWeather.postValue(handlingWeather(response))
    }

     private fun handlingWeather(response : Response<WeatherLocation> ) :Resource<WeatherLocation>{

         if(response.isSuccessful){
             response.body()?.let {

                 return Resource.Success(it)
             }
         }

         return Resource.Error(response.message())

     }

}