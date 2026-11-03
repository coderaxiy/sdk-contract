# AdminPhoneOtpsApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**listPhoneOtpsApiV1AdminAuthPhoneOtpsGet**](AdminPhoneOtpsApi.md#listPhoneOtpsApiV1AdminAuthPhoneOtpsGet) | **GET** api/v1/admin/auth/phone-otps | List Phone Otps |
| [**revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost**](AdminPhoneOtpsApi.md#revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost) | **POST** api/v1/admin/auth/phone-otps/{challenge_id}/reveal | Reveal Phone Otp |



List Phone Otps

Pending phone signup/recovery requests; no codes in list responses. Needs auth:otp:read.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminPhoneOtpsApi::class.java)
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


Reveal Phone Otp

Audited code reveal for a staff callback to the submitted number. Does not verify the account.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(AdminPhoneOtpsApi::class.java)
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

