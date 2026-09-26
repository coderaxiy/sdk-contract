package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.AppModulesLogisticsSchemasInviteStaffRequest
import com.emarketseller.sdk.model.CashCollectionRecordRead
import com.emarketseller.sdk.model.CheckInRequest
import com.emarketseller.sdk.model.ConfirmCollectionRequest
import com.emarketseller.sdk.model.DeclareReconciliationRequest
import com.emarketseller.sdk.model.DispatchToPointRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.HoldingRead
import com.emarketseller.sdk.model.NearbyPickupPointRead
import com.emarketseller.sdk.model.PickupPointCashReconciliationStatus
import com.emarketseller.sdk.model.PickupPointCreateRequest
import com.emarketseller.sdk.model.PickupPointRead
import com.emarketseller.sdk.model.PickupPointShipmentStatus
import com.emarketseller.sdk.model.PickupPointStaffRead
import com.emarketseller.sdk.model.PickupPointStatus
import com.emarketseller.sdk.model.PickupPointStatusUpdateRequest
import com.emarketseller.sdk.model.PickupPointUpdateRequest
import com.emarketseller.sdk.model.PickupStatusRead
import com.emarketseller.sdk.model.ReconciliationRead
import com.emarketseller.sdk.model.RegionRead
import com.emarketseller.sdk.model.RejectItemsRequest
import com.emarketseller.sdk.model.ResolveDiscrepancyRequest
import com.emarketseller.sdk.model.ResolveReconciliationRequest
import com.emarketseller.sdk.model.ShipmentRead
import com.emarketseller.sdk.model.UpdateStaffRoleRequest

interface LogisticsApi {
    /**
     * POST api/v1/pickup-staff/shipments/{shipment_id}/check-in
     * Check In Shipment
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shipmentId 
     * @param checkInRequest 
     * @param accessToken  (optional)
     * @return [ShipmentRead]
     */
    @POST("api/v1/pickup-staff/shipments/{shipment_id}/check-in")
    suspend fun checkInShipmentApiV1PickupStaffShipmentsShipmentIdCheckInPost(@Path("shipment_id") shipmentId: kotlin.Int, @Body checkInRequest: CheckInRequest, ): Response<ShipmentRead>

    /**
     * POST api/v1/pickup-staff/holdings/{holding_id}/collect
     * Collect Holding Items
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param holdingId 
     * @param confirmCollectionRequest 
     * @param accessToken  (optional)
     * @return [CashCollectionRecordRead]
     */
    @POST("api/v1/pickup-staff/holdings/{holding_id}/collect")
    suspend fun collectHoldingItemsApiV1PickupStaffHoldingsHoldingIdCollectPost(@Path("holding_id") holdingId: kotlin.Int, @Body confirmCollectionRequest: ConfirmCollectionRequest, ): Response<CashCollectionRecordRead>

    /**
     * POST api/v1/admin/pickup-points
     * Create Pickup Point
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param pickupPointCreateRequest 
     * @param accessToken  (optional)
     * @return [PickupPointRead]
     */
    @POST("api/v1/admin/pickup-points")
    suspend fun createPickupPointApiV1AdminPickupPointsPost(@Body pickupPointCreateRequest: PickupPointCreateRequest, ): Response<PickupPointRead>

    /**
     * POST api/v1/pickup-staff/reconciliation/{reconciliation_id}/declare
     * Declare Reconciliation
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param reconciliationId 
     * @param declareReconciliationRequest 
     * @param accessToken  (optional)
     * @return [ReconciliationRead]
     */
    @POST("api/v1/pickup-staff/reconciliation/{reconciliation_id}/declare")
    suspend fun declareReconciliationApiV1PickupStaffReconciliationReconciliationIdDeclarePost(@Path("reconciliation_id") reconciliationId: kotlin.Int, @Body declareReconciliationRequest: DeclareReconciliationRequest, ): Response<ReconciliationRead>

    /**
     * POST api/v1/seller/order-groups/{group_id}/dispatch-to-point
     * Dispatch Group To Point
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param groupId 
     * @param dispatchToPointRequest 
     * @param accessToken  (optional)
     * @return [ShipmentRead]
     */
    @POST("api/v1/seller/order-groups/{group_id}/dispatch-to-point")
    suspend fun dispatchGroupToPointApiV1SellerOrderGroupsGroupIdDispatchToPointPost(@Path("group_id") groupId: kotlin.Int, @Body dispatchToPointRequest: DispatchToPointRequest, ): Response<ShipmentRead>

    /**
     * GET api/v1/pickup-staff/me
     * Get Current Pickup Staff Identity
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [PickupPointStaffRead]
     */
    @GET("api/v1/pickup-staff/me")
    suspend fun getCurrentPickupStaffIdentityApiV1PickupStaffMeGet(): Response<PickupPointStaffRead>

