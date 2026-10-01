# UploadsApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**createUploadApiV1UploadsPost**](UploadsApi.md#createUploadApiV1UploadsPost) | **POST** api/v1/uploads | Create Upload |



Create Upload

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UploadsApi::class.java)
val purpose : UploadPurpose =  // UploadPurpose | 
val file : java.io.File = BINARY_DATA_HERE // java.io.File | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UploadRead = webService.createUploadApiV1UploadsPost(purpose, file, accessToken)
}
```

### Parameters
| **purpose** | [**UploadPurpose**](.md)|  | [enum: shop_logo, shop_banner, product_image, seller_document, refund_evidence] |
| **file** | **java.io.File**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**UploadRead**](UploadRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

