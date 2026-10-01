package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.BankAccountCreateRequest
import com.emarketseller.sdk.model.BankAccountRead
import com.emarketseller.sdk.model.DocumentRead
import com.emarketseller.sdk.model.DocumentReviewRequest
import com.emarketseller.sdk.model.DocumentSubmitRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.SellerAdminRead
import com.emarketseller.sdk.model.SellerRead
import com.emarketseller.sdk.model.SellerRegisterRequest
import com.emarketseller.sdk.model.SellerUpdateRequest
import com.emarketseller.sdk.model.StatusReasonRequest
import com.emarketseller.sdk.model.UpdateShopLimitRequest

interface SellersApi {
    /**
     * POST api/v1/seller/bank-accounts
     * Add Bank Account
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param bankAccountCreateRequest 
     * @param accessToken  (optional)
     * @return [BankAccountRead]
     */
    @POST("api/v1/seller/bank-accounts")
    suspend fun addBankAccountApiV1SellerBankAccountsPost(@Body bankAccountCreateRequest: BankAccountCreateRequest, ): Response<BankAccountRead>

    /**
     * PATCH api/v1/admin/sellers/{seller_id}/approve
     * Approve Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @PATCH("api/v1/admin/sellers/{seller_id}/approve")
    suspend fun approveSellerApiV1AdminSellersSellerIdApprovePatch(@Path("seller_id") sellerId: kotlin.Int, ): Response<SellerRead>

    /**
     * PATCH api/v1/admin/sellers/{seller_id}/ban
     * Ban Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param statusReasonRequest 
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @PATCH("api/v1/admin/sellers/{seller_id}/ban")
    suspend fun banSellerApiV1AdminSellersSellerIdBanPatch(@Path("seller_id") sellerId: kotlin.Int, @Body statusReasonRequest: StatusReasonRequest, ): Response<SellerRead>

    /**
     * GET api/v1/admin/sellers/{seller_id}
     * Get Seller Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param accessToken  (optional)
     * @return [SellerAdminRead]
     */
    @GET("api/v1/admin/sellers/{seller_id}")
    suspend fun getSellerAdminApiV1AdminSellersSellerIdGet(@Path("seller_id") sellerId: kotlin.Int, ): Response<SellerAdminRead>

    /**
     * GET api/v1/seller/me
     * Get Seller Me
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @GET("api/v1/seller/me")
    suspend fun getSellerMeApiV1SellerMeGet(): Response<SellerRead>

    /**
     * GET api/v1/seller/bank-accounts
     * List My Bank Accounts
     * My accounts plus those of my shops with their own legal entity. Account numbers are never returned.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<BankAccountRead>]
     */
    @GET("api/v1/seller/bank-accounts")
    suspend fun listMyBankAccountsApiV1SellerBankAccountsGet(): Response<kotlin.collections.List<BankAccountRead>>

    /**
     * GET api/v1/seller/documents
     * List My Documents
     * My documents, newest first, with review status and rejection reason.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId Only this shop&#39;s own documents (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<DocumentRead>]
     */
    @GET("api/v1/seller/documents")
    suspend fun listMyDocumentsApiV1SellerDocumentsGet(@Query("shop_id") shopId: kotlin.Int? = null, ): Response<kotlin.collections.List<DocumentRead>>

    /**
     * GET api/v1/admin/sellers/{seller_id}/documents
     * List Seller Documents
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<DocumentRead>]
     */
    @GET("api/v1/admin/sellers/{seller_id}/documents")
    suspend fun listSellerDocumentsApiV1AdminSellersSellerIdDocumentsGet(@Path("seller_id") sellerId: kotlin.Int, ): Response<kotlin.collections.List<DocumentRead>>

    /**
     * GET api/v1/admin/sellers
     * List Sellers
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param search  (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<SellerRead>]
     */
    @GET("api/v1/admin/sellers")
    suspend fun listSellersApiV1AdminSellersGet(@Query("status") status: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<SellerRead>>

    /**
     * POST api/v1/seller/register
     * Register Seller
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerRegisterRequest 
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @POST("api/v1/seller/register")
    suspend fun registerSellerApiV1SellerRegisterPost(@Body sellerRegisterRequest: SellerRegisterRequest, ): Response<SellerRead>

    /**
     * PATCH api/v1/admin/sellers/{seller_id}/reinstate
     * Reinstate Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @PATCH("api/v1/admin/sellers/{seller_id}/reinstate")
    suspend fun reinstateSellerApiV1AdminSellersSellerIdReinstatePatch(@Path("seller_id") sellerId: kotlin.Int, ): Response<SellerRead>

    /**
     * PATCH api/v1/admin/sellers/{seller_id}/reject
     * Reject Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param statusReasonRequest 
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @PATCH("api/v1/admin/sellers/{seller_id}/reject")
    suspend fun rejectSellerApiV1AdminSellersSellerIdRejectPatch(@Path("seller_id") sellerId: kotlin.Int, @Body statusReasonRequest: StatusReasonRequest, ): Response<SellerRead>

    /**
     * PATCH api/v1/admin/sellers/{seller_id}/documents/{doc_id}
     * Review Document
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param docId 
     * @param documentReviewRequest 
     * @param accessToken  (optional)
     * @return [DocumentRead]
     */
    @PATCH("api/v1/admin/sellers/{seller_id}/documents/{doc_id}")
    suspend fun reviewDocumentApiV1AdminSellersSellerIdDocumentsDocIdPatch(@Path("seller_id") sellerId: kotlin.Int, @Path("doc_id") docId: kotlin.Int, @Body documentReviewRequest: DocumentReviewRequest, ): Response<DocumentRead>

    /**
     * POST api/v1/seller/documents
     * Submit Document
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param documentSubmitRequest 
     * @param accessToken  (optional)
     * @return [DocumentRead]
     */
    @POST("api/v1/seller/documents")
    suspend fun submitDocumentApiV1SellerDocumentsPost(@Body documentSubmitRequest: DocumentSubmitRequest, ): Response<DocumentRead>

    /**
     * PATCH api/v1/admin/sellers/{seller_id}/suspend
     * Suspend Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param statusReasonRequest 
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @PATCH("api/v1/admin/sellers/{seller_id}/suspend")
    suspend fun suspendSellerApiV1AdminSellersSellerIdSuspendPatch(@Path("seller_id") sellerId: kotlin.Int, @Body statusReasonRequest: StatusReasonRequest, ): Response<SellerRead>

    /**
     * PATCH api/v1/seller/me
     * Update Seller Me
     * Send only what changes. Today that is &#x60;interest_category_ids&#x60;.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerUpdateRequest 
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @PATCH("api/v1/seller/me")
    suspend fun updateSellerMeApiV1SellerMePatch(@Body sellerUpdateRequest: SellerUpdateRequest, ): Response<SellerRead>

    /**
     * PATCH api/v1/admin/sellers/{seller_id}/shop-limit
     * Update Shop Limit
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId 
     * @param updateShopLimitRequest 
     * @param accessToken  (optional)
     * @return [SellerRead]
     */
    @PATCH("api/v1/admin/sellers/{seller_id}/shop-limit")
    suspend fun updateShopLimitApiV1AdminSellersSellerIdShopLimitPatch(@Path("seller_id") sellerId: kotlin.Int, @Body updateShopLimitRequest: UpdateShopLimitRequest, ): Response<SellerRead>

}
