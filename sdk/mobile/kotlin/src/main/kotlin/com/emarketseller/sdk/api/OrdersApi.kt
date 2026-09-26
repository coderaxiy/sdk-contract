package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.CancelGroupRequest
import com.emarketseller.sdk.model.CartItemAddRequest
import com.emarketseller.sdk.model.CartItemRead
import com.emarketseller.sdk.model.CartItemUpdateRequest
import com.emarketseller.sdk.model.CartRead
import com.emarketseller.sdk.model.CheckoutRequest
import com.emarketseller.sdk.model.CheckoutResponse
import com.emarketseller.sdk.model.GroupStatusUpdateRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.LedgerEntryRead
import com.emarketseller.sdk.model.LedgerStatementRead
import com.emarketseller.sdk.model.ManualAdjustmentRequest
import com.emarketseller.sdk.model.OrderAdminRead
import com.emarketseller.sdk.model.OrderRead
import com.emarketseller.sdk.model.OrderShopGroupDetailRead
import com.emarketseller.sdk.model.OrderShopGroupStatus
import com.emarketseller.sdk.model.PayoutRead
import com.emarketseller.sdk.model.PayoutRunRequest
import com.emarketseller.sdk.model.RefundApproveRequest
import com.emarketseller.sdk.model.RefundRejectRequest
import com.emarketseller.sdk.model.RefundRequestCreate
import com.emarketseller.sdk.model.RefundRequestRead
import com.emarketseller.sdk.model.RefundResolveRequest
import com.emarketseller.sdk.model.RefundStatus

interface OrdersApi {
    /**
     * POST api/v1/cart/items
     * Add Cart Item
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param cartItemAddRequest 
     * @param accessToken  (optional)
     * @return [CartItemRead]
     */
    @POST("api/v1/cart/items")
    suspend fun addCartItemApiV1CartItemsPost(@Body cartItemAddRequest: CartItemAddRequest, ): Response<CartItemRead>

    /**
     * PATCH api/v1/seller/refund-requests/{refund_id}/approve
     * Approve Refund Request
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param refundId 
     * @param refundApproveRequest 
     * @param accessToken  (optional)
     * @return [RefundRequestRead]
     */
    @PATCH("api/v1/seller/refund-requests/{refund_id}/approve")
    suspend fun approveRefundRequestApiV1SellerRefundRequestsRefundIdApprovePatch(@Path("refund_id") refundId: kotlin.Int, @Body refundApproveRequest: RefundApproveRequest, ): Response<RefundRequestRead>

    /**
     * POST api/v1/orders/{order_id}/groups/{group_id}/cancel
     * Cancel Order Group
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param orderId 
     * @param groupId 
     * @param cancelGroupRequest 
     * @param accessToken  (optional)
     * @return [OrderShopGroupDetailRead]
     */
    @POST("api/v1/orders/{order_id}/groups/{group_id}/cancel")
    suspend fun cancelOrderGroupApiV1OrdersOrderIdGroupsGroupIdCancelPost(@Path("order_id") orderId: kotlin.Int, @Path("group_id") groupId: kotlin.Int, @Body cancelGroupRequest: CancelGroupRequest, ): Response<OrderShopGroupDetailRead>

    /**
     * POST api/v1/checkout
     * Checkout
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param checkoutRequest 
     * @param accessToken  (optional)
     * @return [CheckoutResponse]
     */
    @POST("api/v1/checkout")
    suspend fun checkoutApiV1CheckoutPost(@Body checkoutRequest: CheckoutRequest, ): Response<CheckoutResponse>

    /**
     * POST api/v1/admin/ledger/{shop_id}/manual-adjustment
     * Create Manual Adjustment
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param manualAdjustmentRequest 
     * @param accessToken  (optional)
     * @return [LedgerEntryRead]
     */
    @POST("api/v1/admin/ledger/{shop_id}/manual-adjustment")
    suspend fun createManualAdjustmentApiV1AdminLedgerShopIdManualAdjustmentPost(@Path("shop_id") shopId: kotlin.Int, @Body manualAdjustmentRequest: ManualAdjustmentRequest, ): Response<LedgerEntryRead>

