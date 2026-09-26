package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.CategoryAttributeRead
import com.emarketseller.sdk.model.CategoryCreate
import com.emarketseller.sdk.model.CategoryMoveRequest
import com.emarketseller.sdk.model.CategoryRead
import com.emarketseller.sdk.model.CategoryUpdate
import com.emarketseller.sdk.model.CommissionResolutionRead
import com.emarketseller.sdk.model.CommissionRuleCreate
import com.emarketseller.sdk.model.CommissionRuleRead
import com.emarketseller.sdk.model.CommissionScopeType
import com.emarketseller.sdk.model.DeactivationImpact
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.SetAttributesRequest

interface CategoriesApi {
    /**
     * GET api/v1/seller/shops/{shop_id}/commission-preview
     * Commission Preview
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param categoryId 
     * @param accessToken  (optional)
     * @return [CommissionResolutionRead]
     */
    @GET("api/v1/seller/shops/{shop_id}/commission-preview")
    suspend fun commissionPreviewApiV1SellerShopsShopIdCommissionPreviewGet(@Path("shop_id") shopId: kotlin.Int, @Query("category_id") categoryId: kotlin.Int, ): Response<CommissionResolutionRead>

    /**
     * POST api/v1/admin/categories/{category_id}/deactivate/confirm
     * Confirm Category Deactivation
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId 
     * @param accessToken  (optional)
     * @return [CategoryRead]
     */
    @POST("api/v1/admin/categories/{category_id}/deactivate/confirm")
    suspend fun confirmCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivateConfirmPost(@Path("category_id") categoryId: kotlin.Int, ): Response<CategoryRead>

    /**
     * POST api/v1/admin/categories
     * Create Category
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryCreate 
     * @param accessToken  (optional)
     * @return [CategoryRead]
     */
    @POST("api/v1/admin/categories")
    suspend fun createCategoryApiV1AdminCategoriesPost(@Body categoryCreate: CategoryCreate, ): Response<CategoryRead>

    /**
     * POST api/v1/admin/commission-rules
     * Create Commission Rule
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param commissionRuleCreate 
     * @param accessToken  (optional)
     * @return [CommissionRuleRead]
     */
    @POST("api/v1/admin/commission-rules")
    suspend fun createCommissionRuleApiV1AdminCommissionRulesPost(@Body commissionRuleCreate: CommissionRuleCreate, ): Response<CommissionRuleRead>

    /**
     * PATCH api/v1/admin/commission-rules/{rule_id}/deactivate
     * Deactivate Commission Rule
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param ruleId 
     * @param accessToken  (optional)
     * @return [CommissionRuleRead]
     */
    @PATCH("api/v1/admin/commission-rules/{rule_id}/deactivate")
    suspend fun deactivateCommissionRuleApiV1AdminCommissionRulesRuleIdDeactivatePatch(@Path("rule_id") ruleId: kotlin.Int, ): Response<CommissionRuleRead>

    /**
     * DELETE api/v1/admin/categories/{category_id}
     * Delete Category
     * 
     * Responses:
     *  - 204: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId 
     * @param accessToken  (optional)
     * @return [Unit]
     */
    @DELETE("api/v1/admin/categories/{category_id}")
    suspend fun deleteCategoryApiV1AdminCategoriesCategoryIdDelete(@Path("category_id") categoryId: kotlin.Int, ): Response<Unit>

    /**
     * GET api/v1/admin/categories/{category_id}/attributes
     * Get Effective Attributes Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<CategoryAttributeRead>]
     */
    @GET("api/v1/admin/categories/{category_id}/attributes")
    suspend fun getEffectiveAttributesAdminApiV1AdminCategoriesCategoryIdAttributesGet(@Path("category_id") categoryId: kotlin.Int, ): Response<kotlin.collections.List<CategoryAttributeRead>>

    /**
     * GET api/v1/seller/categories/{category_id}/attributes
     * Get Effective Attributes Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId 
     * @return [kotlin.collections.List<CategoryAttributeRead>]
     */
    @GET("api/v1/seller/categories/{category_id}/attributes")
    suspend fun getEffectiveAttributesSellerApiV1SellerCategoriesCategoryIdAttributesGet(@Path("category_id") categoryId: kotlin.Int): Response<kotlin.collections.List<CategoryAttributeRead>>

