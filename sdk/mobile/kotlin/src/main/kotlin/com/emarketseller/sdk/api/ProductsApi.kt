package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.BrandRead
import com.emarketseller.sdk.model.BrandRejectRequest
import com.emarketseller.sdk.model.BrandRequestCreate
import com.emarketseller.sdk.model.BrandStatus
import com.emarketseller.sdk.model.DelistRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.ModerationConfigRead
import com.emarketseller.sdk.model.ModerationConfigUpdate
import com.emarketseller.sdk.model.ModerationQueueItemRead
import com.emarketseller.sdk.model.ProductCreate
import com.emarketseller.sdk.model.ProductModerationLogRead
import com.emarketseller.sdk.model.ProductRead
import com.emarketseller.sdk.model.ProductStatus
import com.emarketseller.sdk.model.ProductUpdate
import com.emarketseller.sdk.model.ProductVariantCreate
import com.emarketseller.sdk.model.ProductVariantRead
import com.emarketseller.sdk.model.ProductVariantUpdate
import com.emarketseller.sdk.model.RejectRequest

interface ProductsApi {
    /**
     * PATCH api/v1/admin/brands/{brand_id}/approve
     * Approve Brand
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param brandId 
     * @param accessToken  (optional)
     * @return [BrandRead]
     */
    @PATCH("api/v1/admin/brands/{brand_id}/approve")
    suspend fun approveBrandApiV1AdminBrandsBrandIdApprovePatch(@Path("brand_id") brandId: kotlin.Int, ): Response<BrandRead>

    /**
     * PATCH api/v1/admin/products/{product_id}/approve
     * Approve Product
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @PATCH("api/v1/admin/products/{product_id}/approve")
    suspend fun approveProductApiV1AdminProductsProductIdApprovePatch(@Path("product_id") productId: kotlin.Int, ): Response<ProductRead>

    /**
     * POST api/v1/seller/products/{product_id}/archive
     * Archive Product
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @POST("api/v1/seller/products/{product_id}/archive")
    suspend fun archiveProductApiV1SellerProductsProductIdArchivePost(@Path("product_id") productId: kotlin.Int, ): Response<ProductRead>

    /**
     * POST api/v1/seller/shops/{shop_id}/products
     * Create Product
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param productCreate 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @POST("api/v1/seller/shops/{shop_id}/products")
    suspend fun createProductApiV1SellerShopsShopIdProductsPost(@Path("shop_id") shopId: kotlin.Int, @Body productCreate: ProductCreate, ): Response<ProductRead>

    /**
     * POST api/v1/seller/products/{product_id}/variants
     * Create Variant
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param productVariantCreate 
     * @param accessToken  (optional)
     * @return [ProductVariantRead]
     */
    @POST("api/v1/seller/products/{product_id}/variants")
    suspend fun createVariantApiV1SellerProductsProductIdVariantsPost(@Path("product_id") productId: kotlin.Int, @Body productVariantCreate: ProductVariantCreate, ): Response<ProductVariantRead>

    /**
     * DELETE api/v1/seller/variants/{variant_id}
     * Delete Variant
     * 
     * Responses:
     *  - 204: Successful Response
     *  - 422: Validation Error
     *
     * @param variantId 
     * @param accessToken  (optional)
     * @return [Unit]
     */
    @DELETE("api/v1/seller/variants/{variant_id}")
    suspend fun deleteVariantApiV1SellerVariantsVariantIdDelete(@Path("variant_id") variantId: kotlin.Int, ): Response<Unit>

    /**
     * PATCH api/v1/admin/products/{product_id}/delist
     * Delist Product Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param delistRequest 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @PATCH("api/v1/admin/products/{product_id}/delist")
    suspend fun delistProductAdminApiV1AdminProductsProductIdDelistPatch(@Path("product_id") productId: kotlin.Int, @Body delistRequest: DelistRequest, ): Response<ProductRead>

    /**
     * POST api/v1/seller/products/{product_id}/delist
     * Delist Product Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param delistRequest 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @POST("api/v1/seller/products/{product_id}/delist")
    suspend fun delistProductSellerApiV1SellerProductsProductIdDelistPost(@Path("product_id") productId: kotlin.Int, @Body delistRequest: DelistRequest, ): Response<ProductRead>

    /**
     * GET api/v1/admin/moderation-config
     * Get Moderation Config
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [ModerationConfigRead]
     */
    @GET("api/v1/admin/moderation-config")
    suspend fun getModerationConfigApiV1AdminModerationConfigGet(): Response<ModerationConfigRead>

    /**
     * GET api/v1/admin/products/{product_id}/moderation-log
     * Get Moderation Log
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ProductModerationLogRead>]
     */
    @GET("api/v1/admin/products/{product_id}/moderation-log")
    suspend fun getModerationLogApiV1AdminProductsProductIdModerationLogGet(@Path("product_id") productId: kotlin.Int, ): Response<kotlin.collections.List<ProductModerationLogRead>>

