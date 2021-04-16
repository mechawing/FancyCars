package com.project.fancycars.ui.fancycar_list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.project.fancycars.R
import com.project.fancycars.data.model.FancyCarAvailability
import com.project.fancycars.data.model.FancyCarDetails
import com.project.fancycars.ui.FancyCarAdapter
import com.project.fancycars.viewmodel.FancyCarViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fancyCarDetailViewmodel by viewModels<FancyCarViewmodel>()

    private lateinit var fancyCarAvailability: FancyCarAvailability
    private val adapter = FancyCarAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fancy_car_recycler_view.adapter = adapter

        //offline data
        fancyCarDetailViewmodel.offlineData.observe(this, Observer{
            updateRecyclerView(it)
        })
        fancyCarDetailViewmodel.getOfflineData()

        //Use MediatorLivedata later
        fancyCarDetailViewmodel.fancyCarDetails.observe(this, Observer {
            updateRecyclerView(it)
        })

    }

    private fun updateRecyclerView(carList: List<FancyCarDetails>) {
        adapter.fancyCarDetailsList = carList
    }

}