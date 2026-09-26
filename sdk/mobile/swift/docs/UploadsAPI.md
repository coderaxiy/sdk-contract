# UploadsAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUploadApiV1UploadsPost**](UploadsAPI.md#createuploadapiv1uploadspost) | **POST** /api/v1/uploads | Create Upload


# **createUploadApiV1UploadsPost**
```swift
    open class func createUploadApiV1UploadsPost(purpose: UploadPurpose, file: URL, accessToken: String? = nil, completion: @escaping (_ data: UploadRead?, _ error: Error?) -> Void)
```

Create Upload

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let purpose = UploadPurpose() // UploadPurpose | 
let file = URL(string: "https://example.com")! // URL | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Upload
UploadsAPI.createUploadApiV1UploadsPost(purpose: purpose, file: file, accessToken: accessToken) { (response, error) in
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
 **purpose** | [**UploadPurpose**](.md) |  | 
 **file** | **URL** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UploadRead**](UploadRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

