package com.example.weather_app.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.weather_app.R
import com.example.weather_app.model.Coord
import com.example.weather_app.viewmodel.CurrentWeatherViewModel
import com.example.weather_app.viewmodel.WeatherUiState

@Composable
fun WeatherView(navController : NavController, currentLocation: Coord) {
    Scaffold (
        topBar = { TopBar(title = stringResource(R.string.app_name), navController = navController )},

        content =  {
            Box(modifier = Modifier.padding(it)) {
                WeatherApp(currentLocation)
            }

        }
    )
}


@Composable
fun WeatherApp(currentLocation: Coord, viewModel: CurrentWeatherViewModel = viewModel()) {



    LaunchedEffect(key1 = currentLocation) {
        Log.d("WeatherApp", "Current location: Lat=${currentLocation.lat}, Lon=${currentLocation.lon}")
        viewModel.getCurrentWeather(currentLocation.lat, currentLocation.lon)
    }

    val state = viewModel.weatherUiState

    when (state) {
        is WeatherUiState.Loading -> LoadingView()
        is WeatherUiState.Error -> ErrorView()
        is WeatherUiState.Success -> SuccessView(weatherData = state.currentWeather)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar (title: String, navController: NavController) {
    TopAppBar(
        actions = {
            IconButton(onClick = { navController.navigate( "Info") }) {
                Icon(Icons.Filled.Info, contentDescription = null)
            }
        },
        title = {
            Text(
                textAlign = TextAlign.Center,
                text = title,
                modifier = Modifier.fillMaxWidth()
            )
        }
    )
}