    /**
     * GET api/v1/pickup-staff/reconciliation/current
     * Get Current Reconciliation For Staff
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [ReconciliationRead]
     */
    @GET("api/v1/pickup-staff/reconciliation/current")
    suspend fun getCurrentReconciliationForStaffApiV1PickupStaffReconciliationCurrentGet(): Response<ReconciliationRead>

    /**
     * GET api/v1/orders/{order_id}/groups/{group_id}/pickup-status
     * Get Group Pickup Status
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param orderId 
     * @param groupId 
     * @param accessToken  (optional)
     * @return [PickupStatusRead]
     */
    @GET("api/v1/orders/{order_id}/groups/{group_id}/pickup-status")
    suspend fun getGroupPickupStatusApiV1OrdersOrderIdGroupsGroupIdPickupStatusGet(@Path("order_id") orderId: kotlin.Int, @Path("group_id") groupId: kotlin.Int, ): Response<PickupStatusRead>

    /**
     * POST api/v1/pickup-staff/staff/invite
     * Invite Pickup Staff
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param appModulesLogisticsSchemasInviteStaffRequest 
     * @param accessToken  (optional)
     * @return [PickupPointStaffRead]
     */
    @POST("api/v1/pickup-staff/staff/invite")
    suspend fun invitePickupStaffApiV1PickupStaffStaffInvitePost(@Body appModulesLogisticsSchemasInviteStaffRequest: AppModulesLogisticsSchemasInviteStaffRequest, ): Response<PickupPointStaffRead>

    /**
     * GET api/v1/pickup-staff/staff
     * List Co Staff
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<PickupPointStaffRead>]
     */
    @GET("api/v1/pickup-staff/staff")
    suspend fun listCoStaffApiV1PickupStaffStaffGet(): Response<kotlin.collections.List<PickupPointStaffRead>>

    /**
     * GET api/v1/pickup-staff/holdings
     * List Holdings For Staff
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<HoldingRead>]
     */
    @GET("api/v1/pickup-staff/holdings")
    suspend fun listHoldingsForStaffApiV1PickupStaffHoldingsGet(): Response<kotlin.collections.List<HoldingRead>>

    /**
     * GET api/v1/pickup-points/nearby
     * List Nearby Pickup Points
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param lat 
     * @param lng 
     * @param radiusKm  (optional, default to 25.0)
     * @return [kotlin.collections.List<NearbyPickupPointRead>]
     */
    @GET("api/v1/pickup-points/nearby")
    suspend fun listNearbyPickupPointsApiV1PickupPointsNearbyGet(@Query("lat") lat: java.math.BigDecimal, @Query("lng") lng: java.math.BigDecimal, @Query("radius_km") radiusKm: java.math.BigDecimal? = java.math.BigDecimal("25.0")): Response<kotlin.collections.List<NearbyPickupPointRead>>

    /**
     * GET api/v1/admin/pickup-points/{point_id}/staff
     * List Pickup Point Staff Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param pointId 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<PickupPointStaffRead>]
     */
    @GET("api/v1/admin/pickup-points/{point_id}/staff")
    suspend fun listPickupPointStaffAdminApiV1AdminPickupPointsPointIdStaffGet(@Path("point_id") pointId: kotlin.Int, ): Response<kotlin.collections.List<PickupPointStaffRead>>

    /**
     * GET api/v1/admin/pickup-points
     * List Pickup Points Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param regionId  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<PickupPointRead>]
     */
    @GET("api/v1/admin/pickup-points")
    suspend fun listPickupPointsAdminApiV1AdminPickupPointsGet(@Query("status") status: PickupPointStatus? = null, @Query("region_id") regionId: kotlin.Int? = null, ): Response<kotlin.collections.List<PickupPointRead>>

    /**
     * GET api/v1/admin/reconciliations
     * List Reconciliations Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ReconciliationRead>]
     */
    @GET("api/v1/admin/reconciliations")
    suspend fun listReconciliationsAdminApiV1AdminReconciliationsGet(@Query("status") status: PickupPointCashReconciliationStatus? = null, ): Response<kotlin.collections.List<ReconciliationRead>>

    /**
     * GET api/v1/admin/regions
     * List Regions Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<RegionRead>]
     */
    @GET("api/v1/admin/regions")
    suspend fun listRegionsAdminApiV1AdminRegionsGet(): Response<kotlin.collections.List<RegionRead>>

    /**
     * GET api/v1/seller/shipments
     * List Seller Shipments
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ShipmentRead>]
     */
    @GET("api/v1/seller/shipments")
    suspend fun listSellerShipmentsApiV1SellerShipmentsGet(): Response<kotlin.collections.List<ShipmentRead>>

