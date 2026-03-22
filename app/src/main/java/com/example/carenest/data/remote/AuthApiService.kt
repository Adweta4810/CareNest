package com.example.carenest.data.remote

import com.example.carenest.data.remote.dto.AuthResponse
import com.example.carenest.data.remote.dto.LoginRequest
import com.example.carenest.data.remote.dto.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<AuthResponse>
}