package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.ChangePasswordRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.LoginRequest
import com.emarketseller.sdk.model.MessageResponse
import com.emarketseller.sdk.model.PasswordResetConfirm
import com.emarketseller.sdk.model.PasswordResetRequest
import com.emarketseller.sdk.model.RegisterRequest
import com.emarketseller.sdk.model.TokenResponse
import com.emarketseller.sdk.model.UpdateProfileRequest
import com.emarketseller.sdk.model.UserRead

interface AuthApi {
    /**
     * POST api/v1/auth/me/password
     * Change My Password
     * Needs the current password (&#x60;400&#x60; if wrong). Every other session is signed out; this one gets a fresh &#x60;access_token&#x60; cookie in the response.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param changePasswordRequest 
     * @param accessToken  (optional)
     * @return [TokenResponse]
     */
    @POST("api/v1/auth/me/password")
    suspend fun changeMyPasswordApiV1AuthMePasswordPost(@Body changePasswordRequest: ChangePasswordRequest, ): Response<TokenResponse>

    /**
     * POST api/v1/auth/password-reset/confirm
     * Confirm Password Reset
     * Public. Sets a new password from the emailed code and signs out every session; the user then logs in normally. &#x60;400 \&quot;Invalid or expired code\&quot;&#x60; covers a wrong, expired or used code, and a code that was guessed wrong too many times.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param passwordResetConfirm 
     * @return [MessageResponse]
     */
    @POST("api/v1/auth/password-reset/confirm")
    suspend fun confirmPasswordResetApiV1AuthPasswordResetConfirmPost(@Body passwordResetConfirm: PasswordResetConfirm): Response<MessageResponse>

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
     * A guest cart (cart_token cookie) is merged into the buyer&#39;s cart and the cookie cleared.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param loginRequest 
     * @param cartToken  (optional)
     * @return [TokenResponse]
     */
    @POST("api/v1/auth/login")
    suspend fun loginApiV1AuthLoginPost(@Body loginRequest: LoginRequest, ): Response<TokenResponse>

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
     * A guest cart (cart_token cookie) is merged into the new account&#39;s cart and the cookie cleared.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param registerRequest 
     * @param cartToken  (optional)
     * @return [UserRead]
     */
    @POST("api/v1/auth/register")
    suspend fun registerApiV1AuthRegisterPost(@Body registerRequest: RegisterRequest, ): Response<UserRead>

    /**
     * POST api/v1/auth/password-reset/request
     * Request Password Reset
     * Public. Emails a 6-digit code valid for 15 minutes. The response is identical whether or not the account exists, so it can&#39;t be used to find out who is registered.
     * Responses:
     *  - 202: Successful Response
     *  - 422: Validation Error
     *
     * @param passwordResetRequest 
     * @return [MessageResponse]
     */
    @POST("api/v1/auth/password-reset/request")
    suspend fun requestPasswordResetApiV1AuthPasswordResetRequestPost(@Body passwordResetRequest: PasswordResetRequest): Response<MessageResponse>

    /**
     * PATCH api/v1/auth/me
     * Update Me
     * Edit my name or saved phone. Email can&#39;t be changed here.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param updateProfileRequest 
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @PATCH("api/v1/auth/me")
    suspend fun updateMeApiV1AuthMePatch(@Body updateProfileRequest: UpdateProfileRequest, ): Response<UserRead>

}
