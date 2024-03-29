@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.weather_app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weather_app.R


@Composable
fun InfoView(navController: NavController) {
    Scaffold (
        topBar = { InfoTopBar(title = stringResource(R.string.app_name) , navController =navController ) },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 10.dp), contentAlignment = Alignment.Center) {
                Text(stringResource(R.string.info_text_about_the_app), style = MaterialTheme.typography.titleLarge)
            }
        }
    )
}


@Composable
fun InfoTopBar(title: String, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                textAlign = TextAlign.Center,
                text = title,
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack,contentDescription = "Back")
            }
        }
    )
}