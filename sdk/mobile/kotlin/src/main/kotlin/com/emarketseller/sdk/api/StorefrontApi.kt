package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.CampaignAdminRead
import com.emarketseller.sdk.model.CampaignRead
import com.emarketseller.sdk.model.CampaignWrite
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.HomeWrite
import com.emarketseller.sdk.model.ProductCardRead
import com.emarketseller.sdk.model.StorefrontHomeRead

interface StorefrontApi {
    /**
     * GET api/v1/admin/storefront/campaigns/{campaign_id}
     * Admin Campaign
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param campaignId 
     * @param accessToken  (optional)
     * @return [CampaignAdminRead]
     */
    @GET("api/v1/admin/storefront/campaigns/{campaign_id}")
    suspend fun adminCampaignApiV1AdminStorefrontCampaignsCampaignIdGet(@Path("campaign_id") campaignId: kotlin.Int, ): Response<CampaignAdminRead>

    /**
     * GET api/v1/admin/storefront/campaigns
     * Admin Campaigns
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<CampaignAdminRead>]
     */
    @GET("api/v1/admin/storefront/campaigns")
    suspend fun adminCampaignsApiV1AdminStorefrontCampaignsGet(@Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<CampaignAdminRead>>

    /**
     * GET api/v1/admin/storefront/home
     * Admin Home
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [HomeWrite]
     */
    @GET("api/v1/admin/storefront/home")
    suspend fun adminHomeApiV1AdminStorefrontHomeGet(): Response<HomeWrite>

    /**
     * POST api/v1/admin/storefront/campaigns
     * Create Campaign
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param campaignWrite 
     * @param accessToken  (optional)
     * @return [CampaignAdminRead]
     */
    @POST("api/v1/admin/storefront/campaigns")
    suspend fun createCampaignApiV1AdminStorefrontCampaignsPost(@Body campaignWrite: CampaignWrite, ): Response<CampaignAdminRead>

    /**
     * DELETE api/v1/admin/storefront/campaigns/{campaign_id}
     * Delete Campaign
     * 
     * Responses:
     *  - 204: Successful Response
     *  - 422: Validation Error
     *
     * @param campaignId 
     * @param accessToken  (optional)
     * @return [Unit]
     */
    @DELETE("api/v1/admin/storefront/campaigns/{campaign_id}")
    suspend fun deleteCampaignApiV1AdminStorefrontCampaignsCampaignIdDelete(@Path("campaign_id") campaignId: kotlin.Int, ): Response<Unit>

    /**
     * GET api/v1/admin/storefront/campaigns/{campaign_id}/preview
     * Preview Campaign
     * Render draft content with normal product visibility. Bypasses only campaign publication/schedule.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param campaignId 
     * @param accessToken  (optional)
     * @return [CampaignRead]
     */
    @GET("api/v1/admin/storefront/campaigns/{campaign_id}/preview")
    suspend fun previewCampaignApiV1AdminStorefrontCampaignsCampaignIdPreviewGet(@Path("campaign_id") campaignId: kotlin.Int, ): Response<CampaignRead>

    /**
     * GET api/v1/storefront/campaigns/{slug}
     * Storefront Campaign
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param slug 
     * @return [CampaignRead]
     */
    @GET("api/v1/storefront/campaigns/{slug}")
    suspend fun storefrontCampaignApiV1StorefrontCampaignsSlugGet(@Path("slug") slug: kotlin.String): Response<CampaignRead>

    /**
     * GET api/v1/storefront/home
     * Storefront Home
     * 
     * Responses:
     *  - 200: Successful Response
     *
     * @return [StorefrontHomeRead]
     */
    @GET("api/v1/storefront/home")
    suspend fun storefrontHomeApiV1StorefrontHomeGet(): Response<StorefrontHomeRead>

    /**
     * GET api/v1/storefront/campaigns/{slug}/sections/{section_id}/products
     * Storefront Section Products
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param slug 
     * @param sectionId 
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 20)
     * @return [kotlin.collections.List<ProductCardRead>]
     */
    @GET("api/v1/storefront/campaigns/{slug}/sections/{section_id}/products")
    suspend fun storefrontSectionProductsApiV1StorefrontCampaignsSlugSectionsSectionIdProductsGet(@Path("slug") slug: kotlin.String, @Path("section_id") sectionId: kotlin.Int, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 20): Response<kotlin.collections.List<ProductCardRead>>

    /**
     * PUT api/v1/admin/storefront/campaigns/{campaign_id}
     * Update Campaign
     * Full replacement; send existing block/banner IDs to preserve them and expected_revision to prevent lost edits.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param campaignId 
     * @param campaignWrite 
     * @param accessToken  (optional)
     * @return [CampaignAdminRead]
     */
    @PUT("api/v1/admin/storefront/campaigns/{campaign_id}")
    suspend fun updateCampaignApiV1AdminStorefrontCampaignsCampaignIdPut(@Path("campaign_id") campaignId: kotlin.Int, @Body campaignWrite: CampaignWrite, ): Response<CampaignAdminRead>

    /**
     * PUT api/v1/admin/storefront/home
     * Update Home
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param homeWrite 
     * @param accessToken  (optional)
     * @return [HomeWrite]
     */
    @PUT("api/v1/admin/storefront/home")
    suspend fun updateHomeApiV1AdminStorefrontHomePut(@Body homeWrite: HomeWrite, ): Response<HomeWrite>

}
