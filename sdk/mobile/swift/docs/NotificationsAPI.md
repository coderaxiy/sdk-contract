# NotificationsAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**registerDeviceApiV1DevicesPut**](NotificationsAPI.md#registerdeviceapiv1devicesput) | **PUT** /api/v1/devices | Register Device
[**unregisterDeviceApiV1DevicesDelete**](NotificationsAPI.md#unregisterdeviceapiv1devicesdelete) | **DELETE** /api/v1/devices | Unregister Device


# **registerDeviceApiV1DevicesPut**
```swift
    open class func registerDeviceApiV1DevicesPut(deviceRegisterRequest: DeviceRegisterRequest, accessToken: String? = nil, completion: @escaping (_ data: DeviceRead?, _ error: Error?) -> Void)
```

Register Device

Register (or refresh) this phone's push token for the logged-in user. Call it after login and whenever the token or the app language changes. A token already registered to another account moves to this one.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let deviceRegisterRequest = DeviceRegisterRequest(token: "token_example", platform: DevicePlatform(), locale: "locale_example") // DeviceRegisterRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Register Device
NotificationsAPI.registerDeviceApiV1DevicesPut(deviceRegisterRequest: deviceRegisterRequest, accessToken: accessToken) { (response, error) in
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
 **deviceRegisterRequest** | [**DeviceRegisterRequest**](DeviceRegisterRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**DeviceRead**](DeviceRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **unregisterDeviceApiV1DevicesDelete**
```swift
    open class func unregisterDeviceApiV1DevicesDelete(token: String, accessToken: String? = nil, completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

Unregister Device

Stop pushes to this phone for the logged-in user. Call it **before** `POST /auth/logout`. Unknown tokens, and tokens of another user, are ignored (`204` either way).

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let token = "token_example" // String | 
let accessToken = "accessToken_example" // String |  (optional)

// Unregister Device
NotificationsAPI.unregisterDeviceApiV1DevicesDelete(token: token, accessToken: accessToken) { (response, error) in
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
 **token** | **String** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

Void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

