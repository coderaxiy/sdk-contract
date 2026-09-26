# RolesApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**assignPermissionToRoleApiV1RolesRoleIdPermissionsPost**](RolesApi.md#assignPermissionToRoleApiV1RolesRoleIdPermissionsPost) | **POST** api/v1/roles/{role_id}/permissions | Assign Permission To Role |
| [**createRoleApiV1RolesPost**](RolesApi.md#createRoleApiV1RolesPost) | **POST** api/v1/roles/ | Create Role |
| [**deleteRoleApiV1RolesRoleIdDelete**](RolesApi.md#deleteRoleApiV1RolesRoleIdDelete) | **DELETE** api/v1/roles/{role_id} | Delete Role |
| [**getRoleApiV1RolesRoleIdGet**](RolesApi.md#getRoleApiV1RolesRoleIdGet) | **GET** api/v1/roles/{role_id} | Get Role |
| [**listPermissionsApiV1PermissionsGet**](RolesApi.md#listPermissionsApiV1PermissionsGet) | **GET** api/v1/permissions/ | List Permissions |
| [**listRolesApiV1RolesGet**](RolesApi.md#listRolesApiV1RolesGet) | **GET** api/v1/roles/ | List Roles |
| [**removePermissionFromRoleApiV1RolesRoleIdPermissionsPermissionIdDelete**](RolesApi.md#removePermissionFromRoleApiV1RolesRoleIdPermissionsPermissionIdDelete) | **DELETE** api/v1/roles/{role_id}/permissions/{permission_id} | Remove Permission From Role |



Assign Permission To Role

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(RolesApi::class.java)
val roleId : kotlin.Int = 56 // kotlin.Int | 
val assignPermissionRequest : AssignPermissionRequest =  // AssignPermissionRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RoleRead = webService.assignPermissionToRoleApiV1RolesRoleIdPermissionsPost(roleId, assignPermissionRequest, accessToken)
}
```

### Parameters
| **roleId** | **kotlin.Int**|  | |
| **assignPermissionRequest** | [**AssignPermissionRequest**](AssignPermissionRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RoleRead**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Create Role

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(RolesApi::class.java)
val roleCreate : RoleCreate =  // RoleCreate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RoleRead = webService.createRoleApiV1RolesPost(roleCreate, accessToken)
}
```

### Parameters
| **roleCreate** | [**RoleCreate**](RoleCreate.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RoleRead**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Delete Role

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(RolesApi::class.java)
val roleId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    webService.deleteRoleApiV1RolesRoleIdDelete(roleId, accessToken)
}
```

### Parameters
| **roleId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Role

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(RolesApi::class.java)
val roleId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RoleRead = webService.getRoleApiV1RolesRoleIdGet(roleId, accessToken)
}
```

### Parameters
| **roleId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RoleRead**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Permissions

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(RolesApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PermissionRead> = webService.listPermissionsApiV1PermissionsGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PermissionRead&gt;**](PermissionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Roles

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(RolesApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RoleRead> = webService.listRolesApiV1RolesGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;RoleRead&gt;**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Remove Permission From Role

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(RolesApi::class.java)
val roleId : kotlin.Int = 56 // kotlin.Int | 
val permissionId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RoleRead = webService.removePermissionFromRoleApiV1RolesRoleIdPermissionsPermissionIdDelete(roleId, permissionId, accessToken)
}
```

### Parameters
| **roleId** | **kotlin.Int**|  | |
| **permissionId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RoleRead**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

