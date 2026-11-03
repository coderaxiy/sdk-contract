# AdminPhoneOtpsAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listPhoneOtpsApiV1AdminAuthPhoneOtpsGet**](AdminPhoneOtpsAPI.md#listphoneotpsapiv1adminauthphoneotpsget) | **GET** /api/v1/admin/auth/phone-otps | List Phone Otps
[**revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost**](AdminPhoneOtpsAPI.md#revealphoneotpapiv1adminauthphoneotpschallengeidrevealpost) | **POST** /api/v1/admin/auth/phone-otps/{challenge_id}/reveal | Reveal Phone Otp


# **listPhoneOtpsApiV1AdminAuthPhoneOtpsGet**
```swift
    open class func listPhoneOtpsApiV1AdminAuthPhoneOtpsGet(skip: Int? = nil, limit: Int? = nil, phone: String? = nil, accessToken: String? = nil, completion: @escaping (_ data: [AdminOtpRead]?, _ error: Error?) -> Void)
```

List Phone Otps

Pending phone signup/recovery requests; no codes in list responses. Needs auth:otp:read.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let phone = "phone_example" // String |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Phone Otps
AdminPhoneOtpsAPI.listPhoneOtpsApiV1AdminAuthPhoneOtpsGet(skip: skip, limit: limit, phone: phone, accessToken: accessToken) { (response, error) in
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
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **phone** | **String** |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[AdminOtpRead]**](AdminOtpRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost**
```swift
    open class func revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost(challengeId: UUID, otpRevealRequest: OtpRevealRequest, accessToken: String? = nil, completion: @escaping (_ data: OtpRevealRead?, _ error: Error?) -> Void)
```

Reveal Phone Otp

Audited code reveal for a staff callback to the submitted number. Does not verify the account.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let challengeId = 987 // UUID | 
let otpRevealRequest = OtpRevealRequest(reason: "reason_example") // OtpRevealRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Reveal Phone Otp
AdminPhoneOtpsAPI.revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost(challengeId: challengeId, otpRevealRequest: otpRevealRequest, accessToken: accessToken) { (response, error) in
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
 **challengeId** | **UUID** |  | 
 **otpRevealRequest** | [**OtpRevealRequest**](OtpRevealRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**OtpRevealRead**](OtpRevealRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

