package com.recepgemalmaz.pazara_bootcamp_odev_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.recepgemalmaz.pazara_bootcamp_odev_1.ui.theme.Pazara_Bootcamp_Odev_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                LoginScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val databaseEmail: String = "recepgemalmaz@gmail.com"
    val databasePassword: String = "123456"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Gmail") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Şifre") },


            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                if (email == databaseEmail && password == databasePassword) {
                    //giris basarili
                    Toast.makeText(context, "Giriş Başarılı", Toast.LENGTH_SHORT).show()
                }
                else if (email != databaseEmail && password == databasePassword) {
                    //email hatali
                    Toast.makeText(context, "Email Hatalı", Toast.LENGTH_SHORT).show()
                }
                else if (email == databaseEmail && password != databasePassword) {
                    //sifre hatali
                    Toast.makeText(context, "Şifre Hatalı", Toast.LENGTH_SHORT).show()
                }
                else {
                    //giris basarisiz
                    Toast.makeText(context, "Giriş Başarısız Email ve Sifre Hatali", Toast.LENGTH_SHORT).show()
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Giriş")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GretingPreview() {
    LoginScreen()
}
