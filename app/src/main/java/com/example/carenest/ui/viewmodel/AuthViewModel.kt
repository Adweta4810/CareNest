package com.example.carenest.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carenest.data.remote.RetrofitClient
import com.example.carenest.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val repository = AuthRepository(RetrofitClient.authApiService)

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _uiState.value = AuthUiState(error = "Email and password are required")
            return
        }

        viewModelScope.launch {
            _uiState.value = AuthUiState(isLoading = true)

            val result = repository.login(email, password)

            result.onSuccess { response ->
                if (response.success) {
                    _uiState.value = AuthUiState(
                        isSuccess = true,
                        message = response.message
                    )
                } else {
                    _uiState.value = AuthUiState(
                        error = response.message
                    )
                }
            }.onFailure { e ->
                _uiState.value = AuthUiState(
                    error = e.message ?: "Something went wrong"
                )
            }
        }
    }

    fun register(name: String, email: String, password: String, confirmPassword: String) {
        if (name.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            _uiState.value = AuthUiState(error = "All fields are required")
            return
        }

        if (password != confirmPassword) {
            _uiState.value = AuthUiState(error = "Passwords do not match")
            return
        }

        viewModelScope.launch {
            _uiState.value = AuthUiState(isLoading = true)

            val result = repository.register(name, email, password)

            result.onSuccess { response ->
                if (response.success) {
                    _uiState.value = AuthUiState(
                        isSuccess = true,
                        message = response.message
                    )
                } else {
                    _uiState.value = AuthUiState(
                        error = response.message
                    )
                }
            }.onFailure { e ->
                _uiState.value = AuthUiState(
                    error = e.message ?: "Something went wrong"
                )
            }
        }
    }

    fun clearState() {
        _uiState.value = AuthUiState()
    }
}