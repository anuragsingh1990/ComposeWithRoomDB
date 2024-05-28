package com.v_service.dynamicthemecompose.screen_routes

sealed class LoginNProfileSetupRoutes(val route: String) {
    data object LoginRoute : LoginNProfileSetupRoutes("/login")
}