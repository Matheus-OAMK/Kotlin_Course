package com.example.weather_app.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app.model.ApiInterface
import com.example.weather_app.model.CurrentWeather
import com.example.weather_app.utils.Util
import kotlinx.coroutines.launch

sealed interface WeatherUiState {
    object Loading: WeatherUiState
    object Error: WeatherUiState
    data class Success(val currentWeather: CurrentWeather): WeatherUiState
}


class CurrentWeatherViewModel(): ViewModel() {

    var weatherUiState: WeatherUiState by mutableStateOf<WeatherUiState>(WeatherUiState.Loading)




    fun getCurrentWeather(latitude: Double, longitude: Double) { // Add parameters here


        val units = "metric"
        val apiKey = Util.API_KEY


        viewModelScope.launch {
            var weatherApi = ApiInterface.getInstance()

            try {
                val currentWeatherInfo = weatherApi.getCurrentWeather(latitude, longitude, units , apiKey)
                weatherUiState = WeatherUiState.Success(currentWeatherInfo)


            } catch (e: Exception) {
                weatherUiState = WeatherUiState.Error
            }
        }
    }
}