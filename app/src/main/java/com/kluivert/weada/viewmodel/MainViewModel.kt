package com.kluivert.weada.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kluivert.weada.repository.MainRepo

class MainViewModel(application: Application) : AndroidViewModel(application) {

   private val mainRepo = MainRepo(application)
    val showProgress : LiveData<Boolean>

    init {
        this.showProgress = mainRepo.showProgress
    }

    fun checkState(){
        mainRepo.checkState()
    }

}