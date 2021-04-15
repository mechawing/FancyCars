package com.project.fancycars.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.fancycars.data.model.FancyCarDetails
import com.project.fancycars.data.repository.FancyCarRepository
import com.project.fancycars.data.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class FancyCarViewmodel() : ViewModel() {
    //create repo here
    val fancyCarRepository = FancyCarRepository()

    private val compositeDisposable = CompositeDisposable()

    val fancyCarDetails : LiveData<List<FancyCarDetails>> by lazy {
        fancyCarRepository.fetchFancyCarDetails(compositeDisposable)
    }

    val networkState : LiveData<NetworkState> by lazy {
        fancyCarRepository.getFancyCarNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}