# OrdersApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addCartItemApiV1CartItemsPost**](OrdersApi.md#addCartItemApiV1CartItemsPost) | **POST** api/v1/cart/items | Add Cart Item |
| [**approveRefundRequestApiV1SellerRefundRequestsRefundIdApprovePatch**](OrdersApi.md#approveRefundRequestApiV1SellerRefundRequestsRefundIdApprovePatch) | **PATCH** api/v1/seller/refund-requests/{refund_id}/approve | Approve Refund Request |
| [**cancelOrderGroupApiV1OrdersOrderIdGroupsGroupIdCancelPost**](OrdersApi.md#cancelOrderGroupApiV1OrdersOrderIdGroupsGroupIdCancelPost) | **POST** api/v1/orders/{order_id}/groups/{group_id}/cancel | Cancel Order Group |
| [**checkoutApiV1CheckoutPost**](OrdersApi.md#checkoutApiV1CheckoutPost) | **POST** api/v1/checkout | Checkout |
| [**confirmRefundReturnApiV1SellerRefundRequestsRefundIdConfirmReturnPost**](OrdersApi.md#confirmRefundReturnApiV1SellerRefundRequestsRefundIdConfirmReturnPost) | **POST** api/v1/seller/refund-requests/{refund_id}/confirm-return | Confirm Refund Return |
| [**createManualAdjustmentApiV1AdminLedgerShopIdManualAdjustmentPost**](OrdersApi.md#createManualAdjustmentApiV1AdminLedgerShopIdManualAdjustmentPost) | **POST** api/v1/admin/ledger/{shop_id}/manual-adjustment | Create Manual Adjustment |
| [**escalateRefundRequestApiV1RefundRequestsRefundIdEscalatePost**](OrdersApi.md#escalateRefundRequestApiV1RefundRequestsRefundIdEscalatePost) | **POST** api/v1/refund-requests/{refund_id}/escalate | Escalate Refund Request |
| [**getCartApiV1CartGet**](OrdersApi.md#getCartApiV1CartGet) | **GET** api/v1/cart | Get Cart |
| [**getLedgerAdminApiV1AdminLedgerShopIdGet**](OrdersApi.md#getLedgerAdminApiV1AdminLedgerShopIdGet) | **GET** api/v1/admin/ledger/{shop_id} | Get Ledger Admin |
| [**getMyOrderApiV1OrdersOrderIdGet**](OrdersApi.md#getMyOrderApiV1OrdersOrderIdGet) | **GET** api/v1/orders/{order_id} | Get My Order |
| [**getOrderAdminApiV1AdminOrdersOrderIdGet**](OrdersApi.md#getOrderAdminApiV1AdminOrdersOrderIdGet) | **GET** api/v1/admin/orders/{order_id} | Get Order Admin |
| [**getRefundRequestApiV1RefundRequestsRefundIdGet**](OrdersApi.md#getRefundRequestApiV1RefundRequestsRefundIdGet) | **GET** api/v1/refund-requests/{refund_id} | Get Refund Request |
| [**getSellerOrderGroupApiV1SellerOrderGroupsGroupIdGet**](OrdersApi.md#getSellerOrderGroupApiV1SellerOrderGroupsGroupIdGet) | **GET** api/v1/seller/order-groups/{group_id} | Get Seller Order Group |
| [**getShopLedgerApiV1SellerShopsShopIdLedgerGet**](OrdersApi.md#getShopLedgerApiV1SellerShopsShopIdLedgerGet) | **GET** api/v1/seller/shops/{shop_id}/ledger | Get Shop Ledger |
| [**listMyOrdersApiV1OrdersGet**](OrdersApi.md#listMyOrdersApiV1OrdersGet) | **GET** api/v1/orders | List My Orders |
| [**listOrdersAdminApiV1AdminOrdersGet**](OrdersApi.md#listOrdersAdminApiV1AdminOrdersGet) | **GET** api/v1/admin/orders | List Orders Admin |
| [**listPayoutsAdminApiV1AdminPayoutsGet**](OrdersApi.md#listPayoutsAdminApiV1AdminPayoutsGet) | **GET** api/v1/admin/payouts | List Payouts Admin |
| [**listRefundRequestsAdminApiV1AdminRefundRequestsGet**](OrdersApi.md#listRefundRequestsAdminApiV1AdminRefundRequestsGet) | **GET** api/v1/admin/refund-requests | List Refund Requests Admin |
| [**listShopOrderGroupsApiV1SellerShopsShopIdOrderGroupsGet**](OrdersApi.md#listShopOrderGroupsApiV1SellerShopsShopIdOrderGroupsGet) | **GET** api/v1/seller/shops/{shop_id}/order-groups | List Shop Order Groups |
| [**listShopPayoutsApiV1SellerShopsShopIdPayoutsGet**](OrdersApi.md#listShopPayoutsApiV1SellerShopsShopIdPayoutsGet) | **GET** api/v1/seller/shops/{shop_id}/payouts | List Shop Payouts |
| [**listShopRefundRequestsApiV1SellerShopsShopIdRefundRequestsGet**](OrdersApi.md#listShopRefundRequestsApiV1SellerShopsShopIdRefundRequestsGet) | **GET** api/v1/seller/shops/{shop_id}/refund-requests | List Shop Refund Requests |
| [**paymentWebhookApiV1CheckoutWebhookProviderPost**](OrdersApi.md#paymentWebhookApiV1CheckoutWebhookProviderPost) | **POST** api/v1/checkout/webhook/{provider} | Payment Webhook |
| [**rejectRefundRequestApiV1SellerRefundRequestsRefundIdRejectPatch**](OrdersApi.md#rejectRefundRequestApiV1SellerRefundRequestsRefundIdRejectPatch) | **PATCH** api/v1/seller/refund-requests/{refund_id}/reject | Reject Refund Request |
| [**removeCartItemApiV1CartItemsCartItemIdDelete**](OrdersApi.md#removeCartItemApiV1CartItemsCartItemIdDelete) | **DELETE** api/v1/cart/items/{cart_item_id} | Remove Cart Item |
| [**requestRefundApiV1OrderLinesOrderLineIdRefundRequestPost**](OrdersApi.md#requestRefundApiV1OrderLinesOrderLineIdRefundRequestPost) | **POST** api/v1/order-lines/{order_line_id}/refund-request | Request Refund |
| [**resolveRefundRequestAdminApiV1AdminRefundRequestsRefundIdResolvePatch**](OrdersApi.md#resolveRefundRequestAdminApiV1AdminRefundRequestsRefundIdResolvePatch) | **PATCH** api/v1/admin/refund-requests/{refund_id}/resolve | Resolve Refund Request Admin |
| [**retryPayoutApiV1AdminPayoutsPayoutIdRetryPatch**](OrdersApi.md#retryPayoutApiV1AdminPayoutsPayoutIdRetryPatch) | **PATCH** api/v1/admin/payouts/{payout_id}/retry | Retry Payout |
| [**runPayoutBatchApiV1AdminPayoutsRunPost**](OrdersApi.md#runPayoutBatchApiV1AdminPayoutsRunPost) | **POST** api/v1/admin/payouts/run | Run Payout Batch |
| [**updateCartItemApiV1CartItemsCartItemIdPatch**](OrdersApi.md#updateCartItemApiV1CartItemsCartItemIdPatch) | **PATCH** api/v1/cart/items/{cart_item_id} | Update Cart Item |
| [**updateOrderGroupStatusApiV1SellerOrderGroupsGroupIdStatusPatch**](OrdersApi.md#updateOrderGroupStatusApiV1SellerOrderGroupsGroupIdStatusPatch) | **PATCH** api/v1/seller/order-groups/{group_id}/status | Update Order Group Status |



Add Cart Item

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val cartItemAddRequest : CartItemAddRequest =  // CartItemAddRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 
val cartToken : kotlin.String = cartToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CartItemRead = webService.addCartItemApiV1CartItemsPost(cartItemAddRequest, accessToken, cartToken)
}
```

### Parameters
| **cartItemAddRequest** | [**CartItemAddRequest**](CartItemAddRequest.md)|  | |
| **accessToken** | **kotlin.String**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **cartToken** | **kotlin.String**|  | [optional] |

### Return type

[**CartItemRead**](CartItemRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Approve Refund Request

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val refundId : kotlin.Int = 56 // kotlin.Int | 
val refundApproveRequest : RefundApproveRequest =  // RefundApproveRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RefundRequestRead = webService.approveRefundRequestApiV1SellerRefundRequestsRefundIdApprovePatch(refundId, refundApproveRequest, accessToken)
}
```

### Parameters
| **refundId** | **kotlin.Int**|  | |
| **refundApproveRequest** | [**RefundApproveRequest**](RefundApproveRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Cancel Order Group

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val orderId : kotlin.Int = 56 // kotlin.Int | 
val groupId : kotlin.Int = 56 // kotlin.Int | 
val cancelGroupRequest : CancelGroupRequest =  // CancelGroupRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : OrderShopGroupRead = webService.cancelOrderGroupApiV1OrdersOrderIdGroupsGroupIdCancelPost(orderId, groupId, cancelGroupRequest, accessToken)
}
```

### Parameters
| **orderId** | **kotlin.Int**|  | |
| **groupId** | **kotlin.Int**|  | |
| **cancelGroupRequest** | [**CancelGroupRequest**](CancelGroupRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**OrderShopGroupRead**](OrderShopGroupRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Checkout

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val checkoutRequest : CheckoutRequest =  // CheckoutRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CheckoutResponse = webService.checkoutApiV1CheckoutPost(checkoutRequest, accessToken)
}
```

### Parameters
| **checkoutRequest** | [**CheckoutRequest**](CheckoutRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CheckoutResponse**](CheckoutResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Confirm Refund Return

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val refundId : kotlin.Int = 56 // kotlin.Int | 
val refundConfirmReturnRequest : RefundConfirmReturnRequest =  // RefundConfirmReturnRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RefundRequestRead = webService.confirmRefundReturnApiV1SellerRefundRequestsRefundIdConfirmReturnPost(refundId, refundConfirmReturnRequest, accessToken)
}
```

### Parameters
| **refundId** | **kotlin.Int**|  | |
| **refundConfirmReturnRequest** | [**RefundConfirmReturnRequest**](RefundConfirmReturnRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Create Manual Adjustment

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val manualAdjustmentRequest : ManualAdjustmentRequest =  // ManualAdjustmentRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : LedgerEntryRead = webService.createManualAdjustmentApiV1AdminLedgerShopIdManualAdjustmentPost(shopId, manualAdjustmentRequest, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **manualAdjustmentRequest** | [**ManualAdjustmentRequest**](ManualAdjustmentRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**LedgerEntryRead**](LedgerEntryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Escalate Refund Request

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val refundId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RefundRequestRead = webService.escalateRefundRequestApiV1RefundRequestsRefundIdEscalatePost(refundId, accessToken)
}
```

### Parameters
| **refundId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Cart

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 
val cartToken : kotlin.String = cartToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CartRead = webService.getCartApiV1CartGet(accessToken, cartToken)
}
```

### Parameters
| **accessToken** | **kotlin.String**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **cartToken** | **kotlin.String**|  | [optional] |

### Return type

[**CartRead**](CartRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Ledger Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val periodStart : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val periodEnd : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : LedgerStatementRead = webService.getLedgerAdminApiV1AdminLedgerShopIdGet(shopId, periodStart, periodEnd, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **periodStart** | **java.time.OffsetDateTime**|  | |
| **periodEnd** | **java.time.OffsetDateTime**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**LedgerStatementRead**](LedgerStatementRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get My Order

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val orderId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : OrderRead = webService.getMyOrderApiV1OrdersOrderIdGet(orderId, accessToken)
}
```

### Parameters
| **orderId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**OrderRead**](OrderRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Order Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val orderId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : OrderAdminRead = webService.getOrderAdminApiV1AdminOrdersOrderIdGet(orderId, accessToken)
}
```

### Parameters
| **orderId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**OrderAdminRead**](OrderAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Refund Request

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val refundId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RefundRequestRead = webService.getRefundRequestApiV1RefundRequestsRefundIdGet(refundId, accessToken)
}
```

### Parameters
| **refundId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Seller Order Group

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val groupId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : OrderShopGroupDetailRead = webService.getSellerOrderGroupApiV1SellerOrderGroupsGroupIdGet(groupId, accessToken)
}
```

### Parameters
| **groupId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**OrderShopGroupDetailRead**](OrderShopGroupDetailRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Shop Ledger

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val periodStart : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val periodEnd : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : LedgerStatementRead = webService.getShopLedgerApiV1SellerShopsShopIdLedgerGet(shopId, periodStart, periodEnd, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **periodStart** | **java.time.OffsetDateTime**|  | |
| **periodEnd** | **java.time.OffsetDateTime**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**LedgerStatementRead**](LedgerStatementRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List My Orders

My orders, newest first. &#x60;status&#x60; may repeat; the total match count is in &#x60;X-Total-Count&#x60;.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val status : kotlin.collections.List<OrderStatus> =  // kotlin.collections.List<OrderStatus> | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<OrderRead> = webService.listMyOrdersApiV1OrdersGet(status, skip, limit, accessToken)
}
```

### Parameters
| **status** | [**kotlin.collections.List&lt;OrderStatus&gt;**](OrderStatus.md)|  | [optional] [default to arrayListOf()] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;OrderRead&gt;**](OrderRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Orders Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val status : kotlin.String = status_example // kotlin.String | 
val shopId : kotlin.Int = 56 // kotlin.Int | 
val buyerId : kotlin.Int = 56 // kotlin.Int | 
val dateFrom : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val dateTo : java.time.OffsetDateTime = 2013-10-20T19:20:30+01:00 // java.time.OffsetDateTime | 
val search : kotlin.String = search_example // kotlin.String | Case-insensitive partial match on order_number
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<OrderAdminRead> = webService.listOrdersAdminApiV1AdminOrdersGet(status, shopId, buyerId, dateFrom, dateTo, search, skip, limit, accessToken)
}
```

### Parameters
| **status** | **kotlin.String**|  | [optional] |
| **shopId** | **kotlin.Int**|  | [optional] |
| **buyerId** | **kotlin.Int**|  | [optional] |
| **dateFrom** | **java.time.OffsetDateTime**|  | [optional] |
| **dateTo** | **java.time.OffsetDateTime**|  | [optional] |
| **search** | **kotlin.String**| Case-insensitive partial match on order_number | [optional] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;OrderAdminRead&gt;**](OrderAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Payouts Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val status : kotlin.String = status_example // kotlin.String | 
val shopId : kotlin.Int = 56 // kotlin.Int | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PayoutRead> = webService.listPayoutsAdminApiV1AdminPayoutsGet(status, shopId, skip, limit, accessToken)
}
```

### Parameters
| **status** | **kotlin.String**|  | [optional] |
| **shopId** | **kotlin.Int**|  | [optional] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PayoutRead&gt;**](PayoutRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Refund Requests Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val status : RefundStatus =  // RefundStatus | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RefundRequestRead> = webService.listRefundRequestsAdminApiV1AdminRefundRequestsGet(status, skip, limit, accessToken)
}
```

### Parameters
| **status** | [**RefundStatus**](.md)|  | [optional] [enum: pending, approved, rejected, escalated_to_admin] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;RefundRequestRead&gt;**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Shop Order Groups

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val status : OrderShopGroupStatus =  // OrderShopGroupStatus | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<OrderShopGroupDetailRead> = webService.listShopOrderGroupsApiV1SellerShopsShopIdOrderGroupsGet(shopId, status, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **status** | [**OrderShopGroupStatus**](.md)|  | [optional] [enum: pending, confirmed, preparing, at_warehouse, shipped, delivered, cancelled, return_requested, partially_refunded, refunded, arrived_at_point, partially_collected, rejected_by_buyer, return_to_seller] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;OrderShopGroupDetailRead&gt;**](OrderShopGroupDetailRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Shop Payouts

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PayoutRead> = webService.listShopPayoutsApiV1SellerShopsShopIdPayoutsGet(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PayoutRead&gt;**](PayoutRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Shop Refund Requests

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val status : RefundStatus =  // RefundStatus | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RefundRequestRead> = webService.listShopRefundRequestsApiV1SellerShopsShopIdRefundRequestsGet(shopId, status, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **status** | [**RefundStatus**](.md)|  | [optional] [enum: pending, approved, rejected, escalated_to_admin] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;RefundRequestRead&gt;**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Payment Webhook

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val provider : kotlin.String = provider_example // kotlin.String | 
val paymentReference : kotlin.String = paymentReference_example // kotlin.String | 
val status : kotlin.String = status_example // kotlin.String | 
val xWebhookSecret : kotlin.String = xWebhookSecret_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.paymentWebhookApiV1CheckoutWebhookProviderPost(provider, paymentReference, status, xWebhookSecret)
}
```

### Parameters
| **provider** | **kotlin.String**|  | |
| **paymentReference** | **kotlin.String**|  | |
| **status** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **xWebhookSecret** | **kotlin.String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Reject Refund Request

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val refundId : kotlin.Int = 56 // kotlin.Int | 
val refundRejectRequest : RefundRejectRequest =  // RefundRejectRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RefundRequestRead = webService.rejectRefundRequestApiV1SellerRefundRequestsRefundIdRejectPatch(refundId, refundRejectRequest, accessToken)
}
```

### Parameters
| **refundId** | **kotlin.Int**|  | |
| **refundRejectRequest** | [**RefundRejectRequest**](RefundRejectRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Remove Cart Item

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val cartItemId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 
val cartToken : kotlin.String = cartToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.removeCartItemApiV1CartItemsCartItemIdDelete(cartItemId, accessToken, cartToken)
}
```

### Parameters
| **cartItemId** | **kotlin.Int**|  | |
| **accessToken** | **kotlin.String**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **cartToken** | **kotlin.String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Request Refund

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val orderLineId : kotlin.Int = 56 // kotlin.Int | 
val refundRequestCreate : RefundRequestCreate =  // RefundRequestCreate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RefundRequestRead = webService.requestRefundApiV1OrderLinesOrderLineIdRefundRequestPost(orderLineId, refundRequestCreate, accessToken)
}
```

### Parameters
| **orderLineId** | **kotlin.Int**|  | |
| **refundRequestCreate** | [**RefundRequestCreate**](RefundRequestCreate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Resolve Refund Request Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val refundId : kotlin.Int = 56 // kotlin.Int | 
val refundResolveRequest : RefundResolveRequest =  // RefundResolveRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RefundRequestRead = webService.resolveRefundRequestAdminApiV1AdminRefundRequestsRefundIdResolvePatch(refundId, refundResolveRequest, accessToken)
}
```

### Parameters
| **refundId** | **kotlin.Int**|  | |
| **refundResolveRequest** | [**RefundResolveRequest**](RefundResolveRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Retry Payout

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val payoutId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PayoutRead = webService.retryPayoutApiV1AdminPayoutsPayoutIdRetryPatch(payoutId, accessToken)
}
```

### Parameters
| **payoutId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PayoutRead**](PayoutRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Run Payout Batch

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val payoutRunRequest : PayoutRunRequest =  // PayoutRunRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PayoutRead> = webService.runPayoutBatchApiV1AdminPayoutsRunPost(payoutRunRequest, accessToken)
}
```

### Parameters
| **payoutRunRequest** | [**PayoutRunRequest**](PayoutRunRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PayoutRead&gt;**](PayoutRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Cart Item

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val cartItemId : kotlin.Int = 56 // kotlin.Int | 
val cartItemUpdateRequest : CartItemUpdateRequest =  // CartItemUpdateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 
val cartToken : kotlin.String = cartToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CartItemRead = webService.updateCartItemApiV1CartItemsCartItemIdPatch(cartItemId, cartItemUpdateRequest, accessToken, cartToken)
}
```

### Parameters
| **cartItemId** | **kotlin.Int**|  | |
| **cartItemUpdateRequest** | [**CartItemUpdateRequest**](CartItemUpdateRequest.md)|  | |
| **accessToken** | **kotlin.String**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **cartToken** | **kotlin.String**|  | [optional] |

### Return type

[**CartItemRead**](CartItemRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Order Group Status

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(OrdersApi::class.java)
val groupId : kotlin.Int = 56 // kotlin.Int | 
val groupStatusUpdateRequest : GroupStatusUpdateRequest =  // GroupStatusUpdateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : OrderShopGroupDetailRead = webService.updateOrderGroupStatusApiV1SellerOrderGroupsGroupIdStatusPatch(groupId, groupStatusUpdateRequest, accessToken)
}
```

### Parameters
| **groupId** | **kotlin.Int**|  | |
| **groupStatusUpdateRequest** | [**GroupStatusUpdateRequest**](GroupStatusUpdateRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**OrderShopGroupDetailRead**](OrderShopGroupDetailRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

