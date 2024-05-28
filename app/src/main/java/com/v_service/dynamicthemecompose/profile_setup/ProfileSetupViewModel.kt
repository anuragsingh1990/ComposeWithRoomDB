package com.v_service.dynamicthemecompose.profile_setup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileSetupViewModel @Inject constructor() : ViewModel() {
    private val _uiLoginState = MutableStateFlow(
        LoginData()
    )
    val uiLoginState: StateFlow<LoginData> = _uiLoginState
    private fun onEvent(e: ProfileSetupEvents) {
        when (e) {
            is ProfileSetupEvents.TextInputEvent -> {
                handleInputEvent(e.inputType, e.value)
            }
        }
    }

    private fun handleInputEvent(inputType: InputType, value: String) {
        when (inputType) {
            is InputType.Phone -> {
                _uiLoginState.update {
                    it.copy(
                        phone = value
                    )
                }
            }
        }

    }
}