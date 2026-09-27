# OrdersAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addCartItemApiV1CartItemsPost**](OrdersAPI.md#addcartitemapiv1cartitemspost) | **POST** /api/v1/cart/items | Add Cart Item
[**approveRefundRequestApiV1SellerRefundRequestsRefundIdApprovePatch**](OrdersAPI.md#approverefundrequestapiv1sellerrefundrequestsrefundidapprovepatch) | **PATCH** /api/v1/seller/refund-requests/{refund_id}/approve | Approve Refund Request
[**cancelOrderGroupApiV1OrdersOrderIdGroupsGroupIdCancelPost**](OrdersAPI.md#cancelordergroupapiv1ordersorderidgroupsgroupidcancelpost) | **POST** /api/v1/orders/{order_id}/groups/{group_id}/cancel | Cancel Order Group
[**checkoutApiV1CheckoutPost**](OrdersAPI.md#checkoutapiv1checkoutpost) | **POST** /api/v1/checkout | Checkout
[**confirmRefundReturnApiV1SellerRefundRequestsRefundIdConfirmReturnPost**](OrdersAPI.md#confirmrefundreturnapiv1sellerrefundrequestsrefundidconfirmreturnpost) | **POST** /api/v1/seller/refund-requests/{refund_id}/confirm-return | Confirm Refund Return
[**createManualAdjustmentApiV1AdminLedgerShopIdManualAdjustmentPost**](OrdersAPI.md#createmanualadjustmentapiv1adminledgershopidmanualadjustmentpost) | **POST** /api/v1/admin/ledger/{shop_id}/manual-adjustment | Create Manual Adjustment
[**escalateRefundRequestApiV1RefundRequestsRefundIdEscalatePost**](OrdersAPI.md#escalaterefundrequestapiv1refundrequestsrefundidescalatepost) | **POST** /api/v1/refund-requests/{refund_id}/escalate | Escalate Refund Request
[**getCartApiV1CartGet**](OrdersAPI.md#getcartapiv1cartget) | **GET** /api/v1/cart | Get Cart
[**getLedgerAdminApiV1AdminLedgerShopIdGet**](OrdersAPI.md#getledgeradminapiv1adminledgershopidget) | **GET** /api/v1/admin/ledger/{shop_id} | Get Ledger Admin
[**getMyOrderApiV1OrdersOrderIdGet**](OrdersAPI.md#getmyorderapiv1ordersorderidget) | **GET** /api/v1/orders/{order_id} | Get My Order
[**getOrderAdminApiV1AdminOrdersOrderIdGet**](OrdersAPI.md#getorderadminapiv1adminordersorderidget) | **GET** /api/v1/admin/orders/{order_id} | Get Order Admin
[**getRefundRequestApiV1RefundRequestsRefundIdGet**](OrdersAPI.md#getrefundrequestapiv1refundrequestsrefundidget) | **GET** /api/v1/refund-requests/{refund_id} | Get Refund Request
[**getSellerOrderGroupApiV1SellerOrderGroupsGroupIdGet**](OrdersAPI.md#getsellerordergroupapiv1sellerordergroupsgroupidget) | **GET** /api/v1/seller/order-groups/{group_id} | Get Seller Order Group
[**getShopLedgerApiV1SellerShopsShopIdLedgerGet**](OrdersAPI.md#getshopledgerapiv1sellershopsshopidledgerget) | **GET** /api/v1/seller/shops/{shop_id}/ledger | Get Shop Ledger
[**listMyOrdersApiV1OrdersGet**](OrdersAPI.md#listmyordersapiv1ordersget) | **GET** /api/v1/orders | List My Orders
[**listOrdersAdminApiV1AdminOrdersGet**](OrdersAPI.md#listordersadminapiv1adminordersget) | **GET** /api/v1/admin/orders | List Orders Admin
[**listPayoutsAdminApiV1AdminPayoutsGet**](OrdersAPI.md#listpayoutsadminapiv1adminpayoutsget) | **GET** /api/v1/admin/payouts | List Payouts Admin
[**listRefundRequestsAdminApiV1AdminRefundRequestsGet**](OrdersAPI.md#listrefundrequestsadminapiv1adminrefundrequestsget) | **GET** /api/v1/admin/refund-requests | List Refund Requests Admin
[**listShopOrderGroupsApiV1SellerShopsShopIdOrderGroupsGet**](OrdersAPI.md#listshopordergroupsapiv1sellershopsshopidordergroupsget) | **GET** /api/v1/seller/shops/{shop_id}/order-groups | List Shop Order Groups
[**listShopPayoutsApiV1SellerShopsShopIdPayoutsGet**](OrdersAPI.md#listshoppayoutsapiv1sellershopsshopidpayoutsget) | **GET** /api/v1/seller/shops/{shop_id}/payouts | List Shop Payouts
[**listShopRefundRequestsApiV1SellerShopsShopIdRefundRequestsGet**](OrdersAPI.md#listshoprefundrequestsapiv1sellershopsshopidrefundrequestsget) | **GET** /api/v1/seller/shops/{shop_id}/refund-requests | List Shop Refund Requests
[**paymentWebhookApiV1CheckoutWebhookProviderPost**](OrdersAPI.md#paymentwebhookapiv1checkoutwebhookproviderpost) | **POST** /api/v1/checkout/webhook/{provider} | Payment Webhook
[**rejectRefundRequestApiV1SellerRefundRequestsRefundIdRejectPatch**](OrdersAPI.md#rejectrefundrequestapiv1sellerrefundrequestsrefundidrejectpatch) | **PATCH** /api/v1/seller/refund-requests/{refund_id}/reject | Reject Refund Request
[**removeCartItemApiV1CartItemsCartItemIdDelete**](OrdersAPI.md#removecartitemapiv1cartitemscartitemiddelete) | **DELETE** /api/v1/cart/items/{cart_item_id} | Remove Cart Item
[**requestRefundApiV1OrderLinesOrderLineIdRefundRequestPost**](OrdersAPI.md#requestrefundapiv1orderlinesorderlineidrefundrequestpost) | **POST** /api/v1/order-lines/{order_line_id}/refund-request | Request Refund
[**resolveRefundRequestAdminApiV1AdminRefundRequestsRefundIdResolvePatch**](OrdersAPI.md#resolverefundrequestadminapiv1adminrefundrequestsrefundidresolvepatch) | **PATCH** /api/v1/admin/refund-requests/{refund_id}/resolve | Resolve Refund Request Admin
[**retryPayoutApiV1AdminPayoutsPayoutIdRetryPatch**](OrdersAPI.md#retrypayoutapiv1adminpayoutspayoutidretrypatch) | **PATCH** /api/v1/admin/payouts/{payout_id}/retry | Retry Payout
[**runPayoutBatchApiV1AdminPayoutsRunPost**](OrdersAPI.md#runpayoutbatchapiv1adminpayoutsrunpost) | **POST** /api/v1/admin/payouts/run | Run Payout Batch
[**updateCartItemApiV1CartItemsCartItemIdPatch**](OrdersAPI.md#updatecartitemapiv1cartitemscartitemidpatch) | **PATCH** /api/v1/cart/items/{cart_item_id} | Update Cart Item
[**updateOrderGroupStatusApiV1SellerOrderGroupsGroupIdStatusPatch**](OrdersAPI.md#updateordergroupstatusapiv1sellerordergroupsgroupidstatuspatch) | **PATCH** /api/v1/seller/order-groups/{group_id}/status | Update Order Group Status


# **addCartItemApiV1CartItemsPost**
```swift
    open class func addCartItemApiV1CartItemsPost(cartItemAddRequest: CartItemAddRequest, accessToken: String? = nil, cartToken: String? = nil, completion: @escaping (_ data: CartItemRead?, _ error: Error?) -> Void)
```

Add Cart Item

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let cartItemAddRequest = CartItemAddRequest(productId: 123, variantId: 123, quantity: 123) // CartItemAddRequest | 
let accessToken = "accessToken_example" // String |  (optional)
let cartToken = "cartToken_example" // String |  (optional)

// Add Cart Item
OrdersAPI.addCartItemApiV1CartItemsPost(cartItemAddRequest: cartItemAddRequest, accessToken: accessToken, cartToken: cartToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cartItemAddRequest** | [**CartItemAddRequest**](CartItemAddRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 
 **cartToken** | **String** |  | [optional] 

### Return type

[**CartItemRead**](CartItemRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **approveRefundRequestApiV1SellerRefundRequestsRefundIdApprovePatch**
```swift
    open class func approveRefundRequestApiV1SellerRefundRequestsRefundIdApprovePatch(refundId: Int, refundApproveRequest: RefundApproveRequest, accessToken: String? = nil, completion: @escaping (_ data: RefundRequestRead?, _ error: Error?) -> Void)
```

Approve Refund Request

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let refundId = 987 // Int | 
let refundApproveRequest = RefundApproveRequest(whoBearsCost: WhoBearsCost()) // RefundApproveRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Approve Refund Request
OrdersAPI.approveRefundRequestApiV1SellerRefundRequestsRefundIdApprovePatch(refundId: refundId, refundApproveRequest: refundApproveRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **Int** |  | 
 **refundApproveRequest** | [**RefundApproveRequest**](RefundApproveRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **cancelOrderGroupApiV1OrdersOrderIdGroupsGroupIdCancelPost**
```swift
    open class func cancelOrderGroupApiV1OrdersOrderIdGroupsGroupIdCancelPost(orderId: Int, groupId: Int, cancelGroupRequest: CancelGroupRequest, accessToken: String? = nil, completion: @escaping (_ data: OrderShopGroupDetailRead?, _ error: Error?) -> Void)
```

Cancel Order Group

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let orderId = 987 // Int | 
let groupId = 987 // Int | 
let cancelGroupRequest = CancelGroupRequest(reason: "reason_example") // CancelGroupRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Cancel Order Group
OrdersAPI.cancelOrderGroupApiV1OrdersOrderIdGroupsGroupIdCancelPost(orderId: orderId, groupId: groupId, cancelGroupRequest: cancelGroupRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Int** |  | 
 **groupId** | **Int** |  | 
 **cancelGroupRequest** | [**CancelGroupRequest**](CancelGroupRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**OrderShopGroupDetailRead**](OrderShopGroupDetailRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **checkoutApiV1CheckoutPost**
```swift
    open class func checkoutApiV1CheckoutPost(checkoutRequest: CheckoutRequest, accessToken: String? = nil, completion: @escaping (_ data: CheckoutResponse?, _ error: Error?) -> Void)
```

Checkout

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let checkoutRequest = CheckoutRequest(recipient: Recipient(fullName: "fullName_example", phone: "phone_example", notes: "notes_example"), pickupPointId: 123, paymentMethod: PaymentMethod()) // CheckoutRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Checkout
OrdersAPI.checkoutApiV1CheckoutPost(checkoutRequest: checkoutRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **checkoutRequest** | [**CheckoutRequest**](CheckoutRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CheckoutResponse**](CheckoutResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **confirmRefundReturnApiV1SellerRefundRequestsRefundIdConfirmReturnPost**
```swift
    open class func confirmRefundReturnApiV1SellerRefundRequestsRefundIdConfirmReturnPost(refundId: Int, refundConfirmReturnRequest: RefundConfirmReturnRequest, accessToken: String? = nil, completion: @escaping (_ data: RefundRequestRead?, _ error: Error?) -> Void)
```

Confirm Refund Return

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let refundId = 987 // Int | 
let refundConfirmReturnRequest = RefundConfirmReturnRequest(conditionNote: "conditionNote_example") // RefundConfirmReturnRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Confirm Refund Return
OrdersAPI.confirmRefundReturnApiV1SellerRefundRequestsRefundIdConfirmReturnPost(refundId: refundId, refundConfirmReturnRequest: refundConfirmReturnRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **Int** |  | 
 **refundConfirmReturnRequest** | [**RefundConfirmReturnRequest**](RefundConfirmReturnRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createManualAdjustmentApiV1AdminLedgerShopIdManualAdjustmentPost**
```swift
    open class func createManualAdjustmentApiV1AdminLedgerShopIdManualAdjustmentPost(shopId: Int, manualAdjustmentRequest: ManualAdjustmentRequest, accessToken: String? = nil, completion: @escaping (_ data: LedgerEntryRead?, _ error: Error?) -> Void)
```

Create Manual Adjustment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let manualAdjustmentRequest = ManualAdjustmentRequest(amount: Amount(), note: "note_example") // ManualAdjustmentRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Manual Adjustment
OrdersAPI.createManualAdjustmentApiV1AdminLedgerShopIdManualAdjustmentPost(shopId: shopId, manualAdjustmentRequest: manualAdjustmentRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shopId** | **Int** |  | 
 **manualAdjustmentRequest** | [**ManualAdjustmentRequest**](ManualAdjustmentRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**LedgerEntryRead**](LedgerEntryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **escalateRefundRequestApiV1RefundRequestsRefundIdEscalatePost**
```swift
    open class func escalateRefundRequestApiV1RefundRequestsRefundIdEscalatePost(refundId: Int, accessToken: String? = nil, completion: @escaping (_ data: RefundRequestRead?, _ error: Error?) -> Void)
```

Escalate Refund Request

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let refundId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Escalate Refund Request
OrdersAPI.escalateRefundRequestApiV1RefundRequestsRefundIdEscalatePost(refundId: refundId, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCartApiV1CartGet**
```swift
    open class func getCartApiV1CartGet(accessToken: String? = nil, cartToken: String? = nil, completion: @escaping (_ data: CartRead?, _ error: Error?) -> Void)
```

Get Cart

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)
let cartToken = "cartToken_example" // String |  (optional)

// Get Cart
OrdersAPI.getCartApiV1CartGet(accessToken: accessToken, cartToken: cartToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String** |  | [optional] 
 **cartToken** | **String** |  | [optional] 

### Return type

[**CartRead**](CartRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getLedgerAdminApiV1AdminLedgerShopIdGet**
```swift
    open class func getLedgerAdminApiV1AdminLedgerShopIdGet(shopId: Int, periodStart: Date, periodEnd: Date, accessToken: String? = nil, completion: @escaping (_ data: LedgerStatementRead?, _ error: Error?) -> Void)
```

Get Ledger Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let periodStart = Date() // Date | 
let periodEnd = Date() // Date | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Ledger Admin
OrdersAPI.getLedgerAdminApiV1AdminLedgerShopIdGet(shopId: shopId, periodStart: periodStart, periodEnd: periodEnd, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shopId** | **Int** |  | 
 **periodStart** | **Date** |  | 
 **periodEnd** | **Date** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**LedgerStatementRead**](LedgerStatementRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMyOrderApiV1OrdersOrderIdGet**
```swift
    open class func getMyOrderApiV1OrdersOrderIdGet(orderId: Int, accessToken: String? = nil, completion: @escaping (_ data: OrderRead?, _ error: Error?) -> Void)
```

Get My Order

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let orderId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get My Order
OrdersAPI.getMyOrderApiV1OrdersOrderIdGet(orderId: orderId, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**OrderRead**](OrderRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getOrderAdminApiV1AdminOrdersOrderIdGet**
```swift
    open class func getOrderAdminApiV1AdminOrdersOrderIdGet(orderId: Int, accessToken: String? = nil, completion: @escaping (_ data: OrderAdminRead?, _ error: Error?) -> Void)
```

Get Order Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let orderId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Order Admin
OrdersAPI.getOrderAdminApiV1AdminOrdersOrderIdGet(orderId: orderId, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**OrderAdminRead**](OrderAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getRefundRequestApiV1RefundRequestsRefundIdGet**
```swift
    open class func getRefundRequestApiV1RefundRequestsRefundIdGet(refundId: Int, accessToken: String? = nil, completion: @escaping (_ data: RefundRequestRead?, _ error: Error?) -> Void)
```

Get Refund Request

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let refundId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Refund Request
OrdersAPI.getRefundRequestApiV1RefundRequestsRefundIdGet(refundId: refundId, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSellerOrderGroupApiV1SellerOrderGroupsGroupIdGet**
```swift
    open class func getSellerOrderGroupApiV1SellerOrderGroupsGroupIdGet(groupId: Int, accessToken: String? = nil, completion: @escaping (_ data: OrderShopGroupDetailRead?, _ error: Error?) -> Void)
```

Get Seller Order Group

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let groupId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Seller Order Group
OrdersAPI.getSellerOrderGroupApiV1SellerOrderGroupsGroupIdGet(groupId: groupId, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**OrderShopGroupDetailRead**](OrderShopGroupDetailRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getShopLedgerApiV1SellerShopsShopIdLedgerGet**
```swift
    open class func getShopLedgerApiV1SellerShopsShopIdLedgerGet(shopId: Int, periodStart: Date, periodEnd: Date, accessToken: String? = nil, completion: @escaping (_ data: LedgerStatementRead?, _ error: Error?) -> Void)
```

Get Shop Ledger

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let periodStart = Date() // Date | 
let periodEnd = Date() // Date | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Shop Ledger
OrdersAPI.getShopLedgerApiV1SellerShopsShopIdLedgerGet(shopId: shopId, periodStart: periodStart, periodEnd: periodEnd, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shopId** | **Int** |  | 
 **periodStart** | **Date** |  | 
 **periodEnd** | **Date** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**LedgerStatementRead**](LedgerStatementRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listMyOrdersApiV1OrdersGet**
```swift
    open class func listMyOrdersApiV1OrdersGet(accessToken: String? = nil, completion: @escaping (_ data: [OrderRead]?, _ error: Error?) -> Void)
```

List My Orders

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// List My Orders
OrdersAPI.listMyOrdersApiV1OrdersGet(accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessToken** | **String** |  | [optional] 

### Return type

[**[OrderRead]**](OrderRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listOrdersAdminApiV1AdminOrdersGet**
```swift
    open class func listOrdersAdminApiV1AdminOrdersGet(status: String? = nil, shopId: Int? = nil, buyerId: Int? = nil, dateFrom: Date? = nil, dateTo: Date? = nil, search: String? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [OrderAdminRead]?, _ error: Error?) -> Void)
```

List Orders Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = "status_example" // String |  (optional)
let shopId = 987 // Int |  (optional)
let buyerId = 987 // Int |  (optional)
let dateFrom = Date() // Date |  (optional)
let dateTo = Date() // Date |  (optional)
let search = "search_example" // String | Case-insensitive partial match on order_number (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// List Orders Admin
OrdersAPI.listOrdersAdminApiV1AdminOrdersGet(status: status, shopId: shopId, buyerId: buyerId, dateFrom: dateFrom, dateTo: dateTo, search: search, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | **String** |  | [optional] 
 **shopId** | **Int** |  | [optional] 
 **buyerId** | **Int** |  | [optional] 
 **dateFrom** | **Date** |  | [optional] 
 **dateTo** | **Date** |  | [optional] 
 **search** | **String** | Case-insensitive partial match on order_number | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[OrderAdminRead]**](OrderAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listPayoutsAdminApiV1AdminPayoutsGet**
```swift
    open class func listPayoutsAdminApiV1AdminPayoutsGet(status: String? = nil, shopId: Int? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [PayoutRead]?, _ error: Error?) -> Void)
```

List Payouts Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = "status_example" // String |  (optional)
let shopId = 987 // Int |  (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// List Payouts Admin
OrdersAPI.listPayoutsAdminApiV1AdminPayoutsGet(status: status, shopId: shopId, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | **String** |  | [optional] 
 **shopId** | **Int** |  | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[PayoutRead]**](PayoutRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listRefundRequestsAdminApiV1AdminRefundRequestsGet**
```swift
    open class func listRefundRequestsAdminApiV1AdminRefundRequestsGet(status: RefundStatus? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [RefundRequestRead]?, _ error: Error?) -> Void)
```

List Refund Requests Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = RefundStatus() // RefundStatus |  (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// List Refund Requests Admin
OrdersAPI.listRefundRequestsAdminApiV1AdminRefundRequestsGet(status: status, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | [**RefundStatus**](.md) |  | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[RefundRequestRead]**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listShopOrderGroupsApiV1SellerShopsShopIdOrderGroupsGet**
```swift
    open class func listShopOrderGroupsApiV1SellerShopsShopIdOrderGroupsGet(shopId: Int, status: OrderShopGroupStatus? = nil, accessToken: String? = nil, completion: @escaping (_ data: [OrderShopGroupDetailRead]?, _ error: Error?) -> Void)
```

List Shop Order Groups

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let status = OrderShopGroupStatus() // OrderShopGroupStatus |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Shop Order Groups
OrdersAPI.listShopOrderGroupsApiV1SellerShopsShopIdOrderGroupsGet(shopId: shopId, status: status, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shopId** | **Int** |  | 
 **status** | [**OrderShopGroupStatus**](.md) |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[OrderShopGroupDetailRead]**](OrderShopGroupDetailRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listShopPayoutsApiV1SellerShopsShopIdPayoutsGet**
```swift
    open class func listShopPayoutsApiV1SellerShopsShopIdPayoutsGet(shopId: Int, accessToken: String? = nil, completion: @escaping (_ data: [PayoutRead]?, _ error: Error?) -> Void)
```

List Shop Payouts

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// List Shop Payouts
OrdersAPI.listShopPayoutsApiV1SellerShopsShopIdPayoutsGet(shopId: shopId, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shopId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[PayoutRead]**](PayoutRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listShopRefundRequestsApiV1SellerShopsShopIdRefundRequestsGet**
```swift
    open class func listShopRefundRequestsApiV1SellerShopsShopIdRefundRequestsGet(shopId: Int, status: RefundStatus? = nil, accessToken: String? = nil, completion: @escaping (_ data: [RefundRequestRead]?, _ error: Error?) -> Void)
```

List Shop Refund Requests

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let status = RefundStatus() // RefundStatus |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Shop Refund Requests
OrdersAPI.listShopRefundRequestsApiV1SellerShopsShopIdRefundRequestsGet(shopId: shopId, status: status, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **shopId** | **Int** |  | 
 **status** | [**RefundStatus**](.md) |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[RefundRequestRead]**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **paymentWebhookApiV1CheckoutWebhookProviderPost**
```swift
    open class func paymentWebhookApiV1CheckoutWebhookProviderPost(provider: String, paymentReference: String, status: String, xWebhookSecret: String? = nil, completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

Payment Webhook

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let provider = "provider_example" // String | 
let paymentReference = "paymentReference_example" // String | 
let status = "status_example" // String | 
let xWebhookSecret = "xWebhookSecret_example" // String |  (optional)

// Payment Webhook
OrdersAPI.paymentWebhookApiV1CheckoutWebhookProviderPost(provider: provider, paymentReference: paymentReference, status: status, xWebhookSecret: xWebhookSecret) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **provider** | **String** |  | 
 **paymentReference** | **String** |  | 
 **status** | **String** |  | 
 **xWebhookSecret** | **String** |  | [optional] 

### Return type

Void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rejectRefundRequestApiV1SellerRefundRequestsRefundIdRejectPatch**
```swift
    open class func rejectRefundRequestApiV1SellerRefundRequestsRefundIdRejectPatch(refundId: Int, refundRejectRequest: RefundRejectRequest, accessToken: String? = nil, completion: @escaping (_ data: RefundRequestRead?, _ error: Error?) -> Void)
```

Reject Refund Request

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let refundId = 987 // Int | 
let refundRejectRequest = RefundRejectRequest(reason: "reason_example") // RefundRejectRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Reject Refund Request
OrdersAPI.rejectRefundRequestApiV1SellerRefundRequestsRefundIdRejectPatch(refundId: refundId, refundRejectRequest: refundRejectRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **Int** |  | 
 **refundRejectRequest** | [**RefundRejectRequest**](RefundRejectRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **removeCartItemApiV1CartItemsCartItemIdDelete**
```swift
    open class func removeCartItemApiV1CartItemsCartItemIdDelete(cartItemId: Int, accessToken: String? = nil, cartToken: String? = nil, completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

Remove Cart Item

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let cartItemId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)
let cartToken = "cartToken_example" // String |  (optional)

// Remove Cart Item
OrdersAPI.removeCartItemApiV1CartItemsCartItemIdDelete(cartItemId: cartItemId, accessToken: accessToken, cartToken: cartToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cartItemId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 
 **cartToken** | **String** |  | [optional] 

### Return type

Void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **requestRefundApiV1OrderLinesOrderLineIdRefundRequestPost**
```swift
    open class func requestRefundApiV1OrderLinesOrderLineIdRefundRequestPost(orderLineId: Int, refundRequestCreate: RefundRequestCreate, accessToken: String? = nil, completion: @escaping (_ data: RefundRequestRead?, _ error: Error?) -> Void)
```

Request Refund

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let orderLineId = 987 // Int | 
let refundRequestCreate = RefundRequestCreate(reasonCode: RefundReasonCode(), reasonText: "reasonText_example", evidenceUrls: ["evidenceUrls_example"]) // RefundRequestCreate | 
let accessToken = "accessToken_example" // String |  (optional)

// Request Refund
OrdersAPI.requestRefundApiV1OrderLinesOrderLineIdRefundRequestPost(orderLineId: orderLineId, refundRequestCreate: refundRequestCreate, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **orderLineId** | **Int** |  | 
 **refundRequestCreate** | [**RefundRequestCreate**](RefundRequestCreate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resolveRefundRequestAdminApiV1AdminRefundRequestsRefundIdResolvePatch**
```swift
    open class func resolveRefundRequestAdminApiV1AdminRefundRequestsRefundIdResolvePatch(refundId: Int, refundResolveRequest: RefundResolveRequest, accessToken: String? = nil, completion: @escaping (_ data: RefundRequestRead?, _ error: Error?) -> Void)
```

Resolve Refund Request Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let refundId = 987 // Int | 
let refundResolveRequest = RefundResolveRequest(decision: RefundDecision(), whoBearsCost: WhoBearsCost(), reason: "reason_example") // RefundResolveRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Resolve Refund Request Admin
OrdersAPI.resolveRefundRequestAdminApiV1AdminRefundRequestsRefundIdResolvePatch(refundId: refundId, refundResolveRequest: refundResolveRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **Int** |  | 
 **refundResolveRequest** | [**RefundResolveRequest**](RefundResolveRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **retryPayoutApiV1AdminPayoutsPayoutIdRetryPatch**
```swift
    open class func retryPayoutApiV1AdminPayoutsPayoutIdRetryPatch(payoutId: Int, accessToken: String? = nil, completion: @escaping (_ data: PayoutRead?, _ error: Error?) -> Void)
```

Retry Payout

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let payoutId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Retry Payout
OrdersAPI.retryPayoutApiV1AdminPayoutsPayoutIdRetryPatch(payoutId: payoutId, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **payoutId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**PayoutRead**](PayoutRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **runPayoutBatchApiV1AdminPayoutsRunPost**
```swift
    open class func runPayoutBatchApiV1AdminPayoutsRunPost(payoutRunRequest: PayoutRunRequest, accessToken: String? = nil, completion: @escaping (_ data: [PayoutRead]?, _ error: Error?) -> Void)
```

Run Payout Batch

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let payoutRunRequest = PayoutRunRequest(periodStart: Date(), periodEnd: Date()) // PayoutRunRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Run Payout Batch
OrdersAPI.runPayoutBatchApiV1AdminPayoutsRunPost(payoutRunRequest: payoutRunRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **payoutRunRequest** | [**PayoutRunRequest**](PayoutRunRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[PayoutRead]**](PayoutRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateCartItemApiV1CartItemsCartItemIdPatch**
```swift
    open class func updateCartItemApiV1CartItemsCartItemIdPatch(cartItemId: Int, cartItemUpdateRequest: CartItemUpdateRequest, accessToken: String? = nil, cartToken: String? = nil, completion: @escaping (_ data: CartItemRead?, _ error: Error?) -> Void)
```

Update Cart Item

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let cartItemId = 987 // Int | 
let cartItemUpdateRequest = CartItemUpdateRequest(quantity: 123) // CartItemUpdateRequest | 
let accessToken = "accessToken_example" // String |  (optional)
let cartToken = "cartToken_example" // String |  (optional)

// Update Cart Item
OrdersAPI.updateCartItemApiV1CartItemsCartItemIdPatch(cartItemId: cartItemId, cartItemUpdateRequest: cartItemUpdateRequest, accessToken: accessToken, cartToken: cartToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cartItemId** | **Int** |  | 
 **cartItemUpdateRequest** | [**CartItemUpdateRequest**](CartItemUpdateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 
 **cartToken** | **String** |  | [optional] 

### Return type

[**CartItemRead**](CartItemRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateOrderGroupStatusApiV1SellerOrderGroupsGroupIdStatusPatch**
```swift
    open class func updateOrderGroupStatusApiV1SellerOrderGroupsGroupIdStatusPatch(groupId: Int, groupStatusUpdateRequest: GroupStatusUpdateRequest, accessToken: String? = nil, completion: @escaping (_ data: OrderShopGroupDetailRead?, _ error: Error?) -> Void)
```

Update Order Group Status

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let groupId = 987 // Int | 
let groupStatusUpdateRequest = GroupStatusUpdateRequest(status: OrderShopGroupStatus(), reason: "reason_example") // GroupStatusUpdateRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Order Group Status
OrdersAPI.updateOrderGroupStatusApiV1SellerOrderGroupsGroupIdStatusPatch(groupId: groupId, groupStatusUpdateRequest: groupStatusUpdateRequest, accessToken: accessToken) { (response, error) in
    guard error == nil else {
        print(error)
        return
    }

    if (response) {
        dump(response)
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Int** |  | 
 **groupStatusUpdateRequest** | [**GroupStatusUpdateRequest**](GroupStatusUpdateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**OrderShopGroupDetailRead**](OrderShopGroupDetailRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

