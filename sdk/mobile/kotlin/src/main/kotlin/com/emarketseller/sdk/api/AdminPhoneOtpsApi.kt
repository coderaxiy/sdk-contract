package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.AdminOtpRead
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.OtpRevealRead
import com.emarketseller.sdk.model.OtpRevealRequest

interface AdminPhoneOtpsApi {
    /**
     * GET api/v1/admin/auth/phone-otps
     * List Phone Otps
     * Pending phone signup/recovery requests; no codes in list responses. Needs auth:otp:read.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param phone  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<AdminOtpRead>]
     */
    @GET("api/v1/admin/auth/phone-otps")
    suspend fun listPhoneOtpsApiV1AdminAuthPhoneOtpsGet(@Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, @Query("phone") phone: kotlin.String? = null, ): Response<kotlin.collections.List<AdminOtpRead>>

    /**
     * POST api/v1/admin/auth/phone-otps/{challenge_id}/reveal
     * Reveal Phone Otp
     * Audited code reveal for a staff callback to the submitted number. Does not verify the account.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param challengeId 
     * @param otpRevealRequest 
     * @param accessToken  (optional)
     * @return [OtpRevealRead]
     */
    @POST("api/v1/admin/auth/phone-otps/{challenge_id}/reveal")
    suspend fun revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost(@Path("challenge_id") challengeId: java.util.UUID, @Body otpRevealRequest: OtpRevealRequest, ): Response<OtpRevealRead>

}
