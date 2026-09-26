# UsersAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**adminCreateUserApiV1UsersPost**](UsersAPI.md#admincreateuserapiv1userspost) | **POST** /api/v1/users/ | Admin Create User
[**assignRoleToUserApiV1UsersUserIdRolesPost**](UsersAPI.md#assignroletouserapiv1usersuseridrolespost) | **POST** /api/v1/users/{user_id}/roles | Assign Role To User
[**deactivateUserApiV1UsersUserIdDeactivatePost**](UsersAPI.md#deactivateuserapiv1usersuseriddeactivatepost) | **POST** /api/v1/users/{user_id}/deactivate | Deactivate User
[**getUserApiV1UsersUserIdGet**](UsersAPI.md#getuserapiv1usersuseridget) | **GET** /api/v1/users/{user_id} | Get User
[**getUserRolesApiV1UsersUserIdRolesGet**](UsersAPI.md#getuserrolesapiv1usersuseridrolesget) | **GET** /api/v1/users/{user_id}/roles | Get User Roles
[**listUsersApiV1UsersGet**](UsersAPI.md#listusersapiv1usersget) | **GET** /api/v1/users/ | List Users
[**reactivateUserApiV1UsersUserIdReactivatePost**](UsersAPI.md#reactivateuserapiv1usersuseridreactivatepost) | **POST** /api/v1/users/{user_id}/reactivate | Reactivate User
[**removeRoleFromUserApiV1UsersUserIdRolesRoleIdDelete**](UsersAPI.md#removerolefromuserapiv1usersuseridrolesroleiddelete) | **DELETE** /api/v1/users/{user_id}/roles/{role_id} | Remove Role From User
[**setUserPasswordApiV1UsersUserIdPasswordPost**](UsersAPI.md#setuserpasswordapiv1usersuseridpasswordpost) | **POST** /api/v1/users/{user_id}/password | Set User Password
[**updateUserApiV1UsersUserIdPatch**](UsersAPI.md#updateuserapiv1usersuseridpatch) | **PATCH** /api/v1/users/{user_id} | Update User


# **adminCreateUserApiV1UsersPost**
```swift
    open class func adminCreateUserApiV1UsersPost(userAdminCreate: UserAdminCreate, accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Admin Create User

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userAdminCreate = UserAdminCreate(email: "email_example", fullName: "fullName_example", password: "password_example") // UserAdminCreate | 
let accessToken = "accessToken_example" // String |  (optional)

// Admin Create User
UsersAPI.adminCreateUserApiV1UsersPost(userAdminCreate: userAdminCreate, accessToken: accessToken) { (response, error) in
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
 **userAdminCreate** | [**UserAdminCreate**](UserAdminCreate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **assignRoleToUserApiV1UsersUserIdRolesPost**
```swift
    open class func assignRoleToUserApiV1UsersUserIdRolesPost(userId: Int, assignRoleRequest: AssignRoleRequest, accessToken: String? = nil, completion: @escaping (_ data: [RoleRead]?, _ error: Error?) -> Void)
```

Assign Role To User

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userId = 987 // Int | 
let assignRoleRequest = AssignRoleRequest(roleId: 123) // AssignRoleRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Assign Role To User
UsersAPI.assignRoleToUserApiV1UsersUserIdRolesPost(userId: userId, assignRoleRequest: assignRoleRequest, accessToken: accessToken) { (response, error) in
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
 **userId** | **Int** |  | 
 **assignRoleRequest** | [**AssignRoleRequest**](AssignRoleRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[RoleRead]**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deactivateUserApiV1UsersUserIdDeactivatePost**
```swift
    open class func deactivateUserApiV1UsersUserIdDeactivatePost(userId: Int, accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Deactivate User

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Deactivate User
UsersAPI.deactivateUserApiV1UsersUserIdDeactivatePost(userId: userId, accessToken: accessToken) { (response, error) in
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
 **userId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getUserApiV1UsersUserIdGet**
```swift
    open class func getUserApiV1UsersUserIdGet(userId: Int, accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Get User

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get User
UsersAPI.getUserApiV1UsersUserIdGet(userId: userId, accessToken: accessToken) { (response, error) in
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
 **userId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getUserRolesApiV1UsersUserIdRolesGet**
```swift
    open class func getUserRolesApiV1UsersUserIdRolesGet(userId: Int, accessToken: String? = nil, completion: @escaping (_ data: [RoleRead]?, _ error: Error?) -> Void)
```

Get User Roles

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get User Roles
UsersAPI.getUserRolesApiV1UsersUserIdRolesGet(userId: userId, accessToken: accessToken) { (response, error) in
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
 **userId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[RoleRead]**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listUsersApiV1UsersGet**
```swift
    open class func listUsersApiV1UsersGet(skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [UserRead]?, _ error: Error?) -> Void)
```

List Users

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 100)
let accessToken = "accessToken_example" // String |  (optional)

// List Users
UsersAPI.listUsersApiV1UsersGet(skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **limit** | **Int** |  | [optional] [default to 100]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[UserRead]**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **reactivateUserApiV1UsersUserIdReactivatePost**
```swift
    open class func reactivateUserApiV1UsersUserIdReactivatePost(userId: Int, accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Reactivate User

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Reactivate User
UsersAPI.reactivateUserApiV1UsersUserIdReactivatePost(userId: userId, accessToken: accessToken) { (response, error) in
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
 **userId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **removeRoleFromUserApiV1UsersUserIdRolesRoleIdDelete**
```swift
    open class func removeRoleFromUserApiV1UsersUserIdRolesRoleIdDelete(userId: Int, roleId: Int, accessToken: String? = nil, completion: @escaping (_ data: [RoleRead]?, _ error: Error?) -> Void)
```

Remove Role From User

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userId = 987 // Int | 
let roleId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Remove Role From User
UsersAPI.removeRoleFromUserApiV1UsersUserIdRolesRoleIdDelete(userId: userId, roleId: roleId, accessToken: accessToken) { (response, error) in
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
 **userId** | **Int** |  | 
 **roleId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[RoleRead]**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **setUserPasswordApiV1UsersUserIdPasswordPost**
```swift
    open class func setUserPasswordApiV1UsersUserIdPasswordPost(userId: Int, userPasswordSet: UserPasswordSet, accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Set User Password

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userId = 987 // Int | 
let userPasswordSet = UserPasswordSet(password: "password_example") // UserPasswordSet | 
let accessToken = "accessToken_example" // String |  (optional)

// Set User Password
UsersAPI.setUserPasswordApiV1UsersUserIdPasswordPost(userId: userId, userPasswordSet: userPasswordSet, accessToken: accessToken) { (response, error) in
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
 **userId** | **Int** |  | 
 **userPasswordSet** | [**UserPasswordSet**](UserPasswordSet.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updateUserApiV1UsersUserIdPatch**
```swift
    open class func updateUserApiV1UsersUserIdPatch(userId: Int, userUpdate: UserUpdate, accessToken: String? = nil, completion: @escaping (_ data: UserRead?, _ error: Error?) -> Void)
```

Update User

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let userId = 987 // Int | 
let userUpdate = UserUpdate(fullName: "fullName_example", email: "email_example") // UserUpdate | 
let accessToken = "accessToken_example" // String |  (optional)

// Update User
UsersAPI.updateUserApiV1UsersUserIdPatch(userId: userId, userUpdate: userUpdate, accessToken: accessToken) { (response, error) in
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
 **userId** | **Int** |  | 
 **userUpdate** | [**UserUpdate**](UserUpdate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**UserRead**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

