package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.AppModulesShopsSchemasInviteStaffRequest
import com.emarketseller.sdk.model.AssignCategoryRequest
import com.emarketseller.sdk.model.AuditLogRead
import com.emarketseller.sdk.model.CategoryAssignmentRead
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.RejectAssignmentRequest
import com.emarketseller.sdk.model.ShopCreateRequest
import com.emarketseller.sdk.model.ShopPublicRead
import com.emarketseller.sdk.model.ShopRead
import com.emarketseller.sdk.model.ShopStaffRead
import com.emarketseller.sdk.model.ShopUpdateRequest
import com.emarketseller.sdk.model.SlugAvailabilityRead
import com.emarketseller.sdk.model.StatusReasonRequest

interface ShopsApi {
    /**
     * PATCH api/v1/admin/shop-category-assignments/{assignment_id}/approve
     * Approve Category Assignment
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param assignmentId 
     * @param accessToken  (optional)
     * @return [CategoryAssignmentRead]
     */
    @PATCH("api/v1/admin/shop-category-assignments/{assignment_id}/approve")
    suspend fun approveCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdApprovePatch(@Path("assignment_id") assignmentId: kotlin.Int, ): Response<CategoryAssignmentRead>

    /**
     * PATCH api/v1/admin/shops/{shop_id}/approve
     * Approve Shop
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @PATCH("api/v1/admin/shops/{shop_id}/approve")
    suspend fun approveShopApiV1AdminShopsShopIdApprovePatch(@Path("shop_id") shopId: kotlin.Int, ): Response<ShopRead>

    /**
     * GET api/v1/seller/shops/slug-availability
     * Check Slug Availability
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param slug 
     * @param accessToken  (optional)
     * @return [SlugAvailabilityRead]
     */
    @GET("api/v1/seller/shops/slug-availability")
    suspend fun checkSlugAvailabilityApiV1SellerShopsSlugAvailabilityGet(@Query("slug") slug: kotlin.String, ): Response<SlugAvailabilityRead>

    /**
     * POST api/v1/seller/shops/{shop_id}/close
     * Close Shop
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @POST("api/v1/seller/shops/{shop_id}/close")
    suspend fun closeShopApiV1SellerShopsShopIdClosePost(@Path("shop_id") shopId: kotlin.Int, ): Response<ShopRead>

    /**
     * POST api/v1/seller/shops
     * Create Shop
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param shopCreateRequest 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @POST("api/v1/seller/shops")
    suspend fun createShopApiV1SellerShopsPost(@Body shopCreateRequest: ShopCreateRequest, ): Response<ShopRead>

    /**
     * GET api/v1/seller/shops/{shop_id}
     * Get Own Shop
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @GET("api/v1/seller/shops/{shop_id}")
    suspend fun getOwnShopApiV1SellerShopsShopIdGet(@Path("shop_id") shopId: kotlin.Int, ): Response<ShopRead>

    /**
     * GET api/v1/admin/shops/{shop_id}
     * Get Shop Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @GET("api/v1/admin/shops/{shop_id}")
    suspend fun getShopAdminApiV1AdminShopsShopIdGet(@Path("shop_id") shopId: kotlin.Int, ): Response<ShopRead>

    /**
     * GET api/v1/shops/by-slug/{slug}
     * Get Shop Public
     * An active shop&#39;s public profile; 404 for any other status. Shop slugs never change.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param slug 
     * @return [ShopPublicRead]
     */
    @GET("api/v1/shops/by-slug/{slug}")
    suspend fun getShopPublicApiV1ShopsBySlugSlugGet(@Path("slug") slug: kotlin.String): Response<ShopPublicRead>

    /**
     * POST api/v1/seller/shops/{shop_id}/staff
     * Invite Staff
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param appModulesShopsSchemasInviteStaffRequest 
     * @param accessToken  (optional)
     * @return [ShopStaffRead]
     */
    @POST("api/v1/seller/shops/{shop_id}/staff")
    suspend fun inviteStaffApiV1SellerShopsShopIdStaffPost(@Path("shop_id") shopId: kotlin.Int, @Body appModulesShopsSchemasInviteStaffRequest: AppModulesShopsSchemasInviteStaffRequest, ): Response<ShopStaffRead>

