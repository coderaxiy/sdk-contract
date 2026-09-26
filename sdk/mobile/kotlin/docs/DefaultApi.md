# DefaultApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**rootGet**](DefaultApi.md#rootGet) | **GET**  | Root |



Root

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(DefaultApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.Any = webService.rootGet()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.Any**](kotlin.Any.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

