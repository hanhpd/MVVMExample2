package com.example.mvvmexample2.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NicePlaceViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NicePlaceViewModel::class.java)){
            return NicePlaceViewModel() as T
        }
        throw  IllegalAccessException("UnknowViewModel")
    }
}