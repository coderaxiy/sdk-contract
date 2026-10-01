# LogisticsApi

All URIs are relative to *http://localhost:8000*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**checkInShipmentApiV1PickupStaffShipmentsShipmentIdCheckInPost**](LogisticsApi.md#checkInShipmentApiV1PickupStaffShipmentsShipmentIdCheckInPost) | **POST** api/v1/pickup-staff/shipments/{shipment_id}/check-in | Check In Shipment |
| [**collectHoldingItemsApiV1PickupStaffHoldingsHoldingIdCollectPost**](LogisticsApi.md#collectHoldingItemsApiV1PickupStaffHoldingsHoldingIdCollectPost) | **POST** api/v1/pickup-staff/holdings/{holding_id}/collect | Collect Holding Items |
| [**createPickupPointApiV1AdminPickupPointsPost**](LogisticsApi.md#createPickupPointApiV1AdminPickupPointsPost) | **POST** api/v1/admin/pickup-points | Create Pickup Point |
| [**createWarehouseShipmentApiV1WarehouseShipmentsPost**](LogisticsApi.md#createWarehouseShipmentApiV1WarehouseShipmentsPost) | **POST** api/v1/warehouse/shipments | Create Warehouse Shipment |
| [**declareReconciliationApiV1PickupStaffReconciliationReconciliationIdDeclarePost**](LogisticsApi.md#declareReconciliationApiV1PickupStaffReconciliationReconciliationIdDeclarePost) | **POST** api/v1/pickup-staff/reconciliation/{reconciliation_id}/declare | Declare Reconciliation |
| [**getCurrentPickupStaffIdentityApiV1PickupStaffMeGet**](LogisticsApi.md#getCurrentPickupStaffIdentityApiV1PickupStaffMeGet) | **GET** api/v1/pickup-staff/me | Get Current Pickup Staff Identity |
| [**getCurrentReconciliationForStaffApiV1PickupStaffReconciliationCurrentGet**](LogisticsApi.md#getCurrentReconciliationForStaffApiV1PickupStaffReconciliationCurrentGet) | **GET** api/v1/pickup-staff/reconciliation/current | Get Current Reconciliation For Staff |
| [**getGroupPickupStatusApiV1OrdersOrderIdGroupsGroupIdPickupStatusGet**](LogisticsApi.md#getGroupPickupStatusApiV1OrdersOrderIdGroupsGroupIdPickupStatusGet) | **GET** api/v1/orders/{order_id}/groups/{group_id}/pickup-status | Get Group Pickup Status |
| [**getLastUsedPickupPointApiV1PickupPointsLastUsedGet**](LogisticsApi.md#getLastUsedPickupPointApiV1PickupPointsLastUsedGet) | **GET** api/v1/pickup-points/last-used | Get Last Used Pickup Point |
| [**invitePickupStaffApiV1PickupStaffStaffInvitePost**](LogisticsApi.md#invitePickupStaffApiV1PickupStaffStaffInvitePost) | **POST** api/v1/pickup-staff/staff/invite | Invite Pickup Staff |
| [**listCoStaffApiV1PickupStaffStaffGet**](LogisticsApi.md#listCoStaffApiV1PickupStaffStaffGet) | **GET** api/v1/pickup-staff/staff | List Co Staff |
| [**listHoldingsForStaffApiV1PickupStaffHoldingsGet**](LogisticsApi.md#listHoldingsForStaffApiV1PickupStaffHoldingsGet) | **GET** api/v1/pickup-staff/holdings | List Holdings For Staff |
| [**listNearbyPickupPointsApiV1PickupPointsNearbyGet**](LogisticsApi.md#listNearbyPickupPointsApiV1PickupPointsNearbyGet) | **GET** api/v1/pickup-points/nearby | List Nearby Pickup Points |
| [**listPickupPointStaffAdminApiV1AdminPickupPointsPointIdStaffGet**](LogisticsApi.md#listPickupPointStaffAdminApiV1AdminPickupPointsPointIdStaffGet) | **GET** api/v1/admin/pickup-points/{point_id}/staff | List Pickup Point Staff Admin |
| [**listPickupPointsAdminApiV1AdminPickupPointsGet**](LogisticsApi.md#listPickupPointsAdminApiV1AdminPickupPointsGet) | **GET** api/v1/admin/pickup-points | List Pickup Points Admin |
| [**listPickupPointsApiV1PickupPointsGet**](LogisticsApi.md#listPickupPointsApiV1PickupPointsGet) | **GET** api/v1/pickup-points | List Pickup Points |
| [**listReconciliationsAdminApiV1AdminReconciliationsGet**](LogisticsApi.md#listReconciliationsAdminApiV1AdminReconciliationsGet) | **GET** api/v1/admin/reconciliations | List Reconciliations Admin |
| [**listRegionsAdminApiV1AdminRegionsGet**](LogisticsApi.md#listRegionsAdminApiV1AdminRegionsGet) | **GET** api/v1/admin/regions | List Regions Admin |
| [**listRegionsApiV1RegionsGet**](LogisticsApi.md#listRegionsApiV1RegionsGet) | **GET** api/v1/regions | List Regions |
| [**listReturnsForStaffApiV1PickupStaffReturnsGet**](LogisticsApi.md#listReturnsForStaffApiV1PickupStaffReturnsGet) | **GET** api/v1/pickup-staff/returns | List Returns For Staff |
| [**listShipmentDiscrepanciesAdminApiV1AdminShipmentsGet**](LogisticsApi.md#listShipmentDiscrepanciesAdminApiV1AdminShipmentsGet) | **GET** api/v1/admin/shipments | List Shipment Discrepancies Admin |
| [**listShipmentsForStaffApiV1PickupStaffShipmentsGet**](LogisticsApi.md#listShipmentsForStaffApiV1PickupStaffShipmentsGet) | **GET** api/v1/pickup-staff/shipments | List Shipments For Staff |
| [**listWarehouseInboundApiV1WarehouseInboundGet**](LogisticsApi.md#listWarehouseInboundApiV1WarehouseInboundGet) | **GET** api/v1/warehouse/inbound | List Warehouse Inbound |
| [**listWarehouseOutboundApiV1WarehouseOutboundGet**](LogisticsApi.md#listWarehouseOutboundApiV1WarehouseOutboundGet) | **GET** api/v1/warehouse/outbound | List Warehouse Outbound |
| [**listWarehouseShipmentsApiV1WarehouseShipmentsGet**](LogisticsApi.md#listWarehouseShipmentsApiV1WarehouseShipmentsGet) | **GET** api/v1/warehouse/shipments | List Warehouse Shipments |
| [**receiveOrderGroupApiV1WarehouseOrderGroupsGroupIdReceivePost**](LogisticsApi.md#receiveOrderGroupApiV1WarehouseOrderGroupsGroupIdReceivePost) | **POST** api/v1/warehouse/order-groups/{group_id}/receive | Receive Order Group |
| [**receiveReturnApiV1PickupStaffReturnsRefundRequestIdReceivePost**](LogisticsApi.md#receiveReturnApiV1PickupStaffReturnsRefundRequestIdReceivePost) | **POST** api/v1/pickup-staff/returns/{refund_request_id}/receive | Receive Return |
| [**rejectHoldingItemsApiV1PickupStaffHoldingsHoldingIdRejectPost**](LogisticsApi.md#rejectHoldingItemsApiV1PickupStaffHoldingsHoldingIdRejectPost) | **POST** api/v1/pickup-staff/holdings/{holding_id}/reject | Reject Holding Items |
| [**resolveReconciliationAdminApiV1AdminReconciliationsReconciliationIdResolvePatch**](LogisticsApi.md#resolveReconciliationAdminApiV1AdminReconciliationsReconciliationIdResolvePatch) | **PATCH** api/v1/admin/reconciliations/{reconciliation_id}/resolve | Resolve Reconciliation Admin |
| [**resolveShipmentDiscrepancyApiV1AdminShipmentsShipmentIdResolveDiscrepancyPatch**](LogisticsApi.md#resolveShipmentDiscrepancyApiV1AdminShipmentsShipmentIdResolveDiscrepancyPatch) | **PATCH** api/v1/admin/shipments/{shipment_id}/resolve-discrepancy | Resolve Shipment Discrepancy |
| [**suspendPickupStaffApiV1PickupStaffStaffStaffIdSuspendPatch**](LogisticsApi.md#suspendPickupStaffApiV1PickupStaffStaffStaffIdSuspendPatch) | **PATCH** api/v1/pickup-staff/staff/{staff_id}/suspend | Suspend Pickup Staff |
| [**updatePickupPointApiV1AdminPickupPointsPointIdPatch**](LogisticsApi.md#updatePickupPointApiV1AdminPickupPointsPointIdPatch) | **PATCH** api/v1/admin/pickup-points/{point_id} | Update Pickup Point |
| [**updatePickupPointStatusApiV1AdminPickupPointsPointIdStatusPatch**](LogisticsApi.md#updatePickupPointStatusApiV1AdminPickupPointsPointIdStatusPatch) | **PATCH** api/v1/admin/pickup-points/{point_id}/status | Update Pickup Point Status |
| [**updatePickupStaffRoleApiV1PickupStaffStaffStaffIdRolePatch**](LogisticsApi.md#updatePickupStaffRoleApiV1PickupStaffStaffStaffIdRolePatch) | **PATCH** api/v1/pickup-staff/staff/{staff_id}/role | Update Pickup Staff Role |



Check In Shipment

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val shipmentId : kotlin.Int = 56 // kotlin.Int | 
val checkInRequest : CheckInRequest =  // CheckInRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShipmentRead = webService.checkInShipmentApiV1PickupStaffShipmentsShipmentIdCheckInPost(shipmentId, checkInRequest, accessToken)
}
```

### Parameters
| **shipmentId** | **kotlin.Int**|  | |
| **checkInRequest** | [**CheckInRequest**](CheckInRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShipmentRead**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Collect Holding Items

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val holdingId : kotlin.Int = 56 // kotlin.Int | 
val confirmCollectionRequest : ConfirmCollectionRequest =  // ConfirmCollectionRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : CashCollectionRecordRead = webService.collectHoldingItemsApiV1PickupStaffHoldingsHoldingIdCollectPost(holdingId, confirmCollectionRequest, accessToken)
}
```

### Parameters
| **holdingId** | **kotlin.Int**|  | |
| **confirmCollectionRequest** | [**ConfirmCollectionRequest**](ConfirmCollectionRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**CashCollectionRecordRead**](CashCollectionRecordRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Create Pickup Point

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val pickupPointCreateRequest : PickupPointCreateRequest =  // PickupPointCreateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupPointRead = webService.createPickupPointApiV1AdminPickupPointsPost(pickupPointCreateRequest, accessToken)
}
```

### Parameters
| **pickupPointCreateRequest** | [**PickupPointCreateRequest**](PickupPointCreateRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupPointRead**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Create Warehouse Shipment

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val warehouseShipmentCreateRequest : WarehouseShipmentCreateRequest =  // WarehouseShipmentCreateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShipmentRead = webService.createWarehouseShipmentApiV1WarehouseShipmentsPost(warehouseShipmentCreateRequest, accessToken)
}
```

### Parameters
| **warehouseShipmentCreateRequest** | [**WarehouseShipmentCreateRequest**](WarehouseShipmentCreateRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShipmentRead**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Declare Reconciliation

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val reconciliationId : kotlin.Int = 56 // kotlin.Int | 
val declareReconciliationRequest : DeclareReconciliationRequest =  // DeclareReconciliationRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ReconciliationRead = webService.declareReconciliationApiV1PickupStaffReconciliationReconciliationIdDeclarePost(reconciliationId, declareReconciliationRequest, accessToken)
}
```

### Parameters
| **reconciliationId** | **kotlin.Int**|  | |
| **declareReconciliationRequest** | [**DeclareReconciliationRequest**](DeclareReconciliationRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ReconciliationRead**](ReconciliationRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Get Current Pickup Staff Identity

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupPointStaffRead = webService.getCurrentPickupStaffIdentityApiV1PickupStaffMeGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupPointStaffRead**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Current Reconciliation For Staff

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ReconciliationRead = webService.getCurrentReconciliationForStaffApiV1PickupStaffReconciliationCurrentGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ReconciliationRead**](ReconciliationRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Group Pickup Status

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val orderId : kotlin.Int = 56 // kotlin.Int | 
val groupId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupStatusRead = webService.getGroupPickupStatusApiV1OrdersOrderIdGroupsGroupIdPickupStatusGet(orderId, groupId, accessToken)
}
```

### Parameters
| **orderId** | **kotlin.Int**|  | |
| **groupId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupStatusRead**](PickupStatusRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Get Last Used Pickup Point

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupPointRead = webService.getLastUsedPickupPointApiV1PickupPointsLastUsedGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupPointRead**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Invite Pickup Staff

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val appModulesLogisticsSchemasInviteStaffRequest : AppModulesLogisticsSchemasInviteStaffRequest =  // AppModulesLogisticsSchemasInviteStaffRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupPointStaffRead = webService.invitePickupStaffApiV1PickupStaffStaffInvitePost(appModulesLogisticsSchemasInviteStaffRequest, accessToken)
}
```

### Parameters
| **appModulesLogisticsSchemasInviteStaffRequest** | [**AppModulesLogisticsSchemasInviteStaffRequest**](AppModulesLogisticsSchemasInviteStaffRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupPointStaffRead**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


List Co Staff

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PickupPointStaffRead> = webService.listCoStaffApiV1PickupStaffStaffGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PickupPointStaffRead&gt;**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Holdings For Staff

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<HoldingRead> = webService.listHoldingsForStaffApiV1PickupStaffHoldingsGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;HoldingRead&gt;**](HoldingRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Nearby Pickup Points

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val lat : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 
val lng : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 
val radiusKm : java.math.BigDecimal = 8.14 // java.math.BigDecimal | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<NearbyPickupPointRead> = webService.listNearbyPickupPointsApiV1PickupPointsNearbyGet(lat, lng, radiusKm)
}
```

### Parameters
| **lat** | **java.math.BigDecimal**|  | |
| **lng** | **java.math.BigDecimal**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **radiusKm** | **java.math.BigDecimal**|  | [optional] [default to 25.0] |

### Return type

[**kotlin.collections.List&lt;NearbyPickupPointRead&gt;**](NearbyPickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Pickup Point Staff Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val pointId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PickupPointStaffRead> = webService.listPickupPointStaffAdminApiV1AdminPickupPointsPointIdStaffGet(pointId, accessToken)
}
```

### Parameters
| **pointId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PickupPointStaffRead&gt;**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Pickup Points Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val status : PickupPointStatus =  // PickupPointStatus | 
val regionId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PickupPointRead> = webService.listPickupPointsAdminApiV1AdminPickupPointsGet(status, regionId, accessToken)
}
```

### Parameters
| **status** | [**PickupPointStatus**](.md)|  | [optional] [enum: pending_setup, active, temporarily_closed, closed] |
| **regionId** | **kotlin.Int**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PickupPointRead&gt;**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Pickup Points

Active points only — for buyers who pick by region instead of location.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val regionId : kotlin.Int = 56 // kotlin.Int | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PickupPointRead> = webService.listPickupPointsApiV1PickupPointsGet(regionId)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **regionId** | **kotlin.Int**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PickupPointRead&gt;**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Reconciliations Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val status : PickupPointCashReconciliationStatus =  // PickupPointCashReconciliationStatus | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ReconciliationRead> = webService.listReconciliationsAdminApiV1AdminReconciliationsGet(status, accessToken)
}
```

### Parameters
| **status** | [**PickupPointCashReconciliationStatus**](.md)|  | [optional] [enum: pending_review, matched, variance_flagged, resolved] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ReconciliationRead&gt;**](ReconciliationRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Regions Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RegionRead> = webService.listRegionsAdminApiV1AdminRegionsGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;RegionRead&gt;**](RegionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Regions

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<RegionRead> = webService.listRegionsApiV1RegionsGet()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**kotlin.collections.List&lt;RegionRead&gt;**](RegionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Returns For Staff

Approved returns for orders collected at this point, waiting for the buyer to hand the item in.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<PickupReturnRead> = webService.listReturnsForStaffApiV1PickupStaffReturnsGet(accessToken)
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;PickupReturnRead&gt;**](PickupReturnRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Shipment Discrepancies Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val status : PickupPointShipmentStatus =  // PickupPointShipmentStatus | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ShipmentRead> = webService.listShipmentDiscrepanciesAdminApiV1AdminShipmentsGet(status, accessToken)
}
```

### Parameters
| **status** | [**PickupPointShipmentStatus**](.md)|  | [optional] [enum: dispatched, in_transit, arrived, discrepancy] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ShipmentRead&gt;**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Shipments For Staff

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val status : PickupPointShipmentStatus =  // PickupPointShipmentStatus | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ShipmentRead> = webService.listShipmentsForStaffApiV1PickupStaffShipmentsGet(status, accessToken)
}
```

### Parameters
| **status** | [**PickupPointShipmentStatus**](.md)|  | [optional] [enum: dispatched, in_transit, arrived, discrepancy] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ShipmentRead&gt;**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Warehouse Inbound

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val shopId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<WarehouseGroupRead> = webService.listWarehouseInboundApiV1WarehouseInboundGet(shopId, accessToken)
}
```

### Parameters
| **shopId** | **kotlin.Int**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;WarehouseGroupRead&gt;**](WarehouseGroupRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Warehouse Outbound

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val pickupPointId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<WarehouseGroupRead> = webService.listWarehouseOutboundApiV1WarehouseOutboundGet(pickupPointId, accessToken)
}
```

### Parameters
| **pickupPointId** | **kotlin.Int**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;WarehouseGroupRead&gt;**](WarehouseGroupRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


List Warehouse Shipments

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val status : PickupPointShipmentStatus =  // PickupPointShipmentStatus | 
val skip : kotlin.Int = 56 // kotlin.Int | 
val limit : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : kotlin.collections.List<ShipmentRead> = webService.listWarehouseShipmentsApiV1WarehouseShipmentsGet(status, skip, limit, accessToken)
}
```

### Parameters
| **status** | [**PickupPointShipmentStatus**](.md)|  | [optional] [enum: dispatched, in_transit, arrived, discrepancy] |
| **skip** | **kotlin.Int**|  | [optional] [default to 0] |
| **limit** | **kotlin.Int**|  | [optional] [default to 50] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**kotlin.collections.List&lt;ShipmentRead&gt;**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Receive Order Group

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val groupId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : OrderShopGroupBase = webService.receiveOrderGroupApiV1WarehouseOrderGroupsGroupIdReceivePost(groupId, accessToken)
}
```

### Parameters
| **groupId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**OrderShopGroupBase**](OrderShopGroupBase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Receive Return

Take in a returned item. The line becomes &#x60;returned_to_point&#x60;; the seller&#39;s confirm-return still releases the refund.

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val refundRequestId : kotlin.Int = 56 // kotlin.Int | 
val receiveReturnRequest : ReceiveReturnRequest =  // ReceiveReturnRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : RefundRequestRead = webService.receiveReturnApiV1PickupStaffReturnsRefundRequestIdReceivePost(refundRequestId, receiveReturnRequest, accessToken)
}
```

### Parameters
| **refundRequestId** | **kotlin.Int**|  | |
| **receiveReturnRequest** | [**ReceiveReturnRequest**](ReceiveReturnRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Reject Holding Items

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val holdingId : kotlin.Int = 56 // kotlin.Int | 
val rejectItemsRequest : RejectItemsRequest =  // RejectItemsRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : HoldingRead = webService.rejectHoldingItemsApiV1PickupStaffHoldingsHoldingIdRejectPost(holdingId, rejectItemsRequest, accessToken)
}
```

### Parameters
| **holdingId** | **kotlin.Int**|  | |
| **rejectItemsRequest** | [**RejectItemsRequest**](RejectItemsRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**HoldingRead**](HoldingRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Resolve Reconciliation Admin

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val reconciliationId : kotlin.Int = 56 // kotlin.Int | 
val resolveReconciliationRequest : ResolveReconciliationRequest =  // ResolveReconciliationRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ReconciliationRead = webService.resolveReconciliationAdminApiV1AdminReconciliationsReconciliationIdResolvePatch(reconciliationId, resolveReconciliationRequest, accessToken)
}
```

### Parameters
| **reconciliationId** | **kotlin.Int**|  | |
| **resolveReconciliationRequest** | [**ResolveReconciliationRequest**](ResolveReconciliationRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ReconciliationRead**](ReconciliationRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Resolve Shipment Discrepancy

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val shipmentId : kotlin.Int = 56 // kotlin.Int | 
val resolveDiscrepancyRequest : ResolveDiscrepancyRequest =  // ResolveDiscrepancyRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : ShipmentRead = webService.resolveShipmentDiscrepancyApiV1AdminShipmentsShipmentIdResolveDiscrepancyPatch(shipmentId, resolveDiscrepancyRequest, accessToken)
}
```

### Parameters
| **shipmentId** | **kotlin.Int**|  | |
| **resolveDiscrepancyRequest** | [**ResolveDiscrepancyRequest**](ResolveDiscrepancyRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**ShipmentRead**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Suspend Pickup Staff

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val staffId : kotlin.Int = 56 // kotlin.Int | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupPointStaffRead = webService.suspendPickupStaffApiV1PickupStaffStaffStaffIdSuspendPatch(staffId, accessToken)
}
```

### Parameters
| **staffId** | **kotlin.Int**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupPointStaffRead**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


Update Pickup Point

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val pointId : kotlin.Int = 56 // kotlin.Int | 
val pickupPointUpdateRequest : PickupPointUpdateRequest =  // PickupPointUpdateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupPointRead = webService.updatePickupPointApiV1AdminPickupPointsPointIdPatch(pointId, pickupPointUpdateRequest, accessToken)
}
```

### Parameters
| **pointId** | **kotlin.Int**|  | |
| **pickupPointUpdateRequest** | [**PickupPointUpdateRequest**](PickupPointUpdateRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupPointRead**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Pickup Point Status

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val pointId : kotlin.Int = 56 // kotlin.Int | 
val pickupPointStatusUpdateRequest : PickupPointStatusUpdateRequest =  // PickupPointStatusUpdateRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupPointRead = webService.updatePickupPointStatusApiV1AdminPickupPointsPointIdStatusPatch(pointId, pickupPointStatusUpdateRequest, accessToken)
}
```

### Parameters
| **pointId** | **kotlin.Int**|  | |
| **pickupPointStatusUpdateRequest** | [**PickupPointStatusUpdateRequest**](PickupPointStatusUpdateRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupPointRead**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


Update Pickup Staff Role

### Example
```kotlin
// Import classes:
//import com.emarketseller.sdk.*
//import com.emarketseller.sdk.infrastructure.*
//import com.emarketseller.sdk.model.*

val apiClient = ApiClient()
val webService = apiClient.createWebservice(LogisticsApi::class.java)
val staffId : kotlin.Int = 56 // kotlin.Int | 
val updateStaffRoleRequest : UpdateStaffRoleRequest =  // UpdateStaffRoleRequest | 
val accessToken : kotlin.String = accessToken_example // kotlin.String | 

launch(Dispatchers.IO) {
    val result : PickupPointStaffRead = webService.updatePickupStaffRoleApiV1PickupStaffStaffStaffIdRolePatch(staffId, updateStaffRoleRequest, accessToken)
}
```

### Parameters
| **staffId** | **kotlin.Int**|  | |
| **updateStaffRoleRequest** | [**UpdateStaffRoleRequest**](UpdateStaffRoleRequest.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **accessToken** | **kotlin.String**|  | [optional] |

### Return type

[**PickupPointStaffRead**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

