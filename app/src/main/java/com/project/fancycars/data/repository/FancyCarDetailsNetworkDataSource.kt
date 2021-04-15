package com.project.fancycars.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.fancycars.data.api.FancyCarDBClient
import com.project.fancycars.data.api.FancyCarDBInterface
import com.project.fancycars.data.model.FancyCarDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

//this will be our repository
class FancyCarNetworkDataSource (private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _downloadedFancyCarDetailsResponse =  MutableLiveData<List<FancyCarDetails>>()
    val downloadedFancyCarResponse: LiveData<List<FancyCarDetails>>
        get() = _downloadedFancyCarDetailsResponse

    val apiService = FancyCarDBClient.getService(FancyCarDBInterface::class.java)

    //network call
    @SuppressLint("LongLogTag")
    fun fetchFancyCarDetails() {

        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getFancyCarDetails()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedFancyCarDetailsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("FancyCarDetailsDataSource", it.message.toString())
                        }
                    )
            )

        }

        catch (e: Exception){
            Log.e("FancyCarDetailsDataSource",e.message.toString())
        }


    }

    //TODO: Database setup and call to make app work offline
}