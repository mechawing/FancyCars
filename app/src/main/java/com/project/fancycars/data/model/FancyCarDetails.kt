package com.project.fancycars.data.model

import android.media.Image

data class FancyCarDetails (
    val id: Integer,
    val img: Image,
    val make: String,
    val model: String,
    val year: Integer
    )