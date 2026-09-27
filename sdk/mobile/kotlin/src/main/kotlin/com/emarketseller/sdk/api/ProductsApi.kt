package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.BrandPublicRead
import com.emarketseller.sdk.model.BrandRead
import com.emarketseller.sdk.model.BrandRejectRequest
import com.emarketseller.sdk.model.BrandRequestCreate
import com.emarketseller.sdk.model.BrandStatus
import com.emarketseller.sdk.model.CatalogFacetsRead
import com.emarketseller.sdk.model.CatalogSort
import com.emarketseller.sdk.model.DelistRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.ModerationConfigRead
import com.emarketseller.sdk.model.ModerationConfigUpdate
import com.emarketseller.sdk.model.ModerationQueueItemRead
import com.emarketseller.sdk.model.PriceMax
import com.emarketseller.sdk.model.PriceMin
import com.emarketseller.sdk.model.ProductCardRead
import com.emarketseller.sdk.model.ProductCreate
import com.emarketseller.sdk.model.ProductModerationLogRead
import com.emarketseller.sdk.model.ProductPublicRead
import com.emarketseller.sdk.model.ProductRead
import com.emarketseller.sdk.model.ProductStatus
import com.emarketseller.sdk.model.ProductUpdate
import com.emarketseller.sdk.model.ProductVariantCreate
import com.emarketseller.sdk.model.ProductVariantRead
import com.emarketseller.sdk.model.ProductVariantUpdate
import com.emarketseller.sdk.model.RejectRequest

import com.emarketseller.sdk.model.*

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
     * GET api/v1/products/facets
     * Get Catalog Facets
     * Brands (with counts) and the price range for the filter sidebar, given the same filters as GET /products.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param q Case-insensitive match on title or brand name; Uzbek Latin and Cyrillic spellings both match (optional)
     * @param categoryId The category and all its descendants (optional)
     * @param brandId Repeatable; OR across values (optional)
     * @param shopId  (optional)
     * @param priceMin Compared against the card&#39;s price_min (optional)
     * @param priceMax Compared against the card&#39;s price_min (optional)
     * @param inStock true hides out-of-stock products (optional)
     * @param attr Repeatable key:value on a filterable attribute of category_id (required). OR within a key, AND across keys (optional)
     * @return [CatalogFacetsRead]
     */
    @GET("api/v1/products/facets")
    suspend fun getCatalogFacetsApiV1ProductsFacetsGet(@Query("q") q: kotlin.String? = null, @Query("category_id") categoryId: kotlin.Int? = null, @Query("brand_id") brandId: @JvmSuppressWildcards kotlin.collections.List<kotlin.Int?>? = null, @Query("shop_id") shopId: kotlin.Int? = null, @Query("price_min") priceMin: PriceMin? = null, @Query("price_max") priceMax: PriceMax? = null, @Query("in_stock") inStock: kotlin.Boolean? = null, @Query("attr") attr: @JvmSuppressWildcards kotlin.collections.List<kotlin.String?>? = null): Response<CatalogFacetsRead>

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
     * GET api/v1/shops/by-slug/{shop_slug}/products/{product_slug}
     * Get Product By Slugs
     * A product&#39;s previous slugs still resolve; compare the response&#39;s &#x60;slug&#x60; and &#x60;shop.slug&#x60; with the URL and redirect when they differ.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopSlug 
     * @param productSlug 
     * @return [ProductPublicRead]
     */
    @GET("api/v1/shops/by-slug/{shop_slug}/products/{product_slug}")
    suspend fun getProductBySlugsApiV1ShopsBySlugShopSlugProductsProductSlugGet(@Path("shop_slug") shopSlug: kotlin.String, @Path("product_slug") productSlug: kotlin.String): Response<ProductPublicRead>

    /**
     * GET api/v1/products/{product_id}
     * Get Product Public
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param productId 
     * @return [ProductPublicRead]
     */
    @GET("api/v1/products/{product_id}")
    suspend fun getProductPublicApiV1ProductsProductIdGet(@Path("product_id") productId: kotlin.Int): Response<ProductPublicRead>

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
     * GET api/v1/brands
     * List Brands Public
     * Approved brands, ordered by name.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param categoryId Only brands with a visible product in this category or its descendants (optional)
     * @param q Case-insensitive match on the brand name (optional)
     * @return [kotlin.collections.List<BrandPublicRead>]
     */
    @GET("api/v1/brands")
    suspend fun listBrandsPublicApiV1BrandsGet(@Query("category_id") categoryId: kotlin.Int? = null, @Query("q") q: kotlin.String? = null): Response<kotlin.collections.List<BrandPublicRead>>

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
     * GET api/v1/products
     * List Catalog
     * Public catalog and search. The total match count is in the &#x60;X-Total-Count&#x60; header.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param sort Default: relevance when q is set, newest otherwise (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param q Case-insensitive match on title or brand name; Uzbek Latin and Cyrillic spellings both match (optional)
     * @param categoryId The category and all its descendants (optional)
     * @param brandId Repeatable; OR across values (optional, default to arrayListOf())
     * @param shopId  (optional)
     * @param priceMin Compared against the card&#39;s price_min (optional)
     * @param priceMax Compared against the card&#39;s price_min (optional)
     * @param inStock true hides out-of-stock products (optional)
     * @param attr Repeatable key:value on a filterable attribute of category_id (required). OR within a key, AND across keys (optional, default to arrayListOf())
     * @return [kotlin.collections.List<ProductCardRead>]
     */
    @GET("api/v1/products")
    suspend fun listCatalogApiV1ProductsGet(@Query("sort") sort: CatalogSort? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, @Query("q") q: kotlin.String? = null, @Query("category_id") categoryId: kotlin.Int? = null, @Query("brand_id") brandId: @JvmSuppressWildcards kotlin.collections.List<kotlin.Int?>? = arrayListOf(), @Query("shop_id") shopId: kotlin.Int? = null, @Query("price_min") priceMin: PriceMin? = null, @Query("price_max") priceMax: PriceMax? = null, @Query("in_stock") inStock: kotlin.Boolean? = null, @Query("attr") attr: @JvmSuppressWildcards kotlin.collections.List<kotlin.String?>? = arrayListOf()): Response<kotlin.collections.List<ProductCardRead>>

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
     * @return [kotlin.collections.List<ProductPublicRead>]
     */
    @GET("api/v1/shops/{shop_id}/products")
    suspend fun listShopProductsPublicApiV1ShopsShopIdProductsGet(@Path("shop_id") shopId: kotlin.Int): Response<kotlin.collections.List<ProductPublicRead>>

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
