package com.v_service.dynamicthemecompose

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.WhitePoint
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.v_service.dynamicthemecompose.screen_routes.LoginNProfileSetupRoutes
import com.v_service.dynamicthemecompose.ui.theme.DynamicThemeComposeTheme
import com.v_service.dynamicthemecompose.ui.theme.Purple80
import com.v_service.dynamicthemecompose.ui.theme.ThemeColor
import com.v_service.dynamicthemecompose.ui.theme.spacing

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                ThemeColor.toArgb(),
                Purple80.toArgb()
            ),
            navigationBarStyle = SystemBarStyle.auto(
                ThemeColor.toArgb(),
                Purple80.toArgb()
            )
        )
        setContent {
            val showTopBar = remember {
                MutableTransitionState(false)
            }
            val navController = rememberNavController()
            DynamicThemeComposeTheme(dynamicColor = true) {
                Surface {
                    Scaffold(modifier = Modifier.background(ThemeColor),

                        topBar = {
                            AnimatedVisibility(visibleState = showTopBar) {
                                TopAppBar(
                                    title = {
                                        Text(
                                            stringResource(id = R.string.app_name),
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    },
                                    colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.White)
                                )
                            }
                        }) { padding ->
                        MainContatiner(
                            startDestination = LoginNProfileSetupRoutes.LoginRoute.route/*if (introViewed) {
                                if (vehicles.isEmpty())
                                    MyDroomScreens.OnBoardingScreen.route
                                else
                                    MyDroomScreens.DashboardDetailScreen.route
                            } else {
                                MyDroomScreens.MyDroomIntroScreen.route
                            }*/,
                            navController = navController,
                            viewModelStoreOwner = this,
                            toggleToolbarVisibility = {
                                //  showTopBar.targetState = it
                            },
                            modifier = Modifier
                                .padding(padding)
                        )
                        //  Greeting("Android", modifier = Modifier.padding(padding))
                    }
                }
            }

        }
    }

    @Composable
    private fun MainContatiner(
        startDestination: String,
        navController: NavHostController,
        viewModelStoreOwner: MainActivity,
        toggleToolbarVisibility: () -> Unit,
        modifier: Modifier
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier.fillMaxSize()
        ) {

        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


    Column(
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .fillMaxSize()
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DynamicThemeComposeTheme {
        Greeting("Android")
    }
}