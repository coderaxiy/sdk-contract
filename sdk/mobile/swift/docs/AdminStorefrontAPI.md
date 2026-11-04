# AdminStorefrontAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**adminCampaignApiV1AdminStorefrontCampaignsCampaignIdGet**](AdminStorefrontAPI.md#admincampaignapiv1adminstorefrontcampaignscampaignidget) | **GET** /api/v1/admin/storefront/campaigns/{campaign_id} | Admin Campaign
[**adminCampaignsApiV1AdminStorefrontCampaignsGet**](AdminStorefrontAPI.md#admincampaignsapiv1adminstorefrontcampaignsget) | **GET** /api/v1/admin/storefront/campaigns | Admin Campaigns
[**adminHomeApiV1AdminStorefrontHomeGet**](AdminStorefrontAPI.md#adminhomeapiv1adminstorefronthomeget) | **GET** /api/v1/admin/storefront/home | Admin Home
[**createCampaignApiV1AdminStorefrontCampaignsPost**](AdminStorefrontAPI.md#createcampaignapiv1adminstorefrontcampaignspost) | **POST** /api/v1/admin/storefront/campaigns | Create Campaign
[**deleteCampaignApiV1AdminStorefrontCampaignsCampaignIdDelete**](AdminStorefrontAPI.md#deletecampaignapiv1adminstorefrontcampaignscampaigniddelete) | **DELETE** /api/v1/admin/storefront/campaigns/{campaign_id} | Delete Campaign
[**previewCampaignApiV1AdminStorefrontCampaignsCampaignIdPreviewGet**](AdminStorefrontAPI.md#previewcampaignapiv1adminstorefrontcampaignscampaignidpreviewget) | **GET** /api/v1/admin/storefront/campaigns/{campaign_id}/preview | Preview Campaign
[**updateCampaignApiV1AdminStorefrontCampaignsCampaignIdPut**](AdminStorefrontAPI.md#updatecampaignapiv1adminstorefrontcampaignscampaignidput) | **PUT** /api/v1/admin/storefront/campaigns/{campaign_id} | Update Campaign
[**updateHomeApiV1AdminStorefrontHomePut**](AdminStorefrontAPI.md#updatehomeapiv1adminstorefronthomeput) | **PUT** /api/v1/admin/storefront/home | Update Home


# **adminCampaignApiV1AdminStorefrontCampaignsCampaignIdGet**
```swift
    open class func adminCampaignApiV1AdminStorefrontCampaignsCampaignIdGet(campaignId: Int, accessToken: String? = nil, completion: @escaping (_ data: CampaignAdminRead?, _ error: Error?) -> Void)
```

Admin Campaign

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let campaignId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Admin Campaign
AdminStorefrontAPI.adminCampaignApiV1AdminStorefrontCampaignsCampaignIdGet(campaignId: campaignId, accessToken: accessToken) { (response, error) in
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
 **campaignId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CampaignAdminRead**](CampaignAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **adminCampaignsApiV1AdminStorefrontCampaignsGet**
```swift
    open class func adminCampaignsApiV1AdminStorefrontCampaignsGet(skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [CampaignAdminRead]?, _ error: Error?) -> Void)
```

Admin Campaigns

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// Admin Campaigns
AdminStorefrontAPI.adminCampaignsApiV1AdminStorefrontCampaignsGet(skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[CampaignAdminRead]**](CampaignAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **adminHomeApiV1AdminStorefrontHomeGet**
```swift
    open class func adminHomeApiV1AdminStorefrontHomeGet(accessToken: String? = nil, completion: @escaping (_ data: HomeWrite?, _ error: Error?) -> Void)
```

Admin Home

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// Admin Home
AdminStorefrontAPI.adminHomeApiV1AdminStorefrontHomeGet(accessToken: accessToken) { (response, error) in
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

[**HomeWrite**](HomeWrite.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createCampaignApiV1AdminStorefrontCampaignsPost**
```swift
    open class func createCampaignApiV1AdminStorefrontCampaignsPost(campaignWrite: CampaignWrite, accessToken: String? = nil, completion: @escaping (_ data: CampaignAdminRead?, _ error: Error?) -> Void)
```

Create Campaign

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let campaignWrite = CampaignWrite(slug: "slug_example", title: LocalizedText(uz: "uz_example", ru: "ru_example"), intro: nil, hero: LocalizedArtwork(uz: ImagePairIn(mobileKey: "mobileKey_example", desktopKey: "desktopKey_example"), ru: nil), published: false, startsAt: Date(), endsAt: Date(), categoryIds: [123], banners: [BannerIn(id: 123, sortOrder: 123, title: nil, artwork: nil)], blocks: [Blocks_inner(id: 123, sortOrder: 123, title: nil, type: "type_example", productIds: [123], homeKind: "homeKind_example", homeSortOrder: 123, text: nil, artwork: nil, categoryIds: [123])], expectedRevision: 123) // CampaignWrite | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Campaign
AdminStorefrontAPI.createCampaignApiV1AdminStorefrontCampaignsPost(campaignWrite: campaignWrite, accessToken: accessToken) { (response, error) in
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
 **campaignWrite** | [**CampaignWrite**](CampaignWrite.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CampaignAdminRead**](CampaignAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteCampaignApiV1AdminStorefrontCampaignsCampaignIdDelete**
```swift
    open class func deleteCampaignApiV1AdminStorefrontCampaignsCampaignIdDelete(campaignId: Int, accessToken: String? = nil, completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

Delete Campaign

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let campaignId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Delete Campaign
AdminStorefrontAPI.deleteCampaignApiV1AdminStorefrontCampaignsCampaignIdDelete(campaignId: campaignId, accessToken: accessToken) { (response, error) in
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
 **campaignId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

Void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **previewCampaignApiV1AdminStorefrontCampaignsCampaignIdPreviewGet**
```swift
    open class func previewCampaignApiV1AdminStorefrontCampaignsCampaignIdPreviewGet(campaignId: Int, accessToken: String? = nil, completion: @escaping (_ data: CampaignRead?, _ error: Error?) -> Void)
```

Preview Campaign

Render draft content with normal product visibility. Bypasses only campaign publication/schedule.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let campaignId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Preview Campaign
AdminStorefrontAPI.previewCampaignApiV1AdminStorefrontCampaignsCampaignIdPreviewGet(campaignId: campaignId, accessToken: accessToken) { (response, error) in
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
 **campaignId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CampaignRead**](CampaignRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateCampaignApiV1AdminStorefrontCampaignsCampaignIdPut**
```swift
    open class func updateCampaignApiV1AdminStorefrontCampaignsCampaignIdPut(campaignId: Int, campaignWrite: CampaignWrite, accessToken: String? = nil, completion: @escaping (_ data: CampaignAdminRead?, _ error: Error?) -> Void)
```

Update Campaign

Full replacement; send existing block/banner IDs to preserve them and expected_revision to prevent lost edits.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let campaignId = 987 // Int | 
let campaignWrite = CampaignWrite(slug: "slug_example", title: LocalizedText(uz: "uz_example", ru: "ru_example"), intro: nil, hero: LocalizedArtwork(uz: ImagePairIn(mobileKey: "mobileKey_example", desktopKey: "desktopKey_example"), ru: nil), published: false, startsAt: Date(), endsAt: Date(), categoryIds: [123], banners: [BannerIn(id: 123, sortOrder: 123, title: nil, artwork: nil)], blocks: [Blocks_inner(id: 123, sortOrder: 123, title: nil, type: "type_example", productIds: [123], homeKind: "homeKind_example", homeSortOrder: 123, text: nil, artwork: nil, categoryIds: [123])], expectedRevision: 123) // CampaignWrite | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Campaign
AdminStorefrontAPI.updateCampaignApiV1AdminStorefrontCampaignsCampaignIdPut(campaignId: campaignId, campaignWrite: campaignWrite, accessToken: accessToken) { (response, error) in
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
 **campaignId** | **Int** |  | 
 **campaignWrite** | [**CampaignWrite**](CampaignWrite.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CampaignAdminRead**](CampaignAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateHomeApiV1AdminStorefrontHomePut**
```swift
    open class func updateHomeApiV1AdminStorefrontHomePut(homeWrite: HomeWrite, accessToken: String? = nil, completion: @escaping (_ data: HomeWrite?, _ error: Error?) -> Void)
```

Update Home

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let homeWrite = HomeWrite(categoryIds: [123]) // HomeWrite | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Home
AdminStorefrontAPI.updateHomeApiV1AdminStorefrontHomePut(homeWrite: homeWrite, accessToken: accessToken) { (response, error) in
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
 **homeWrite** | [**HomeWrite**](HomeWrite.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**HomeWrite**](HomeWrite.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

