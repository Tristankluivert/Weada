package com.kluivert.weada.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kluivert.weada.repository.MainRepo
import com.kluivert.weada.utils.UnitSystem
import com.kluivert.weada.utils.lazyDeferred


class MainViewModel(application: Application) : AndroidViewModel(application){

    val showProgress : LiveData<Boolean>
    private val repo = MainRepo(application)

    init {
        this.showProgress = repo.showProgress
    }

      fun checkState(){
          repo.checkState()
      }

      fun getLocationName(location : String){
          repo.getLocationName(location)


      }


}
