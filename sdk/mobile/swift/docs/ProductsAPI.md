# ProductsAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**approveBrandApiV1AdminBrandsBrandIdApprovePatch**](ProductsAPI.md#approvebrandapiv1adminbrandsbrandidapprovepatch) | **PATCH** /api/v1/admin/brands/{brand_id}/approve | Approve Brand
[**approveProductApiV1AdminProductsProductIdApprovePatch**](ProductsAPI.md#approveproductapiv1adminproductsproductidapprovepatch) | **PATCH** /api/v1/admin/products/{product_id}/approve | Approve Product
[**archiveProductApiV1SellerProductsProductIdArchivePost**](ProductsAPI.md#archiveproductapiv1sellerproductsproductidarchivepost) | **POST** /api/v1/seller/products/{product_id}/archive | Archive Product
[**createProductApiV1SellerShopsShopIdProductsPost**](ProductsAPI.md#createproductapiv1sellershopsshopidproductspost) | **POST** /api/v1/seller/shops/{shop_id}/products | Create Product
[**createVariantApiV1SellerProductsProductIdVariantsPost**](ProductsAPI.md#createvariantapiv1sellerproductsproductidvariantspost) | **POST** /api/v1/seller/products/{product_id}/variants | Create Variant
[**deleteVariantApiV1SellerVariantsVariantIdDelete**](ProductsAPI.md#deletevariantapiv1sellervariantsvariantiddelete) | **DELETE** /api/v1/seller/variants/{variant_id} | Delete Variant
[**delistProductAdminApiV1AdminProductsProductIdDelistPatch**](ProductsAPI.md#delistproductadminapiv1adminproductsproductiddelistpatch) | **PATCH** /api/v1/admin/products/{product_id}/delist | Delist Product Admin
[**delistProductSellerApiV1SellerProductsProductIdDelistPost**](ProductsAPI.md#delistproductsellerapiv1sellerproductsproductiddelistpost) | **POST** /api/v1/seller/products/{product_id}/delist | Delist Product Seller
[**getCatalogFacetsApiV1ProductsFacetsGet**](ProductsAPI.md#getcatalogfacetsapiv1productsfacetsget) | **GET** /api/v1/products/facets | Get Catalog Facets
[**getModerationConfigApiV1AdminModerationConfigGet**](ProductsAPI.md#getmoderationconfigapiv1adminmoderationconfigget) | **GET** /api/v1/admin/moderation-config | Get Moderation Config
[**getModerationLogApiV1AdminProductsProductIdModerationLogGet**](ProductsAPI.md#getmoderationlogapiv1adminproductsproductidmoderationlogget) | **GET** /api/v1/admin/products/{product_id}/moderation-log | Get Moderation Log
[**getModerationQueueApiV1AdminModerationQueueGet**](ProductsAPI.md#getmoderationqueueapiv1adminmoderationqueueget) | **GET** /api/v1/admin/moderation-queue | Get Moderation Queue
[**getProductAdminApiV1AdminProductsProductIdGet**](ProductsAPI.md#getproductadminapiv1adminproductsproductidget) | **GET** /api/v1/admin/products/{product_id} | Get Product Admin
[**getProductBySlugsApiV1ShopsBySlugShopSlugProductsProductSlugGet**](ProductsAPI.md#getproductbyslugsapiv1shopsbyslugshopslugproductsproductslugget) | **GET** /api/v1/shops/by-slug/{shop_slug}/products/{product_slug} | Get Product By Slugs
[**getProductPublicApiV1ProductsProductIdGet**](ProductsAPI.md#getproductpublicapiv1productsproductidget) | **GET** /api/v1/products/{product_id} | Get Product Public
[**getProductSellerApiV1SellerProductsProductIdGet**](ProductsAPI.md#getproductsellerapiv1sellerproductsproductidget) | **GET** /api/v1/seller/products/{product_id} | Get Product Seller
[**listBrandsAdminApiV1AdminBrandsGet**](ProductsAPI.md#listbrandsadminapiv1adminbrandsget) | **GET** /api/v1/admin/brands | List Brands Admin
[**listBrandsPublicApiV1BrandsGet**](ProductsAPI.md#listbrandspublicapiv1brandsget) | **GET** /api/v1/brands | List Brands Public
[**listBrandsSellerApiV1SellerBrandsGet**](ProductsAPI.md#listbrandssellerapiv1sellerbrandsget) | **GET** /api/v1/seller/brands | List Brands Seller
[**listCatalogApiV1ProductsGet**](ProductsAPI.md#listcatalogapiv1productsget) | **GET** /api/v1/products | List Catalog
[**listProductsAdminApiV1AdminProductsGet**](ProductsAPI.md#listproductsadminapiv1adminproductsget) | **GET** /api/v1/admin/products | List Products Admin
[**listProductsSellerApiV1SellerProductsGet**](ProductsAPI.md#listproductssellerapiv1sellerproductsget) | **GET** /api/v1/seller/products | List Products Seller
[**listShopProductsPublicApiV1ShopsShopIdProductsGet**](ProductsAPI.md#listshopproductspublicapiv1shopsshopidproductsget) | **GET** /api/v1/shops/{shop_id}/products | List Shop Products Public
[**rejectBrandApiV1AdminBrandsBrandIdRejectPatch**](ProductsAPI.md#rejectbrandapiv1adminbrandsbrandidrejectpatch) | **PATCH** /api/v1/admin/brands/{brand_id}/reject | Reject Brand
[**rejectProductApiV1AdminProductsProductIdRejectPatch**](ProductsAPI.md#rejectproductapiv1adminproductsproductidrejectpatch) | **PATCH** /api/v1/admin/products/{product_id}/reject | Reject Product
[**requestBrandApiV1SellerBrandsRequestPost**](ProductsAPI.md#requestbrandapiv1sellerbrandsrequestpost) | **POST** /api/v1/seller/brands/request | Request Brand
[**submitProductApiV1SellerProductsProductIdSubmitPost**](ProductsAPI.md#submitproductapiv1sellerproductsproductidsubmitpost) | **POST** /api/v1/seller/products/{product_id}/submit | Submit Product
[**updateModerationConfigApiV1AdminModerationConfigPut**](ProductsAPI.md#updatemoderationconfigapiv1adminmoderationconfigput) | **PUT** /api/v1/admin/moderation-config | Update Moderation Config
[**updateProductApiV1SellerProductsProductIdPatch**](ProductsAPI.md#updateproductapiv1sellerproductsproductidpatch) | **PATCH** /api/v1/seller/products/{product_id} | Update Product
[**updateVariantApiV1SellerVariantsVariantIdPatch**](ProductsAPI.md#updatevariantapiv1sellervariantsvariantidpatch) | **PATCH** /api/v1/seller/variants/{variant_id} | Update Variant


# **approveBrandApiV1AdminBrandsBrandIdApprovePatch**
```swift
    open class func approveBrandApiV1AdminBrandsBrandIdApprovePatch(brandId: Int, accessToken: String? = nil, completion: @escaping (_ data: BrandRead?, _ error: Error?) -> Void)
```

Approve Brand

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let brandId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Approve Brand
ProductsAPI.approveBrandApiV1AdminBrandsBrandIdApprovePatch(brandId: brandId, accessToken: accessToken) { (response, error) in
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
 **brandId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**BrandRead**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **approveProductApiV1AdminProductsProductIdApprovePatch**
```swift
    open class func approveProductApiV1AdminProductsProductIdApprovePatch(productId: Int, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Approve Product

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Approve Product
ProductsAPI.approveProductApiV1AdminProductsProductIdApprovePatch(productId: productId, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **archiveProductApiV1SellerProductsProductIdArchivePost**
```swift
    open class func archiveProductApiV1SellerProductsProductIdArchivePost(productId: Int, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Archive Product

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Archive Product
ProductsAPI.archiveProductApiV1SellerProductsProductIdArchivePost(productId: productId, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createProductApiV1SellerShopsShopIdProductsPost**
```swift
    open class func createProductApiV1SellerShopsShopIdProductsPost(shopId: Int, productCreate: ProductCreate, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Create Product

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let productCreate = ProductCreate(categoryId: 123, brandId: 123, title: "title_example", slug: "slug_example", description: "description_example", hasVariants: false, basePrice: Base_Price(), stockQuantity: 123, sellerSku: "sellerSku_example", images: [ProductImageIn(key: "key_example", sortOrder: 123, isPrimary: false)], attributeValues: [ProductAttributeValueIn(categoryAttributeId: 123, value: Value())]) // ProductCreate | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Product
ProductsAPI.createProductApiV1SellerShopsShopIdProductsPost(shopId: shopId, productCreate: productCreate, accessToken: accessToken) { (response, error) in
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
 **productCreate** | [**ProductCreate**](ProductCreate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createVariantApiV1SellerProductsProductIdVariantsPost**
```swift
    open class func createVariantApiV1SellerProductsProductIdVariantsPost(productId: Int, productVariantCreate: ProductVariantCreate, accessToken: String? = nil, completion: @escaping (_ data: ProductVariantRead?, _ error: Error?) -> Void)
```

Create Variant

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let productVariantCreate = ProductVariantCreate(sellerSku: "sellerSku_example", price: Price(), stockQuantity: 123, attributes: "TODO", imageIds: [123]) // ProductVariantCreate | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Variant
ProductsAPI.createVariantApiV1SellerProductsProductIdVariantsPost(productId: productId, productVariantCreate: productVariantCreate, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **productVariantCreate** | [**ProductVariantCreate**](ProductVariantCreate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductVariantRead**](ProductVariantRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteVariantApiV1SellerVariantsVariantIdDelete**
```swift
    open class func deleteVariantApiV1SellerVariantsVariantIdDelete(variantId: Int, accessToken: String? = nil, completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

Delete Variant

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let variantId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Delete Variant
ProductsAPI.deleteVariantApiV1SellerVariantsVariantIdDelete(variantId: variantId, accessToken: accessToken) { (response, error) in
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
 **variantId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

Void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delistProductAdminApiV1AdminProductsProductIdDelistPatch**
```swift
    open class func delistProductAdminApiV1AdminProductsProductIdDelistPatch(productId: Int, delistRequest: DelistRequest, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Delist Product Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let delistRequest = DelistRequest(reason: "reason_example") // DelistRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Delist Product Admin
ProductsAPI.delistProductAdminApiV1AdminProductsProductIdDelistPatch(productId: productId, delistRequest: delistRequest, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **delistRequest** | [**DelistRequest**](DelistRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **delistProductSellerApiV1SellerProductsProductIdDelistPost**
```swift
    open class func delistProductSellerApiV1SellerProductsProductIdDelistPost(productId: Int, delistRequest: DelistRequest, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Delist Product Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let delistRequest = DelistRequest(reason: "reason_example") // DelistRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Delist Product Seller
ProductsAPI.delistProductSellerApiV1SellerProductsProductIdDelistPost(productId: productId, delistRequest: delistRequest, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **delistRequest** | [**DelistRequest**](DelistRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCatalogFacetsApiV1ProductsFacetsGet**
```swift
    open class func getCatalogFacetsApiV1ProductsFacetsGet(q: String? = nil, categoryId: Int? = nil, brandId: [Int]? = nil, shopId: Int? = nil, priceMin: PriceMin? = nil, priceMax: PriceMax? = nil, inStock: Bool? = nil, attr: [String]? = nil, completion: @escaping (_ data: CatalogFacetsRead?, _ error: Error?) -> Void)
```

Get Catalog Facets

Brands (with counts) and the price range for the filter sidebar, given the same filters as GET /products.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let q = "q_example" // String | Case-insensitive match on title or brand name; Uzbek Latin and Cyrillic spellings both match (optional)
let categoryId = 987 // Int | The category and all its descendants (optional)
let brandId = [123] // [Int] | Repeatable; OR across values (optional)
let shopId = 987 // Int |  (optional)
let priceMin = Price_Min() // PriceMin | Compared against the card's price_min (optional)
let priceMax = Price_Max() // PriceMax | Compared against the card's price_min (optional)
let inStock = true // Bool | true hides out-of-stock products (optional)
let attr = ["inner_example"] // [String] | Repeatable key:value on a filterable attribute of category_id (required). OR within a key, AND across keys (optional)

// Get Catalog Facets
ProductsAPI.getCatalogFacetsApiV1ProductsFacetsGet(q: q, categoryId: categoryId, brandId: brandId, shopId: shopId, priceMin: priceMin, priceMax: priceMax, inStock: inStock, attr: attr) { (response, error) in
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
 **q** | **String** | Case-insensitive match on title or brand name; Uzbek Latin and Cyrillic spellings both match | [optional] 
 **categoryId** | **Int** | The category and all its descendants | [optional] 
 **brandId** | [**[Int]**](Int.md) | Repeatable; OR across values | [optional] 
 **shopId** | **Int** |  | [optional] 
 **priceMin** | [**PriceMin**](.md) | Compared against the card&#39;s price_min | [optional] 
 **priceMax** | [**PriceMax**](.md) | Compared against the card&#39;s price_min | [optional] 
 **inStock** | **Bool** | true hides out-of-stock products | [optional] 
 **attr** | [**[String]**](String.md) | Repeatable key:value on a filterable attribute of category_id (required). OR within a key, AND across keys | [optional] 

### Return type

[**CatalogFacetsRead**](CatalogFacetsRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getModerationConfigApiV1AdminModerationConfigGet**
```swift
    open class func getModerationConfigApiV1AdminModerationConfigGet(accessToken: String? = nil, completion: @escaping (_ data: ModerationConfigRead?, _ error: Error?) -> Void)
```

Get Moderation Config

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// Get Moderation Config
ProductsAPI.getModerationConfigApiV1AdminModerationConfigGet(accessToken: accessToken) { (response, error) in
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

[**ModerationConfigRead**](ModerationConfigRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getModerationLogApiV1AdminProductsProductIdModerationLogGet**
```swift
    open class func getModerationLogApiV1AdminProductsProductIdModerationLogGet(productId: Int, accessToken: String? = nil, completion: @escaping (_ data: [ProductModerationLogRead]?, _ error: Error?) -> Void)
```

Get Moderation Log

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Moderation Log
ProductsAPI.getModerationLogApiV1AdminProductsProductIdModerationLogGet(productId: productId, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ProductModerationLogRead]**](ProductModerationLogRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getModerationQueueApiV1AdminModerationQueueGet**
```swift
    open class func getModerationQueueApiV1AdminModerationQueueGet(categoryId: Int? = nil, shopId: Int? = nil, onlyFlagged: Bool? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [ModerationQueueItemRead]?, _ error: Error?) -> Void)
```

Get Moderation Queue

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int |  (optional)
let shopId = 987 // Int |  (optional)
let onlyFlagged = true // Bool |  (optional) (default to false)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// Get Moderation Queue
ProductsAPI.getModerationQueueApiV1AdminModerationQueueGet(categoryId: categoryId, shopId: shopId, onlyFlagged: onlyFlagged, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | [optional] 
 **shopId** | **Int** |  | [optional] 
 **onlyFlagged** | **Bool** |  | [optional] [default to false]
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ModerationQueueItemRead]**](ModerationQueueItemRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getProductAdminApiV1AdminProductsProductIdGet**
```swift
    open class func getProductAdminApiV1AdminProductsProductIdGet(productId: Int, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Get Product Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Product Admin
ProductsAPI.getProductAdminApiV1AdminProductsProductIdGet(productId: productId, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getProductBySlugsApiV1ShopsBySlugShopSlugProductsProductSlugGet**
```swift
    open class func getProductBySlugsApiV1ShopsBySlugShopSlugProductsProductSlugGet(shopSlug: String, productSlug: String, completion: @escaping (_ data: ProductPublicRead?, _ error: Error?) -> Void)
```

Get Product By Slugs

A product's previous slugs still resolve; compare the response's `slug` and `shop.slug` with the URL and redirect when they differ.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopSlug = "shopSlug_example" // String | 
let productSlug = "productSlug_example" // String | 

// Get Product By Slugs
ProductsAPI.getProductBySlugsApiV1ShopsBySlugShopSlugProductsProductSlugGet(shopSlug: shopSlug, productSlug: productSlug) { (response, error) in
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
 **shopSlug** | **String** |  | 
 **productSlug** | **String** |  | 

### Return type

[**ProductPublicRead**](ProductPublicRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getProductPublicApiV1ProductsProductIdGet**
```swift
    open class func getProductPublicApiV1ProductsProductIdGet(productId: Int, completion: @escaping (_ data: ProductPublicRead?, _ error: Error?) -> Void)
```

Get Product Public

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 

// Get Product Public
ProductsAPI.getProductPublicApiV1ProductsProductIdGet(productId: productId) { (response, error) in
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
 **productId** | **Int** |  | 

### Return type

[**ProductPublicRead**](ProductPublicRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getProductSellerApiV1SellerProductsProductIdGet**
```swift
    open class func getProductSellerApiV1SellerProductsProductIdGet(productId: Int, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Get Product Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Product Seller
ProductsAPI.getProductSellerApiV1SellerProductsProductIdGet(productId: productId, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listBrandsAdminApiV1AdminBrandsGet**
```swift
    open class func listBrandsAdminApiV1AdminBrandsGet(status: BrandStatus? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [BrandRead]?, _ error: Error?) -> Void)
```

List Brands Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = BrandStatus() // BrandStatus |  (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// List Brands Admin
ProductsAPI.listBrandsAdminApiV1AdminBrandsGet(status: status, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **status** | [**BrandStatus**](.md) |  | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[BrandRead]**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listBrandsPublicApiV1BrandsGet**
```swift
    open class func listBrandsPublicApiV1BrandsGet(categoryId: Int? = nil, q: String? = nil, completion: @escaping (_ data: [BrandPublicRead]?, _ error: Error?) -> Void)
```

List Brands Public

Approved brands, ordered by name.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | Only brands with a visible product in this category or its descendants (optional)
let q = "q_example" // String | Case-insensitive match on the brand name (optional)

// List Brands Public
ProductsAPI.listBrandsPublicApiV1BrandsGet(categoryId: categoryId, q: q) { (response, error) in
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
 **categoryId** | **Int** | Only brands with a visible product in this category or its descendants | [optional] 
 **q** | **String** | Case-insensitive match on the brand name | [optional] 

### Return type

[**[BrandPublicRead]**](BrandPublicRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listBrandsSellerApiV1SellerBrandsGet**
```swift
    open class func listBrandsSellerApiV1SellerBrandsGet(completion: @escaping (_ data: [BrandRead]?, _ error: Error?) -> Void)
```

List Brands Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK


// List Brands Seller
ProductsAPI.listBrandsSellerApiV1SellerBrandsGet() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

[**[BrandRead]**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listCatalogApiV1ProductsGet**
```swift
    open class func listCatalogApiV1ProductsGet(sort: CatalogSort? = nil, skip: Int? = nil, limit: Int? = nil, q: String? = nil, categoryId: Int? = nil, brandId: [Int]? = nil, shopId: Int? = nil, priceMin: PriceMin? = nil, priceMax: PriceMax? = nil, inStock: Bool? = nil, attr: [String]? = nil, completion: @escaping (_ data: [ProductCardRead]?, _ error: Error?) -> Void)
```

List Catalog

Public catalog and search. The total match count is in the `X-Total-Count` header.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let sort = CatalogSort() // CatalogSort | Default: relevance when q is set, newest otherwise (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let q = "q_example" // String | Case-insensitive match on title or brand name; Uzbek Latin and Cyrillic spellings both match (optional)
let categoryId = 987 // Int | The category and all its descendants (optional)
let brandId = [123] // [Int] | Repeatable; OR across values (optional)
let shopId = 987 // Int |  (optional)
let priceMin = Price_Min() // PriceMin | Compared against the card's price_min (optional)
let priceMax = Price_Max() // PriceMax | Compared against the card's price_min (optional)
let inStock = true // Bool | true hides out-of-stock products (optional)
let attr = ["inner_example"] // [String] | Repeatable key:value on a filterable attribute of category_id (required). OR within a key, AND across keys (optional)

// List Catalog
ProductsAPI.listCatalogApiV1ProductsGet(sort: sort, skip: skip, limit: limit, q: q, categoryId: categoryId, brandId: brandId, shopId: shopId, priceMin: priceMin, priceMax: priceMax, inStock: inStock, attr: attr) { (response, error) in
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
 **sort** | [**CatalogSort**](.md) | Default: relevance when q is set, newest otherwise | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **q** | **String** | Case-insensitive match on title or brand name; Uzbek Latin and Cyrillic spellings both match | [optional] 
 **categoryId** | **Int** | The category and all its descendants | [optional] 
 **brandId** | [**[Int]**](Int.md) | Repeatable; OR across values | [optional] 
 **shopId** | **Int** |  | [optional] 
 **priceMin** | [**PriceMin**](.md) | Compared against the card&#39;s price_min | [optional] 
 **priceMax** | [**PriceMax**](.md) | Compared against the card&#39;s price_min | [optional] 
 **inStock** | **Bool** | true hides out-of-stock products | [optional] 
 **attr** | [**[String]**](String.md) | Repeatable key:value on a filterable attribute of category_id (required). OR within a key, AND across keys | [optional] 

### Return type

[**[ProductCardRead]**](ProductCardRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listProductsAdminApiV1AdminProductsGet**
```swift
    open class func listProductsAdminApiV1AdminProductsGet(status: ProductStatus? = nil, shopId: Int? = nil, categoryId: Int? = nil, search: String? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [ProductRead]?, _ error: Error?) -> Void)
```

List Products Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = ProductStatus() // ProductStatus |  (optional)
let shopId = 987 // Int |  (optional)
let categoryId = 987 // Int |  (optional)
let search = "search_example" // String | Case-insensitive partial match on title or SKU (incl. variant SKUs) (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// List Products Admin
ProductsAPI.listProductsAdminApiV1AdminProductsGet(status: status, shopId: shopId, categoryId: categoryId, search: search, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **status** | [**ProductStatus**](.md) |  | [optional] 
 **shopId** | **Int** |  | [optional] 
 **categoryId** | **Int** |  | [optional] 
 **search** | **String** | Case-insensitive partial match on title or SKU (incl. variant SKUs) | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ProductRead]**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listProductsSellerApiV1SellerProductsGet**
```swift
    open class func listProductsSellerApiV1SellerProductsGet(shopId: Int? = nil, status: ProductStatus? = nil, accessToken: String? = nil, completion: @escaping (_ data: [ProductRead]?, _ error: Error?) -> Void)
```

List Products Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int |  (optional)
let status = ProductStatus() // ProductStatus |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Products Seller
ProductsAPI.listProductsSellerApiV1SellerProductsGet(shopId: shopId, status: status, accessToken: accessToken) { (response, error) in
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
 **shopId** | **Int** |  | [optional] 
 **status** | [**ProductStatus**](.md) |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ProductRead]**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listShopProductsPublicApiV1ShopsShopIdProductsGet**
```swift
    open class func listShopProductsPublicApiV1ShopsShopIdProductsGet(shopId: Int, completion: @escaping (_ data: [ProductPublicRead]?, _ error: Error?) -> Void)
```

List Shop Products Public

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 

// List Shop Products Public
ProductsAPI.listShopProductsPublicApiV1ShopsShopIdProductsGet(shopId: shopId) { (response, error) in
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

### Return type

[**[ProductPublicRead]**](ProductPublicRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rejectBrandApiV1AdminBrandsBrandIdRejectPatch**
```swift
    open class func rejectBrandApiV1AdminBrandsBrandIdRejectPatch(brandId: Int, brandRejectRequest: BrandRejectRequest, accessToken: String? = nil, completion: @escaping (_ data: BrandRead?, _ error: Error?) -> Void)
```

Reject Brand

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let brandId = 987 // Int | 
let brandRejectRequest = BrandRejectRequest(reason: "reason_example") // BrandRejectRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Reject Brand
ProductsAPI.rejectBrandApiV1AdminBrandsBrandIdRejectPatch(brandId: brandId, brandRejectRequest: brandRejectRequest, accessToken: accessToken) { (response, error) in
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
 **brandId** | **Int** |  | 
 **brandRejectRequest** | [**BrandRejectRequest**](BrandRejectRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**BrandRead**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rejectProductApiV1AdminProductsProductIdRejectPatch**
```swift
    open class func rejectProductApiV1AdminProductsProductIdRejectPatch(productId: Int, rejectRequest: RejectRequest, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Reject Product

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let rejectRequest = RejectRequest(reason: "reason_example") // RejectRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Reject Product
ProductsAPI.rejectProductApiV1AdminProductsProductIdRejectPatch(productId: productId, rejectRequest: rejectRequest, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **rejectRequest** | [**RejectRequest**](RejectRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **requestBrandApiV1SellerBrandsRequestPost**
```swift
    open class func requestBrandApiV1SellerBrandsRequestPost(brandRequestCreate: BrandRequestCreate, accessToken: String? = nil, completion: @escaping (_ data: BrandRead?, _ error: Error?) -> Void)
```

Request Brand

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let brandRequestCreate = BrandRequestCreate(shopId: 123, name: "name_example", logoUrl: "logoUrl_example") // BrandRequestCreate | 
let accessToken = "accessToken_example" // String |  (optional)

// Request Brand
ProductsAPI.requestBrandApiV1SellerBrandsRequestPost(brandRequestCreate: brandRequestCreate, accessToken: accessToken) { (response, error) in
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
 **brandRequestCreate** | [**BrandRequestCreate**](BrandRequestCreate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**BrandRead**](BrandRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **submitProductApiV1SellerProductsProductIdSubmitPost**
```swift
    open class func submitProductApiV1SellerProductsProductIdSubmitPost(productId: Int, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Submit Product

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Submit Product
ProductsAPI.submitProductApiV1SellerProductsProductIdSubmitPost(productId: productId, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateModerationConfigApiV1AdminModerationConfigPut**
```swift
    open class func updateModerationConfigApiV1AdminModerationConfigPut(moderationConfigUpdate: ModerationConfigUpdate, accessToken: String? = nil, completion: @escaping (_ data: ModerationConfigRead?, _ error: Error?) -> Void)
```

Update Moderation Config

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let moderationConfigUpdate = ModerationConfigUpdate(sensitiveFields: ["sensitiveFields_example"]) // ModerationConfigUpdate | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Moderation Config
ProductsAPI.updateModerationConfigApiV1AdminModerationConfigPut(moderationConfigUpdate: moderationConfigUpdate, accessToken: accessToken) { (response, error) in
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
 **moderationConfigUpdate** | [**ModerationConfigUpdate**](ModerationConfigUpdate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ModerationConfigRead**](ModerationConfigRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateProductApiV1SellerProductsProductIdPatch**
```swift
    open class func updateProductApiV1SellerProductsProductIdPatch(productId: Int, productUpdate: ProductUpdate, accessToken: String? = nil, completion: @escaping (_ data: ProductRead?, _ error: Error?) -> Void)
```

Update Product

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let productId = 987 // Int | 
let productUpdate = ProductUpdate(categoryId: 123, brandId: 123, title: "title_example", slug: "slug_example", description: "description_example", basePrice: Base_Price(), stockQuantity: 123, sellerSku: "sellerSku_example", images: [ProductImageIn(key: "key_example", sortOrder: 123, isPrimary: false)], attributeValues: [ProductAttributeValueIn(categoryAttributeId: 123, value: Value())]) // ProductUpdate | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Product
ProductsAPI.updateProductApiV1SellerProductsProductIdPatch(productId: productId, productUpdate: productUpdate, accessToken: accessToken) { (response, error) in
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
 **productId** | **Int** |  | 
 **productUpdate** | [**ProductUpdate**](ProductUpdate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductRead**](ProductRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateVariantApiV1SellerVariantsVariantIdPatch**
```swift
    open class func updateVariantApiV1SellerVariantsVariantIdPatch(variantId: Int, productVariantUpdate: ProductVariantUpdate, accessToken: String? = nil, completion: @escaping (_ data: ProductVariantRead?, _ error: Error?) -> Void)
```

Update Variant

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let variantId = 987 // Int | 
let productVariantUpdate = ProductVariantUpdate(sellerSku: "sellerSku_example", price: Price_1(), stockQuantity: 123, attributes: "TODO", imageIds: [123], isActive: false) // ProductVariantUpdate | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Variant
ProductsAPI.updateVariantApiV1SellerVariantsVariantIdPatch(variantId: variantId, productVariantUpdate: productVariantUpdate, accessToken: accessToken) { (response, error) in
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
 **variantId** | **Int** |  | 
 **productVariantUpdate** | [**ProductVariantUpdate**](ProductVariantUpdate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ProductVariantRead**](ProductVariantRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

