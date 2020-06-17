package com.kluivert.weada.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData

class MainRepo(application: Application) {

    val showProgress = MutableLiveData<Boolean>()


    fun checkState(){
        showProgress.value = !(showProgress.value != null && showProgress.value == null)
    }
}