    /**
     * GET api/v1/admin/shops
     * List All Shops
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sellerId  (optional)
     * @param status  (optional)
     * @param categoryId  (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ShopRead>]
     */
    @GET("api/v1/admin/shops")
    suspend fun listAllShopsApiV1AdminShopsGet(@Query("seller_id") sellerId: kotlin.Int? = null, @Query("status") status: kotlin.String? = null, @Query("category_id") categoryId: kotlin.Int? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<ShopRead>>

    /**
     * GET api/v1/admin/audit-log
     * List Audit Log
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param targetType  (optional)
     * @param targetId  (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 100)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<AuditLogRead>]
     */
    @GET("api/v1/admin/audit-log")
    suspend fun listAuditLogApiV1AdminAuditLogGet(@Query("target_type") targetType: kotlin.String? = null, @Query("target_id") targetId: kotlin.Int? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 100, ): Response<kotlin.collections.List<AuditLogRead>>

    /**
     * GET api/v1/seller/shops/{shop_id}/category-assignments
     * List Own Category Assignments
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<CategoryAssignmentRead>]
     */
    @GET("api/v1/seller/shops/{shop_id}/category-assignments")
    suspend fun listOwnCategoryAssignmentsApiV1SellerShopsShopIdCategoryAssignmentsGet(@Path("shop_id") shopId: kotlin.Int, ): Response<kotlin.collections.List<CategoryAssignmentRead>>

    /**
     * GET api/v1/seller/shops
     * List Own Shops
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ShopRead>]
     */
    @GET("api/v1/seller/shops")
    suspend fun listOwnShopsApiV1SellerShopsGet(): Response<kotlin.collections.List<ShopRead>>

    /**
     * GET api/v1/admin/shop-category-assignments
     * List Shop Category Assignments
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param shopId  (optional)
     * @param categoryId  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<CategoryAssignmentRead>]
     */
    @GET("api/v1/admin/shop-category-assignments")
    suspend fun listShopCategoryAssignmentsApiV1AdminShopCategoryAssignmentsGet(@Query("status") status: kotlin.String? = null, @Query("shop_id") shopId: kotlin.Int? = null, @Query("category_id") categoryId: kotlin.Int? = null, ): Response<kotlin.collections.List<CategoryAssignmentRead>>

    /**
     * PATCH api/v1/admin/shops/{shop_id}/reactivate
     * Reactivate Shop
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @PATCH("api/v1/admin/shops/{shop_id}/reactivate")
    suspend fun reactivateShopApiV1AdminShopsShopIdReactivatePatch(@Path("shop_id") shopId: kotlin.Int, ): Response<ShopRead>

    /**
     * PATCH api/v1/admin/shop-category-assignments/{assignment_id}/reject
     * Reject Category Assignment
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param assignmentId 
     * @param rejectAssignmentRequest 
     * @param accessToken  (optional)
     * @return [CategoryAssignmentRead]
     */
    @PATCH("api/v1/admin/shop-category-assignments/{assignment_id}/reject")
    suspend fun rejectCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdRejectPatch(@Path("assignment_id") assignmentId: kotlin.Int, @Body rejectAssignmentRequest: RejectAssignmentRequest, ): Response<CategoryAssignmentRead>

    /**
     * PATCH api/v1/admin/shops/{shop_id}/reject
     * Reject Shop
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param statusReasonRequest 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @PATCH("api/v1/admin/shops/{shop_id}/reject")
    suspend fun rejectShopApiV1AdminShopsShopIdRejectPatch(@Path("shop_id") shopId: kotlin.Int, @Body statusReasonRequest: StatusReasonRequest, ): Response<ShopRead>

    /**
     * POST api/v1/seller/shops/{shop_id}/category-assignments
     * Request Category Assignment
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param assignCategoryRequest 
     * @param accessToken  (optional)
     * @return [CategoryAssignmentRead]
     */
    @POST("api/v1/seller/shops/{shop_id}/category-assignments")
    suspend fun requestCategoryAssignmentApiV1SellerShopsShopIdCategoryAssignmentsPost(@Path("shop_id") shopId: kotlin.Int, @Body assignCategoryRequest: AssignCategoryRequest, ): Response<CategoryAssignmentRead>

    /**
     * POST api/v1/seller/shops/{shop_id}/submit
     * Submit Shop For Approval
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @POST("api/v1/seller/shops/{shop_id}/submit")
    suspend fun submitShopForApprovalApiV1SellerShopsShopIdSubmitPost(@Path("shop_id") shopId: kotlin.Int, ): Response<ShopRead>

    /**
     * PATCH api/v1/admin/shops/{shop_id}/suspend
     * Suspend Shop
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param statusReasonRequest 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @PATCH("api/v1/admin/shops/{shop_id}/suspend")
    suspend fun suspendShopApiV1AdminShopsShopIdSuspendPatch(@Path("shop_id") shopId: kotlin.Int, @Body statusReasonRequest: StatusReasonRequest, ): Response<ShopRead>

    /**
     * PATCH api/v1/seller/shops/{shop_id}
     * Update Shop
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param shopUpdateRequest 
     * @param accessToken  (optional)
     * @return [ShopRead]
     */
    @PATCH("api/v1/seller/shops/{shop_id}")
    suspend fun updateShopApiV1SellerShopsShopIdPatch(@Path("shop_id") shopId: kotlin.Int, @Body shopUpdateRequest: ShopUpdateRequest, ): Response<ShopRead>

}
