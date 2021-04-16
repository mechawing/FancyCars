package com.project.fancycars.data.model

import android.content.Context
import android.util.Log
import com.google.gson.Gson

class MockOffline {
    companion object {
        private val jsonFileName = "response.json"
        fun readData(context: Context): List<FancyCarDetails> {

            var carList = listOf<FancyCarDetails>()
            try {
                val inputStream = context.assets.open(jsonFileName)

                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()

                val jsonString = String(buffer)
                val gson = Gson()

                val carArray = gson.fromJson<Array<FancyCarDetails>>(
                    jsonString,
                    Array<FancyCarDetails>::class.java
                )
                carList = carArray.toList()

            } catch (e: Exception) {
                Log.e("TAG_Error", e.localizedMessage)
            }

            return carList
        }
    }
}