    /**
     * POST api/v1/refund-requests/{refund_id}/escalate
     * Escalate Refund Request
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param refundId 
     * @param accessToken  (optional)
     * @return [RefundRequestRead]
     */
    @POST("api/v1/refund-requests/{refund_id}/escalate")
    suspend fun escalateRefundRequestApiV1RefundRequestsRefundIdEscalatePost(@Path("refund_id") refundId: kotlin.Int, ): Response<RefundRequestRead>

    /**
     * GET api/v1/cart
     * Get Cart
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [CartRead]
     */
    @GET("api/v1/cart")
    suspend fun getCartApiV1CartGet(): Response<CartRead>

    /**
     * GET api/v1/admin/ledger/{shop_id}
     * Get Ledger Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param periodStart 
     * @param periodEnd 
     * @param accessToken  (optional)
     * @return [LedgerStatementRead]
     */
    @GET("api/v1/admin/ledger/{shop_id}")
    suspend fun getLedgerAdminApiV1AdminLedgerShopIdGet(@Path("shop_id") shopId: kotlin.Int, @Query("period_start") periodStart: java.time.OffsetDateTime, @Query("period_end") periodEnd: java.time.OffsetDateTime, ): Response<LedgerStatementRead>

    /**
     * GET api/v1/orders/{order_id}
     * Get My Order
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param orderId 
     * @param accessToken  (optional)
     * @return [OrderRead]
     */
    @GET("api/v1/orders/{order_id}")
    suspend fun getMyOrderApiV1OrdersOrderIdGet(@Path("order_id") orderId: kotlin.Int, ): Response<OrderRead>

    /**
     * GET api/v1/admin/orders/{order_id}
     * Get Order Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param orderId 
     * @param accessToken  (optional)
     * @return [OrderAdminRead]
     */
    @GET("api/v1/admin/orders/{order_id}")
    suspend fun getOrderAdminApiV1AdminOrdersOrderIdGet(@Path("order_id") orderId: kotlin.Int, ): Response<OrderAdminRead>

    /**
     * GET api/v1/refund-requests/{refund_id}
     * Get Refund Request
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param refundId 
     * @param accessToken  (optional)
     * @return [RefundRequestRead]
     */
    @GET("api/v1/refund-requests/{refund_id}")
    suspend fun getRefundRequestApiV1RefundRequestsRefundIdGet(@Path("refund_id") refundId: kotlin.Int, ): Response<RefundRequestRead>

    /**
     * GET api/v1/seller/order-groups/{group_id}
     * Get Seller Order Group
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param groupId 
     * @param accessToken  (optional)
     * @return [OrderShopGroupDetailRead]
     */
    @GET("api/v1/seller/order-groups/{group_id}")
    suspend fun getSellerOrderGroupApiV1SellerOrderGroupsGroupIdGet(@Path("group_id") groupId: kotlin.Int, ): Response<OrderShopGroupDetailRead>

    /**
     * GET api/v1/seller/shops/{shop_id}/ledger
     * Get Shop Ledger
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param periodStart 
     * @param periodEnd 
     * @param accessToken  (optional)
     * @return [LedgerStatementRead]
     */
    @GET("api/v1/seller/shops/{shop_id}/ledger")
    suspend fun getShopLedgerApiV1SellerShopsShopIdLedgerGet(@Path("shop_id") shopId: kotlin.Int, @Query("period_start") periodStart: java.time.OffsetDateTime, @Query("period_end") periodEnd: java.time.OffsetDateTime, ): Response<LedgerStatementRead>

    /**
     * GET api/v1/orders
     * List My Orders
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<OrderRead>]
     */
    @GET("api/v1/orders")
    suspend fun listMyOrdersApiV1OrdersGet(): Response<kotlin.collections.List<OrderRead>>