    /**
     * GET api/v1/admin/shipments
     * List Shipment Discrepancies Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ShipmentRead>]
     */
    @GET("api/v1/admin/shipments")
    suspend fun listShipmentDiscrepanciesAdminApiV1AdminShipmentsGet(@Query("status") status: PickupPointShipmentStatus? = null, ): Response<kotlin.collections.List<ShipmentRead>>

    /**
     * GET api/v1/pickup-staff/shipments
     * List Shipments For Staff
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<ShipmentRead>]
     */
    @GET("api/v1/pickup-staff/shipments")
    suspend fun listShipmentsForStaffApiV1PickupStaffShipmentsGet(@Query("status") status: PickupPointShipmentStatus? = null, ): Response<kotlin.collections.List<ShipmentRead>>

    /**
     * POST api/v1/pickup-staff/holdings/{holding_id}/reject
     * Reject Holding Items
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param holdingId 
     * @param rejectItemsRequest 
     * @param accessToken  (optional)
     * @return [HoldingRead]
     */
    @POST("api/v1/pickup-staff/holdings/{holding_id}/reject")
    suspend fun rejectHoldingItemsApiV1PickupStaffHoldingsHoldingIdRejectPost(@Path("holding_id") holdingId: kotlin.Int, @Body rejectItemsRequest: RejectItemsRequest, ): Response<HoldingRead>

    /**
     * PATCH api/v1/admin/reconciliations/{reconciliation_id}/resolve
     * Resolve Reconciliation Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param reconciliationId 
     * @param resolveReconciliationRequest 
     * @param accessToken  (optional)
     * @return [ReconciliationRead]
     */
    @PATCH("api/v1/admin/reconciliations/{reconciliation_id}/resolve")
    suspend fun resolveReconciliationAdminApiV1AdminReconciliationsReconciliationIdResolvePatch(@Path("reconciliation_id") reconciliationId: kotlin.Int, @Body resolveReconciliationRequest: ResolveReconciliationRequest, ): Response<ReconciliationRead>

    /**
     * PATCH api/v1/admin/shipments/{shipment_id}/resolve-discrepancy
     * Resolve Shipment Discrepancy
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shipmentId 
     * @param resolveDiscrepancyRequest 
     * @param accessToken  (optional)
     * @return [ShipmentRead]
     */
    @PATCH("api/v1/admin/shipments/{shipment_id}/resolve-discrepancy")
    suspend fun resolveShipmentDiscrepancyApiV1AdminShipmentsShipmentIdResolveDiscrepancyPatch(@Path("shipment_id") shipmentId: kotlin.Int, @Body resolveDiscrepancyRequest: ResolveDiscrepancyRequest, ): Response<ShipmentRead>

    /**
     * PATCH api/v1/pickup-staff/staff/{staff_id}/suspend
     * Suspend Pickup Staff
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param staffId 
     * @param accessToken  (optional)
     * @return [PickupPointStaffRead]
     */
    @PATCH("api/v1/pickup-staff/staff/{staff_id}/suspend")
    suspend fun suspendPickupStaffApiV1PickupStaffStaffStaffIdSuspendPatch(@Path("staff_id") staffId: kotlin.Int, ): Response<PickupPointStaffRead>

    /**
     * PATCH api/v1/admin/pickup-points/{point_id}
     * Update Pickup Point
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param pointId 
     * @param pickupPointUpdateRequest 
     * @param accessToken  (optional)
     * @return [PickupPointRead]
     */
    @PATCH("api/v1/admin/pickup-points/{point_id}")
    suspend fun updatePickupPointApiV1AdminPickupPointsPointIdPatch(@Path("point_id") pointId: kotlin.Int, @Body pickupPointUpdateRequest: PickupPointUpdateRequest, ): Response<PickupPointRead>

    /**
     * PATCH api/v1/admin/pickup-points/{point_id}/status
     * Update Pickup Point Status
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param pointId 
     * @param pickupPointStatusUpdateRequest 
     * @param accessToken  (optional)
     * @return [PickupPointRead]
     */
    @PATCH("api/v1/admin/pickup-points/{point_id}/status")
    suspend fun updatePickupPointStatusApiV1AdminPickupPointsPointIdStatusPatch(@Path("point_id") pointId: kotlin.Int, @Body pickupPointStatusUpdateRequest: PickupPointStatusUpdateRequest, ): Response<PickupPointRead>

    /**
     * PATCH api/v1/pickup-staff/staff/{staff_id}/role
     * Update Pickup Staff Role
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param staffId 
     * @param updateStaffRoleRequest 
     * @param accessToken  (optional)
     * @return [PickupPointStaffRead]
     */
    @PATCH("api/v1/pickup-staff/staff/{staff_id}/role")
    suspend fun updatePickupStaffRoleApiV1PickupStaffStaffStaffIdRolePatch(@Path("staff_id") staffId: kotlin.Int, @Body updateStaffRoleRequest: UpdateStaffRoleRequest, ): Response<PickupPointStaffRead>

}
