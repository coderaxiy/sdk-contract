# CategoriesAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**commissionPreviewApiV1SellerShopsShopIdCommissionPreviewGet**](CategoriesAPI.md#commissionpreviewapiv1sellershopsshopidcommissionpreviewget) | **GET** /api/v1/seller/shops/{shop_id}/commission-preview | Commission Preview
[**confirmCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivateConfirmPost**](CategoriesAPI.md#confirmcategorydeactivationapiv1admincategoriescategoryiddeactivateconfirmpost) | **POST** /api/v1/admin/categories/{category_id}/deactivate/confirm | Confirm Category Deactivation
[**createCategoryApiV1AdminCategoriesPost**](CategoriesAPI.md#createcategoryapiv1admincategoriespost) | **POST** /api/v1/admin/categories | Create Category
[**createCommissionRuleApiV1AdminCommissionRulesPost**](CategoriesAPI.md#createcommissionruleapiv1admincommissionrulespost) | **POST** /api/v1/admin/commission-rules | Create Commission Rule
[**deactivateCommissionRuleApiV1AdminCommissionRulesRuleIdDeactivatePatch**](CategoriesAPI.md#deactivatecommissionruleapiv1admincommissionrulesruleiddeactivatepatch) | **PATCH** /api/v1/admin/commission-rules/{rule_id}/deactivate | Deactivate Commission Rule
[**deleteCategoryApiV1AdminCategoriesCategoryIdDelete**](CategoriesAPI.md#deletecategoryapiv1admincategoriescategoryiddelete) | **DELETE** /api/v1/admin/categories/{category_id} | Delete Category
[**getCategoryAttributesPublicApiV1CategoriesCategoryIdAttributesGet**](CategoriesAPI.md#getcategoryattributespublicapiv1categoriescategoryidattributesget) | **GET** /api/v1/categories/{category_id}/attributes | Get Category Attributes Public
[**getCategoryTreeApiV1CategoriesGet**](CategoriesAPI.md#getcategorytreeapiv1categoriesget) | **GET** /api/v1/categories | Get Category Tree
[**getEffectiveAttributesAdminApiV1AdminCategoriesCategoryIdAttributesGet**](CategoriesAPI.md#geteffectiveattributesadminapiv1admincategoriescategoryidattributesget) | **GET** /api/v1/admin/categories/{category_id}/attributes | Get Effective Attributes Admin
[**getEffectiveAttributesSellerApiV1SellerCategoriesCategoryIdAttributesGet**](CategoriesAPI.md#geteffectiveattributessellerapiv1sellercategoriescategoryidattributesget) | **GET** /api/v1/seller/categories/{category_id}/attributes | Get Effective Attributes Seller
[**listCategoriesAdminApiV1AdminCategoriesGet**](CategoriesAPI.md#listcategoriesadminapiv1admincategoriesget) | **GET** /api/v1/admin/categories | List Categories Admin
[**listCategoriesSellerApiV1SellerCategoriesGet**](CategoriesAPI.md#listcategoriessellerapiv1sellercategoriesget) | **GET** /api/v1/seller/categories | List Categories Seller
[**listCommissionRulesApiV1AdminCommissionRulesGet**](CategoriesAPI.md#listcommissionrulesapiv1admincommissionrulesget) | **GET** /api/v1/admin/commission-rules | List Commission Rules
[**moveCategoryApiV1AdminCategoriesCategoryIdMovePost**](CategoriesAPI.md#movecategoryapiv1admincategoriescategoryidmovepost) | **POST** /api/v1/admin/categories/{category_id}/move | Move Category
[**previewCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivatePreviewPost**](CategoriesAPI.md#previewcategorydeactivationapiv1admincategoriescategoryiddeactivatepreviewpost) | **POST** /api/v1/admin/categories/{category_id}/deactivate/preview | Preview Category Deactivation
[**resolveCommissionRuleDebugApiV1AdminCommissionRulesResolveGet**](CategoriesAPI.md#resolvecommissionruledebugapiv1admincommissionrulesresolveget) | **GET** /api/v1/admin/commission-rules/resolve | Resolve Commission Rule Debug
[**setAttributesApiV1AdminCategoriesCategoryIdAttributesPut**](CategoriesAPI.md#setattributesapiv1admincategoriescategoryidattributesput) | **PUT** /api/v1/admin/categories/{category_id}/attributes | Set Attributes
[**updateCategoryApiV1AdminCategoriesCategoryIdPatch**](CategoriesAPI.md#updatecategoryapiv1admincategoriescategoryidpatch) | **PATCH** /api/v1/admin/categories/{category_id} | Update Category


# **commissionPreviewApiV1SellerShopsShopIdCommissionPreviewGet**
```swift
    open class func commissionPreviewApiV1SellerShopsShopIdCommissionPreviewGet(shopId: Int, categoryId: Int, accessToken: String? = nil, completion: @escaping (_ data: CommissionResolutionRead?, _ error: Error?) -> Void)
```

Commission Preview

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let categoryId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Commission Preview
CategoriesAPI.commissionPreviewApiV1SellerShopsShopIdCommissionPreviewGet(shopId: shopId, categoryId: categoryId, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CommissionResolutionRead**](CommissionResolutionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **confirmCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivateConfirmPost**
```swift
    open class func confirmCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivateConfirmPost(categoryId: Int, accessToken: String? = nil, completion: @escaping (_ data: CategoryRead?, _ error: Error?) -> Void)
```

Confirm Category Deactivation

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Confirm Category Deactivation
CategoriesAPI.confirmCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivateConfirmPost(categoryId: categoryId, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CategoryRead**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createCategoryApiV1AdminCategoriesPost**
```swift
    open class func createCategoryApiV1AdminCategoriesPost(categoryCreate: CategoryCreate, accessToken: String? = nil, completion: @escaping (_ data: CategoryRead?, _ error: Error?) -> Void)
```

Create Category

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryCreate = CategoryCreate(parentId: 123, slug: "slug_example", iconUrl: "iconUrl_example", sortOrder: 123, requiresDocuments: false, requiredDocumentTypes: ["requiredDocumentTypes_example"], allowsVariants: false, returnWindowDays: 123, translations: [TranslationIn(locale: "locale_example", name: "name_example", description: "description_example")]) // CategoryCreate | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Category
CategoriesAPI.createCategoryApiV1AdminCategoriesPost(categoryCreate: categoryCreate, accessToken: accessToken) { (response, error) in
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
 **categoryCreate** | [**CategoryCreate**](CategoryCreate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CategoryRead**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createCommissionRuleApiV1AdminCommissionRulesPost**
```swift
    open class func createCommissionRuleApiV1AdminCommissionRulesPost(commissionRuleCreate: CommissionRuleCreate, accessToken: String? = nil, completion: @escaping (_ data: CommissionRuleRead?, _ error: Error?) -> Void)
```

Create Commission Rule

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let commissionRuleCreate = CommissionRuleCreate(scopeType: CommissionScopeType(), scopeId: 123, categoryId: 123, calculationType: CommissionCalculationType(), percent: Percent(), flatFeeAmount: Flat_Fee_Amount(), currency: "currency_example", tiers: [CommissionTier(minAmount: Min_Amount(), maxAmount: Max_Amount(), percent: Percent_1())], effectiveFrom: Date(), effectiveTo: Date()) // CommissionRuleCreate | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Commission Rule
CategoriesAPI.createCommissionRuleApiV1AdminCommissionRulesPost(commissionRuleCreate: commissionRuleCreate, accessToken: accessToken) { (response, error) in
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
 **commissionRuleCreate** | [**CommissionRuleCreate**](CommissionRuleCreate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CommissionRuleRead**](CommissionRuleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deactivateCommissionRuleApiV1AdminCommissionRulesRuleIdDeactivatePatch**
```swift
    open class func deactivateCommissionRuleApiV1AdminCommissionRulesRuleIdDeactivatePatch(ruleId: Int, accessToken: String? = nil, completion: @escaping (_ data: CommissionRuleRead?, _ error: Error?) -> Void)
```

Deactivate Commission Rule

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let ruleId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Deactivate Commission Rule
CategoriesAPI.deactivateCommissionRuleApiV1AdminCommissionRulesRuleIdDeactivatePatch(ruleId: ruleId, accessToken: accessToken) { (response, error) in
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
 **ruleId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CommissionRuleRead**](CommissionRuleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteCategoryApiV1AdminCategoriesCategoryIdDelete**
```swift
    open class func deleteCategoryApiV1AdminCategoriesCategoryIdDelete(categoryId: Int, accessToken: String? = nil, completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

Delete Category

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Delete Category
CategoriesAPI.deleteCategoryApiV1AdminCategoriesCategoryIdDelete(categoryId: categoryId, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

Void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCategoryAttributesPublicApiV1CategoriesCategoryIdAttributesGet**
```swift
    open class func getCategoryAttributesPublicApiV1CategoriesCategoryIdAttributesGet(categoryId: Int, completion: @escaping (_ data: [CategoryAttributePublicRead]?, _ error: Error?) -> Void)
```

Get Category Attributes Public

Effective attributes (inherited ones included) of an active category; 404 otherwise.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 

// Get Category Attributes Public
CategoriesAPI.getCategoryAttributesPublicApiV1CategoriesCategoryIdAttributesGet(categoryId: categoryId) { (response, error) in
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
 **categoryId** | **Int** |  | 

### Return type

[**[CategoryAttributePublicRead]**](CategoryAttributePublicRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCategoryTreeApiV1CategoriesGet**
```swift
    open class func getCategoryTreeApiV1CategoriesGet(completion: @escaping (_ data: [CategoryNodeRead]?, _ error: Error?) -> Void)
```

Get Category Tree

The active category tree (roots, children nested), ordered by sort_order then id. A deactivated category hides its whole subtree. Slugs are globally unique.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK


// Get Category Tree
CategoriesAPI.getCategoryTreeApiV1CategoriesGet() { (response, error) in
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

[**[CategoryNodeRead]**](CategoryNodeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getEffectiveAttributesAdminApiV1AdminCategoriesCategoryIdAttributesGet**
```swift
    open class func getEffectiveAttributesAdminApiV1AdminCategoriesCategoryIdAttributesGet(categoryId: Int, accessToken: String? = nil, completion: @escaping (_ data: [CategoryAttributeRead]?, _ error: Error?) -> Void)
```

Get Effective Attributes Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Effective Attributes Admin
CategoriesAPI.getEffectiveAttributesAdminApiV1AdminCategoriesCategoryIdAttributesGet(categoryId: categoryId, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[CategoryAttributeRead]**](CategoryAttributeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getEffectiveAttributesSellerApiV1SellerCategoriesCategoryIdAttributesGet**
```swift
    open class func getEffectiveAttributesSellerApiV1SellerCategoriesCategoryIdAttributesGet(categoryId: Int, completion: @escaping (_ data: [CategoryAttributeRead]?, _ error: Error?) -> Void)
```

Get Effective Attributes Seller

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 

// Get Effective Attributes Seller
CategoriesAPI.getEffectiveAttributesSellerApiV1SellerCategoriesCategoryIdAttributesGet(categoryId: categoryId) { (response, error) in
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
 **categoryId** | **Int** |  | 

### Return type

[**[CategoryAttributeRead]**](CategoryAttributeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listCategoriesAdminApiV1AdminCategoriesGet**
```swift
    open class func listCategoriesAdminApiV1AdminCategoriesGet(parentId: Int? = nil, isActive: Bool? = nil, accessToken: String? = nil, completion: @escaping (_ data: [CategoryRead]?, _ error: Error?) -> Void)
```

List Categories Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let parentId = 987 // Int |  (optional)
let isActive = true // Bool |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Categories Admin
CategoriesAPI.listCategoriesAdminApiV1AdminCategoriesGet(parentId: parentId, isActive: isActive, accessToken: accessToken) { (response, error) in
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
 **parentId** | **Int** |  | [optional] 
 **isActive** | **Bool** |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[CategoryRead]**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listCategoriesSellerApiV1SellerCategoriesGet**
```swift
    open class func listCategoriesSellerApiV1SellerCategoriesGet(completion: @escaping (_ data: [SellerCategoryRead]?, _ error: Error?) -> Void)
```

List Categories Seller

Active leaf categories (the only ones products can use), each with its ancestors so the picker can show a path.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK


// List Categories Seller
CategoriesAPI.listCategoriesSellerApiV1SellerCategoriesGet() { (response, error) in
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

[**[SellerCategoryRead]**](SellerCategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listCommissionRulesApiV1AdminCommissionRulesGet**
```swift
    open class func listCommissionRulesApiV1AdminCommissionRulesGet(scopeType: CommissionScopeType? = nil, scopeId: Int? = nil, isActive: Bool? = nil, accessToken: String? = nil, completion: @escaping (_ data: [CommissionRuleRead]?, _ error: Error?) -> Void)
```

List Commission Rules

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let scopeType = CommissionScopeType() // CommissionScopeType |  (optional)
let scopeId = 987 // Int |  (optional)
let isActive = true // Bool |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Commission Rules
CategoriesAPI.listCommissionRulesApiV1AdminCommissionRulesGet(scopeType: scopeType, scopeId: scopeId, isActive: isActive, accessToken: accessToken) { (response, error) in
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
 **scopeType** | [**CommissionScopeType**](.md) |  | [optional] 
 **scopeId** | **Int** |  | [optional] 
 **isActive** | **Bool** |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[CommissionRuleRead]**](CommissionRuleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **moveCategoryApiV1AdminCategoriesCategoryIdMovePost**
```swift
    open class func moveCategoryApiV1AdminCategoriesCategoryIdMovePost(categoryId: Int, categoryMoveRequest: CategoryMoveRequest, accessToken: String? = nil, completion: @escaping (_ data: CategoryRead?, _ error: Error?) -> Void)
```

Move Category

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 
let categoryMoveRequest = CategoryMoveRequest(newParentId: 123) // CategoryMoveRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Move Category
CategoriesAPI.moveCategoryApiV1AdminCategoriesCategoryIdMovePost(categoryId: categoryId, categoryMoveRequest: categoryMoveRequest, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **categoryMoveRequest** | [**CategoryMoveRequest**](CategoryMoveRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CategoryRead**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **previewCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivatePreviewPost**
```swift
    open class func previewCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivatePreviewPost(categoryId: Int, accessToken: String? = nil, completion: @escaping (_ data: DeactivationImpact?, _ error: Error?) -> Void)
```

Preview Category Deactivation

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Preview Category Deactivation
CategoriesAPI.previewCategoryDeactivationApiV1AdminCategoriesCategoryIdDeactivatePreviewPost(categoryId: categoryId, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**DeactivationImpact**](DeactivationImpact.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resolveCommissionRuleDebugApiV1AdminCommissionRulesResolveGet**
```swift
    open class func resolveCommissionRuleDebugApiV1AdminCommissionRulesResolveGet(shopId: Int, categoryId: Int, accessToken: String? = nil, completion: @escaping (_ data: CommissionRuleRead?, _ error: Error?) -> Void)
```

Resolve Commission Rule Debug

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int | 
let categoryId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Resolve Commission Rule Debug
CategoriesAPI.resolveCommissionRuleDebugApiV1AdminCommissionRulesResolveGet(shopId: shopId, categoryId: categoryId, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CommissionRuleRead**](CommissionRuleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setAttributesApiV1AdminCategoriesCategoryIdAttributesPut**
```swift
    open class func setAttributesApiV1AdminCategoriesCategoryIdAttributesPut(categoryId: Int, setAttributesRequest: SetAttributesRequest, accessToken: String? = nil, completion: @escaping (_ data: [CategoryAttributeRead]?, _ error: Error?) -> Void)
```

Set Attributes

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 
let setAttributesRequest = SetAttributesRequest(attributes: [CategoryAttributeIn(key: "key_example", dataType: AttributeDataType(), options: ["options_example"], unit: "unit_example", isRequired: false, isFilterable: false, isInherited: false, isVariantDefining: false, sortOrder: 123, translations: [AttributeTranslationIn(locale: "locale_example", label: "label_example")])]) // SetAttributesRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Set Attributes
CategoriesAPI.setAttributesApiV1AdminCategoriesCategoryIdAttributesPut(categoryId: categoryId, setAttributesRequest: setAttributesRequest, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **setAttributesRequest** | [**SetAttributesRequest**](SetAttributesRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[CategoryAttributeRead]**](CategoryAttributeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateCategoryApiV1AdminCategoriesCategoryIdPatch**
```swift
    open class func updateCategoryApiV1AdminCategoriesCategoryIdPatch(categoryId: Int, categoryUpdate: CategoryUpdate, accessToken: String? = nil, completion: @escaping (_ data: CategoryRead?, _ error: Error?) -> Void)
```

Update Category

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let categoryId = 987 // Int | 
let categoryUpdate = CategoryUpdate(slug: "slug_example", iconUrl: "iconUrl_example", sortOrder: 123, isActive: false, requiresDocuments: false, requiredDocumentTypes: ["requiredDocumentTypes_example"], allowsVariants: false, returnWindowDays: 123, defaultCommissionRuleId: 123, translations: [TranslationIn(locale: "locale_example", name: "name_example", description: "description_example")]) // CategoryUpdate | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Category
CategoriesAPI.updateCategoryApiV1AdminCategoriesCategoryIdPatch(categoryId: categoryId, categoryUpdate: categoryUpdate, accessToken: accessToken) { (response, error) in
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
 **categoryId** | **Int** |  | 
 **categoryUpdate** | [**CategoryUpdate**](CategoryUpdate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CategoryRead**](CategoryRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