    /**
     * GET api/v1/admin/orders
     * List Orders Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param shopId  (optional)
     * @param buyerId  (optional)
     * @param dateFrom  (optional)
     * @param dateTo  (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<OrderAdminRead>]
     */
    @GET("api/v1/admin/orders")
    suspend fun listOrdersAdminApiV1AdminOrdersGet(@Query("status") status: kotlin.String? = null, @Query("shop_id") shopId: kotlin.Int? = null, @Query("buyer_id") buyerId: kotlin.Int? = null, @Query("date_from") dateFrom: java.time.OffsetDateTime? = null, @Query("date_to") dateTo: java.time.OffsetDateTime? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<OrderAdminRead>>

    /**
     * GET api/v1/admin/payouts
     * List Payouts Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param shopId  (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<PayoutRead>]
     */
    @GET("api/v1/admin/payouts")
    suspend fun listPayoutsAdminApiV1AdminPayoutsGet(@Query("status") status: kotlin.String? = null, @Query("shop_id") shopId: kotlin.Int? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<PayoutRead>>

    /**
     * GET api/v1/admin/refund-requests
     * List Refund Requests Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param status  (optional)
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 50)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<RefundRequestRead>]
     */
    @GET("api/v1/admin/refund-requests")
    suspend fun listRefundRequestsAdminApiV1AdminRefundRequestsGet(@Query("status") status: RefundStatus? = null, @Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 50, ): Response<kotlin.collections.List<RefundRequestRead>>

    /**
     * GET api/v1/seller/shops/{shop_id}/order-groups
     * List Shop Order Groups
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param status  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<OrderShopGroupDetailRead>]
     */
    @GET("api/v1/seller/shops/{shop_id}/order-groups")
    suspend fun listShopOrderGroupsApiV1SellerShopsShopIdOrderGroupsGet(@Path("shop_id") shopId: kotlin.Int, @Query("status") status: OrderShopGroupStatus? = null, ): Response<kotlin.collections.List<OrderShopGroupDetailRead>>

    /**
     * GET api/v1/seller/shops/{shop_id}/payouts
     * List Shop Payouts
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<PayoutRead>]
     */
    @GET("api/v1/seller/shops/{shop_id}/payouts")
    suspend fun listShopPayoutsApiV1SellerShopsShopIdPayoutsGet(@Path("shop_id") shopId: kotlin.Int, ): Response<kotlin.collections.List<PayoutRead>>

    /**
     * GET api/v1/seller/shops/{shop_id}/refund-requests
     * List Shop Refund Requests
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param shopId 
     * @param status  (optional)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<RefundRequestRead>]
     */
    @GET("api/v1/seller/shops/{shop_id}/refund-requests")
    suspend fun listShopRefundRequestsApiV1SellerShopsShopIdRefundRequestsGet(@Path("shop_id") shopId: kotlin.Int, @Query("status") status: RefundStatus? = null, ): Response<kotlin.collections.List<RefundRequestRead>>

    /**
     * POST api/v1/checkout/webhook/{provider}
     * Payment Webhook
     * 
     * Responses:
     *  - 204: Successful Response
     *  - 422: Validation Error
     *
     * @param provider 
     * @param paymentReference 
     * @param status 
     * @param xWebhookSecret  (optional)
     * @return [Unit]
     */
    @POST("api/v1/checkout/webhook/{provider}")
    suspend fun paymentWebhookApiV1CheckoutWebhookProviderPost(@Path("provider") provider: kotlin.String, @Query("payment_reference") paymentReference: kotlin.String, @Query("status_") status: kotlin.String, @Header("x-webhook-secret") xWebhookSecret: kotlin.String? = null): Response<Unit>

    /**
     * PATCH api/v1/seller/refund-requests/{refund_id}/reject
     * Reject Refund Request
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param refundId 
     * @param refundRejectRequest 
     * @param accessToken  (optional)
     * @return [RefundRequestRead]
     */
    @PATCH("api/v1/seller/refund-requests/{refund_id}/reject")
    suspend fun rejectRefundRequestApiV1SellerRefundRequestsRefundIdRejectPatch(@Path("refund_id") refundId: kotlin.Int, @Body refundRejectRequest: RefundRejectRequest, ): Response<RefundRequestRead>

    /**
     * DELETE api/v1/cart/items/{cart_item_id}
     * Remove Cart Item
     * 
     * Responses:
     *  - 204: Successful Response
     *  - 422: Validation Error
     *
     * @param cartItemId 
     * @param accessToken  (optional)
     * @return [Unit]
     */
    @DELETE("api/v1/cart/items/{cart_item_id}")
    suspend fun removeCartItemApiV1CartItemsCartItemIdDelete(@Path("cart_item_id") cartItemId: kotlin.Int, ): Response<Unit>

    /**
     * POST api/v1/order-lines/{order_line_id}/refund-request
     * Request Refund
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param orderLineId 
     * @param refundRequestCreate 
     * @param accessToken  (optional)
     * @return [RefundRequestRead]
     */
    @POST("api/v1/order-lines/{order_line_id}/refund-request")
    suspend fun requestRefundApiV1OrderLinesOrderLineIdRefundRequestPost(@Path("order_line_id") orderLineId: kotlin.Int, @Body refundRequestCreate: RefundRequestCreate, ): Response<RefundRequestRead>

    /**
     * PATCH api/v1/admin/refund-requests/{refund_id}/resolve
     * Resolve Refund Request Admin
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param refundId 
     * @param refundResolveRequest 
     * @param accessToken  (optional)
     * @return [RefundRequestRead]
     */
    @PATCH("api/v1/admin/refund-requests/{refund_id}/resolve")
    suspend fun resolveRefundRequestAdminApiV1AdminRefundRequestsRefundIdResolvePatch(@Path("refund_id") refundId: kotlin.Int, @Body refundResolveRequest: RefundResolveRequest, ): Response<RefundRequestRead>

    /**
     * PATCH api/v1/admin/payouts/{payout_id}/retry
     * Retry Payout
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param payoutId 
     * @param accessToken  (optional)
     * @return [PayoutRead]
     */
    @PATCH("api/v1/admin/payouts/{payout_id}/retry")
    suspend fun retryPayoutApiV1AdminPayoutsPayoutIdRetryPatch(@Path("payout_id") payoutId: kotlin.Int, ): Response<PayoutRead>

    /**
     * POST api/v1/admin/payouts/run
     * Run Payout Batch
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param payoutRunRequest 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<PayoutRead>]
     */
    @POST("api/v1/admin/payouts/run")
    suspend fun runPayoutBatchApiV1AdminPayoutsRunPost(@Body payoutRunRequest: PayoutRunRequest, ): Response<kotlin.collections.List<PayoutRead>>

    /**
     * PATCH api/v1/cart/items/{cart_item_id}
     * Update Cart Item
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param cartItemId 
     * @param cartItemUpdateRequest 
     * @param accessToken  (optional)
     * @return [CartItemRead]
     */
    @PATCH("api/v1/cart/items/{cart_item_id}")
    suspend fun updateCartItemApiV1CartItemsCartItemIdPatch(@Path("cart_item_id") cartItemId: kotlin.Int, @Body cartItemUpdateRequest: CartItemUpdateRequest, ): Response<CartItemRead>

    /**
     * PATCH api/v1/seller/order-groups/{group_id}/status
     * Update Order Group Status
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param groupId 
     * @param groupStatusUpdateRequest 
     * @param accessToken  (optional)
     * @return [OrderShopGroupDetailRead]
     */
    @PATCH("api/v1/seller/order-groups/{group_id}/status")
    suspend fun updateOrderGroupStatusApiV1SellerOrderGroupsGroupIdStatusPatch(@Path("group_id") groupId: kotlin.Int, @Body groupStatusUpdateRequest: GroupStatusUpdateRequest, ): Response<OrderShopGroupDetailRead>

}
