package com.example.mvvmexample2.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvmexample2.Models.NicePlace
import java.util.ArrayList

class NicePlaceViewModel: ViewModel()  {
    var mNicePlaceList = MutableLiveData<ArrayList<NicePlace>>()
    var newList = ArrayList<NicePlace>()
    fun addNicePlace(nicePlace: NicePlace){
        newList.add(nicePlace)
        mNicePlaceList.value = newList
    }

    fun removeNicePlace(nicePlace: NicePlace){
        newList.remove(nicePlace)
        mNicePlaceList.value = newList
    }
}