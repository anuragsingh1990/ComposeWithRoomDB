package com.v_service.dynamicthemecompose.profile_setup

import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.v_service.dynamicthemecompose.R
import com.v_service.dynamicthemecompose.common_widgits.GTTextField
import com.v_service.dynamicthemecompose.common_widgits.LoadingButton
import com.v_service.dynamicthemecompose.ui.theme.spacing

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    state: LoginData
) {
    val isLoading = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.medium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GTTextField(value = "", onValueChange = {})
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))
        LoadingButton(
            buttonText = stringResource(id = R.string.login),
            backgroundColor = Color.Black,
            showBorder = false,
            showLoader = isLoading.value
        ) {
            isLoading.value = true
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PreviewLogin() {
    LoginScreen(state = LoginData())
}