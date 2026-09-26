# AuthAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMeApiV1AuthMeGet**](AuthAPI.md#getmeapiv1authmeget) | **GET** /api/v1/auth/me | Get Me
[**loginApiV1AuthLoginPost**](AuthAPI.md#loginapiv1authloginpost) | **POST** /api/v1/auth/login | Login
[**logoutApiV1AuthLogoutPost**](AuthAPI.md#logoutapiv1authlogoutpost) | **POST** /api/v1/auth/logout | Logout
[**registerApiV1AuthRegisterPost**](AuthAPI.md#registerapiv1authregisterpost) | **POST** /api/v1/auth/register | Register


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
    open class func loginApiV1AuthLoginPost(loginRequest: LoginRequest, completion: @escaping (_ data: TokenResponse?, _ error: Error?) -> Void)
```

Login

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let loginRequest = LoginRequest(email: "email_example", password: "password_example") // LoginRequest | 

// Login
AuthAPI.loginApiV1AuthLoginPost(loginRequest: loginRequest) { (response, error) in
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
    open class func registerApiV1AuthRegisterPost(registerRequest: RegisterRequest, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Register

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let registerRequest = RegisterRequest(email: "email_example", password: "password_example", fullName: "fullName_example") // RegisterRequest | 

// Register
AuthAPI.registerApiV1AuthRegisterPost(registerRequest: registerRequest) { (response, error) in
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

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

