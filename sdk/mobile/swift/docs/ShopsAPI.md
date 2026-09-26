# ShopsAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**approveCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdApprovePatch**](ShopsAPI.md#approvecategoryassignmentapiv1adminshopcategoryassignmentsassignmentidapprovepatch) | **PATCH** /api/v1/admin/shop-category-assignments/{assignment_id}/approve | Approve Category Assignment
[**approveShopApiV1AdminShopsShopIdApprovePatch**](ShopsAPI.md#approveshopapiv1adminshopsshopidapprovepatch) | **PATCH** /api/v1/admin/shops/{shop_id}/approve | Approve Shop
[**closeShopApiV1SellerShopsShopIdClosePost**](ShopsAPI.md#closeshopapiv1sellershopsshopidclosepost) | **POST** /api/v1/seller/shops/{shop_id}/close | Close Shop
[**createShopApiV1SellerShopsPost**](ShopsAPI.md#createshopapiv1sellershopspost) | **POST** /api/v1/seller/shops | Create Shop
[**getOwnShopApiV1SellerShopsShopIdGet**](ShopsAPI.md#getownshopapiv1sellershopsshopidget) | **GET** /api/v1/seller/shops/{shop_id} | Get Own Shop
[**getShopAdminApiV1AdminShopsShopIdGet**](ShopsAPI.md#getshopadminapiv1adminshopsshopidget) | **GET** /api/v1/admin/shops/{shop_id} | Get Shop Admin
[**inviteStaffApiV1SellerShopsShopIdStaffPost**](ShopsAPI.md#invitestaffapiv1sellershopsshopidstaffpost) | **POST** /api/v1/seller/shops/{shop_id}/staff | Invite Staff
[**listAllShopsApiV1AdminShopsGet**](ShopsAPI.md#listallshopsapiv1adminshopsget) | **GET** /api/v1/admin/shops | List All Shops
[**listAuditLogApiV1AdminAuditLogGet**](ShopsAPI.md#listauditlogapiv1adminauditlogget) | **GET** /api/v1/admin/audit-log | List Audit Log
[**listOwnCategoryAssignmentsApiV1SellerShopsShopIdCategoryAssignmentsGet**](ShopsAPI.md#listowncategoryassignmentsapiv1sellershopsshopidcategoryassignmentsget) | **GET** /api/v1/seller/shops/{shop_id}/category-assignments | List Own Category Assignments
[**listOwnShopsApiV1SellerShopsGet**](ShopsAPI.md#listownshopsapiv1sellershopsget) | **GET** /api/v1/seller/shops | List Own Shops
[**listShopCategoryAssignmentsApiV1AdminShopCategoryAssignmentsGet**](ShopsAPI.md#listshopcategoryassignmentsapiv1adminshopcategoryassignmentsget) | **GET** /api/v1/admin/shop-category-assignments | List Shop Category Assignments
[**reactivateShopApiV1AdminShopsShopIdReactivatePatch**](ShopsAPI.md#reactivateshopapiv1adminshopsshopidreactivatepatch) | **PATCH** /api/v1/admin/shops/{shop_id}/reactivate | Reactivate Shop
[**rejectCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdRejectPatch**](ShopsAPI.md#rejectcategoryassignmentapiv1adminshopcategoryassignmentsassignmentidrejectpatch) | **PATCH** /api/v1/admin/shop-category-assignments/{assignment_id}/reject | Reject Category Assignment
[**rejectShopApiV1AdminShopsShopIdRejectPatch**](ShopsAPI.md#rejectshopapiv1adminshopsshopidrejectpatch) | **PATCH** /api/v1/admin/shops/{shop_id}/reject | Reject Shop
[**requestCategoryAssignmentApiV1SellerShopsShopIdCategoryAssignmentsPost**](ShopsAPI.md#requestcategoryassignmentapiv1sellershopsshopidcategoryassignmentspost) | **POST** /api/v1/seller/shops/{shop_id}/category-assignments | Request Category Assignment
[**submitShopForApprovalApiV1SellerShopsShopIdSubmitPost**](ShopsAPI.md#submitshopforapprovalapiv1sellershopsshopidsubmitpost) | **POST** /api/v1/seller/shops/{shop_id}/submit | Submit Shop For Approval
[**suspendShopApiV1AdminShopsShopIdSuspendPatch**](ShopsAPI.md#suspendshopapiv1adminshopsshopidsuspendpatch) | **PATCH** /api/v1/admin/shops/{shop_id}/suspend | Suspend Shop
[**updateShopApiV1SellerShopsShopIdPatch**](ShopsAPI.md#updateshopapiv1sellershopsshopidpatch) | **PATCH** /api/v1/seller/shops/{shop_id} | Update Shop


# **approveCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdApprovePatch**
```swift
    open class func approveCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdApprovePatch(assignmentId: Int, accessToken: String? = nil, completion: @escaping (_ data: CategoryAssignmentRead?, _ error: Error?) -> Void)
```

Approve Category Assignment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let assignmentId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Approve Category Assignment
ShopsAPI.approveCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdApprovePatch(assignmentId: assignmentId, accessToken: accessToken) { (response, error) in
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
 **assignmentId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CategoryAssignmentRead**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **approveShopApiV1AdminShopsShopIdApprovePatch**
```swift
    open class func approveShopApiV1AdminShopsShopIdApprovePatch(shopId: Int, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Approve Shop

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Approve Shop
ShopsAPI.approveShopApiV1AdminShopsShopIdApprovePatch(shopId: shopId, accessToken: accessToken) { (response, error) in
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

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **closeShopApiV1SellerShopsShopIdClosePost**
```swift
    open class func closeShopApiV1SellerShopsShopIdClosePost(shopId: Int, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Close Shop

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Close Shop
ShopsAPI.closeShopApiV1SellerShopsShopIdClosePost(shopId: shopId, accessToken: accessToken) { (response, error) in
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

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createShopApiV1SellerShopsPost**
```swift
    open class func createShopApiV1SellerShopsPost(shopCreateRequest: ShopCreateRequest, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Create Shop

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopCreateRequest = ShopCreateRequest(name: "name_example", slug: "slug_example", logoKey: "logoKey_example", bannerKey: "bannerKey_example", description: "description_example", legalEntityOverride: false) // ShopCreateRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Shop
ShopsAPI.createShopApiV1SellerShopsPost(shopCreateRequest: shopCreateRequest, accessToken: accessToken) { (response, error) in
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
 **shopCreateRequest** | [**ShopCreateRequest**](ShopCreateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getOwnShopApiV1SellerShopsShopIdGet**
```swift
    open class func getOwnShopApiV1SellerShopsShopIdGet(shopId: Int, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Get Own Shop

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Own Shop
ShopsAPI.getOwnShopApiV1SellerShopsShopIdGet(shopId: shopId, accessToken: accessToken) { (response, error) in
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

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getShopAdminApiV1AdminShopsShopIdGet**
```swift
    open class func getShopAdminApiV1AdminShopsShopIdGet(shopId: Int, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Get Shop Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Shop Admin
ShopsAPI.getShopAdminApiV1AdminShopsShopIdGet(shopId: shopId, accessToken: accessToken) { (response, error) in
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

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **inviteStaffApiV1SellerShopsShopIdStaffPost**
```swift
    open class func inviteStaffApiV1SellerShopsShopIdStaffPost(shopId: Int, appModulesShopsSchemasInviteStaffRequest: AppModulesShopsSchemasInviteStaffRequest, accessToken: String? = nil, completion: @escaping (_ data: ShopStaffRead?, _ error: Error?) -> Void)
```

Invite Staff

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let appModulesShopsSchemasInviteStaffRequest = app__modules__shops__schemas__InviteStaffRequest(userId: 123, role: StaffRole()) // AppModulesShopsSchemasInviteStaffRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Invite Staff
ShopsAPI.inviteStaffApiV1SellerShopsShopIdStaffPost(shopId: shopId, appModulesShopsSchemasInviteStaffRequest: appModulesShopsSchemasInviteStaffRequest, accessToken: accessToken) { (response, error) in
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
 **appModulesShopsSchemasInviteStaffRequest** | [**AppModulesShopsSchemasInviteStaffRequest**](AppModulesShopsSchemasInviteStaffRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ShopStaffRead**](ShopStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listAllShopsApiV1AdminShopsGet**
```swift
    open class func listAllShopsApiV1AdminShopsGet(sellerId: Int? = nil, status: String? = nil, categoryId: Int? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [ShopRead]?, _ error: Error?) -> Void)
```

List All Shops

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sellerId = 987 // Int |  (optional)
let status = "status_example" // String |  (optional)
let categoryId = 987 // Int |  (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// List All Shops
ShopsAPI.listAllShopsApiV1AdminShopsGet(sellerId: sellerId, status: status, categoryId: categoryId, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **sellerId** | **Int** |  | [optional] 
 **status** | **String** |  | [optional] 
 **categoryId** | **Int** |  | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ShopRead]**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listAuditLogApiV1AdminAuditLogGet**
```swift
    open class func listAuditLogApiV1AdminAuditLogGet(targetType: String? = nil, targetId: Int? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [AuditLogRead]?, _ error: Error?) -> Void)
```

List Audit Log

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let targetType = "targetType_example" // String |  (optional)
let targetId = 987 // Int |  (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 100)
let accessToken = "accessToken_example" // String |  (optional)

// List Audit Log
ShopsAPI.listAuditLogApiV1AdminAuditLogGet(targetType: targetType, targetId: targetId, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **targetType** | **String** |  | [optional] 
 **targetId** | **Int** |  | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 100]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[AuditLogRead]**](AuditLogRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listOwnCategoryAssignmentsApiV1SellerShopsShopIdCategoryAssignmentsGet**
```swift
    open class func listOwnCategoryAssignmentsApiV1SellerShopsShopIdCategoryAssignmentsGet(shopId: Int, accessToken: String? = nil, completion: @escaping (_ data: [CategoryAssignmentRead]?, _ error: Error?) -> Void)
```

List Own Category Assignments

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// List Own Category Assignments
ShopsAPI.listOwnCategoryAssignmentsApiV1SellerShopsShopIdCategoryAssignmentsGet(shopId: shopId, accessToken: accessToken) { (response, error) in
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

[**[CategoryAssignmentRead]**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listOwnShopsApiV1SellerShopsGet**
```swift
    open class func listOwnShopsApiV1SellerShopsGet(accessToken: String? = nil, completion: @escaping (_ data: [ShopRead]?, _ error: Error?) -> Void)
```

List Own Shops

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// List Own Shops
ShopsAPI.listOwnShopsApiV1SellerShopsGet(accessToken: accessToken) { (response, error) in
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

[**[ShopRead]**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listShopCategoryAssignmentsApiV1AdminShopCategoryAssignmentsGet**
```swift
    open class func listShopCategoryAssignmentsApiV1AdminShopCategoryAssignmentsGet(status: String? = nil, shopId: Int? = nil, categoryId: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [CategoryAssignmentRead]?, _ error: Error?) -> Void)
```

List Shop Category Assignments

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = "status_example" // String |  (optional)
let shopId = 987 // Int |  (optional)
let categoryId = 987 // Int |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Shop Category Assignments
ShopsAPI.listShopCategoryAssignmentsApiV1AdminShopCategoryAssignmentsGet(status: status, shopId: shopId, categoryId: categoryId, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[CategoryAssignmentRead]**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **reactivateShopApiV1AdminShopsShopIdReactivatePatch**
```swift
    open class func reactivateShopApiV1AdminShopsShopIdReactivatePatch(shopId: Int, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Reactivate Shop

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Reactivate Shop
ShopsAPI.reactivateShopApiV1AdminShopsShopIdReactivatePatch(shopId: shopId, accessToken: accessToken) { (response, error) in
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

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rejectCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdRejectPatch**
```swift
    open class func rejectCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdRejectPatch(assignmentId: Int, rejectAssignmentRequest: RejectAssignmentRequest, accessToken: String? = nil, completion: @escaping (_ data: CategoryAssignmentRead?, _ error: Error?) -> Void)
```

Reject Category Assignment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let assignmentId = 987 // Int | 
let rejectAssignmentRequest = RejectAssignmentRequest(reason: "reason_example") // RejectAssignmentRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Reject Category Assignment
ShopsAPI.rejectCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdRejectPatch(assignmentId: assignmentId, rejectAssignmentRequest: rejectAssignmentRequest, accessToken: accessToken) { (response, error) in
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
 **assignmentId** | **Int** |  | 
 **rejectAssignmentRequest** | [**RejectAssignmentRequest**](RejectAssignmentRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CategoryAssignmentRead**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rejectShopApiV1AdminShopsShopIdRejectPatch**
```swift
    open class func rejectShopApiV1AdminShopsShopIdRejectPatch(shopId: Int, statusReasonRequest: StatusReasonRequest, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Reject Shop

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let statusReasonRequest = StatusReasonRequest(reason: "reason_example") // StatusReasonRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Reject Shop
ShopsAPI.rejectShopApiV1AdminShopsShopIdRejectPatch(shopId: shopId, statusReasonRequest: statusReasonRequest, accessToken: accessToken) { (response, error) in
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
 **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **requestCategoryAssignmentApiV1SellerShopsShopIdCategoryAssignmentsPost**
```swift
    open class func requestCategoryAssignmentApiV1SellerShopsShopIdCategoryAssignmentsPost(shopId: Int, assignCategoryRequest: AssignCategoryRequest, accessToken: String? = nil, completion: @escaping (_ data: CategoryAssignmentRead?, _ error: Error?) -> Void)
```

Request Category Assignment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let assignCategoryRequest = AssignCategoryRequest(categoryId: 123, documentIds: [123]) // AssignCategoryRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Request Category Assignment
ShopsAPI.requestCategoryAssignmentApiV1SellerShopsShopIdCategoryAssignmentsPost(shopId: shopId, assignCategoryRequest: assignCategoryRequest, accessToken: accessToken) { (response, error) in
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
 **assignCategoryRequest** | [**AssignCategoryRequest**](AssignCategoryRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CategoryAssignmentRead**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **submitShopForApprovalApiV1SellerShopsShopIdSubmitPost**
```swift
    open class func submitShopForApprovalApiV1SellerShopsShopIdSubmitPost(shopId: Int, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Submit Shop For Approval

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Submit Shop For Approval
ShopsAPI.submitShopForApprovalApiV1SellerShopsShopIdSubmitPost(shopId: shopId, accessToken: accessToken) { (response, error) in
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

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **suspendShopApiV1AdminShopsShopIdSuspendPatch**
```swift
    open class func suspendShopApiV1AdminShopsShopIdSuspendPatch(shopId: Int, statusReasonRequest: StatusReasonRequest, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Suspend Shop

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let statusReasonRequest = StatusReasonRequest(reason: "reason_example") // StatusReasonRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Suspend Shop
ShopsAPI.suspendShopApiV1AdminShopsShopIdSuspendPatch(shopId: shopId, statusReasonRequest: statusReasonRequest, accessToken: accessToken) { (response, error) in
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
 **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateShopApiV1SellerShopsShopIdPatch**
```swift
    open class func updateShopApiV1SellerShopsShopIdPatch(shopId: Int, shopUpdateRequest: ShopUpdateRequest, accessToken: String? = nil, completion: @escaping (_ data: ShopRead?, _ error: Error?) -> Void)
```

Update Shop

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let shopUpdateRequest = ShopUpdateRequest(name: "name_example", logoKey: "logoKey_example", bannerKey: "bannerKey_example", description: "description_example") // ShopUpdateRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Shop
ShopsAPI.updateShopApiV1SellerShopsShopIdPatch(shopId: shopId, shopUpdateRequest: shopUpdateRequest, accessToken: accessToken) { (response, error) in
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
 **shopUpdateRequest** | [**ShopUpdateRequest**](ShopUpdateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

