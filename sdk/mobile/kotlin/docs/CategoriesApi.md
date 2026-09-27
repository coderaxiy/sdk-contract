# CategoriesApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**commissionPreviewApiV1SellerShopsShopIdCommissionPreviewGet**](CategoriesApi.md#commissionPreviewApiV1SellerShopsShopIdCommissionPreviewGet) | **GET** api/v1/seller/shops/{shop_id}/commission-preview | Commission Preview |
| [**confirmCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivateConfirmPost**](CategoriesApi.md#confirmCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivateConfirmPost) | **POST** api/v1/admin/categories/{category_id}/deactivate/confirm | Confirm Category Deactivation |
| [**createCategoryApiV1AdminCategoriesPost**](CategoriesApi.md#createCategoryApiV1AdminCategoriesPost) | **POST** api/v1/admin/categories | Create Category |
| [**createCommissionRuleApiV1AdminCommissionRulesPost**](CategoriesApi.md#createCommissionRuleApiV1AdminCommissionRulesPost) | **POST** api/v1/admin/commission-rules | Create Commission Rule |
| [**deactivateCommissionRuleApiV1AdminCommissionRulesRuleIdDeactivatePatch**](CategoriesApi.md#deactivateCommissionRuleApiV1AdminCommissionRulesRuleIdDeactivatePatch) | **PATCH** api/v1/admin/commission-rules/{rule_id}/deactivate | Deactivate Commission Rule |
| [**deleteCategoryApiV1AdminCategoriesCategoryIdDelete**](CategoriesApi.md#deleteCategoryApiV1AdminCategoriesCategoryIdDelete) | **DELETE** api/v1/admin/categories/{category_id} | Delete Category |
| [**getCategoryAttributesPublicApiV1CategoriesCategoryIdAttributesGet**](CategoriesApi.md#getCategoryAttributesPublicApiV1CategoriesCategoryIdAttributesGet) | **GET** api/v1/categories/{category_id}/attributes | Get Category Attributes Public |
| [**getCategoryTreeApiV1CategoriesGet**](CategoriesApi.md#getCategoryTreeApiV1CategoriesGet) | **GET** api/v1/categories | Get Category Tree |
| [**getEffectiveAttributesAdminApiV1AdminCategoriesCategoryIdAttributesGet**](CategoriesApi.md#getEffectiveAttributesAdminApiV1AdminCategoriesCategoryIdAttributesGet) | **GET** api/v1/admin/categories/{category_id}/attributes | Get Effective Attributes Admin |
| [**getEffectiveAttributesSellerApiV1SellerCategoriesCategoryIdAttributesGet**](CategoriesApi.md#getEffectiveAttributesSellerApiV1SellerCategoriesCategoryIdAttributesGet) | **GET** api/v1/seller/categories/{category_id}/attributes | Get Effective Attributes Seller |
| [**listCategoriesAdminApiV1AdminCategoriesGet**](CategoriesApi.md#listCategoriesAdminApiV1AdminCategoriesGet) | **GET** api/v1/admin/categories | List Categories Admin |
| [**listCategoriesSellerApiV1SellerCategoriesGet**](CategoriesApi.md#listCategoriesSellerApiV1SellerCategoriesGet) | **GET** api/v1/seller/categories | List Categories Seller |
| [**listCommissionRulesApiV1AdminCommissionRulesGet**](CategoriesApi.md#listCommissionRulesApiV1AdminCommissionRulesGet) | **GET** api/v1/admin/commission-rules | List Commission Rules |
| [**moveCategoryApiV1AdminCategoriesCategoryIdMovePost**](CategoriesApi.md#moveCategoryApiV1AdminCategoriesCategoryIdMovePost) | **POST** api/v1/admin/categories/{category_id}/move | Move Category |
| [**previewCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivatePreviewPost**](CategoriesApi.md#previewCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivatePreviewPost) | **POST** api/v1/admin/categories/{category_id}/deactivate/preview | Preview Category Deactivation |
| [**resolveCommissionRuleDebugApiV1AdminCommissionRulesResolveGet**](CategoriesApi.md#resolveCommissionRuleDebugApiV1AdminCommissionRulesResolveGet) | **GET** api/v1/admin/commission-rules/resolve | Resolve Commission Rule Debug |
| [**setAttributesApiV1AdminCategoriesCategoryIdAttributesPut**](CategoriesApi.md#setAttributesApiV1AdminCategoriesCategoryIdAttributesPut) | **PUT** api/v1/admin/categories/{category_id}/attributes | Set Attributes |
| [**updateCategoryApiV1AdminCategoriesCategoryIdPatch**](CategoriesApi.md#updateCategoryApiV1AdminCategoriesCategoryIdPatch) | **PATCH** api/v1/admin/categories/{category_id} | Update Category |



Commission Preview

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CommissionResolutionRead = webService.commissionPreviewApiV1SellerShopsShopIdCommissionPreviewGet(shopId, categoryId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **categoryId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CommissionResolutionRead**](CommissionResolutionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Confirm Category Deactivation

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CategoryRead = webService.confirmCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivateConfirmPost(categoryId, accessToken)
}
```

### Parameters
| **categoryId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CategoryRead**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Create Category

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryCreate : CategoryCreate =  // CategoryCreate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CategoryRead = webService.createCategoryApiV1AdminCategoriesPost(categoryCreate, accessToken)
}
```

### Parameters
| **categoryCreate** | [**CategoryCreate**](CategoryCreate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CategoryRead**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Create Commission Rule

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val commissionRuleCreate : CommissionRuleCreate =  // CommissionRuleCreate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CommissionRuleRead = webService.createCommissionRuleApiV1AdminCommissionRulesPost(commissionRuleCreate, accessToken)
}
```

### Parameters
| **commissionRuleCreate** | [**CommissionRuleCreate**](CommissionRuleCreate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CommissionRuleRead**](CommissionRuleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Deactivate Commission Rule

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val ruleId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CommissionRuleRead = webService.deactivateCommissionRuleApiV1AdminCommissionRulesRuleIdDeactivatePatch(ruleId, accessToken)
}
```

### Parameters
| **ruleId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CommissionRuleRead**](CommissionRuleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Delete Category

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.deleteCategoryApiV1AdminCategoriesCategoryIdDelete(categoryId, accessToken)
}
```

### Parameters
| **categoryId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Category Attributes Public

Effective attributes (inherited ones included) of an active category; 404 otherwise.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CategoryAttributePublicRead> = webService.getCategoryAttributesPublicApiV1CategoriesCategoryIdAttributesGet(categoryId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **categoryId** | **kotlin.Int**|  | |

### Return type

[**kotlin.collections.List&lt;CategoryAttributePublicRead&gt;**](CategoryAttributePublicRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Category Tree

The active category tree (roots, children nested), ordered by sort_order then id. A deactivated category hides its whole subtree. Slugs are globally unique.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CategoryNodeRead> = webService.getCategoryTreeApiV1CategoriesGet()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;CategoryNodeRead&gt;**](CategoryNodeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Effective Attributes Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CategoryAttributeRead> = webService.getEffectiveAttributesAdminApiV1AdminCategoriesCategoryIdAttributesGet(categoryId, accessToken)
}
```

### Parameters
| **categoryId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;CategoryAttributeRead&gt;**](CategoryAttributeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Effective Attributes Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CategoryAttributeRead> = webService.getEffectiveAttributesSellerApiV1SellerCategoriesCategoryIdAttributesGet(categoryId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **categoryId** | **kotlin.Int**|  | |

### Return type

[**kotlin.collections.List&lt;CategoryAttributeRead&gt;**](CategoryAttributeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Categories Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val parentId : kotlin.Int = 56 // kotlin.Int | 
val isActive : kotlin.Boolean = true // kotlin.Boolean | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CategoryRead> = webService.listCategoriesAdminApiV1AdminCategoriesGet(parentId, isActive, accessToken)
}
```

### Parameters
| **parentId** | **kotlin.Int**|  | [optional] |
| **isActive** | **kotlin.Boolean**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;CategoryRead&gt;**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Categories Seller

Active leaf categories (the only ones products can use), each with its ancestors so the picker can show a path.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<SellerCategoryRead> = webService.listCategoriesSellerApiV1SellerCategoriesGet()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;SellerCategoryRead&gt;**](SellerCategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Commission Rules

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val scopeType : CommissionScopeType =  // CommissionScopeType | 
val scopeId : kotlin.Int = 56 // kotlin.Int | 
val isActive : kotlin.Boolean = true // kotlin.Boolean | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CommissionRuleRead> = webService.listCommissionRulesApiV1AdminCommissionRulesGet(scopeType, scopeId, isActive, accessToken)
}
```

### Parameters
| **scopeType** | [**CommissionScopeType**](.md)|  | [optional] [enum: global, category, shop, shop_category] |
| **scopeId** | **kotlin.Int**|  | [optional] |
| **isActive** | **kotlin.Boolean**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;CommissionRuleRead&gt;**](CommissionRuleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Move Category

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val categoryMoveRequest : CategoryMoveRequest =  // CategoryMoveRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CategoryRead = webService.moveCategoryApiV1AdminCategoriesCategoryIdMovePost(categoryId, categoryMoveRequest, accessToken)
}
```

### Parameters
| **categoryId** | **kotlin.Int**|  | |
| **categoryMoveRequest** | [**CategoryMoveRequest**](CategoryMoveRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CategoryRead**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Preview Category Deactivation

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : DeactivationImpact = webService.previewCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivatePreviewPost(categoryId, accessToken)
}
```

### Parameters
| **categoryId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**DeactivationImpact**](DeactivationImpact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Resolve Commission Rule Debug

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CommissionRuleRead = webService.resolveCommissionRuleDebugApiV1AdminCommissionRulesResolveGet(shopId, categoryId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **categoryId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CommissionRuleRead**](CommissionRuleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Set Attributes

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val setAttributesRequest : SetAttributesRequest =  // SetAttributesRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CategoryAttributeRead> = webService.setAttributesApiV1AdminCategoriesCategoryIdAttributesPut(categoryId, setAttributesRequest, accessToken)
}
```

### Parameters
| **categoryId** | **kotlin.Int**|  | |
| **setAttributesRequest** | [**SetAttributesRequest**](SetAttributesRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;CategoryAttributeRead&gt;**](CategoryAttributeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Category

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(CategoriesApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val categoryUpdate : CategoryUpdate =  // CategoryUpdate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CategoryRead = webService.updateCategoryApiV1AdminCategoriesCategoryIdPatch(categoryId, categoryUpdate, accessToken)
}
```

### Parameters
| **categoryId** | **kotlin.Int**|  | |
| **categoryUpdate** | [**CategoryUpdate**](CategoryUpdate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CategoryRead**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