    /**
     * GET api/v1/admin/categories
     * List Categories Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param parentId  (optional)
     * @param isActive  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<CategoryRead>]
     */
    @GET("api/v1/admin/categories")
    suspend fun listCategoriesAdminApiV1AdminCategoriesGet(@Query("parent_id") parentId: kotlin.Int? = null, @Query("is_active") isActive: kotlin.Boolean? = null, ): Response<kotlin.collections.List<CategoryRead>>

    /**
     * GET api/v1/seller/categories
     * List Categories Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *
     * @return [kotlin.collections.List<CategoryRead>]
     */
    @GET("api/v1/seller/categories")
    suspend fun listCategoriesSellerApiV1SellerCategoriesGet(): Response<kotlin.collections.List<CategoryRead>>

    /**
     * GET api/v1/admin/commission-rules
     * List Commission Rules
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param scopeType  (optional)
     * @param scopeId  (optional)
     * @param isActive  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<CommissionRuleRead>]
     */
    @GET("api/v1/admin/commission-rules")
    suspend fun listCommissionRulesApiV1AdminCommissionRulesGet(@Query("scope_type") scopeType: CommissionScopeType? = null, @Query("scope_id") scopeId: kotlin.Int? = null, @Query("is_active") isActive: kotlin.Boolean? = null, ): Response<kotlin.collections.List<CommissionRuleRead>>

    /**
     * POST api/v1/admin/categories/{category_id}/move
     * Move Category
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId 
     * @param categoryMoveRequest 
     * @param accessToken  (optional)
     * @return [CategoryRead]
     */
    @POST("api/v1/admin/categories/{category_id}/move")
    suspend fun moveCategoryApiV1AdminCategoriesCategoryIdMovePost(@Path("category_id") categoryId: kotlin.Int, @Body categoryMoveRequest: CategoryMoveRequest, ): Response<CategoryRead>

    /**
     * POST api/v1/admin/categories/{category_id}/deactivate/preview
     * Preview Category Deactivation
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId 
     * @param accessToken  (optional)
     * @return [DeactivationImpact]
     */
    @POST("api/v1/admin/categories/{category_id}/deactivate/preview")
    suspend fun previewCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivatePreviewPost(@Path("category_id") categoryId: kotlin.Int, ): Response<DeactivationImpact>

    /**
     * GET api/v1/admin/commission-rules/resolve
     * Resolve Commission Rule Debug
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param categoryId 
     * @param accessToken  (optional)
     * @return [CommissionRuleRead]
     */
    @GET("api/v1/admin/commission-rules/resolve")
    suspend fun resolveCommissionRuleDebugApiV1AdminCommissionRulesResolveGet(@Query("shop_id") shopId: kotlin.Int, @Query("category_id") categoryId: kotlin.Int, ): Response<CommissionRuleRead>

    /**
     * PUT api/v1/admin/categories/{category_id}/attributes
     * Set Attributes
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId 
     * @param setAttributesRequest 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<CategoryAttributeRead>]
     */
    @PUT("api/v1/admin/categories/{category_id}/attributes")
    suspend fun setAttributesApiV1AdminCategoriesCategoryIdAttributesPut(@Path("category_id") categoryId: kotlin.Int, @Body setAttributesRequest: SetAttributesRequest, ): Response<kotlin.collections.List<CategoryAttributeRead>>

    /**
     * PATCH api/v1/admin/categories/{category_id}
     * Update Category
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId 
     * @param categoryUpdate 
     * @param accessToken  (optional)
     * @return [CategoryRead]
     */
    @PATCH("api/v1/admin/categories/{category_id}")
    suspend fun updateCategoryApiV1AdminCategoriesCategoryIdPatch(@Path("category_id") categoryId: kotlin.Int, @Body categoryUpdate: CategoryUpdate, ): Response<CategoryRead>

}
