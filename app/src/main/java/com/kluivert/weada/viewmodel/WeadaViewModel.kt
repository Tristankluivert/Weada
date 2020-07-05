package com.kluivert.weada.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kluivert.weada.repository.WeadaRepo

class WeadaViewModel(application: Application) : AndroidViewModel(application){

    val repo = WeadaRepo(application)
    val showProgress : LiveData<Boolean>

    init {
        this.showProgress = repo.showProgress
    }


    fun currentWeada(location : String){
     repo.currentWeada(location)

    }


}