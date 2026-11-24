# AdminStorefrontApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**adminCampaignApiV1AdminStorefrontCampaignsCampaignIdGet**](AdminStorefrontApi.md#adminCampaignApiV1AdminStorefrontCampaignsCampaignIdGet) | **GET** api/v1/admin/storefront/campaigns/{campaign_id} | Admin Campaign |
| [**adminCampaignsApiV1AdminStorefrontCampaignsGet**](AdminStorefrontApi.md#adminCampaignsApiV1AdminStorefrontCampaignsGet) | **GET** api/v1/admin/storefront/campaigns | Admin Campaigns |
| [**adminHomeApiV1AdminStorefrontHomeGet**](AdminStorefrontApi.md#adminHomeApiV1AdminStorefrontHomeGet) | **GET** api/v1/admin/storefront/home | Admin Home |
| [**createCampaignApiV1AdminStorefrontCampaignsPost**](AdminStorefrontApi.md#createCampaignApiV1AdminStorefrontCampaignsPost) | **POST** api/v1/admin/storefront/campaigns | Create Campaign |
| [**createHomepageShopBannerApiV1AdminStorefrontHomeBannersPost**](AdminStorefrontApi.md#createHomepageShopBannerApiV1AdminStorefrontHomeBannersPost) | **POST** api/v1/admin/storefront/home/banners | Create Homepage Shop Banner |
| [**deleteCampaignApiV1AdminStorefrontCampaignsCampaignIdDelete**](AdminStorefrontApi.md#deleteCampaignApiV1AdminStorefrontCampaignsCampaignIdDelete) | **DELETE** api/v1/admin/storefront/campaigns/{campaign_id} | Delete Campaign |
| [**listHomepageBannerShopsApiV1AdminStorefrontHomeBannersShopsGet**](AdminStorefrontApi.md#listHomepageBannerShopsApiV1AdminStorefrontHomeBannersShopsGet) | **GET** api/v1/admin/storefront/home/banners/shops | List Homepage Banner Shops |
| [**listHomepageShopBannersApiV1AdminStorefrontHomeBannersGet**](AdminStorefrontApi.md#listHomepageShopBannersApiV1AdminStorefrontHomeBannersGet) | **GET** api/v1/admin/storefront/home/banners | List Homepage Shop Banners |
| [**previewCampaignApiV1AdminStorefrontCampaignsCampaignIdPreviewGet**](AdminStorefrontApi.md#previewCampaignApiV1AdminStorefrontCampaignsCampaignIdPreviewGet) | **GET** api/v1/admin/storefront/campaigns/{campaign_id}/preview | Preview Campaign |
| [**setHomepageShopBannerPublicationApiV1AdminStorefrontHomeBannersBannerIdPublicationPatch**](AdminStorefrontApi.md#setHomepageShopBannerPublicationApiV1AdminStorefrontHomeBannersBannerIdPublicationPatch) | **PATCH** api/v1/admin/storefront/home/banners/{banner_id}/publication | Set Homepage Shop Banner Publication |
| [**updateCampaignApiV1AdminStorefrontCampaignsCampaignIdPut**](AdminStorefrontApi.md#updateCampaignApiV1AdminStorefrontCampaignsCampaignIdPut) | **PUT** api/v1/admin/storefront/campaigns/{campaign_id} | Update Campaign |
| [**updateHomeApiV1AdminStorefrontHomePut**](AdminStorefrontApi.md#updateHomeApiV1AdminStorefrontHomePut) | **PUT** api/v1/admin/storefront/home | Update Home |
| [**updateHomepageShopBannerApiV1AdminStorefrontHomeBannersBannerIdPut**](AdminStorefrontApi.md#updateHomepageShopBannerApiV1AdminStorefrontHomeBannersBannerIdPut) | **PUT** api/v1/admin/storefront/home/banners/{banner_id} | Update Homepage Shop Banner |



Admin Campaign

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val campaignId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CampaignAdminRead = webService.adminCampaignApiV1AdminStorefrontCampaignsCampaignIdGet(campaignId, accessToken)
}
```

### Parameters
| **campaignId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CampaignAdminRead**](CampaignAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Admin Campaigns

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<CampaignAdminRead> = webService.adminCampaignsApiV1AdminStorefrontCampaignsGet(skip, limit, accessToken)
}
```

### Parameters
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;CampaignAdminRead&gt;**](CampaignAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Admin Home

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : HomeWrite = webService.adminHomeApiV1AdminStorefrontHomeGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**HomeWrite**](HomeWrite.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Create Campaign

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val campaignWrite : CampaignWrite =  // CampaignWrite | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CampaignAdminRead = webService.createCampaignApiV1AdminStorefrontCampaignsPost(campaignWrite, accessToken)
}
```

### Parameters
| **campaignWrite** | [**CampaignWrite**](CampaignWrite.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CampaignAdminRead**](CampaignAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Create Homepage Shop Banner

Create an unpublished shop banner.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val homepageShopBannerWrite : HomepageShopBannerWrite =  // HomepageShopBannerWrite | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : HomepageShopBannerAdminRead = webService.createHomepageShopBannerApiV1AdminStorefrontHomeBannersPost(homepageShopBannerWrite, accessToken)
}
```

### Parameters
| **homepageShopBannerWrite** | [**HomepageShopBannerWrite**](HomepageShopBannerWrite.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**HomepageShopBannerAdminRead**](HomepageShopBannerAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Delete Campaign

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val campaignId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.deleteCampaignApiV1AdminStorefrontCampaignsCampaignIdDelete(campaignId, accessToken)
}
```

### Parameters
| **campaignId** | **kotlin.Int**|  | |
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


List Homepage Banner Shops

Search public shops by name or slug for the banner picker.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val q : kotlin.String = q_example // kotlin.String | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<HomepageShopOptionRead> = webService.listHomepageBannerShopsApiV1AdminStorefrontHomeBannersShopsGet(q, skip, limit, accessToken)
}
```

### Parameters
| **q** | **kotlin.String**|  | [optional] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;HomepageShopOptionRead&gt;**](HomepageShopOptionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Homepage Shop Banners

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<HomepageShopBannerAdminRead> = webService.listHomepageShopBannersApiV1AdminStorefrontHomeBannersGet(skip, limit, accessToken)
}
```

### Parameters
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;HomepageShopBannerAdminRead&gt;**](HomepageShopBannerAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Preview Campaign

Render draft content with normal product visibility. Bypasses only campaign publication/schedule.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val campaignId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CampaignRead = webService.previewCampaignApiV1AdminStorefrontCampaignsCampaignIdPreviewGet(campaignId, accessToken)
}
```

### Parameters
| **campaignId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CampaignRead**](CampaignRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Set Homepage Shop Banner Publication

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val bannerId : kotlin.Int = 56 // kotlin.Int | 
val homepageShopBannerPublication : HomepageShopBannerPublication =  // HomepageShopBannerPublication | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : HomepageShopBannerAdminRead = webService.setHomepageShopBannerPublicationApiV1AdminStorefrontHomeBannersBannerIdPublicationPatch(bannerId, homepageShopBannerPublication, accessToken)
}
```

### Parameters
| **bannerId** | **kotlin.Int**|  | |
| **homepageShopBannerPublication** | [**HomepageShopBannerPublication**](HomepageShopBannerPublication.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**HomepageShopBannerAdminRead**](HomepageShopBannerAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Campaign

Full replacement; send existing block/banner IDs to preserve them and expected_revision to prevent lost edits.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val campaignId : kotlin.Int = 56 // kotlin.Int | 
val campaignWrite : CampaignWrite =  // CampaignWrite | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CampaignAdminRead = webService.updateCampaignApiV1AdminStorefrontCampaignsCampaignIdPut(campaignId, campaignWrite, accessToken)
}
```

### Parameters
| **campaignId** | **kotlin.Int**|  | |
| **campaignWrite** | [**CampaignWrite**](CampaignWrite.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CampaignAdminRead**](CampaignAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Home

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val homeWrite : HomeWrite =  // HomeWrite | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : HomeWrite = webService.updateHomeApiV1AdminStorefrontHomePut(homeWrite, accessToken)
}
```

### Parameters
| **homeWrite** | [**HomeWrite**](HomeWrite.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**HomeWrite**](HomeWrite.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Homepage Shop Banner

Replace editable content and schedule while preserving publication state.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminStorefrontApi::class.java)
val bannerId : kotlin.Int = 56 // kotlin.Int | 
val homepageShopBannerWrite : HomepageShopBannerWrite =  // HomepageShopBannerWrite | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : HomepageShopBannerAdminRead = webService.updateHomepageShopBannerApiV1AdminStorefrontHomeBannersBannerIdPut(bannerId, homepageShopBannerWrite, accessToken)
}
```

### Parameters
| **bannerId** | **kotlin.Int**|  | |
| **homepageShopBannerWrite** | [**HomepageShopBannerWrite**](HomepageShopBannerWrite.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**HomepageShopBannerAdminRead**](HomepageShopBannerAdminRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

