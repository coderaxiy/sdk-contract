# UsersApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**adminCreateUserApiV1UsersPost**](UsersApi.md#adminCreateUserApiV1UsersPost) | **POST** api/v1/users/ | Admin Create User |
| [**assignRoleToUserApiV1UsersUserIdRolesPost**](UsersApi.md#assignRoleToUserApiV1UsersUserIdRolesPost) | **POST** api/v1/users/{user_id}/roles | Assign Role To User |
| [**deactivateUserApiV1UsersUserIdDeactivatePost**](UsersApi.md#deactivateUserApiV1UsersUserIdDeactivatePost) | **POST** api/v1/users/{user_id}/deactivate | Deactivate User |
| [**getUserApiV1UsersUserIdGet**](UsersApi.md#getUserApiV1UsersUserIdGet) | **GET** api/v1/users/{user_id} | Get User |
| [**getUserRolesApiV1UsersUserIdRolesGet**](UsersApi.md#getUserRolesApiV1UsersUserIdRolesGet) | **GET** api/v1/users/{user_id}/roles | Get User Roles |
| [**listUsersApiV1UsersGet**](UsersApi.md#listUsersApiV1UsersGet) | **GET** api/v1/users/ | List Users |
| [**reactivateUserApiV1UsersUserIdReactivatePost**](UsersApi.md#reactivateUserApiV1UsersUserIdReactivatePost) | **POST** api/v1/users/{user_id}/reactivate | Reactivate User |
| [**removeRoleFromUserApiV1UsersUserIdRolesRoleIdDelete**](UsersApi.md#removeRoleFromUserApiV1UsersUserIdRolesRoleIdDelete) | **DELETE** api/v1/users/{user_id}/roles/{role_id} | Remove Role From User |
| [**setUserPasswordApiV1UsersUserIdPasswordPost**](UsersApi.md#setUserPasswordApiV1UsersUserIdPasswordPost) | **POST** api/v1/users/{user_id}/password | Set User Password |
| [**updateUserApiV1UsersUserIdPatch**](UsersApi.md#updateUserApiV1UsersUserIdPatch) | **PATCH** api/v1/users/{user_id} | Update User |



Admin Create User

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userAdminCreate : UserAdminCreate =  // UserAdminCreate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.adminCreateUserApiV1UsersPost(userAdminCreate, accessToken)
}
```

### Parameters
| **userAdminCreate** | [**UserAdminCreate**](UserAdminCreate.md)|  | |
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


Assign Role To User

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userId : kotlin.Int = 56 // kotlin.Int | 
val assignRoleRequest : AssignRoleRequest =  // AssignRoleRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RoleRead> = webService.assignRoleToUserApiV1UsersUserIdRolesPost(userId, assignRoleRequest, accessToken)
}
```

### Parameters
| **userId** | **kotlin.Int**|  | |
| **assignRoleRequest** | [**AssignRoleRequest**](AssignRoleRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;RoleRead&gt;**](RoleRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Deactivate User

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.deactivateUserApiV1UsersUserIdDeactivatePost(userId, accessToken)
}
```

### Parameters
| **userId** | **kotlin.Int**|  | |
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


Get User

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.getUserApiV1UsersUserIdGet(userId, accessToken)
}
```

### Parameters
| **userId** | **kotlin.Int**|  | |
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


Get User Roles

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RoleRead> = webService.getUserRolesApiV1UsersUserIdRolesGet(userId, accessToken)
}
```

### Parameters
| **userId** | **kotlin.Int**|  | |
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


List Users

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<UserRead> = webService.listUsersApiV1UsersGet(skip, limit, accessToken)
}
```

### Parameters
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 100] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;UserRead&gt;**](UserRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Reactivate User

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.reactivateUserApiV1UsersUserIdReactivatePost(userId, accessToken)
}
```

### Parameters
| **userId** | **kotlin.Int**|  | |
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


Remove Role From User

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userId : kotlin.Int = 56 // kotlin.Int | 
val roleId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RoleRead> = webService.removeRoleFromUserApiV1UsersUserIdRolesRoleIdDelete(userId, roleId, accessToken)
}
```

### Parameters
| **userId** | **kotlin.Int**|  | |
| **roleId** | **kotlin.Int**|  | |
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


Set User Password

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userId : kotlin.Int = 56 // kotlin.Int | 
val userPasswordSet : UserPasswordSet =  // UserPasswordSet | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.setUserPasswordApiV1UsersUserIdPasswordPost(userId, userPasswordSet, accessToken)
}
```

### Parameters
| **userId** | **kotlin.Int**|  | |
| **userPasswordSet** | [**UserPasswordSet**](UserPasswordSet.md)|  | |
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


Update User

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(UsersApi::class.java)
val userId : kotlin.Int = 56 // kotlin.Int | 
val userUpdate : UserUpdate =  // UserUpdate | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : UserRead = webService.updateUserApiV1UsersUserIdPatch(userId, userUpdate, accessToken)
}
```

### Parameters
| **userId** | **kotlin.Int**|  | |
| **userUpdate** | [**UserUpdate**](UserUpdate.md)|  | |
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

