package com.v_service.dynamicthemecompose.common_widgits

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GTTextField(
    value:String,
    modifier: Modifier = Modifier,
    label: String? = null,
    textColor: Color = Color.White,
    fontSize: TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    fontStyle: FontStyle = FontStyle.Normal,
    singleLine: Boolean = true,
    focusedBorderColor: Color = Color.Gray,
    focusedLabelColor: Color = Color.Gray,
    unFocusedBorderColor: Color = Color.LightGray,
    unFocusedLabelColor: Color = Color.Gray,
    cursorColor: Color = Color.Gray,
    imeAction: ImeAction = ImeAction.Done,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    shape: Shape = MaterialTheme.shapes.small,
    placeHolder: String = "",
    maxLen: Int = -1,
    onValueChange: (String) -> Unit
) {
OutlinedTextField(     value = value,
    onValueChange = {
        if (maxLen > -1) {
            if (it.length <= maxLen)
                onValueChange(it)
        } else {
            onValueChange(it)
        }
    },
    placeholder = {
        Text(
            text = placeHolder,
            style = TextStyle(
               // fontFamily = FontFamily(Font(R.font.cera_pro_regular)),
                fontStyle = fontStyle,
                fontSize = fontSize,
                fontWeight = fontWeight,
                color = Color.LightGray
            )
        )
    },
    label = label?.let {
        {
            Text(
                text = label,
                style = TextStyle(
                  //  fontFamily = FontFamily(Font(R.font.cera_pro_regular)),
                    fontStyle = fontStyle,
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    color = Color.LightGray
                )
            )
        }
    },
    singleLine = singleLine,
    textStyle = TextStyle(
      //  fontFamily = FontFamily(Font(R.font.cera_pro_regular)),
        fontStyle = fontStyle,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = Color.Gray
    ),
    colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = focusedBorderColor,
        unfocusedBorderColor = unFocusedBorderColor,
        focusedLabelColor = focusedLabelColor,
        unfocusedLabelColor = unFocusedLabelColor,
        cursorColor = cursorColor
    ),
    keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = keyboardType,
        imeAction = imeAction,
        capitalization = capitalization
    ),
    keyboardActions = keyboardActions,
    visualTransformation = visualTransformation,
    leadingIcon = leadingIcon,
    trailingIcon = trailingIcon,
    enabled = enabled,
    readOnly = readOnly,
    shape = shape,
    modifier = Modifier
        .fillMaxWidth()
        .then(modifier)
    )
}