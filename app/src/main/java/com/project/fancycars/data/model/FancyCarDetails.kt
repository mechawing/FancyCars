package com.project.fancycars.data.model

import android.media.Image

data class FancyCarDetails (
        //TODO: add id so that it's autogenerated when adding Room
    val id: Int,
    val name: String,
    val img: String,
    val make: String,
    val model: String,
    val year: Int
    )