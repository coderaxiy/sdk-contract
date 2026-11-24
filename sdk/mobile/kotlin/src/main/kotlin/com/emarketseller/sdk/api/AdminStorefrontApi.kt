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
import com.emarketseller.sdk.model.HomepageShopBannerAdminRead
import com.emarketseller.sdk.model.HomepageShopBannerPublication
import com.emarketseller.sdk.model.HomepageShopBannerWrite
import com.emarketseller.sdk.model.HomepageShopOptionRead

interface AdminStorefrontApi {
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
     * POST api/v1/admin/storefront/home/banners
     * Create Homepage Shop Banner
     * Create an unpublished shop banner.
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param homepageShopBannerWrite 
     * @param accessToken  (optional)
     * @return [HomepageShopBannerAdminRead]
     */
    @POST("api/v1/admin/storefront/home/banners")
    suspend fun createHomepageShopBannerApiV1AdminStorefrontHomeBannersPost(@Body homepageShopBannerWrite: HomepageShopBannerWrite, ): Response<HomepageShopBannerAdminRead>

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
     * GET api/v1/admin/storefront/home/banners/shops
     * List Homepage Banner Shops
     * Search public shops by name or slug for the banner picker.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param q  (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<HomepageShopOptionRead>]
     */
    @GET("api/v1/admin/storefront/home/banners/shops")
    suspend fun listHomepageBannerShopsApiV1AdminStorefrontHomeBannersShopsGet(@Query("q") q: kotlin.String? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<HomepageShopOptionRead>>

    /**
     * GET api/v1/admin/storefront/home/banners
     * List Homepage Shop Banners
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<HomepageShopBannerAdminRead>]
     */
    @GET("api/v1/admin/storefront/home/banners")
    suspend fun listHomepageShopBannersApiV1AdminStorefrontHomeBannersGet(@Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<HomepageShopBannerAdminRead>>

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
     * PATCH api/v1/admin/storefront/home/banners/{banner_id}/publication
     * Set Homepage Shop Banner Publication
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param bannerId 
     * @param homepageShopBannerPublication 
     * @param accessToken  (optional)
     * @return [HomepageShopBannerAdminRead]
     */
    @PATCH("api/v1/admin/storefront/home/banners/{banner_id}/publication")
    suspend fun setHomepageShopBannerPublicationApiV1AdminStorefrontHomeBannersBannerIdPublicationPatch(@Path("banner_id") bannerId: kotlin.Int, @Body homepageShopBannerPublication: HomepageShopBannerPublication, ): Response<HomepageShopBannerAdminRead>

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

    /**
     * PUT api/v1/admin/storefront/home/banners/{banner_id}
     * Update Homepage Shop Banner
     * Replace editable content and schedule while preserving publication state.
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param bannerId 
     * @param homepageShopBannerWrite 
     * @param accessToken  (optional)
     * @return [HomepageShopBannerAdminRead]
     */
    @PUT("api/v1/admin/storefront/home/banners/{banner_id}")
    suspend fun updateHomepageShopBannerApiV1AdminStorefrontHomeBannersBannerIdPut(@Path("banner_id") bannerId: kotlin.Int, @Body homepageShopBannerWrite: HomepageShopBannerWrite, ): Response<HomepageShopBannerAdminRead>

}
