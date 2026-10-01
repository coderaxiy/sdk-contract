# NotificationsApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**registerDeviceApiV1DevicesPut**](NotificationsApi.md#registerDeviceApiV1DevicesPut) | **PUT** api/v1/devices | Register Device |
| [**unregisterDeviceApiV1DevicesDelete**](NotificationsApi.md#unregisterDeviceApiV1DevicesDelete) | **DELETE** api/v1/devices | Unregister Device |



Register Device

Register (or refresh) this phone&#39;s push token for the logged-in user. Call it after login and whenever the token or the app language changes. A token already registered to another account moves to this one.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(NotificationsApi::class.java)
val deviceRegisterRequest : DeviceRegisterRequest =  // DeviceRegisterRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : DeviceRead = webService.registerDeviceApiV1DevicesPut(deviceRegisterRequest, accessToken)
}
```

### Parameters
| **deviceRegisterRequest** | [**DeviceRegisterRequest**](DeviceRegisterRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**DeviceRead**](DeviceRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Unregister Device

Stop pushes to this phone for the logged-in user. Call it **before** &#x60;POST /auth/logout&#x60;. Unknown tokens, and tokens of another user, are ignored (&#x60;204&#x60; either way).

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(NotificationsApi::class.java)
val token : kotlin.String = token_example // kotlin.String | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.unregisterDeviceApiV1DevicesDelete(token, accessToken)
}
```

### Parameters
| **token** | **kotlin.String**|  | |
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

