package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.DeviceRead
import com.emarketseller.sdk.model.DeviceRegisterRequest
import com.emarketseller.sdk.model.HTTPValidationError

interface NotificationsApi {
    /**
     * PUT api/v1/devices
     * Register Device
     * Register (or refresh) this phone&#39;s push token for the logged-in user. Call it after login and whenever the token or the app language changes. A token already registered to another account moves to this one.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param deviceRegisterRequest 
     * @param accessToken  (optional)
     * @return [DeviceRead]
     */
    @PUT("api/v1/devices")
    suspend fun registerDeviceApiV1DevicesPut(@Body deviceRegisterRequest: DeviceRegisterRequest, ): Response<DeviceRead>

    /**
     * DELETE api/v1/devices
     * Unregister Device
     * Stop pushes to this phone for the logged-in user. Call it **before** &#x60;POST /auth/logout&#x60;. Unknown tokens, and tokens of another user, are ignored (&#x60;204&#x60; either way).
     * Responses:
     *  - 204: Successful Response
     *  - 422: Validation Error
     *
     * @param token 
     * @param accessToken  (optional)
     * @return [Unit]
     */
    @DELETE("api/v1/devices")
    suspend fun unregisterDeviceApiV1DevicesDelete(@Query("token") token: kotlin.String, ): Response<Unit>

}
