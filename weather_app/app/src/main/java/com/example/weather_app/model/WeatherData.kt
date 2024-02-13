package com.example.weather_app.model

import com.example.weather_app.utils.Util
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude : Double,
        @Query("lon") longitude : Double,
        @Query("units") units : String,
        @Query("appid") apiKey : String,
    ): CurrentWeather

    companion object {
        var weatherService: ApiInterface? = null


        fun getInstance(): ApiInterface {
            if (weatherService == null) {
                weatherService = Retrofit.Builder()
                    .baseUrl(Util.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiInterface::class.java)
            }

            return weatherService!!
        }

    }

}