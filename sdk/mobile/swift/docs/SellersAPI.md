# SellersAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addBankAccountApiV1SellerBankAccountsPost**](SellersAPI.md#addbankaccountapiv1sellerbankaccountspost) | **POST** /api/v1/seller/bank-accounts | Add Bank Account
[**approveSellerApiV1AdminSellersSellerIdApprovePatch**](SellersAPI.md#approvesellerapiv1adminsellersselleridapprovepatch) | **PATCH** /api/v1/admin/sellers/{seller_id}/approve | Approve Seller
[**banSellerApiV1AdminSellersSellerIdBanPatch**](SellersAPI.md#bansellerapiv1adminsellersselleridbanpatch) | **PATCH** /api/v1/admin/sellers/{seller_id}/ban | Ban Seller
[**getSellerAdminApiV1AdminSellersSellerIdGet**](SellersAPI.md#getselleradminapiv1adminsellersselleridget) | **GET** /api/v1/admin/sellers/{seller_id} | Get Seller Admin
[**getSellerMeApiV1SellerMeGet**](SellersAPI.md#getsellermeapiv1sellermeget) | **GET** /api/v1/seller/me | Get Seller Me
[**listSellerDocumentsApiV1AdminSellersSellerIdDocumentsGet**](SellersAPI.md#listsellerdocumentsapiv1adminsellersselleriddocumentsget) | **GET** /api/v1/admin/sellers/{seller_id}/documents | List Seller Documents
[**listSellersApiV1AdminSellersGet**](SellersAPI.md#listsellersapiv1adminsellersget) | **GET** /api/v1/admin/sellers | List Sellers
[**registerSellerApiV1SellerRegisterPost**](SellersAPI.md#registersellerapiv1sellerregisterpost) | **POST** /api/v1/seller/register | Register Seller
[**reinstateSellerApiV1AdminSellersSellerIdReinstatePatch**](SellersAPI.md#reinstatesellerapiv1adminsellersselleridreinstatepatch) | **PATCH** /api/v1/admin/sellers/{seller_id}/reinstate | Reinstate Seller
[**rejectSellerApiV1AdminSellersSellerIdRejectPatch**](SellersAPI.md#rejectsellerapiv1adminsellersselleridrejectpatch) | **PATCH** /api/v1/admin/sellers/{seller_id}/reject | Reject Seller
[**reviewDocumentApiV1AdminSellersSellerIdDocumentsDocIdPatch**](SellersAPI.md#reviewdocumentapiv1adminsellersselleriddocumentsdocidpatch) | **PATCH** /api/v1/admin/sellers/{seller_id}/documents/{doc_id} | Review Document
[**submitDocumentApiV1SellerDocumentsPost**](SellersAPI.md#submitdocumentapiv1sellerdocumentspost) | **POST** /api/v1/seller/documents | Submit Document
[**suspendSellerApiV1AdminSellersSellerIdSuspendPatch**](SellersAPI.md#suspendsellerapiv1adminsellersselleridsuspendpatch) | **PATCH** /api/v1/admin/sellers/{seller_id}/suspend | Suspend Seller
[**updateShopLimitApiV1AdminSellersSellerIdShopLimitPatch**](SellersAPI.md#updateshoplimitapiv1adminsellersselleridshoplimitpatch) | **PATCH** /api/v1/admin/sellers/{seller_id}/shop-limit | Update Shop Limit


# **addBankAccountApiV1SellerBankAccountsPost**
```swift
    open class func addBankAccountApiV1SellerBankAccountsPost(bankAccountCreateRequest: BankAccountCreateRequest, accessToken: String? = nil, completion: @escaping (_ data: BankAccountRead?, _ error: Error?) -> Void)
```

Add Bank Account

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let bankAccountCreateRequest = BankAccountCreateRequest(ownerType: BankOwnerType(), shopId: 123, accountHolderName: "accountHolderName_example", bankName: "bankName_example", accountNumber: "accountNumber_example", isPrimary: false) // BankAccountCreateRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Add Bank Account
SellersAPI.addBankAccountApiV1SellerBankAccountsPost(bankAccountCreateRequest: bankAccountCreateRequest, accessToken: accessToken) { (response, error) in
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
 **bankAccountCreateRequest** | [**BankAccountCreateRequest**](BankAccountCreateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**BankAccountRead**](BankAccountRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **approveSellerApiV1AdminSellersSellerIdApprovePatch**
```swift
    open class func approveSellerApiV1AdminSellersSellerIdApprovePatch(sellerId: Int, accessToken: String? = nil, completion: @escaping (_ data: SellerRead?, _ error: Error?) -> Void)
```

Approve Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Approve Seller
SellersAPI.approveSellerApiV1AdminSellersSellerIdApprovePatch(sellerId: sellerId, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **banSellerApiV1AdminSellersSellerIdBanPatch**
```swift
    open class func banSellerApiV1AdminSellersSellerIdBanPatch(sellerId: Int, statusReasonRequest: StatusReasonRequest, accessToken: String? = nil, completion: @escaping (_ data: SellerRead?, _ error: Error?) -> Void)
```

Ban Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let statusReasonRequest = StatusReasonRequest(reason: "reason_example") // StatusReasonRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Ban Seller
SellersAPI.banSellerApiV1AdminSellersSellerIdBanPatch(sellerId: sellerId, statusReasonRequest: statusReasonRequest, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSellerAdminApiV1AdminSellersSellerIdGet**
```swift
    open class func getSellerAdminApiV1AdminSellersSellerIdGet(sellerId: Int, accessToken: String? = nil, completion: @escaping (_ data: SellerAdminRead?, _ error: Error?) -> Void)
```

Get Seller Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Seller Admin
SellersAPI.getSellerAdminApiV1AdminSellersSellerIdGet(sellerId: sellerId, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**SellerAdminRead**](SellerAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getSellerMeApiV1SellerMeGet**
```swift
    open class func getSellerMeApiV1SellerMeGet(accessToken: String? = nil, completion: @escaping (_ data: SellerRead?, _ error: Error?) -> Void)
```

Get Seller Me

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// Get Seller Me
SellersAPI.getSellerMeApiV1SellerMeGet(accessToken: accessToken) { (response, error) in
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

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listSellerDocumentsApiV1AdminSellersSellerIdDocumentsGet**
```swift
    open class func listSellerDocumentsApiV1AdminSellersSellerIdDocumentsGet(sellerId: Int, accessToken: String? = nil, completion: @escaping (_ data: [DocumentRead]?, _ error: Error?) -> Void)
```

List Seller Documents

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// List Seller Documents
SellersAPI.listSellerDocumentsApiV1AdminSellersSellerIdDocumentsGet(sellerId: sellerId, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[DocumentRead]**](DocumentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listSellersApiV1AdminSellersGet**
```swift
    open class func listSellersApiV1AdminSellersGet(status: String? = nil, search: String? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [SellerRead]?, _ error: Error?) -> Void)
```

List Sellers

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = "status_example" // String |  (optional)
let search = "search_example" // String |  (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// List Sellers
SellersAPI.listSellersApiV1AdminSellersGet(status: status, search: search, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **search** | **String** |  | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[SellerRead]**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **registerSellerApiV1SellerRegisterPost**
```swift
    open class func registerSellerApiV1SellerRegisterPost(sellerRegisterRequest: SellerRegisterRequest, accessToken: String? = nil, completion: @escaping (_ data: SellerRead?, _ error: Error?) -> Void)
```

Register Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerRegisterRequest = SellerRegisterRequest(legalName: "legalName_example", entityType: EntityType(), taxId: "taxId_example", country: "country_example", contactEmail: "contactEmail_example", contactPhone: "contactPhone_example") // SellerRegisterRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Register Seller
SellersAPI.registerSellerApiV1SellerRegisterPost(sellerRegisterRequest: sellerRegisterRequest, accessToken: accessToken) { (response, error) in
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
 **sellerRegisterRequest** | [**SellerRegisterRequest**](SellerRegisterRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **reinstateSellerApiV1AdminSellersSellerIdReinstatePatch**
```swift
    open class func reinstateSellerApiV1AdminSellersSellerIdReinstatePatch(sellerId: Int, accessToken: String? = nil, completion: @escaping (_ data: SellerRead?, _ error: Error?) -> Void)
```

Reinstate Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Reinstate Seller
SellersAPI.reinstateSellerApiV1AdminSellersSellerIdReinstatePatch(sellerId: sellerId, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rejectSellerApiV1AdminSellersSellerIdRejectPatch**
```swift
    open class func rejectSellerApiV1AdminSellersSellerIdRejectPatch(sellerId: Int, statusReasonRequest: StatusReasonRequest, accessToken: String? = nil, completion: @escaping (_ data: SellerRead?, _ error: Error?) -> Void)
```

Reject Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let statusReasonRequest = StatusReasonRequest(reason: "reason_example") // StatusReasonRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Reject Seller
SellersAPI.rejectSellerApiV1AdminSellersSellerIdRejectPatch(sellerId: sellerId, statusReasonRequest: statusReasonRequest, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **reviewDocumentApiV1AdminSellersSellerIdDocumentsDocIdPatch**
```swift
    open class func reviewDocumentApiV1AdminSellersSellerIdDocumentsDocIdPatch(sellerId: Int, docId: Int, documentReviewRequest: DocumentReviewRequest, accessToken: String? = nil, completion: @escaping (_ data: DocumentRead?, _ error: Error?) -> Void)
```

Review Document

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let docId = 987 // Int | 
let documentReviewRequest = DocumentReviewRequest(status: DocumentStatus(), rejectionReason: "rejectionReason_example") // DocumentReviewRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Review Document
SellersAPI.reviewDocumentApiV1AdminSellersSellerIdDocumentsDocIdPatch(sellerId: sellerId, docId: docId, documentReviewRequest: documentReviewRequest, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **docId** | **Int** |  | 
 **documentReviewRequest** | [**DocumentReviewRequest**](DocumentReviewRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**DocumentRead**](DocumentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **submitDocumentApiV1SellerDocumentsPost**
```swift
    open class func submitDocumentApiV1SellerDocumentsPost(documentSubmitRequest: DocumentSubmitRequest, accessToken: String? = nil, completion: @escaping (_ data: DocumentRead?, _ error: Error?) -> Void)
```

Submit Document

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let documentSubmitRequest = DocumentSubmitRequest(type: DocumentType(), fileUrl: "fileUrl_example", shopId: 123) // DocumentSubmitRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Submit Document
SellersAPI.submitDocumentApiV1SellerDocumentsPost(documentSubmitRequest: documentSubmitRequest, accessToken: accessToken) { (response, error) in
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
 **documentSubmitRequest** | [**DocumentSubmitRequest**](DocumentSubmitRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**DocumentRead**](DocumentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **suspendSellerApiV1AdminSellersSellerIdSuspendPatch**
```swift
    open class func suspendSellerApiV1AdminSellersSellerIdSuspendPatch(sellerId: Int, statusReasonRequest: StatusReasonRequest, accessToken: String? = nil, completion: @escaping (_ data: SellerRead?, _ error: Error?) -> Void)
```

Suspend Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let statusReasonRequest = StatusReasonRequest(reason: "reason_example") // StatusReasonRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Suspend Seller
SellersAPI.suspendSellerApiV1AdminSellersSellerIdSuspendPatch(sellerId: sellerId, statusReasonRequest: statusReasonRequest, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateShopLimitApiV1AdminSellersSellerIdShopLimitPatch**
```swift
    open class func updateShopLimitApiV1AdminSellersSellerIdShopLimitPatch(sellerId: Int, updateShopLimitRequest: UpdateShopLimitRequest, accessToken: String? = nil, completion: @escaping (_ data: SellerRead?, _ error: Error?) -> Void)
```

Update Shop Limit

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int | 
let updateShopLimitRequest = UpdateShopLimitRequest(shopLimit: 123) // UpdateShopLimitRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Shop Limit
SellersAPI.updateShopLimitApiV1AdminSellersSellerIdShopLimitPatch(sellerId: sellerId, updateShopLimitRequest: updateShopLimitRequest, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | 
 **updateShopLimitRequest** | [**UpdateShopLimitRequest**](UpdateShopLimitRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

