package com.v_service.dynamicthemecompose.profile_setup


sealed class ProfileSetupEvents {
    data class TextInputEvent(val value: String, val inputType: InputType) : ProfileSetupEvents()
}

sealed interface InputType {
    data object Phone : InputType
}