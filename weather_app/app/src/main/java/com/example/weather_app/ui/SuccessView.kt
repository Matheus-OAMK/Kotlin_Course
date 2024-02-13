package com.example.weather_app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weather_app.model.CurrentWeather

@Composable
fun SuccessView(weatherData: CurrentWeather) {
    val iconCode = weatherData.weather.firstOrNull()?.icon
    // Replace with your desired UI layout and data presentation
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "${weatherData.name} ${weatherData.main.temp} °C",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "${weatherData.weather.firstOrNull()?.description}",
            style = MaterialTheme.typography.headlineMedium
        )

        WeatherIcon(iconCode)


        Divider(
            color = Color.DarkGray,
            thickness = 0.2.dp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
        )

        Text(
            text = "Temperature (min / max)",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 5.dp)
        )


        Text(
            text = "${weatherData.main.temp_min} / ${weatherData.main.temp_max} °C",
            style = MaterialTheme.typography.bodyMedium,

            )

        Divider(
            color = Color.DarkGray,
            thickness = 0.2.dp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
        )


        Text(
            text = "Wind",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 5.dp)
        )

        Text(
            text = "${weatherData.wind.speed} m/s",
            style = MaterialTheme.typography.bodyMedium,

            )

        Divider(
            color = Color.DarkGray,
            thickness = 0.2.dp,
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
        )

        Text(
            text = "Humidity",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 5.dp)
        )

        Text(
            text = "${weatherData.main.humidity} %",
            style = MaterialTheme.typography.bodyMedium,
        )




    }

}


@Composable
fun WeatherIcon(iconCode: String?) {
    val iconUrl = "https://openweathermap.org/img/wn/$iconCode@2x.png"

    AsyncImage(
        model = iconUrl,
        contentDescription = "Weather Icon",
        modifier = Modifier.size(80.dp)
    )
}