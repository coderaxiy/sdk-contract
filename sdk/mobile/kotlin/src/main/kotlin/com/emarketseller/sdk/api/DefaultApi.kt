package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


interface DefaultApi {
    /**
     * GET 
     * Root
     * 
     * Responses:
     *  - 200: Successful Response
     *
     * @return [kotlin.Any]
     */
    @GET("")
    suspend fun rootGet(): Response<kotlin.Any>

}