    /**
     * GET api/v1/admin/moderation-queue
     * Get Moderation Queue
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId  (optional)
     * @param shopId  (optional)
     * @param onlyFlagged  (optional, default to false)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ModerationQueueItemRead>]
     */
    @GET("api/v1/admin/moderation-queue")
    suspend fun getModerationQueueApiV1AdminModerationQueueGet(@Query("category_id") categoryId: kotlin.Int? = null, @Query("shop_id") shopId: kotlin.Int? = null, @Query("only_flagged") onlyFlagged: kotlin.Boolean? = false, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<ModerationQueueItemRead>>

    /**
     * GET api/v1/admin/products/{product_id}
     * Get Product Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @GET("api/v1/admin/products/{product_id}")
    suspend fun getProductAdminApiV1AdminProductsProductIdGet(@Path("product_id") productId: kotlin.Int, ): Response<ProductRead>

    /**
     * GET api/v1/products/{product_id}
     * Get Product Public
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @return [ProductRead]
     */
    @GET("api/v1/products/{product_id}")
    suspend fun getProductPublicApiV1ProductsProductIdGet(@Path("product_id") productId: kotlin.Int): Response<ProductRead>

    /**
     * GET api/v1/seller/products/{product_id}
     * Get Product Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @GET("api/v1/seller/products/{product_id}")
    suspend fun getProductSellerApiV1SellerProductsProductIdGet(@Path("product_id") productId: kotlin.Int, ): Response<ProductRead>

    /**
     * GET api/v1/admin/brands
     * List Brands Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<BrandRead>]
     */
    @GET("api/v1/admin/brands")
    suspend fun listBrandsAdminApiV1AdminBrandsGet(@Query("status") status: BrandStatus? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<BrandRead>>

    /**
     * GET api/v1/seller/brands
     * List Brands Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *
     * @return [kotlin.collections.List<BrandRead>]
     */
    @GET("api/v1/seller/brands")
    suspend fun listBrandsSellerApiV1SellerBrandsGet(): Response<kotlin.collections.List<BrandRead>>

    /**
     * GET api/v1/admin/products
     * List Products Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param shopId  (optional)
     * @param categoryId  (optional)
     * @param search Case-insensitive partial match on title or SKU (incl. variant SKUs) (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ProductRead>]
     */
    @GET("api/v1/admin/products")
    suspend fun listProductsAdminApiV1AdminProductsGet(@Query("status") status: ProductStatus? = null, @Query("shop_id") shopId: kotlin.Int? = null, @Query("category_id") categoryId: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<ProductRead>>

    /**
     * GET api/v1/seller/products
     * List Products Seller
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId  (optional)
     * @param status  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ProductRead>]
     */
    @GET("api/v1/seller/products")
    suspend fun listProductsSellerApiV1SellerProductsGet(@Query("shop_id") shopId: kotlin.Int? = null, @Query("status") status: ProductStatus? = null, ): Response<kotlin.collections.List<ProductRead>>

    /**
     * GET api/v1/shops/{shop_id}/products
     * List Shop Products Public
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @return [kotlin.collections.List<ProductRead>]
     */
    @GET("api/v1/shops/{shop_id}/products")
    suspend fun listShopProductsPublicApiV1ShopsShopIdProductsGet(@Path("shop_id") shopId: kotlin.Int): Response<kotlin.collections.List<ProductRead>>

    /**
     * PATCH api/v1/admin/brands/{brand_id}/reject
     * Reject Brand
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param brandId 
     * @param brandRejectRequest 
     * @param accessToken  (optional)
     * @return [BrandRead]
     */
    @PATCH("api/v1/admin/brands/{brand_id}/reject")
    suspend fun rejectBrandApiV1AdminBrandsBrandIdRejectPatch(@Path("brand_id") brandId: kotlin.Int, @Body brandRejectRequest: BrandRejectRequest, ): Response<BrandRead>

    /**
     * PATCH api/v1/admin/products/{product_id}/reject
     * Reject Product
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param rejectRequest 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @PATCH("api/v1/admin/products/{product_id}/reject")
    suspend fun rejectProductApiV1AdminProductsProductIdRejectPatch(@Path("product_id") productId: kotlin.Int, @Body rejectRequest: RejectRequest, ): Response<ProductRead>

    /**
     * POST api/v1/seller/brands/request
     * Request Brand
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param brandRequestCreate 
     * @param accessToken  (optional)
     * @return [BrandRead]
     */
    @POST("api/v1/seller/brands/request")
    suspend fun requestBrandApiV1SellerBrandsRequestPost(@Body brandRequestCreate: BrandRequestCreate, ): Response<BrandRead>

    /**
     * POST api/v1/seller/products/{product_id}/submit
     * Submit Product
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @POST("api/v1/seller/products/{product_id}/submit")
    suspend fun submitProductApiV1SellerProductsProductIdSubmitPost(@Path("product_id") productId: kotlin.Int, ): Response<ProductRead>

    /**
     * PUT api/v1/admin/moderation-config
     * Update Moderation Config
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param moderationConfigUpdate 
     * @param accessToken  (optional)
     * @return [ModerationConfigRead]
     */
    @PUT("api/v1/admin/moderation-config")
    suspend fun updateModerationConfigApiV1AdminModerationConfigPut(@Body moderationConfigUpdate: ModerationConfigUpdate, ): Response<ModerationConfigRead>

    /**
     * PATCH api/v1/seller/products/{product_id}
     * Update Product
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @param productUpdate 
     * @param accessToken  (optional)
     * @return [ProductRead]
     */
    @PATCH("api/v1/seller/products/{product_id}")
    suspend fun updateProductApiV1SellerProductsProductIdPatch(@Path("product_id") productId: kotlin.Int, @Body productUpdate: ProductUpdate, ): Response<ProductRead>

    /**
     * PATCH api/v1/seller/variants/{variant_id}
     * Update Variant
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param variantId 
     * @param productVariantUpdate 
     * @param accessToken  (optional)
     * @return [ProductVariantRead]
     */
    @PATCH("api/v1/seller/variants/{variant_id}")
    suspend fun updateVariantApiV1SellerVariantsVariantIdPatch(@Path("variant_id") variantId: kotlin.Int, @Body productVariantUpdate: ProductVariantUpdate, ): Response<ProductVariantRead>

}
