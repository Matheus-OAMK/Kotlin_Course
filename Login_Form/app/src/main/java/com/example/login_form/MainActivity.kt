package com.example.login_form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login_form.ui.theme.Login_FormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login_FormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {

    var usernameInput by remember { mutableStateOf("")}
    var passwordInput by remember { mutableStateOf("")}

    Column (modifier = Modifier.padding(start = 16.dp, end = 16.dp).fillMaxHeight()) {

        Text(
            text = "Login",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding( top = 16.dp, start = 16.dp),

        )
        OutlinedTextField(
            value = usernameInput,
            onValueChange = { usernameInput = it},
            label = { Text( "Username")},
            singleLine = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person Icon"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = passwordInput,
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {passwordInput = it},
            label = { Text( "Password")},
            singleLine = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Lock Icon"
                )
            },
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp  )
        )
        
        Button(

            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(
                text = "Submit",
                fontSize = 20.sp,


            )

        }

    }

}

