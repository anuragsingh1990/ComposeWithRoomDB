package com.v_service.dynamicthemecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.v_service.dynamicthemecompose.ui.theme.DynamicThemeComposeTheme
import com.v_service.dynamicthemecompose.ui.theme.spacing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting(
                name = "Android",
                //     modifier = Modifier.padding(innerPadding)
            )

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val theme = remember {
        mutableStateOf(false)
    }
    DynamicThemeComposeTheme(darkTheme = theme.value) {

        Surface(modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
            Scaffold {
                if (theme.value) {
                    Column(
                        modifier = Modifier
                            .background(Color.Red)
                            .padding(it)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Hello $name!",
                            modifier = modifier
                        )
                    }
                } else {
                    Column(
                        modifier = Modifier
                            .background(Color.Yellow)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Hello $name!",
                            modifier = modifier
                        )
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DynamicThemeComposeTheme {
        Greeting("Android")
    }
}