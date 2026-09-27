# ProductsApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**approveBrandApiV1AdminBrandsBrandIdApprovePatch**](ProductsApi.md#approveBrandApiV1AdminBrandsBrandIdApprovePatch) | **PATCH** api/v1/admin/brands/{brand_id}/approve | Approve Brand |
| [**approveProductApiV1AdminProductsProductIdApprovePatch**](ProductsApi.md#approveProductApiV1AdminProductsProductIdApprovePatch) | **PATCH** api/v1/admin/products/{product_id}/approve | Approve Product |
| [**archiveProductApiV1SellerProductsProductIdArchivePost**](ProductsApi.md#archiveProductApiV1SellerProductsProductIdArchivePost) | **POST** api/v1/seller/products/{product_id}/archive | Archive Product |
| [**createProductApiV1SellerShopsShopIdProductsPost**](ProductsApi.md#createProductApiV1SellerShopsShopIdProductsPost) | **POST** api/v1/seller/shops/{shop_id}/products | Create Product |
| [**createVariantApiV1SellerProductsProductIdVariantsPost**](ProductsApi.md#createVariantApiV1SellerProductsProductIdVariantsPost) | **POST** api/v1/seller/products/{product_id}/variants | Create Variant |
| [**deleteVariantApiV1SellerVariantsVariantIdDelete**](ProductsApi.md#deleteVariantApiV1SellerVariantsVariantIdDelete) | **DELETE** api/v1/seller/variants/{variant_id} | Delete Variant |
| [**delistProductAdminApiV1AdminProductsProductIdDelistPatch**](ProductsApi.md#delistProductAdminApiV1AdminProductsProductIdDelistPatch) | **PATCH** api/v1/admin/products/{product_id}/delist | Delist Product Admin |
| [**delistProductSellerApiV1SellerProductsProductIdDelistPost**](ProductsApi.md#delistProductSellerApiV1SellerProductsProductIdDelistPost) | **POST** api/v1/seller/products/{product_id}/delist | Delist Product Seller |
| [**getModerationConfigApiV1AdminModerationConfigGet**](ProductsApi.md#getModerationConfigApiV1AdminModerationConfigGet) | **GET** api/v1/admin/moderation-config | Get Moderation Config |
| [**getModerationLogApiV1AdminProductsProductIdModerationLogGet**](ProductsApi.md#getModerationLogApiV1AdminProductsProductIdModerationLogGet) | **GET** api/v1/admin/products/{product_id}/moderation-log | Get Moderation Log |
| [**getModerationQueueApiV1AdminModerationQueueGet**](ProductsApi.md#getModerationQueueApiV1AdminModerationQueueGet) | **GET** api/v1/admin/moderation-queue | Get Moderation Queue |
| [**getProductAdminApiV1AdminProductsProductIdGet**](ProductsApi.md#getProductAdminApiV1AdminProductsProductIdGet) | **GET** api/v1/admin/products/{product_id} | Get Product Admin |
| [**getProductPublicApiV1ProductsProductIdGet**](ProductsApi.md#getProductPublicApiV1ProductsProductIdGet) | **GET** api/v1/products/{product_id} | Get Product Public |
| [**getProductSellerApiV1SellerProductsProductIdGet**](ProductsApi.md#getProductSellerApiV1SellerProductsProductIdGet) | **GET** api/v1/seller/products/{product_id} | Get Product Seller |
| [**listBrandsAdminApiV1AdminBrandsGet**](ProductsApi.md#listBrandsAdminApiV1AdminBrandsGet) | **GET** api/v1/admin/brands | List Brands Admin |
| [**listBrandsSellerApiV1SellerBrandsGet**](ProductsApi.md#listBrandsSellerApiV1SellerBrandsGet) | **GET** api/v1/seller/brands | List Brands Seller |
| [**listProductsAdminApiV1AdminProductsGet**](ProductsApi.md#listProductsAdminApiV1AdminProductsGet) | **GET** api/v1/admin/products | List Products Admin |
| [**listProductsSellerApiV1SellerProductsGet**](ProductsApi.md#listProductsSellerApiV1SellerProductsGet) | **GET** api/v1/seller/products | List Products Seller |
| [**listShopProductsPublicApiV1ShopsShopIdProductsGet**](ProductsApi.md#listShopProductsPublicApiV1ShopsShopIdProductsGet) | **GET** api/v1/shops/{shop_id}/products | List Shop Products Public |
| [**rejectBrandApiV1AdminBrandsBrandIdRejectPatch**](ProductsApi.md#rejectBrandApiV1AdminBrandsBrandIdRejectPatch) | **PATCH** api/v1/admin/brands/{brand_id}/reject | Reject Brand |
| [**rejectProductApiV1AdminProductsProductIdRejectPatch**](ProductsApi.md#rejectProductApiV1AdminProductsProductIdRejectPatch) | **PATCH** api/v1/admin/products/{product_id}/reject | Reject Product |
| [**requestBrandApiV1SellerBrandsRequestPost**](ProductsApi.md#requestBrandApiV1SellerBrandsRequestPost) | **POST** api/v1/seller/brands/request | Request Brand |
| [**submitProductApiV1SellerProductsProductIdSubmitPost**](ProductsApi.md#submitProductApiV1SellerProductsProductIdSubmitPost) | **POST** api/v1/seller/products/{product_id}/submit | Submit Product |
| [**updateModerationConfigApiV1AdminModerationConfigPut**](ProductsApi.md#updateModerationConfigApiV1AdminModerationConfigPut) | **PUT** api/v1/admin/moderation-config | Update Moderation Config |
| [**updateProductApiV1SellerProductsProductIdPatch**](ProductsApi.md#updateProductApiV1SellerProductsProductIdPatch) | **PATCH** api/v1/seller/products/{product_id} | Update Product |
| [**updateVariantApiV1SellerVariantsVariantIdPatch**](ProductsApi.md#updateVariantApiV1SellerVariantsVariantIdPatch) | **PATCH** api/v1/seller/variants/{variant_id} | Update Variant |



Approve Brand

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val brandId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : BrandRead = webService.approveBrandApiV1AdminBrandsBrandIdApprovePatch(brandId, accessToken)
}
```

### Parameters
| **brandId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**BrandRead**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Approve Product

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.approveProductApiV1AdminProductsProductIdApprovePatch(productId, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Archive Product

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.archiveProductApiV1SellerProductsProductIdArchivePost(productId, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Create Product

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val productCreate : ProductCreate =  // ProductCreate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.createProductApiV1SellerShopsShopIdProductsPost(shopId, productCreate, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | |
| **productCreate** | [**ProductCreate**](ProductCreate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Create Variant

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val productVariantCreate : ProductVariantCreate =  // ProductVariantCreate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductVariantRead = webService.createVariantApiV1SellerProductsProductIdVariantsPost(productId, productVariantCreate, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| **productVariantCreate** | [**ProductVariantCreate**](ProductVariantCreate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductVariantRead**](ProductVariantRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Delete Variant

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val variantId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.deleteVariantApiV1SellerVariantsVariantIdDelete(variantId, accessToken)
}
```

### Parameters
| **variantId** | **kotlin.Int**|  | |
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


Delist Product Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val delistRequest : DelistRequest =  // DelistRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.delistProductAdminApiV1AdminProductsProductIdDelistPatch(productId, delistRequest, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| **delistRequest** | [**DelistRequest**](DelistRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Delist Product Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val delistRequest : DelistRequest =  // DelistRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.delistProductSellerApiV1SellerProductsProductIdDelistPost(productId, delistRequest, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| **delistRequest** | [**DelistRequest**](DelistRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Get Moderation Config

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ModerationConfigRead = webService.getModerationConfigApiV1AdminModerationConfigGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ModerationConfigRead**](ModerationConfigRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Moderation Log

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ProductModerationLogRead> = webService.getModerationLogApiV1AdminProductsProductIdModerationLogGet(productId, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ProductModerationLogRead&gt;**](ProductModerationLogRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Moderation Queue

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val shopId : kotlin.Int = 56 // kotlin.Int | 
val onlyFlagged : kotlin.Boolean = true // kotlin.Boolean | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ModerationQueueItemRead> = webService.getModerationQueueApiV1AdminModerationQueueGet(categoryId, shopId, onlyFlagged, skip, limit, accessToken)
}
```

### Parameters
| **categoryId** | **kotlin.Int**|  | [optional] |
| **shopId** | **kotlin.Int**|  | [optional] |
| **onlyFlagged** | **kotlin.Boolean**|  | [optional] [default to false] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ModerationQueueItemRead&gt;**](ModerationQueueItemRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Product Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.getProductAdminApiV1AdminProductsProductIdGet(productId, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Product Public

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.getProductPublicApiV1ProductsProductIdGet(productId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **productId** | **kotlin.Int**|  | |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Product Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.getProductSellerApiV1SellerProductsProductIdGet(productId, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Brands Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val status : BrandStatus =  // BrandStatus | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<BrandRead> = webService.listBrandsAdminApiV1AdminBrandsGet(status, skip, limit, accessToken)
}
```

### Parameters
| **status** | [**BrandStatus**](.md)|  | [optional] [enum: pending, approved, rejected] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;BrandRead&gt;**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Brands Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<BrandRead> = webService.listBrandsSellerApiV1SellerBrandsGet()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;BrandRead&gt;**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Products Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val status : ProductStatus =  // ProductStatus | 
val shopId : kotlin.Int = 56 // kotlin.Int | 
val categoryId : kotlin.Int = 56 // kotlin.Int | 
val search : kotlin.String = search_example // kotlin.String | Case-insensitive partial match on title or SKU (incl. variant SKUs)
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ProductRead> = webService.listProductsAdminApiV1AdminProductsGet(status, shopId, categoryId, search, skip, limit, accessToken)
}
```

### Parameters
| **status** | [**ProductStatus**](.md)|  | [optional] [enum: draft, pending_review, approved, rejected, delisted, archived] |
| **shopId** | **kotlin.Int**|  | [optional] |
| **categoryId** | **kotlin.Int**|  | [optional] |
| **search** | **kotlin.String**| Case-insensitive partial match on title or SKU (incl. variant SKUs) | [optional] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ProductRead&gt;**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Products Seller

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val status : ProductStatus =  // ProductStatus | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ProductRead> = webService.listProductsSellerApiV1SellerProductsGet(shopId, status, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | [optional] |
| **status** | [**ProductStatus**](.md)|  | [optional] [enum: draft, pending_review, approved, rejected, delisted, archived] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ProductRead&gt;**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Shop Products Public

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ProductRead> = webService.listShopProductsPublicApiV1ShopsShopIdProductsGet(shopId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **shopId** | **kotlin.Int**|  | |

### Return type

[**kotlin.collections.List&lt;ProductRead&gt;**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Reject Brand

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val brandId : kotlin.Int = 56 // kotlin.Int | 
val brandRejectRequest : BrandRejectRequest =  // BrandRejectRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : BrandRead = webService.rejectBrandApiV1AdminBrandsBrandIdRejectPatch(brandId, brandRejectRequest, accessToken)
}
```

### Parameters
| **brandId** | **kotlin.Int**|  | |
| **brandRejectRequest** | [**BrandRejectRequest**](BrandRejectRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**BrandRead**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Reject Product

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val rejectRequest : RejectRequest =  // RejectRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.rejectProductApiV1AdminProductsProductIdRejectPatch(productId, rejectRequest, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| **rejectRequest** | [**RejectRequest**](RejectRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Request Brand

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val brandRequestCreate : BrandRequestCreate =  // BrandRequestCreate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : BrandRead = webService.requestBrandApiV1SellerBrandsRequestPost(brandRequestCreate, accessToken)
}
```

### Parameters
| **brandRequestCreate** | [**BrandRequestCreate**](BrandRequestCreate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**BrandRead**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Submit Product

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.submitProductApiV1SellerProductsProductIdSubmitPost(productId, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Update Moderation Config

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val moderationConfigUpdate : ModerationConfigUpdate =  // ModerationConfigUpdate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ModerationConfigRead = webService.updateModerationConfigApiV1AdminModerationConfigPut(moderationConfigUpdate, accessToken)
}
```

### Parameters
| **moderationConfigUpdate** | [**ModerationConfigUpdate**](ModerationConfigUpdate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ModerationConfigRead**](ModerationConfigRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Product

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val productId : kotlin.Int = 56 // kotlin.Int | 
val productUpdate : ProductUpdate =  // ProductUpdate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductRead = webService.updateProductApiV1SellerProductsProductIdPatch(productId, productUpdate, accessToken)
}
```

### Parameters
| **productId** | **kotlin.Int**|  | |
| **productUpdate** | [**ProductUpdate**](ProductUpdate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Variant

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(ProductsApi::class.java)
val variantId : kotlin.Int = 56 // kotlin.Int | 
val productVariantUpdate : ProductVariantUpdate =  // ProductVariantUpdate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ProductVariantRead = webService.updateVariantApiV1SellerVariantsVariantIdPatch(variantId, productVariantUpdate, accessToken)
}
```

### Parameters
| **variantId** | **kotlin.Int**|  | |
| **productVariantUpdate** | [**ProductVariantUpdate**](ProductVariantUpdate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ProductVariantRead**](ProductVariantRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

