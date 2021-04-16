package com.project.fancycars.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.fancycars.R
import com.project.fancycars.data.model.FancyCarDetails
import kotlinx.android.synthetic.main.fancy_car_row_layout.view.*

class FancyCarAdapter(
        val context: Context
//CarAvailabilityClick
) : RecyclerView.Adapter<FancyCarDetailsViewHolder>()  {

    var fancyCarDetailsList: List<FancyCarDetails> = emptyList()
        set(value) {
            field = value
            //updates the list every time it is set, and notifies observers when changed;
            //also invalidates every item in the recyclerview list
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FancyCarDetailsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fancy_car_row_layout, parent, false)
        return FancyCarDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FancyCarDetailsViewHolder, position: Int) {
        val currentFancyCarDetail = fancyCarDetailsList[position]
        holder.carMake.text = currentFancyCarDetail.make
        Glide.with(context)
                .load(currentFancyCarDetail.img)
                .into(holder.carImage)
    }

    override fun getItemCount(): Int {
        return fancyCarDetailsList.size
    }
}

class FancyCarDetailsViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    var carMake: TextView
    var carImage: ImageView
    //i would have to connect the databinded layout to this viewholder if i did databinding later

    init {
        carMake = view.findViewById(R.id.car_make)
        carImage = view.findViewById(R.id.car_image)
    }

}