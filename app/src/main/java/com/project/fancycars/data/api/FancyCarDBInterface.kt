package com.project.fancycars.data.api

import com.project.fancycars.data.model.FancyCarAvailability
import com.project.fancycars.data.model.FancyCarDetails
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FancyCarDBInterface {

    @GET ("availability")
    fun getFancyCarAvailability(@Query("id") id: Int) : Single<FancyCarAvailability>
    //RESPONSE: {available: “In Dealership”}  // all  options are [ “Out of Stock”, “Unavailable”]

    @GET("cars")
    fun getFancyCarDetails() : Observable<List<FancyCarDetails>>
    //RESPONSE:  [ {id: 1, img: http://myfancycar/image, name: “My Fancy Car”, make: “MyMake”, model: “MyModel”, year: 2018} ….]

}