# SellersApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**addBankAccountApiV1SellerBankAccountsPost**](SellersApi.md#addBankAccountApiV1SellerBankAccountsPost) | **POST** api/v1/seller/bank-accounts | Add Bank Account |
| [**approveSellerApiV1AdminSellersSellerIdApprovePatch**](SellersApi.md#approveSellerApiV1AdminSellersSellerIdApprovePatch) | **PATCH** api/v1/admin/sellers/{seller_id}/approve | Approve Seller |
| [**banSellerApiV1AdminSellersSellerIdBanPatch**](SellersApi.md#banSellerApiV1AdminSellersSellerIdBanPatch) | **PATCH** api/v1/admin/sellers/{seller_id}/ban | Ban Seller |
| [**getSellerAdminApiV1AdminSellersSellerIdGet**](SellersApi.md#getSellerAdminApiV1AdminSellersSellerIdGet) | **GET** api/v1/admin/sellers/{seller_id} | Get Seller Admin |
| [**getSellerMeApiV1SellerMeGet**](SellersApi.md#getSellerMeApiV1SellerMeGet) | **GET** api/v1/seller/me | Get Seller Me |
| [**listSellerDocumentsApiV1AdminSellersSellerIdDocumentsGet**](SellersApi.md#listSellerDocumentsApiV1AdminSellersSellerIdDocumentsGet) | **GET** api/v1/admin/sellers/{seller_id}/documents | List Seller Documents |
| [**listSellersApiV1AdminSellersGet**](SellersApi.md#listSellersApiV1AdminSellersGet) | **GET** api/v1/admin/sellers | List Sellers |
| [**registerSellerApiV1SellerRegisterPost**](SellersApi.md#registerSellerApiV1SellerRegisterPost) | **POST** api/v1/seller/register | Register Seller |
| [**reinstateSellerApiV1AdminSellersSellerIdReinstatePatch**](SellersApi.md#reinstateSellerApiV1AdminSellersSellerIdReinstatePatch) | **PATCH** api/v1/admin/sellers/{seller_id}/reinstate | Reinstate Seller |
| [**rejectSellerApiV1AdminSellersSellerIdRejectPatch**](SellersApi.md#rejectSellerApiV1AdminSellersSellerIdRejectPatch) | **PATCH** api/v1/admin/sellers/{seller_id}/reject | Reject Seller |
| [**reviewDocumentApiV1AdminSellersSellerIdDocumentsDocIdPatch**](SellersApi.md#reviewDocumentApiV1AdminSellersSellerIdDocumentsDocIdPatch) | **PATCH** api/v1/admin/sellers/{seller_id}/documents/{doc_id} | Review Document |
| [**submitDocumentApiV1SellerDocumentsPost**](SellersApi.md#submitDocumentApiV1SellerDocumentsPost) | **POST** api/v1/seller/documents | Submit Document |
| [**suspendSellerApiV1AdminSellersSellerIdSuspendPatch**](SellersApi.md#suspendSellerApiV1AdminSellersSellerIdSuspendPatch) | **PATCH** api/v1/admin/sellers/{seller_id}/suspend | Suspend Seller |
| [**updateShopLimitApiV1AdminSellersSellerIdShopLimitPatch**](SellersApi.md#updateShopLimitApiV1AdminSellersSellerIdShopLimitPatch) | **PATCH** api/v1/admin/sellers/{seller_id}/shop-limit | Update Shop Limit |



Add Bank Account

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val bankAccountCreateRequest : BankAccountCreateRequest =  // BankAccountCreateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : BankAccountRead = webService.addBankAccountApiV1SellerBankAccountsPost(bankAccountCreateRequest, accessToken)
}
```

### Parameters
| **bankAccountCreateRequest** | [**BankAccountCreateRequest**](BankAccountCreateRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**BankAccountRead**](BankAccountRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Approve Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerRead = webService.approveSellerApiV1AdminSellersSellerIdApprovePatch(sellerId, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Ban Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val statusReasonRequest : StatusReasonRequest =  // StatusReasonRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerRead = webService.banSellerApiV1AdminSellersSellerIdBanPatch(sellerId, statusReasonRequest, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Get Seller Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerAdminRead = webService.getSellerAdminApiV1AdminSellersSellerIdGet(sellerId, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerAdminRead**](SellerAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Seller Me

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerRead = webService.getSellerMeApiV1SellerMeGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Seller Documents

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<DocumentRead> = webService.listSellerDocumentsApiV1AdminSellersSellerIdDocumentsGet(sellerId, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;DocumentRead&gt;**](DocumentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Sellers

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val status : kotlin.String = status_example // kotlin.String | 
val search : kotlin.String = search_example // kotlin.String | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<SellerRead> = webService.listSellersApiV1AdminSellersGet(status, search, skip, limit, accessToken)
}
```

### Parameters
| **status** | **kotlin.String**|  | [optional] |
| **search** | **kotlin.String**|  | [optional] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;SellerRead&gt;**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Register Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerRegisterRequest : SellerRegisterRequest =  // SellerRegisterRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerRead = webService.registerSellerApiV1SellerRegisterPost(sellerRegisterRequest, accessToken)
}
```

### Parameters
| **sellerRegisterRequest** | [**SellerRegisterRequest**](SellerRegisterRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Reinstate Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerRead = webService.reinstateSellerApiV1AdminSellersSellerIdReinstatePatch(sellerId, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Reject Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val statusReasonRequest : StatusReasonRequest =  // StatusReasonRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerRead = webService.rejectSellerApiV1AdminSellersSellerIdRejectPatch(sellerId, statusReasonRequest, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Review Document

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val docId : kotlin.Int = 56 // kotlin.Int | 
val documentReviewRequest : DocumentReviewRequest =  // DocumentReviewRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : DocumentRead = webService.reviewDocumentApiV1AdminSellersSellerIdDocumentsDocIdPatch(sellerId, docId, documentReviewRequest, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| **docId** | **kotlin.Int**|  | |
| **documentReviewRequest** | [**DocumentReviewRequest**](DocumentReviewRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**DocumentRead**](DocumentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Submit Document

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val documentSubmitRequest : DocumentSubmitRequest =  // DocumentSubmitRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : DocumentRead = webService.submitDocumentApiV1SellerDocumentsPost(documentSubmitRequest, accessToken)
}
```

### Parameters
| **documentSubmitRequest** | [**DocumentSubmitRequest**](DocumentSubmitRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**DocumentRead**](DocumentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Suspend Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val statusReasonRequest : StatusReasonRequest =  // StatusReasonRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerRead = webService.suspendSellerApiV1AdminSellersSellerIdSuspendPatch(sellerId, statusReasonRequest, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| **statusReasonRequest** | [**StatusReasonRequest**](StatusReasonRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Shop Limit

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(SellersApi::class.java)
val sellerId : kotlin.Int = 56 // kotlin.Int | 
val updateShopLimitRequest : UpdateShopLimitRequest =  // UpdateShopLimitRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : SellerRead = webService.updateShopLimitApiV1AdminSellersSellerIdShopLimitPatch(sellerId, updateShopLimitRequest, accessToken)
}
```

### Parameters
| **sellerId** | **kotlin.Int**|  | |
| **updateShopLimitRequest** | [**UpdateShopLimitRequest**](UpdateShopLimitRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**SellerRead**](SellerRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

