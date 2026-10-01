# AuthAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**changeMyPasswordApiV1AuthMePasswordPost**](AuthAPI.md#changemypasswordapiv1authmepasswordpost) | **POST** /api/v1/auth/me/password | Change My Password
[**confirmPasswordResetApiV1AuthPasswordResetConfirmPost**](AuthAPI.md#confirmpasswordresetapiv1authpasswordresetconfirmpost) | **POST** /api/v1/auth/password-reset/confirm | Confirm Password Reset
[**getMeApiV1AuthMeGet**](AuthAPI.md#getmeapiv1authmeget) | **GET** /api/v1/auth/me | Get Me
[**loginApiV1AuthLoginPost**](AuthAPI.md#loginapiv1authloginpost) | **POST** /api/v1/auth/login | Login
[**logoutApiV1AuthLogoutPost**](AuthAPI.md#logoutapiv1authlogoutpost) | **POST** /api/v1/auth/logout | Logout
[**registerApiV1AuthRegisterPost**](AuthAPI.md#registerapiv1authregisterpost) | **POST** /api/v1/auth/register | Register
[**requestPasswordResetApiV1AuthPasswordResetRequestPost**](AuthAPI.md#requestpasswordresetapiv1authpasswordresetrequestpost) | **POST** /api/v1/auth/password-reset/request | Request Password Reset
[**updateMeApiV1AuthMePatch**](AuthAPI.md#updatemeapiv1authmepatch) | **PATCH** /api/v1/auth/me | Update Me


# **changeMyPasswordApiV1AuthMePasswordPost**
```swift
    open class func changeMyPasswordApiV1AuthMePasswordPost(changePasswordRequest: ChangePasswordRequest, accessToken: String? = nil, completion: @escaping (_ data: TokenResponse?, _ error: Error?) -> Void)
```

Change My Password

Needs the current password (`400` if wrong). Every other session is signed out; this one gets a fresh `access_token` cookie in the response.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let changePasswordRequest = ChangePasswordRequest(currentPassword: "currentPassword_example", newPassword: "newPassword_example") // ChangePasswordRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Change My Password
AuthAPI.changeMyPasswordApiV1AuthMePasswordPost(changePasswordRequest: changePasswordRequest, accessToken: accessToken) { (response, error) in
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
 **changePasswordRequest** | [**ChangePasswordRequest**](ChangePasswordRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **confirmPasswordResetApiV1AuthPasswordResetConfirmPost**
```swift
    open class func confirmPasswordResetApiV1AuthPasswordResetConfirmPost(passwordResetConfirm: PasswordResetConfirm, completion: @escaping (_ data: MessageResponse?, _ error: Error?) -> Void)
```

Confirm Password Reset

Public. Sets a new password from the emailed code and signs out every session; the user then logs in normally. `400 \"Invalid or expired code\"` covers a wrong, expired or used code, and a code that was guessed wrong too many times.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let passwordResetConfirm = PasswordResetConfirm(email: "email_example", code: "code_example", newPassword: "newPassword_example") // PasswordResetConfirm | 

// Confirm Password Reset
AuthAPI.confirmPasswordResetApiV1AuthPasswordResetConfirmPost(passwordResetConfirm: passwordResetConfirm) { (response, error) in
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
 **passwordResetConfirm** | [**PasswordResetConfirm**](PasswordResetConfirm.md) |  | 

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getMeApiV1AuthMeGet**
```swift
    open class func getMeApiV1AuthMeGet(accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Get Me

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// Get Me
AuthAPI.getMeApiV1AuthMeGet(accessToken: accessToken) { (response, error) in
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
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **loginApiV1AuthLoginPost**
```swift
    open class func loginApiV1AuthLoginPost(loginRequest: LoginRequest, cartToken: String? = nil, completion: @escaping (_ data: TokenResponse?, _ error: Error?) -> Void)
```

Login

A guest cart (cart_token cookie) is merged into the buyer's cart and the cookie cleared.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let loginRequest = LoginRequest(email: "email_example", password: "password_example") // LoginRequest | 
let cartToken = "cartToken_example" // String |  (optional)

// Login
AuthAPI.loginApiV1AuthLoginPost(loginRequest: loginRequest, cartToken: cartToken) { (response, error) in
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
 **loginRequest** | [**LoginRequest**](LoginRequest.md) |  | 
 **cartToken** | **String** |  | [optional] 

### Return type

[**TokenResponse**](TokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **logoutApiV1AuthLogoutPost**
```swift
    open class func logoutApiV1AuthLogoutPost(completion: @escaping (_ data: JSONValue?, _ error: Error?) -> Void)
```

Logout

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK


// Logout
AuthAPI.logoutApiV1AuthLogoutPost() { (response, error) in
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
This endpoint does not need any parameter.

### Return type

**JSONValue**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **registerApiV1AuthRegisterPost**
```swift
    open class func registerApiV1AuthRegisterPost(registerRequest: RegisterRequest, cartToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Register

A guest cart (cart_token cookie) is merged into the new account's cart and the cookie cleared.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let registerRequest = RegisterRequest(email: "email_example", password: "password_example", fullName: "fullName_example") // RegisterRequest | 
let cartToken = "cartToken_example" // String |  (optional)

// Register
AuthAPI.registerApiV1AuthRegisterPost(registerRequest: registerRequest, cartToken: cartToken) { (response, error) in
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
 **registerRequest** | [**RegisterRequest**](RegisterRequest.md) |  | 
 **cartToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **requestPasswordResetApiV1AuthPasswordResetRequestPost**
```swift
    open class func requestPasswordResetApiV1AuthPasswordResetRequestPost(passwordResetRequest: PasswordResetRequest, completion: @escaping (_ data: MessageResponse?, _ error: Error?) -> Void)
```

Request Password Reset

Public. Emails a 6-digit code valid for 15 minutes. The response is identical whether or not the account exists, so it can't be used to find out who is registered.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let passwordResetRequest = PasswordResetRequest(email: "email_example") // PasswordResetRequest | 

// Request Password Reset
AuthAPI.requestPasswordResetApiV1AuthPasswordResetRequestPost(passwordResetRequest: passwordResetRequest) { (response, error) in
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
 **passwordResetRequest** | [**PasswordResetRequest**](PasswordResetRequest.md) |  | 

### Return type

[**MessageResponse**](MessageResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateMeApiV1AuthMePatch**
```swift
    open class func updateMeApiV1AuthMePatch(updateProfileRequest: UpdateProfileRequest, accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Update Me

Edit my name or saved phone. Email can't be changed here.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let updateProfileRequest = UpdateProfileRequest(fullName: "fullName_example", phone: "phone_example") // UpdateProfileRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Me
AuthAPI.updateMeApiV1AuthMePatch(updateProfileRequest: updateProfileRequest, accessToken: accessToken) { (response, error) in
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
 **updateProfileRequest** | [**UpdateProfileRequest**](UpdateProfileRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

