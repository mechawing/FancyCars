package com.project.fancycars.ui.fancycar_list

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.fancycars.R
import com.project.fancycars.data.model.FancyCarAvailability
import com.project.fancycars.ui.FancyCarAdapter
import com.project.fancycars.viewmodel.FancyCarViewmodel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.jvm.internal.MagicApiIntrinsics

class MainActivity : AppCompatActivity() {
    private val fancyCarDetailViewmodel by lazy {
        ViewModelProviders.of(this).get(FancyCarViewmodel::class.java)
    }

    private lateinit var fancyCarAvailability: FancyCarAvailability

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Use MediatorLivedata later
        fancyCarDetailViewmodel.fancyCarDetails.observe(this, Observer {
            //we get list here
            //set list adapter here
            fancy_car_recycler_view.apply {
                adapter = FancyCarAdapter(this.context)

            }

//            fancyCarDetailViewmodel.fancyCarAvailability.observe

                Log.v("api_response", it[0].make)
        })

    }

}