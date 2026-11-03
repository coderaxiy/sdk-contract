# PhoneAuthAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**confirmPhoneRecoveryApiV1AuthPhonePasswordResetConfirmPost**](PhoneAuthAPI.md#confirmphonerecoveryapiv1authphonepasswordresetconfirmpost) | **POST** /api/v1/auth/phone/password-reset/confirm | Confirm Phone Recovery
[**confirmPhoneSignupApiV1AuthPhoneRegisterConfirmPost**](PhoneAuthAPI.md#confirmphonesignupapiv1authphoneregisterconfirmpost) | **POST** /api/v1/auth/phone/register/confirm | Confirm Phone Signup
[**confirmProfileEmailApiV1AuthMeEmailConfirmPost**](PhoneAuthAPI.md#confirmprofileemailapiv1authmeemailconfirmpost) | **POST** /api/v1/auth/me/email/confirm | Confirm Profile Email
[**listPhoneOtpsApiV1AdminAuthPhoneOtpsGet**](PhoneAuthAPI.md#listphoneotpsapiv1adminauthphoneotpsget) | **GET** /api/v1/admin/auth/phone-otps | List Phone Otps
[**requestPhoneRecoveryApiV1AuthPhonePasswordResetRequestPost**](PhoneAuthAPI.md#requestphonerecoveryapiv1authphonepasswordresetrequestpost) | **POST** /api/v1/auth/phone/password-reset/request | Request Phone Recovery
[**requestPhoneSignupApiV1AuthPhoneRegisterRequestPost**](PhoneAuthAPI.md#requestphonesignupapiv1authphoneregisterrequestpost) | **POST** /api/v1/auth/phone/register/request | Request Phone Signup
[**requestProfileEmailApiV1AuthMeEmailRequestPost**](PhoneAuthAPI.md#requestprofileemailapiv1authmeemailrequestpost) | **POST** /api/v1/auth/me/email/request | Request Profile Email
[**revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost**](PhoneAuthAPI.md#revealphoneotpapiv1adminauthphoneotpschallengeidrevealpost) | **POST** /api/v1/admin/auth/phone-otps/{challenge_id}/reveal | Reveal Phone Otp


# **confirmPhoneRecoveryApiV1AuthPhonePasswordResetConfirmPost**
```swift
    open class func confirmPhoneRecoveryApiV1AuthPhonePasswordResetConfirmPost(phoneRecoveryConfirm: PhoneRecoveryConfirm, completion: @escaping (_ data: MessageResponse?, _ error: Error?) -> Void)
```

Confirm Phone Recovery

password is the new password. Consumes the OTP and invalidates all sessions; login separately.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let phoneRecoveryConfirm = PhoneRecoveryConfirm(password: "password_example", challengeId: 123, code: "code_example") // PhoneRecoveryConfirm | 

// Confirm Phone Recovery
PhoneAuthAPI.confirmPhoneRecoveryApiV1AuthPhonePasswordResetConfirmPost(phoneRecoveryConfirm: phoneRecoveryConfirm) { (response, error) in
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
 **phoneRecoveryConfirm** | [**PhoneRecoveryConfirm**](PhoneRecoveryConfirm.md) |  | 

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **confirmPhoneSignupApiV1AuthPhoneRegisterConfirmPost**
```swift
    open class func confirmPhoneSignupApiV1AuthPhoneRegisterConfirmPost(otpConfirm: OtpConfirm, cartToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Confirm Phone Signup

Creates a phone-only buyer after verification. Merges guest cart; login is a separate step.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let otpConfirm = OtpConfirm(challengeId: 123, code: "code_example") // OtpConfirm | 
let cartToken = "cartToken_example" // String |  (optional)

// Confirm Phone Signup
PhoneAuthAPI.confirmPhoneSignupApiV1AuthPhoneRegisterConfirmPost(otpConfirm: otpConfirm, cartToken: cartToken) { (response, error) in
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
 **otpConfirm** | [**OtpConfirm**](OtpConfirm.md) |  | 
 **cartToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **confirmProfileEmailApiV1AuthMeEmailConfirmPost**
```swift
    open class func confirmProfileEmailApiV1AuthMeEmailConfirmPost(otpConfirm: OtpConfirm, accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Confirm Profile Email

Attach the verified email. Replacement/removal are not supported by self-service.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let otpConfirm = OtpConfirm(challengeId: 123, code: "code_example") // OtpConfirm | 
let accessToken = "accessToken_example" // String |  (optional)

// Confirm Profile Email
PhoneAuthAPI.confirmProfileEmailApiV1AuthMeEmailConfirmPost(otpConfirm: otpConfirm, accessToken: accessToken) { (response, error) in
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
 **otpConfirm** | [**OtpConfirm**](OtpConfirm.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

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
PhoneAuthAPI.listPhoneOtpsApiV1AdminAuthPhoneOtpsGet(skip: skip, limit: limit, phone: phone, accessToken: accessToken) { (response, error) in
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

# **requestPhoneRecoveryApiV1AuthPhonePasswordResetRequestPost**
```swift
    open class func requestPhoneRecoveryApiV1AuthPhonePasswordResetRequestPost(phoneRequest: PhoneRequest, completion: @escaping (_ data: OtpChallengeRead?, _ error: Error?) -> Void)
```

Request Phone Recovery

Same response for known/unknown numbers. Only active verified-phone accounts reach the staff inbox.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let phoneRequest = PhoneRequest(phone: "phone_example") // PhoneRequest | 

// Request Phone Recovery
PhoneAuthAPI.requestPhoneRecoveryApiV1AuthPhonePasswordResetRequestPost(phoneRequest: phoneRequest) { (response, error) in
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
 **phoneRequest** | [**PhoneRequest**](PhoneRequest.md) |  | 

### Return type

[**OtpChallengeRead**](OtpChallengeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **requestPhoneSignupApiV1AuthPhoneRegisterRequestPost**
```swift
    open class func requestPhoneSignupApiV1AuthPhoneRegisterRequestPost(phoneSignupRequest: PhoneSignupRequest, completion: @escaping (_ data: OtpChallengeRead?, _ error: Error?) -> Void)
```

Request Phone Signup

Begin phone/password signup. Staff call the number and relay the OTP; no SMS is sent.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let phoneSignupRequest = PhoneSignupRequest(password: "password_example", phone: "phone_example", fullName: "fullName_example") // PhoneSignupRequest | 

// Request Phone Signup
PhoneAuthAPI.requestPhoneSignupApiV1AuthPhoneRegisterRequestPost(phoneSignupRequest: phoneSignupRequest) { (response, error) in
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
 **phoneSignupRequest** | [**PhoneSignupRequest**](PhoneSignupRequest.md) |  | 

### Return type

[**OtpChallengeRead**](OtpChallengeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **requestProfileEmailApiV1AuthMeEmailRequestPost**
```swift
    open class func requestProfileEmailApiV1AuthMeEmailRequestPost(emailAdditionRequest: EmailAdditionRequest, accessToken: String? = nil, completion: @escaping (_ data: OtpChallengeRead?, _ error: Error?) -> Void)
```

Request Profile Email

Add an email to a phone-only account. Remains pending until the emailed code is confirmed.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let emailAdditionRequest = EmailAdditionRequest(email: "email_example") // EmailAdditionRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Request Profile Email
PhoneAuthAPI.requestProfileEmailApiV1AuthMeEmailRequestPost(emailAdditionRequest: emailAdditionRequest, accessToken: accessToken) { (response, error) in
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
 **emailAdditionRequest** | [**EmailAdditionRequest**](EmailAdditionRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**OtpChallengeRead**](OtpChallengeRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
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
PhoneAuthAPI.revealPhoneOtpApiV1AdminAuthPhoneOtpsChallengeIdRevealPost(challengeId: challengeId, otpRevealRequest: otpRevealRequest, accessToken: accessToken) { (response, error) in
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

