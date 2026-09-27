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

A guest cart (cart_token cookie) is merged into the buyer&#39;s cart and the cookie cleared.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val loginRequest : LoginRequest =  // LoginRequest | 
val cartToken : kotlin.String = cartToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : TokenResponse = webService.loginApiV1AuthLoginPost(loginRequest, cartToken)
}
```

### Parameters
| **loginRequest** | [**LoginRequest**](LoginRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **cartToken** | **kotlin.String**|  | [optional] |

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

A guest cart (cart_token cookie) is merged into the new account&#39;s cart and the cookie cleared.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val registerRequest : RegisterRequest =  // RegisterRequest | 
val cartToken : kotlin.String = cartToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.registerApiV1AuthRegisterPost(registerRequest, cartToken)
}
```

### Parameters
| **registerRequest** | [**RegisterRequest**](RegisterRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **cartToken** | **kotlin.String**|  | [optional] |

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

