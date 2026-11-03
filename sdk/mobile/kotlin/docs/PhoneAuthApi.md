# PhoneAuthApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**confirmPhoneRecoveryApiV1AuthPhonePasswordResetConfirmPost**](PhoneAuthApi.md#confirmPhoneRecoveryApiV1AuthPhonePasswordResetConfirmPost) | **POST** api/v1/auth/phone/password-reset/confirm | Confirm Phone Recovery |
| [**confirmPhoneSignupApiV1AuthPhoneRegisterConfirmPost**](PhoneAuthApi.md#confirmPhoneSignupApiV1AuthPhoneRegisterConfirmPost) | **POST** api/v1/auth/phone/register/confirm | Confirm Phone Signup |
| [**confirmProfileEmailApiV1AuthMeEmailConfirmPost**](PhoneAuthApi.md#confirmProfileEmailApiV1AuthMeEmailConfirmPost) | **POST** api/v1/auth/me/email/confirm | Confirm Profile Email |
| [**listPhoneOtpsApiV1AdminAuthPhoneOtpsGet**](PhoneAuthApi.md#listPhoneOtpsApiV1AdminAuthPhoneOtpsGet) | **GET** api/v1/admin/auth/phone-otps | List Phone Otps |
| [**requestPhoneRecoveryApiV1AuthPhonePasswordResetRequestPost**](PhoneAuthApi.md#requestPhoneRecoveryApiV1AuthPhonePasswordResetRequestPost) | **POST** api/v1/auth/phone/password-reset/request | Request Phone Recovery |
| [**requestPhoneSignupApiV1AuthPhoneRegisterRequestPost**](PhoneAuthApi.md#requestPhoneSignupApiV1AuthPhoneRegisterRequestPost) | **POST** api/v1/auth/phone/register/request | Request Phone Signup |
| [**requestProfileEmailApiV1AuthMeEmailRequestPost**](PhoneAuthApi.md#requestProfileEmailApiV1AuthMeEmailRequestPost) | **POST** api/v1/auth/me/email/request | Request Profile Email |
| [**revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost**](PhoneAuthApi.md#revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost) | **POST** api/v1/admin/auth/phone-otps/{challenge_id}/reveal | Reveal Phone Otp |



Confirm Phone Recovery

password is the new password. Consumes the OTP and invalidates all sessions; login separately.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PhoneAuthApi::class.java)
val phoneRecoveryConfirm : PhoneRecoveryConfirm =  // PhoneRecoveryConfirm | 

launch(Dispatchers.IO) {
    val result : MessageResponse = webService.confirmPhoneRecoveryApiV1AuthPhonePasswordResetConfirmPost(phoneRecoveryConfirm)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **phoneRecoveryConfirm** | [**PhoneRecoveryConfirm**](PhoneRecoveryConfirm.md)|  | |

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Confirm Phone Signup

Creates a phone-only buyer after verification. Merges guest cart; login is a separate step.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PhoneAuthApi::class.java)
val otpConfirm : OtpConfirm =  // OtpConfirm | 
val cartToken : kotlin.String = cartToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.confirmPhoneSignupApiV1AuthPhoneRegisterConfirmPost(otpConfirm, cartToken)
}
```

### Parameters
| **otpConfirm** | [**OtpConfirm**](OtpConfirm.md)|  | |
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


Confirm Profile Email

Attach the verified email. Replacement/removal are not supported by self-service.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PhoneAuthApi::class.java)
val otpConfirm : OtpConfirm =  // OtpConfirm | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.confirmProfileEmailApiV1AuthMeEmailConfirmPost(otpConfirm, accessToken)
}
```

### Parameters
| **otpConfirm** | [**OtpConfirm**](OtpConfirm.md)|  | |
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


List Phone Otps

Pending phone signup/recovery requests; no codes in list responses. Needs auth:otp:read.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PhoneAuthApi::class.java)
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val phone : kotlin.String = phone_example // kotlin.String | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<AdminOtpRead> = webService.listPhoneOtpsApiV1AdminAuthPhoneOtpsGet(skip, limit, phone, accessToken)
}
```

### Parameters
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| **phone** | **kotlin.String**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;AdminOtpRead&gt;**](AdminOtpRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Request Phone Recovery

Same response for known/unknown numbers. Only active verified-phone accounts reach the staff inbox.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PhoneAuthApi::class.java)
val phoneRequest : PhoneRequest =  // PhoneRequest | 

launch(Dispatchers.IO) {
    val result : OtpChallengeRead = webService.requestPhoneRecoveryApiV1AuthPhonePasswordResetRequestPost(phoneRequest)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **phoneRequest** | [**PhoneRequest**](PhoneRequest.md)|  | |

### Return type

[**OtpChallengeRead**](OtpChallengeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Request Phone Signup

Begin phone/password signup. Staff call the number and relay the OTP; no SMS is sent.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PhoneAuthApi::class.java)
val phoneSignupRequest : PhoneSignupRequest =  // PhoneSignupRequest | 

launch(Dispatchers.IO) {
    val result : OtpChallengeRead = webService.requestPhoneSignupApiV1AuthPhoneRegisterRequestPost(phoneSignupRequest)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **phoneSignupRequest** | [**PhoneSignupRequest**](PhoneSignupRequest.md)|  | |

### Return type

[**OtpChallengeRead**](OtpChallengeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Request Profile Email

Add an email to a phone-only account. Remains pending until the emailed code is confirmed.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PhoneAuthApi::class.java)
val emailAdditionRequest : EmailAdditionRequest =  // EmailAdditionRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : OtpChallengeRead = webService.requestProfileEmailApiV1AuthMeEmailRequestPost(emailAdditionRequest, accessToken)
}
```

### Parameters
| **emailAdditionRequest** | [**EmailAdditionRequest**](EmailAdditionRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**OtpChallengeRead**](OtpChallengeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Reveal Phone Otp

Audited code reveal for a staff callback to the submitted number. Does not verify the account.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(PhoneAuthApi::class.java)
val challengeId : java.util.UUID = 38400000-8cf0-11bd-b23e-10b96e4ef00d // java.util.UUID | 
val otpRevealRequest : OtpRevealRequest =  // OtpRevealRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : OtpRevealRead = webService.revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost(challengeId, otpRevealRequest, accessToken)
}
```

### Parameters
| **challengeId** | **java.util.UUID**|  | |
| **otpRevealRequest** | [**OtpRevealRequest**](OtpRevealRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**OtpRevealRead**](OtpRevealRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

