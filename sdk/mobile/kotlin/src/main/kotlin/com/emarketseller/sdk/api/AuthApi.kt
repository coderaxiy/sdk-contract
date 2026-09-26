package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.LoginRequest
import com.emarketseller.sdk.model.RegisterRequest
import com.emarketseller.sdk.model.TokenResponse
import com.emarketseller.sdk.model.UserRead

interface AuthApi {
    /**
     * GET api/v1/auth/me
     * Get Me
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @GET("api/v1/auth/me")
    suspend fun getMeApiV1AuthMeGet(): Response<UserRead>

    /**
     * POST api/v1/auth/login
     * Login
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param loginRequest 
     * @return [TokenResponse]
     */
    @POST("api/v1/auth/login")
    suspend fun loginApiV1AuthLoginPost(@Body loginRequest: LoginRequest): Response<TokenResponse>

    /**
     * POST api/v1/auth/logout
     * Logout
     * 
     * Responses:
     *  - 200: Successful Response
     *
     * @return [kotlin.Any]
     */
    @POST("api/v1/auth/logout")
    suspend fun logoutApiV1AuthLogoutPost(): Response<kotlin.Any>

    /**
     * POST api/v1/auth/register
     * Register
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param registerRequest 
     * @return [UserRead]
     */
    @POST("api/v1/auth/register")
    suspend fun registerApiV1AuthRegisterPost(@Body registerRequest: RegisterRequest): Response<UserRead>

}
