# AuthApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**changeMyPasswordApiV1AuthMePasswordPost**](AuthApi.md#changeMyPasswordApiV1AuthMePasswordPost) | **POST** api/v1/auth/me/password | Change My Password |
| [**confirmPasswordResetApiV1AuthPasswordResetConfirmPost**](AuthApi.md#confirmPasswordResetApiV1AuthPasswordResetConfirmPost) | **POST** api/v1/auth/password-reset/confirm | Confirm Password Reset |
| [**getMeApiV1AuthMeGet**](AuthApi.md#getMeApiV1AuthMeGet) | **GET** api/v1/auth/me | Get Me |
| [**loginApiV1AuthLoginPost**](AuthApi.md#loginApiV1AuthLoginPost) | **POST** api/v1/auth/login | Login |
| [**logoutApiV1AuthLogoutPost**](AuthApi.md#logoutApiV1AuthLogoutPost) | **POST** api/v1/auth/logout | Logout |
| [**registerApiV1AuthRegisterPost**](AuthApi.md#registerApiV1AuthRegisterPost) | **POST** api/v1/auth/register | Register |
| [**requestPasswordResetApiV1AuthPasswordResetRequestPost**](AuthApi.md#requestPasswordResetApiV1AuthPasswordResetRequestPost) | **POST** api/v1/auth/password-reset/request | Request Password Reset |
| [**updateMeApiV1AuthMePatch**](AuthApi.md#updateMeApiV1AuthMePatch) | **PATCH** api/v1/auth/me | Update Me |



Change My Password

Needs the current password (&#x60;400&#x60; if wrong). Every other session is signed out; this one gets a fresh &#x60;access_token&#x60; cookie in the response.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val changePasswordRequest : ChangePasswordRequest =  // ChangePasswordRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : TokenResponse = webService.changeMyPasswordApiV1AuthMePasswordPost(changePasswordRequest, accessToken)
}
```

### Parameters
| **changePasswordRequest** | [**ChangePasswordRequest**](ChangePasswordRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Confirm Password Reset

Public. Sets a new password from the emailed code and signs out every session; the user then logs in normally. &#x60;400 \&quot;Invalid or expired code\&quot;&#x60; covers a wrong, expired or used code, and a code that was guessed wrong too many times.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val passwordResetConfirm : PasswordResetConfirm =  // PasswordResetConfirm | 

launch(Dispatchers.IO) {
    val result : MessageResponse = webService.confirmPasswordResetApiV1AuthPasswordResetConfirmPost(passwordResetConfirm)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **passwordResetConfirm** | [**PasswordResetConfirm**](PasswordResetConfirm.md)|  | |

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


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


Request Password Reset

Public. Emails a 6-digit code valid for 15 minutes. The response is identical whether or not the account exists, so it can&#39;t be used to find out who is registered.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val passwordResetRequest : PasswordResetRequest =  // PasswordResetRequest | 

launch(Dispatchers.IO) {
    val result : MessageResponse = webService.requestPasswordResetApiV1AuthPasswordResetRequestPost(passwordResetRequest)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **passwordResetRequest** | [**PasswordResetRequest**](PasswordResetRequest.md)|  | |

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Me

Edit my name or saved phone. Email can&#39;t be changed here.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AuthApi::class.java)
val updateProfileRequest : UpdateProfileRequest =  // UpdateProfileRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.updateMeApiV1AuthMePatch(updateProfileRequest, accessToken)
}
```

### Parameters
| **updateProfileRequest** | [**UpdateProfileRequest**](UpdateProfileRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

