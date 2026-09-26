package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.UploadPurpose
import com.emarketseller.sdk.model.UploadRead

import okhttp3.MultipartBody

interface UploadsApi {
    /**
     * POST api/v1/uploads
     * Create Upload
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param purpose 
     * @param file 
     * @param accessToken  (optional)
     * @return [UploadRead]
     */
    @Multipart
    @POST("api/v1/uploads")
    suspend fun createUploadApiV1UploadsPost(@Query("purpose") purpose: UploadPurpose, @Part file: MultipartBody.Part, ): Response<UploadRead>

}
