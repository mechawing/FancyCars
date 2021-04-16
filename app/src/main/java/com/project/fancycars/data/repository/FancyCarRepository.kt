package com.project.fancycars.data.repository

import androidx.lifecycle.LiveData
import com.project.fancycars.data.model.FancyCarAvailability
import com.project.fancycars.data.model.FancyCarDetails
import io.reactivex.disposables.CompositeDisposable

class FancyCarRepository () {

    lateinit var fancyCarNetworkDataSource: FancyCarNetworkDataSource

    fun fetchFancyCarDetails (compositeDisposable: CompositeDisposable) : LiveData<List<FancyCarDetails>> {

        fancyCarNetworkDataSource = FancyCarNetworkDataSource(compositeDisposable)
        fancyCarNetworkDataSource.fetchFancyCarDetails()

        return fancyCarNetworkDataSource.downloadedFancyCarResponse
    }

    fun getFancyCarNetworkState(): LiveData<NetworkState> {
        return fancyCarNetworkDataSource.networkState
    }

    //fetchFAncyCarAvailtiy(id: sTring)

}