package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.AdminOtpRead
import com.emarketseller.sdk.model.EmailAdditionRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.MessageResponse
import com.emarketseller.sdk.model.OtpChallengeRead
import com.emarketseller.sdk.model.OtpConfirm
import com.emarketseller.sdk.model.OtpRevealRead
import com.emarketseller.sdk.model.OtpRevealRequest
import com.emarketseller.sdk.model.PhoneRecoveryConfirm
import com.emarketseller.sdk.model.PhoneRequest
import com.emarketseller.sdk.model.PhoneSignupRequest
import com.emarketseller.sdk.model.UserRead

interface PhoneAuthApi {
    /**
     * POST api/v1/auth/phone/password-reset/confirm
     * Confirm Phone Recovery
     * password is the new password. Consumes the OTP and invalidates all sessions; login separately.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param phoneRecoveryConfirm 
     * @return [MessageResponse]
     */
    @POST("api/v1/auth/phone/password-reset/confirm")
    suspend fun confirmPhoneRecoveryApiV1AuthPhonePasswordResetConfirmPost(@Body phoneRecoveryConfirm: PhoneRecoveryConfirm): Response<MessageResponse>

    /**
     * POST api/v1/auth/phone/register/confirm
     * Confirm Phone Signup
     * Creates a phone-only buyer after verification. Merges guest cart; login is a separate step.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param otpConfirm 
     * @param cartToken  (optional)
     * @return [UserRead]
     */
    @POST("api/v1/auth/phone/register/confirm")
    suspend fun confirmPhoneSignupApiV1AuthPhoneRegisterConfirmPost(@Body otpConfirm: OtpConfirm, ): Response<UserRead>

    /**
     * POST api/v1/auth/me/email/confirm
     * Confirm Profile Email
     * Attach the verified email. Replacement/removal are not supported by self-service.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param otpConfirm 
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @POST("api/v1/auth/me/email/confirm")
    suspend fun confirmProfileEmailApiV1AuthMeEmailConfirmPost(@Body otpConfirm: OtpConfirm, ): Response<UserRead>

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
     * POST api/v1/auth/phone/password-reset/request
     * Request Phone Recovery
     * Same response for known/unknown numbers. Only active verified-phone accounts reach the staff inbox.
     * Responses:
     *  - 202: Successful Response
     *  - 422: Validation Error
     *
     * @param phoneRequest 
     * @return [OtpChallengeRead]
     */
    @POST("api/v1/auth/phone/password-reset/request")
    suspend fun requestPhoneRecoveryApiV1AuthPhonePasswordResetRequestPost(@Body phoneRequest: PhoneRequest): Response<OtpChallengeRead>

    /**
     * POST api/v1/auth/phone/register/request
     * Request Phone Signup
     * Begin phone/password signup. Staff call the number and relay the OTP; no SMS is sent.
     * Responses:
     *  - 202: Successful Response
     *  - 422: Validation Error
     *
     * @param phoneSignupRequest 
     * @return [OtpChallengeRead]
     */
    @POST("api/v1/auth/phone/register/request")
    suspend fun requestPhoneSignupApiV1AuthPhoneRegisterRequestPost(@Body phoneSignupRequest: PhoneSignupRequest): Response<OtpChallengeRead>

    /**
     * POST api/v1/auth/me/email/request
     * Request Profile Email
     * Add an email to a phone-only account. Remains pending until the emailed code is confirmed.
     * Responses:
     *  - 202: Successful Response
     *  - 422: Validation Error
     *
     * @param emailAdditionRequest 
     * @param accessToken  (optional)
     * @return [OtpChallengeRead]
     */
    @POST("api/v1/auth/me/email/request")
    suspend fun requestProfileEmailApiV1AuthMeEmailRequestPost(@Body emailAdditionRequest: EmailAdditionRequest, ): Response<OtpChallengeRead>

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
