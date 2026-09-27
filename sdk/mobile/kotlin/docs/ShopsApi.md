# ShopsApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**approveCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdApprovePatch**](ShopsApi.md#approveCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdApprovePatch) | **PATCH** api/v1/admin/shop-category-assignments/{assignment_id}/approve | Approve Category Assignment |
| [**approveShopApiV1AdminShopsShopIdApprovePatch**](ShopsApi.md#approveShopApiV1AdminShopsShopIdApprovePatch) | **PATCH** api/v1/admin/shops/{shop_id}/approve | Approve Shop |
| [**checkSlugAvailabilityApiV1SellerShopsSlugAvailabilityGet**](ShopsApi.md#checkSlugAvailabilityApiV1SellerShopsSlugAvailabilityGet) | **GET** api/v1/seller/shops/slug-availability | Check Slug Availability |
| [**closeShopApiV1SellerShopsShopIdClosePost**](ShopsApi.md#closeShopApiV1SellerShopsShopIdClosePost) | **POST** api/v1/seller/shops/{shop_id}/close | Close Shop |
| [**createShopApiV1SellerShopsPost**](ShopsApi.md#createShopApiV1SellerShopsPost) | **POST** api/v1/seller/shops | Create Shop |
| [**getOwnShopApiV1SellerShopsShopIdGet**](ShopsApi.md#getOwnShopApiV1SellerShopsShopIdGet) | **GET** api/v1/seller/shops/{shop_id} | Get Own Shop |
| [**getShopAdminApiV1AdminShopsShopIdGet**](ShopsApi.md#getShopAdminApiV1AdminShopsShopIdGet) | **GET** api/v1/admin/shops/{shop_id} | Get Shop Admin |
| [**inviteStaffApiV1SellerShopsShopIdStaffPost**](ShopsApi.md#inviteStaffApiV1SellerShopsShopIdStaffPost) | **POST** api/v1/seller/shops/{shop_id}/staff | Invite Staff |
| [**listAllShopsApiV1AdminShopsGet**](ShopsApi.md#listAllShopsApiV1AdminShopsGet) | **GET** api/v1/admin/shops | List All Shops |
| [**listAuditLogApiV1AdminAuditLogGet**](ShopsApi.md#listAuditLogApiV1AdminAuditLogGet) | **GET** api/v1/admin/audit-log | List Audit Log |
| [**listOwnCategoryAssignmentsApiV1SellerShopsShopIdCategoryAssignmentsGet**](ShopsApi.md#listOwnCategoryAssignmentsApiV1SellerShopsShopIdCategoryAssignmentsGet) | **GET** api/v1/seller/shops/{shop_id}/category-assignments | List Own Category Assignments |
| [**listOwnShopsApiV1SellerShopsGet**](ShopsApi.md#listOwnShopsApiV1SellerShopsGet) | **GET** api/v1/seller/shops | List Own Shops |
| [**listShopCategoryAssignmentsApiV1AdminShopCategoryAssignmentsGet**](ShopsApi.md#listShopCategoryAssignmentsApiV1AdminShopCategoryAssignmentsGet) | **GET** api/v1/admin/shop-category-assignments | List Shop Category Assignments |
| [**reactivateShopApiV1AdminShopsShopIdReactivatePatch**](ShopsApi.md#reactivateShopApiV1AdminShopsShopIdReactivatePatch) | **PATCH** api/v1/admin/shops/{shop_id}/reactivate | Reactivate Shop |
| [**rejectCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdRejectPatch**](ShopsApi.md#rejectCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdRejectPatch) | **PATCH** api/v1/admin/shop-category-assignments/{assignment_id}/reject | Reject Category Assignment |
| [**rejectShopApiV1AdminShopsShopIdRejectPatch**](ShopsApi.md#rejectShopApiV1AdminShopsShopIdRejectPatch) | **PATCH** api/v1/admin/shops/{shop_id}/reject | Reject Shop |
| [**requestCategoryAssignmentApiV1SellerShopsShopIdCategoryAssignmentsPost**](ShopsApi.md#requestCategoryAssignmentApiV1SellerShopsShopIdCategoryAssignmentsPost) | **POST** api/v1/seller/shops/{shop_id}/category-assignments | Request Category Assignment |
| [**submitShopForApprovalApiV1SellerShopsShopIdSubmitPost**](ShopsApi.md#submitShopForApprovalApiV1SellerShopsShopIdSubmitPost) | **POST** api/v1/seller/shops/{shop_id}/submit | Submit Shop For Approval |
| [**suspendShopApiV1AdminShopsShopIdSuspendPatch**](ShopsApi.md#suspendShopApiV1AdminShopsShopIdSuspendPatch) | **PATCH** api/v1/admin/shops/{shop_id}/suspend | Suspend Shop |
| [**updateShopApiV1SellerShopsShopIdPatch**](ShopsApi.md#updateShopApiV1SellerShopsShopIdPatch) | **PATCH** api/v1/seller/shops/{shop_id} | Update Shop |



Approve Category Assignment

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val assignmentId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CategoryAssignmentRead = webService.approveCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdApprovePatch(assignmentId, accessToken)
}
```

### Parameters
| **assignmentId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CategoryAssignmentRead**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Approve Shop

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.approveShopApiV1AdminShopsShopIdApprovePatch(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Check Slug Availability

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val slug : kotlin.String = slug_example // kotlin.String | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SlugAvailabilityRead = webService.checkSlugAvailabilityApiV1SellerShopsSlugAvailabilityGet(slug, accessToken)
}
```

### Parameters
| **slug** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SlugAvailabilityRead**](SlugAvailabilityRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Close Shop

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.closeShopApiV1SellerShopsShopIdClosePost(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Create Shop

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopCreateRequest : ShopCreateRequest =  // ShopCreateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.createShopApiV1SellerShopsPost(shopCreateRequest, accessToken)
}
```

### Parameters
| **shopCreateRequest** | [**ShopCreateRequest**](ShopCreateRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Get Own Shop

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.getOwnShopApiV1SellerShopsShopIdGet(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Shop Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.getShopAdminApiV1AdminShopsShopIdGet(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Invite Staff

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val appModulesShopsSchemasInviteStaffRequest : AppModulesShopsSchemasInviteStaffRequest =  // AppModulesShopsSchemasInviteStaffRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopStaffRead = webService.inviteStaffApiV1SellerShopsShopIdStaffPost(shopId, appModulesShopsSchemasInviteStaffRequest, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **appModulesShopsSchemasInviteStaffRequest** | [**AppModulesShopsSchemasInviteStaffRequest**](AppModulesShopsSchemasInviteStaffRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopStaffRead**](ShopStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


List All Shops

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val status : kotlin.String = status_example // kotlin.String | 
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ShopRead> = webService.listAllShopsApiV1AdminShopsGet(sellerId, status, categoryId, skip, limit, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | [optional] |
| **status** | **kotlin.String**|  | [optional] |
| **categoryId** | **kotlin.Int**|  | [optional] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ShopRead&gt;**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Audit Log

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val targetType : kotlin.String = targetType_example // kotlin.String | 
val targetId : kotlin.Int = 56 // kotlin.Int | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<AuditLogRead> = webService.listAuditLogApiV1AdminAuditLogGet(targetType, targetId, skip, limit, accessToken)
}
```

### Parameters
| **targetType** | **kotlin.String**|  | [optional] |
| **targetId** | **kotlin.Int**|  | [optional] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 100] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;AuditLogRead&gt;**](AuditLogRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Own Category Assignments

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CategoryAssignmentRead> = webService.listOwnCategoryAssignmentsApiV1SellerShopsShopIdCategoryAssignmentsGet(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;CategoryAssignmentRead&gt;**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Own Shops

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ShopRead> = webService.listOwnShopsApiV1SellerShopsGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ShopRead&gt;**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Shop Category Assignments

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val status : kotlin.String = status_example // kotlin.String | 
val shopId : kotlin.Int = 56 // kotlin.Int | 
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CategoryAssignmentRead> = webService.listShopCategoryAssignmentsApiV1AdminShopCategoryAssignmentsGet(status, shopId, categoryId, accessToken)
}
```

### Parameters
| **status** | **kotlin.String**|  | [optional] |
| **shopId** | **kotlin.Int**|  | [optional] |
| **categoryId** | **kotlin.Int**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;CategoryAssignmentRead&gt;**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Reactivate Shop

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.reactivateShopApiV1AdminShopsShopIdReactivatePatch(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Reject Category Assignment

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val assignmentId : kotlin.Int = 56 // kotlin.Int | 
val rejectAssignmentRequest : RejectAssignmentRequest =  // RejectAssignmentRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CategoryAssignmentRead = webService.rejectCategoryAssignmentApiV1AdminShopCategoryAssignmentsAssignmentIdRejectPatch(assignmentId, rejectAssignmentRequest, accessToken)
}
```

### Parameters
| **assignmentId** | **kotlin.Int**|  | |
| **rejectAssignmentRequest** | [**RejectAssignmentRequest**](RejectAssignmentRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CategoryAssignmentRead**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Reject Shop

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val statusReasonRequest : StatusReasonRequest =  // StatusReasonRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.rejectShopApiV1AdminShopsShopIdRejectPatch(shopId, statusReasonRequest, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Request Category Assignment

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val assignCategoryRequest : AssignCategoryRequest =  // AssignCategoryRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CategoryAssignmentRead = webService.requestCategoryAssignmentApiV1SellerShopsShopIdCategoryAssignmentsPost(shopId, assignCategoryRequest, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **assignCategoryRequest** | [**AssignCategoryRequest**](AssignCategoryRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CategoryAssignmentRead**](CategoryAssignmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Submit Shop For Approval

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.submitShopForApprovalApiV1SellerShopsShopIdSubmitPost(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Suspend Shop

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val statusReasonRequest : StatusReasonRequest =  // StatusReasonRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.suspendShopApiV1AdminShopsShopIdSuspendPatch(shopId, statusReasonRequest, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Shop

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ShopsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val shopUpdateRequest : ShopUpdateRequest =  // ShopUpdateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShopRead = webService.updateShopApiV1SellerShopsShopIdPatch(shopId, shopUpdateRequest, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **shopUpdateRequest** | [**ShopUpdateRequest**](ShopUpdateRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShopRead**](ShopRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

