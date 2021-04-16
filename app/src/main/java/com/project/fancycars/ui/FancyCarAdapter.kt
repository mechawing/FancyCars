package com.project.fancycars.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.fancycars.R
import com.project.fancycars.data.model.FancyCarDetails
import kotlinx.android.synthetic.main.fancy_car_row_layout.view.*

class FancyCarAdapter : RecyclerView.Adapter<FancyCarDetailsViewHolder>() {

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
        holder.view.car_make.text = currentFancyCarDetail.make
        holder.view.car_year.text = "Release Year: ${currentFancyCarDetail.year}"
        holder.view.car_model.text = currentFancyCarDetail.model

        Glide.with(holder.view.context)
            .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
            .load(currentFancyCarDetail.img)
            .placeholder(R.drawable.ic_car)
            .into(holder.view.car_image)
    }

    override fun getItemCount(): Int {
        return fancyCarDetailsList.size
    }
}

class FancyCarDetailsViewHolder(val view: View) : RecyclerView.ViewHolder(view)