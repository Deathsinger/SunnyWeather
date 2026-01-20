package com.example.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Location

class WeatherViewModel : ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()

    val locationLng = ""
    val locationLat = ""
    val placeName = ""

    val weatherLiveData = locationLiveData.switchMap {
        Repository.refreshWeather(it.lng, it.lat)
    }

    fun refreshWeather(lng: String ,lat: String) {
        locationLiveData.value = Location(lng, lat)
    }
}