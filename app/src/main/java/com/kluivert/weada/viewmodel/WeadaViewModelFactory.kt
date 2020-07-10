package com.kluivert.weada.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kluivert.weada.repository.WeadaRepo

class WeadaViewModelFactory(
    private val repository: WeadaRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeadaViewModel(repository) as T
    }

}