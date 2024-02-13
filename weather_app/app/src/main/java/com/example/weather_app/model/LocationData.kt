package com.example.weather_app.model

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationData(private val context: Context) : LiveData<Coord>() {

    private var fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    override fun onActive() {
        super.onActive()
        getLocationData()
    }

    private fun getLocationData() {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }

         fusedLocationClient.lastLocation
        .addOnSuccessListener { location ->
           location.also { setLocationData(it) }
        }
    }

    private fun setLocationData(location: Location?) {
        location?.let {
            value = Coord(it.latitude, it.longitude)
        }
    }
}