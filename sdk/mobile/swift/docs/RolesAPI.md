# RolesAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**assignPermissionToRoleApiV1RolesRoleIdPermissionsPost**](RolesAPI.md#assignpermissiontoroleapiv1rolesroleidpermissionspost) | **POST** /api/v1/roles/{role_id}/permissions | Assign Permission To Role
[**createRoleApiV1RolesPost**](RolesAPI.md#createroleapiv1rolespost) | **POST** /api/v1/roles/ | Create Role
[**deleteRoleApiV1RolesRoleIdDelete**](RolesAPI.md#deleteroleapiv1rolesroleiddelete) | **DELETE** /api/v1/roles/{role_id} | Delete Role
[**getRoleApiV1RolesRoleIdGet**](RolesAPI.md#getroleapiv1rolesroleidget) | **GET** /api/v1/roles/{role_id} | Get Role
[**listPermissionsApiV1PermissionsGet**](RolesAPI.md#listpermissionsapiv1permissionsget) | **GET** /api/v1/permissions/ | List Permissions
[**listRolesApiV1RolesGet**](RolesAPI.md#listrolesapiv1rolesget) | **GET** /api/v1/roles/ | List Roles
[**removePermissionFromRoleApiV1RolesRoleIdPermissionsPermissionIdDelete**](RolesAPI.md#removepermissionfromroleapiv1rolesroleidpermissionspermissioniddelete) | **DELETE** /api/v1/roles/{role_id}/permissions/{permission_id} | Remove Permission From Role


# **assignPermissionToRoleApiV1RolesRoleIdPermissionsPost**
```swift
    open class func assignPermissionToRoleApiV1RolesRoleIdPermissionsPost(roleId: Int, assignPermissionRequest: AssignPermissionRequest, accessToken: String? = nil, completion: @escaping (_ data: RoleRead?, _ error: Error?) -> Void)
```

Assign Permission To Role

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let roleId = 987 // Int | 
let assignPermissionRequest = AssignPermissionRequest(permissionId: 123) // AssignPermissionRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Assign Permission To Role
RolesAPI.assignPermissionToRoleApiV1RolesRoleIdPermissionsPost(roleId: roleId, assignPermissionRequest: assignPermissionRequest, accessToken: accessToken) { (response, error) in
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
 **roleId** | **Int** |  | 
 **assignPermissionRequest** | [**AssignPermissionRequest**](AssignPermissionRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RoleRead**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createRoleApiV1RolesPost**
```swift
    open class func createRoleApiV1RolesPost(roleCreate: RoleCreate, accessToken: String? = nil, completion: @escaping (_ data: RoleRead?, _ error: Error?) -> Void)
```

Create Role

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let roleCreate = RoleCreate(name: "name_example", description: "description_example") // RoleCreate | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Role
RolesAPI.createRoleApiV1RolesPost(roleCreate: roleCreate, accessToken: accessToken) { (response, error) in
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
 **roleCreate** | [**RoleCreate**](RoleCreate.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RoleRead**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **deleteRoleApiV1RolesRoleIdDelete**
```swift
    open class func deleteRoleApiV1RolesRoleIdDelete(roleId: Int, accessToken: String? = nil, completion: @escaping (_ data: Void?, _ error: Error?) -> Void)
```

Delete Role

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let roleId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Delete Role
RolesAPI.deleteRoleApiV1RolesRoleIdDelete(roleId: roleId, accessToken: accessToken) { (response, error) in
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
 **roleId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

Void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getRoleApiV1RolesRoleIdGet**
```swift
    open class func getRoleApiV1RolesRoleIdGet(roleId: Int, accessToken: String? = nil, completion: @escaping (_ data: RoleRead?, _ error: Error?) -> Void)
```

Get Role

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let roleId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Role
RolesAPI.getRoleApiV1RolesRoleIdGet(roleId: roleId, accessToken: accessToken) { (response, error) in
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
 **roleId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RoleRead**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listPermissionsApiV1PermissionsGet**
```swift
    open class func listPermissionsApiV1PermissionsGet(accessToken: String? = nil, completion: @escaping (_ data: [PermissionRead]?, _ error: Error?) -> Void)
```

List Permissions

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// List Permissions
RolesAPI.listPermissionsApiV1PermissionsGet(accessToken: accessToken) { (response, error) in
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

[**[PermissionRead]**](PermissionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listRolesApiV1RolesGet**
```swift
    open class func listRolesApiV1RolesGet(accessToken: String? = nil, completion: @escaping (_ data: [RoleRead]?, _ error: Error?) -> Void)
```

List Roles

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// List Roles
RolesAPI.listRolesApiV1RolesGet(accessToken: accessToken) { (response, error) in
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

[**[RoleRead]**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **removePermissionFromRoleApiV1RolesRoleIdPermissionsPermissionIdDelete**
```swift
    open class func removePermissionFromRoleApiV1RolesRoleIdPermissionsPermissionIdDelete(roleId: Int, permissionId: Int, accessToken: String? = nil, completion: @escaping (_ data: RoleRead?, _ error: Error?) -> Void)
```

Remove Permission From Role

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let roleId = 987 // Int | 
let permissionId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Remove Permission From Role
RolesAPI.removePermissionFromRoleApiV1RolesRoleIdPermissionsPermissionIdDelete(roleId: roleId, permissionId: permissionId, accessToken: accessToken) { (response, error) in
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
 **roleId** | **Int** |  | 
 **permissionId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RoleRead**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

