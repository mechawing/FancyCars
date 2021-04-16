package com.project.fancycars.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.fancycars.data.model.FancyCarDetails
import com.project.fancycars.data.model.MockOffline
import com.project.fancycars.data.repository.FancyCarRepository
import com.project.fancycars.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class FancyCarViewmodel(application: Application) : AndroidViewModel(application) {
    //create repo here
    val fancyCarRepository = FancyCarRepository()

    val offlineData = MutableLiveData<List<FancyCarDetails>>()

    private val compositeDisposable = CompositeDisposable()

    val fancyCarDetails : LiveData<List<FancyCarDetails>> by lazy {
        fancyCarRepository.fetchFancyCarDetails(compositeDisposable)
    }

    fun getOfflineData(){
        offlineData.value = MockOffline.readData(getApplication())
    }

    val networkState : LiveData<NetworkState> by lazy {
        fancyCarRepository.getFancyCarNetworkState()
    }

//    val fancyCarAvailability :

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}