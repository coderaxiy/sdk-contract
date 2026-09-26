# AuthApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getMeApiV1AuthMeGet**](AuthApi.md#getMeApiV1AuthMeGet) | **GET** api/v1/auth/me | Get Me |
| [**loginApiV1AuthLoginPost**](AuthApi.md#loginApiV1AuthLoginPost) | **POST** api/v1/auth/login | Login |
| [**logoutApiV1AuthLogoutPost**](AuthApi.md#logoutApiV1AuthLogoutPost) | **POST** api/v1/auth/logout | Logout |
| [**registerApiV1AuthRegisterPost**](AuthApi.md#registerApiV1AuthRegisterPost) | **POST** api/v1/auth/register | Register |



Get Me

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.getMeApiV1AuthMeGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Login

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val loginRequest : LoginRequest =  // LoginRequest | 

launch(Dispatchers.IO) {
    val result : TokenResponse = webService.loginApiV1AuthLoginPost(loginRequest)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **loginRequest** | [**LoginRequest**](LoginRequest.md)|  | |

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Logout

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.Any = webService.logoutApiV1AuthLogoutPost()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Register

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val registerRequest : RegisterRequest =  // RegisterRequest | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.registerApiV1AuthRegisterPost(registerRequest)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **registerRequest** | [**RegisterRequest**](RegisterRequest.md)|  | |

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

