package com.project.fancycars.data.model

import android.media.Image

data class FancyCarDetails (
    val id: Int,
    val img: Image,
    val make: String,
    val model: String,
    val year: Int
    )