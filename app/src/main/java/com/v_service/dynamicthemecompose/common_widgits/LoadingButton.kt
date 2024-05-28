package com.v_service.dynamicthemecompose.common_widgits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.v_service.dynamicthemecompose.ui.theme.ThemeColor
import com.v_service.dynamicthemecompose.ui.theme.Typography

@Composable
fun LoadingButton(
    buttonText: String,
    backgroundColor: Color,
    contentColor: Color = White,
    showLoader: Boolean = false,
    showBorder: Boolean,
    onClick: () -> Unit,
) {
    if (showLoader) {
        Row(
            modifier = Modifier
                .widthIn(max = 48.dp)
                .fillMaxWidth()
                .height(48.dp)
                .onClickCallback { onClick() }
                .background(backgroundColor, RoundedCornerShape(50.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(color = ThemeColor, modifier = Modifier.size(28.dp))
        }
    } else {
        Row(
            modifier = Modifier
                .widthIn(max = 600.dp)
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .height(48.dp)
                .onClickCallback { onClick() } // motionClickEvent is my custom click modifier, use clickable modifier over here
                .background(backgroundColor, RoundedCornerShape(50.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = buttonText,
                style = Typography.titleMedium,
                color = contentColor,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    }
}
@Preview
@Composable
fun PreviewLoadingButton(){
    LoadingButton(buttonText = "Login", backgroundColor = Black, showBorder = true, showLoader = true) {

    }
}