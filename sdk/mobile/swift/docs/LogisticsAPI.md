# LogisticsAPI

All URIs are relative to *http://localhost:8000*

Method | HTTP request | Description
------------- | ------------- | -------------
[**checkInShipmentApiV1PickupStaffShipmentsShipmentIdCheckInPost**](LogisticsAPI.md#checkinshipmentapiv1pickupstaffshipmentsshipmentidcheckinpost) | **POST** /api/v1/pickup-staff/shipments/{shipment_id}/check-in | Check In Shipment
[**collectHoldingItemsApiV1PickupStaffHoldingsHoldingIdCollectPost**](LogisticsAPI.md#collectholdingitemsapiv1pickupstaffholdingsholdingidcollectpost) | **POST** /api/v1/pickup-staff/holdings/{holding_id}/collect | Collect Holding Items
[**createPickupPointApiV1AdminPickupPointsPost**](LogisticsAPI.md#createpickuppointapiv1adminpickuppointspost) | **POST** /api/v1/admin/pickup-points | Create Pickup Point
[**createWarehouseShipmentApiV1WarehouseShipmentsPost**](LogisticsAPI.md#createwarehouseshipmentapiv1warehouseshipmentspost) | **POST** /api/v1/warehouse/shipments | Create Warehouse Shipment
[**declareReconciliationApiV1PickupStaffReconciliationReconciliationIdDeclarePost**](LogisticsAPI.md#declarereconciliationapiv1pickupstaffreconciliationreconciliationiddeclarepost) | **POST** /api/v1/pickup-staff/reconciliation/{reconciliation_id}/declare | Declare Reconciliation
[**getCurrentPickupStaffIdentityApiV1PickupStaffMeGet**](LogisticsAPI.md#getcurrentpickupstaffidentityapiv1pickupstaffmeget) | **GET** /api/v1/pickup-staff/me | Get Current Pickup Staff Identity
[**getCurrentReconciliationForStaffApiV1PickupStaffReconciliationCurrentGet**](LogisticsAPI.md#getcurrentreconciliationforstaffapiv1pickupstaffreconciliationcurrentget) | **GET** /api/v1/pickup-staff/reconciliation/current | Get Current Reconciliation For Staff
[**getGroupPickupStatusApiV1OrdersOrderIdGroupsGroupIdPickupStatusGet**](LogisticsAPI.md#getgrouppickupstatusapiv1ordersorderidgroupsgroupidpickupstatusget) | **GET** /api/v1/orders/{order_id}/groups/{group_id}/pickup-status | Get Group Pickup Status
[**getLastUsedPickupPointApiV1PickupPointsLastUsedGet**](LogisticsAPI.md#getlastusedpickuppointapiv1pickuppointslastusedget) | **GET** /api/v1/pickup-points/last-used | Get Last Used Pickup Point
[**invitePickupStaffApiV1PickupStaffStaffInvitePost**](LogisticsAPI.md#invitepickupstaffapiv1pickupstaffstaffinvitepost) | **POST** /api/v1/pickup-staff/staff/invite | Invite Pickup Staff
[**listCoStaffApiV1PickupStaffStaffGet**](LogisticsAPI.md#listcostaffapiv1pickupstaffstaffget) | **GET** /api/v1/pickup-staff/staff | List Co Staff
[**listHoldingsForStaffApiV1PickupStaffHoldingsGet**](LogisticsAPI.md#listholdingsforstaffapiv1pickupstaffholdingsget) | **GET** /api/v1/pickup-staff/holdings | List Holdings For Staff
[**listNearbyPickupPointsApiV1PickupPointsNearbyGet**](LogisticsAPI.md#listnearbypickuppointsapiv1pickuppointsnearbyget) | **GET** /api/v1/pickup-points/nearby | List Nearby Pickup Points
[**listPickupPointStaffAdminApiV1AdminPickupPointsPointIdStaffGet**](LogisticsAPI.md#listpickuppointstaffadminapiv1adminpickuppointspointidstaffget) | **GET** /api/v1/admin/pickup-points/{point_id}/staff | List Pickup Point Staff Admin
[**listPickupPointsAdminApiV1AdminPickupPointsGet**](LogisticsAPI.md#listpickuppointsadminapiv1adminpickuppointsget) | **GET** /api/v1/admin/pickup-points | List Pickup Points Admin
[**listPickupPointsApiV1PickupPointsGet**](LogisticsAPI.md#listpickuppointsapiv1pickuppointsget) | **GET** /api/v1/pickup-points | List Pickup Points
[**listReconciliationsAdminApiV1AdminReconciliationsGet**](LogisticsAPI.md#listreconciliationsadminapiv1adminreconciliationsget) | **GET** /api/v1/admin/reconciliations | List Reconciliations Admin
[**listRegionsAdminApiV1AdminRegionsGet**](LogisticsAPI.md#listregionsadminapiv1adminregionsget) | **GET** /api/v1/admin/regions | List Regions Admin
[**listRegionsApiV1RegionsGet**](LogisticsAPI.md#listregionsapiv1regionsget) | **GET** /api/v1/regions | List Regions
[**listReturnsForStaffApiV1PickupStaffReturnsGet**](LogisticsAPI.md#listreturnsforstaffapiv1pickupstaffreturnsget) | **GET** /api/v1/pickup-staff/returns | List Returns For Staff
[**listShipmentDiscrepanciesAdminApiV1AdminShipmentsGet**](LogisticsAPI.md#listshipmentdiscrepanciesadminapiv1adminshipmentsget) | **GET** /api/v1/admin/shipments | List Shipment Discrepancies Admin
[**listShipmentsForStaffApiV1PickupStaffShipmentsGet**](LogisticsAPI.md#listshipmentsforstaffapiv1pickupstaffshipmentsget) | **GET** /api/v1/pickup-staff/shipments | List Shipments For Staff
[**listWarehouseInboundApiV1WarehouseInboundGet**](LogisticsAPI.md#listwarehouseinboundapiv1warehouseinboundget) | **GET** /api/v1/warehouse/inbound | List Warehouse Inbound
[**listWarehouseOutboundApiV1WarehouseOutboundGet**](LogisticsAPI.md#listwarehouseoutboundapiv1warehouseoutboundget) | **GET** /api/v1/warehouse/outbound | List Warehouse Outbound
[**listWarehouseShipmentsApiV1WarehouseShipmentsGet**](LogisticsAPI.md#listwarehouseshipmentsapiv1warehouseshipmentsget) | **GET** /api/v1/warehouse/shipments | List Warehouse Shipments
[**receiveOrderGroupApiV1WarehouseOrderGroupsGroupIdReceivePost**](LogisticsAPI.md#receiveordergroupapiv1warehouseordergroupsgroupidreceivepost) | **POST** /api/v1/warehouse/order-groups/{group_id}/receive | Receive Order Group
[**receiveReturnApiV1PickupStaffReturnsRefundRequestIdReceivePost**](LogisticsAPI.md#receivereturnapiv1pickupstaffreturnsrefundrequestidreceivepost) | **POST** /api/v1/pickup-staff/returns/{refund_request_id}/receive | Receive Return
[**rejectHoldingItemsApiV1PickupStaffHoldingsHoldingIdRejectPost**](LogisticsAPI.md#rejectholdingitemsapiv1pickupstaffholdingsholdingidrejectpost) | **POST** /api/v1/pickup-staff/holdings/{holding_id}/reject | Reject Holding Items
[**resolveReconciliationAdminApiV1AdminReconciliationsReconciliationIdResolvePatch**](LogisticsAPI.md#resolvereconciliationadminapiv1adminreconciliationsreconciliationidresolvepatch) | **PATCH** /api/v1/admin/reconciliations/{reconciliation_id}/resolve | Resolve Reconciliation Admin
[**resolveShipmentDiscrepancyApiV1AdminShipmentsShipmentIdResolveDiscrepancyPatch**](LogisticsAPI.md#resolveshipmentdiscrepancyapiv1adminshipmentsshipmentidresolvediscrepancypatch) | **PATCH** /api/v1/admin/shipments/{shipment_id}/resolve-discrepancy | Resolve Shipment Discrepancy
[**suspendPickupStaffApiV1PickupStaffStaffStaffIdSuspendPatch**](LogisticsAPI.md#suspendpickupstaffapiv1pickupstaffstaffstaffidsuspendpatch) | **PATCH** /api/v1/pickup-staff/staff/{staff_id}/suspend | Suspend Pickup Staff
[**updatePickupPointApiV1AdminPickupPointsPointIdPatch**](LogisticsAPI.md#updatepickuppointapiv1adminpickuppointspointidpatch) | **PATCH** /api/v1/admin/pickup-points/{point_id} | Update Pickup Point
[**updatePickupPointStatusApiV1AdminPickupPointsPointIdStatusPatch**](LogisticsAPI.md#updatepickuppointstatusapiv1adminpickuppointspointidstatuspatch) | **PATCH** /api/v1/admin/pickup-points/{point_id}/status | Update Pickup Point Status
[**updatePickupStaffRoleApiV1PickupStaffStaffStaffIdRolePatch**](LogisticsAPI.md#updatepickupstaffroleapiv1pickupstaffstaffstaffidrolepatch) | **PATCH** /api/v1/pickup-staff/staff/{staff_id}/role | Update Pickup Staff Role


# **checkInShipmentApiV1PickupStaffShipmentsShipmentIdCheckInPost**
```swift
    open class func checkInShipmentApiV1PickupStaffShipmentsShipmentIdCheckInPost(shipmentId: Int, checkInRequest: CheckInRequest, accessToken: String? = nil, completion: @escaping (_ data: ShipmentRead?, _ error: Error?) -> Void)
```

Check In Shipment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shipmentId = 987 // Int | 
let checkInRequest = CheckInRequest(items: [CheckInItemInput(itemId: 123, receivedQuantity: 123, conditionNote: "conditionNote_example")]) // CheckInRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Check In Shipment
LogisticsAPI.checkInShipmentApiV1PickupStaffShipmentsShipmentIdCheckInPost(shipmentId: shipmentId, checkInRequest: checkInRequest, accessToken: accessToken) { (response, error) in
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
 **shipmentId** | **Int** |  | 
 **checkInRequest** | [**CheckInRequest**](CheckInRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ShipmentRead**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **collectHoldingItemsApiV1PickupStaffHoldingsHoldingIdCollectPost**
```swift
    open class func collectHoldingItemsApiV1PickupStaffHoldingsHoldingIdCollectPost(holdingId: Int, confirmCollectionRequest: ConfirmCollectionRequest, accessToken: String? = nil, completion: @escaping (_ data: CashCollectionRecordRead?, _ error: Error?) -> Void)
```

Collect Holding Items

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let holdingId = 987 // Int | 
let confirmCollectionRequest = ConfirmCollectionRequest(items: [CollectItemInput(holdingItemId: 123, quantityCollected: 123)], amountCollected: Amount_Collected()) // ConfirmCollectionRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Collect Holding Items
LogisticsAPI.collectHoldingItemsApiV1PickupStaffHoldingsHoldingIdCollectPost(holdingId: holdingId, confirmCollectionRequest: confirmCollectionRequest, accessToken: accessToken) { (response, error) in
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
 **holdingId** | **Int** |  | 
 **confirmCollectionRequest** | [**ConfirmCollectionRequest**](ConfirmCollectionRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**CashCollectionRecordRead**](CashCollectionRecordRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createPickupPointApiV1AdminPickupPointsPost**
```swift
    open class func createPickupPointApiV1AdminPickupPointsPost(pickupPointCreateRequest: PickupPointCreateRequest, accessToken: String? = nil, completion: @escaping (_ data: PickupPointRead?, _ error: Error?) -> Void)
```

Create Pickup Point

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let pickupPointCreateRequest = PickupPointCreateRequest(name: "name_example", address: "TODO", latitude: Latitude(), longitude: Longitude(), type: PickupPointType(), capacityUnits: 123, operatingHours: "TODO", contactPhone: "contactPhone_example", regionId: 123) // PickupPointCreateRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Pickup Point
LogisticsAPI.createPickupPointApiV1AdminPickupPointsPost(pickupPointCreateRequest: pickupPointCreateRequest, accessToken: accessToken) { (response, error) in
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
 **pickupPointCreateRequest** | [**PickupPointCreateRequest**](PickupPointCreateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**PickupPointRead**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **createWarehouseShipmentApiV1WarehouseShipmentsPost**
```swift
    open class func createWarehouseShipmentApiV1WarehouseShipmentsPost(warehouseShipmentCreateRequest: WarehouseShipmentCreateRequest, accessToken: String? = nil, completion: @escaping (_ data: ShipmentRead?, _ error: Error?) -> Void)
```

Create Warehouse Shipment

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let warehouseShipmentCreateRequest = WarehouseShipmentCreateRequest(pickupPointId: 123, orderShopGroupIds: [123]) // WarehouseShipmentCreateRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Create Warehouse Shipment
LogisticsAPI.createWarehouseShipmentApiV1WarehouseShipmentsPost(warehouseShipmentCreateRequest: warehouseShipmentCreateRequest, accessToken: accessToken) { (response, error) in
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
 **warehouseShipmentCreateRequest** | [**WarehouseShipmentCreateRequest**](WarehouseShipmentCreateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ShipmentRead**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **declareReconciliationApiV1PickupStaffReconciliationReconciliationIdDeclarePost**
```swift
    open class func declareReconciliationApiV1PickupStaffReconciliationReconciliationIdDeclarePost(reconciliationId: Int, declareReconciliationRequest: DeclareReconciliationRequest, accessToken: String? = nil, completion: @escaping (_ data: ReconciliationRead?, _ error: Error?) -> Void)
```

Declare Reconciliation

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let reconciliationId = 987 // Int | 
let declareReconciliationRequest = DeclareReconciliationRequest(declaredAmount: Declared_Amount()) // DeclareReconciliationRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Declare Reconciliation
LogisticsAPI.declareReconciliationApiV1PickupStaffReconciliationReconciliationIdDeclarePost(reconciliationId: reconciliationId, declareReconciliationRequest: declareReconciliationRequest, accessToken: accessToken) { (response, error) in
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
 **reconciliationId** | **Int** |  | 
 **declareReconciliationRequest** | [**DeclareReconciliationRequest**](DeclareReconciliationRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ReconciliationRead**](ReconciliationRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCurrentPickupStaffIdentityApiV1PickupStaffMeGet**
```swift
    open class func getCurrentPickupStaffIdentityApiV1PickupStaffMeGet(accessToken: String? = nil, completion: @escaping (_ data: PickupPointStaffRead?, _ error: Error?) -> Void)
```

Get Current Pickup Staff Identity

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// Get Current Pickup Staff Identity
LogisticsAPI.getCurrentPickupStaffIdentityApiV1PickupStaffMeGet(accessToken: accessToken) { (response, error) in
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

[**PickupPointStaffRead**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getCurrentReconciliationForStaffApiV1PickupStaffReconciliationCurrentGet**
```swift
    open class func getCurrentReconciliationForStaffApiV1PickupStaffReconciliationCurrentGet(accessToken: String? = nil, completion: @escaping (_ data: ReconciliationRead?, _ error: Error?) -> Void)
```

Get Current Reconciliation For Staff

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// Get Current Reconciliation For Staff
LogisticsAPI.getCurrentReconciliationForStaffApiV1PickupStaffReconciliationCurrentGet(accessToken: accessToken) { (response, error) in
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

[**ReconciliationRead**](ReconciliationRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getGroupPickupStatusApiV1OrdersOrderIdGroupsGroupIdPickupStatusGet**
```swift
    open class func getGroupPickupStatusApiV1OrdersOrderIdGroupsGroupIdPickupStatusGet(orderId: Int, groupId: Int, accessToken: String? = nil, completion: @escaping (_ data: PickupStatusRead?, _ error: Error?) -> Void)
```

Get Group Pickup Status

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let orderId = 987 // Int | 
let groupId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Get Group Pickup Status
LogisticsAPI.getGroupPickupStatusApiV1OrdersOrderIdGroupsGroupIdPickupStatusGet(orderId: orderId, groupId: groupId, accessToken: accessToken) { (response, error) in
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
 **orderId** | **Int** |  | 
 **groupId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**PickupStatusRead**](PickupStatusRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **getLastUsedPickupPointApiV1PickupPointsLastUsedGet**
```swift
    open class func getLastUsedPickupPointApiV1PickupPointsLastUsedGet(accessToken: String? = nil, completion: @escaping (_ data: PickupPointRead?, _ error: Error?) -> Void)
```

Get Last Used Pickup Point

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// Get Last Used Pickup Point
LogisticsAPI.getLastUsedPickupPointApiV1PickupPointsLastUsedGet(accessToken: accessToken) { (response, error) in
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

[**PickupPointRead**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **invitePickupStaffApiV1PickupStaffStaffInvitePost**
```swift
    open class func invitePickupStaffApiV1PickupStaffStaffInvitePost(appModulesLogisticsSchemasInviteStaffRequest: AppModulesLogisticsSchemasInviteStaffRequest, accessToken: String? = nil, completion: @escaping (_ data: PickupPointStaffRead?, _ error: Error?) -> Void)
```

Invite Pickup Staff

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let appModulesLogisticsSchemasInviteStaffRequest = app__modules__logistics__schemas__InviteStaffRequest(userId: 123, role: PickupPointStaffRole()) // AppModulesLogisticsSchemasInviteStaffRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Invite Pickup Staff
LogisticsAPI.invitePickupStaffApiV1PickupStaffStaffInvitePost(appModulesLogisticsSchemasInviteStaffRequest: appModulesLogisticsSchemasInviteStaffRequest, accessToken: accessToken) { (response, error) in
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
 **appModulesLogisticsSchemasInviteStaffRequest** | [**AppModulesLogisticsSchemasInviteStaffRequest**](AppModulesLogisticsSchemasInviteStaffRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**PickupPointStaffRead**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listCoStaffApiV1PickupStaffStaffGet**
```swift
    open class func listCoStaffApiV1PickupStaffStaffGet(accessToken: String? = nil, completion: @escaping (_ data: [PickupPointStaffRead]?, _ error: Error?) -> Void)
```

List Co Staff

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// List Co Staff
LogisticsAPI.listCoStaffApiV1PickupStaffStaffGet(accessToken: accessToken) { (response, error) in
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

[**[PickupPointStaffRead]**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listHoldingsForStaffApiV1PickupStaffHoldingsGet**
```swift
    open class func listHoldingsForStaffApiV1PickupStaffHoldingsGet(accessToken: String? = nil, completion: @escaping (_ data: [HoldingRead]?, _ error: Error?) -> Void)
```

List Holdings For Staff

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// List Holdings For Staff
LogisticsAPI.listHoldingsForStaffApiV1PickupStaffHoldingsGet(accessToken: accessToken) { (response, error) in
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

[**[HoldingRead]**](HoldingRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listNearbyPickupPointsApiV1PickupPointsNearbyGet**
```swift
    open class func listNearbyPickupPointsApiV1PickupPointsNearbyGet(lat: Double, lng: Double, radiusKm: Double? = nil, completion: @escaping (_ data: [NearbyPickupPointRead]?, _ error: Error?) -> Void)
```

List Nearby Pickup Points

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let lat = 987 // Double | 
let lng = 987 // Double | 
let radiusKm = 987 // Double |  (optional) (default to 25.0)

// List Nearby Pickup Points
LogisticsAPI.listNearbyPickupPointsApiV1PickupPointsNearbyGet(lat: lat, lng: lng, radiusKm: radiusKm) { (response, error) in
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
 **lat** | **Double** |  | 
 **lng** | **Double** |  | 
 **radiusKm** | **Double** |  | [optional] [default to 25.0]

### Return type

[**[NearbyPickupPointRead]**](NearbyPickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listPickupPointStaffAdminApiV1AdminPickupPointsPointIdStaffGet**
```swift
    open class func listPickupPointStaffAdminApiV1AdminPickupPointsPointIdStaffGet(pointId: Int, accessToken: String? = nil, completion: @escaping (_ data: [PickupPointStaffRead]?, _ error: Error?) -> Void)
```

List Pickup Point Staff Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let pointId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// List Pickup Point Staff Admin
LogisticsAPI.listPickupPointStaffAdminApiV1AdminPickupPointsPointIdStaffGet(pointId: pointId, accessToken: accessToken) { (response, error) in
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
 **pointId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[PickupPointStaffRead]**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listPickupPointsAdminApiV1AdminPickupPointsGet**
```swift
    open class func listPickupPointsAdminApiV1AdminPickupPointsGet(status: PickupPointStatus? = nil, regionId: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [PickupPointRead]?, _ error: Error?) -> Void)
```

List Pickup Points Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = PickupPointStatus() // PickupPointStatus |  (optional)
let regionId = 987 // Int |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Pickup Points Admin
LogisticsAPI.listPickupPointsAdminApiV1AdminPickupPointsGet(status: status, regionId: regionId, accessToken: accessToken) { (response, error) in
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
 **status** | [**PickupPointStatus**](.md) |  | [optional] 
 **regionId** | **Int** |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[PickupPointRead]**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listPickupPointsApiV1PickupPointsGet**
```swift
    open class func listPickupPointsApiV1PickupPointsGet(regionId: Int? = nil, completion: @escaping (_ data: [PickupPointRead]?, _ error: Error?) -> Void)
```

List Pickup Points

Active points only — for buyers who pick by region instead of location.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let regionId = 987 // Int |  (optional)

// List Pickup Points
LogisticsAPI.listPickupPointsApiV1PickupPointsGet(regionId: regionId) { (response, error) in
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
 **regionId** | **Int** |  | [optional] 

### Return type

[**[PickupPointRead]**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listReconciliationsAdminApiV1AdminReconciliationsGet**
```swift
    open class func listReconciliationsAdminApiV1AdminReconciliationsGet(status: PickupPointCashReconciliationStatus? = nil, accessToken: String? = nil, completion: @escaping (_ data: [ReconciliationRead]?, _ error: Error?) -> Void)
```

List Reconciliations Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = PickupPointCashReconciliationStatus() // PickupPointCashReconciliationStatus |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Reconciliations Admin
LogisticsAPI.listReconciliationsAdminApiV1AdminReconciliationsGet(status: status, accessToken: accessToken) { (response, error) in
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
 **status** | [**PickupPointCashReconciliationStatus**](.md) |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ReconciliationRead]**](ReconciliationRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listRegionsAdminApiV1AdminRegionsGet**
```swift
    open class func listRegionsAdminApiV1AdminRegionsGet(accessToken: String? = nil, completion: @escaping (_ data: [RegionRead]?, _ error: Error?) -> Void)
```

List Regions Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// List Regions Admin
LogisticsAPI.listRegionsAdminApiV1AdminRegionsGet(accessToken: accessToken) { (response, error) in
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

[**[RegionRead]**](RegionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listRegionsApiV1RegionsGet**
```swift
    open class func listRegionsApiV1RegionsGet(completion: @escaping (_ data: [RegionRead]?, _ error: Error?) -> Void)
```

List Regions

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK


// List Regions
LogisticsAPI.listRegionsApiV1RegionsGet() { (response, error) in
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

[**[RegionRead]**](RegionRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listReturnsForStaffApiV1PickupStaffReturnsGet**
```swift
    open class func listReturnsForStaffApiV1PickupStaffReturnsGet(accessToken: String? = nil, completion: @escaping (_ data: [PickupReturnRead]?, _ error: Error?) -> Void)
```

List Returns For Staff

Approved returns for orders collected at this point, waiting for the buyer to hand the item in.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let accessToken = "accessToken_example" // String |  (optional)

// List Returns For Staff
LogisticsAPI.listReturnsForStaffApiV1PickupStaffReturnsGet(accessToken: accessToken) { (response, error) in
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

[**[PickupReturnRead]**](PickupReturnRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listShipmentDiscrepanciesAdminApiV1AdminShipmentsGet**
```swift
    open class func listShipmentDiscrepanciesAdminApiV1AdminShipmentsGet(status: PickupPointShipmentStatus? = nil, accessToken: String? = nil, completion: @escaping (_ data: [ShipmentRead]?, _ error: Error?) -> Void)
```

List Shipment Discrepancies Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = PickupPointShipmentStatus() // PickupPointShipmentStatus |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Shipment Discrepancies Admin
LogisticsAPI.listShipmentDiscrepanciesAdminApiV1AdminShipmentsGet(status: status, accessToken: accessToken) { (response, error) in
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
 **status** | [**PickupPointShipmentStatus**](.md) |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ShipmentRead]**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listShipmentsForStaffApiV1PickupStaffShipmentsGet**
```swift
    open class func listShipmentsForStaffApiV1PickupStaffShipmentsGet(status: PickupPointShipmentStatus? = nil, accessToken: String? = nil, completion: @escaping (_ data: [ShipmentRead]?, _ error: Error?) -> Void)
```

List Shipments For Staff

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = PickupPointShipmentStatus() // PickupPointShipmentStatus |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Shipments For Staff
LogisticsAPI.listShipmentsForStaffApiV1PickupStaffShipmentsGet(status: status, accessToken: accessToken) { (response, error) in
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
 **status** | [**PickupPointShipmentStatus**](.md) |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ShipmentRead]**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listWarehouseInboundApiV1WarehouseInboundGet**
```swift
    open class func listWarehouseInboundApiV1WarehouseInboundGet(shopId: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [WarehouseGroupRead]?, _ error: Error?) -> Void)
```

List Warehouse Inbound

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shopId = 987 // Int |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Warehouse Inbound
LogisticsAPI.listWarehouseInboundApiV1WarehouseInboundGet(shopId: shopId, accessToken: accessToken) { (response, error) in
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
 **shopId** | **Int** |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[WarehouseGroupRead]**](WarehouseGroupRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listWarehouseOutboundApiV1WarehouseOutboundGet**
```swift
    open class func listWarehouseOutboundApiV1WarehouseOutboundGet(pickupPointId: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [WarehouseGroupRead]?, _ error: Error?) -> Void)
```

List Warehouse Outbound

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let pickupPointId = 987 // Int |  (optional)
let accessToken = "accessToken_example" // String |  (optional)

// List Warehouse Outbound
LogisticsAPI.listWarehouseOutboundApiV1WarehouseOutboundGet(pickupPointId: pickupPointId, accessToken: accessToken) { (response, error) in
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
 **pickupPointId** | **Int** |  | [optional] 
 **accessToken** | **String** |  | [optional] 

### Return type

[**[WarehouseGroupRead]**](WarehouseGroupRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **listWarehouseShipmentsApiV1WarehouseShipmentsGet**
```swift
    open class func listWarehouseShipmentsApiV1WarehouseShipmentsGet(status: PickupPointShipmentStatus? = nil, skip: Int? = nil, limit: Int? = nil, accessToken: String? = nil, completion: @escaping (_ data: [ShipmentRead]?, _ error: Error?) -> Void)
```

List Warehouse Shipments

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let status = PickupPointShipmentStatus() // PickupPointShipmentStatus |  (optional)
let skip = 987 // Int |  (optional) (default to 0)
let limit = 987 // Int |  (optional) (default to 50)
let accessToken = "accessToken_example" // String |  (optional)

// List Warehouse Shipments
LogisticsAPI.listWarehouseShipmentsApiV1WarehouseShipmentsGet(status: status, skip: skip, limit: limit, accessToken: accessToken) { (response, error) in
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
 **status** | [**PickupPointShipmentStatus**](.md) |  | [optional] 
 **skip** | **Int** |  | [optional] [default to 0]
 **limit** | **Int** |  | [optional] [default to 50]
 **accessToken** | **String** |  | [optional] 

### Return type

[**[ShipmentRead]**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **receiveOrderGroupApiV1WarehouseOrderGroupsGroupIdReceivePost**
```swift
    open class func receiveOrderGroupApiV1WarehouseOrderGroupsGroupIdReceivePost(groupId: Int, accessToken: String? = nil, completion: @escaping (_ data: OrderShopGroupBase?, _ error: Error?) -> Void)
```

Receive Order Group

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let groupId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Receive Order Group
LogisticsAPI.receiveOrderGroupApiV1WarehouseOrderGroupsGroupIdReceivePost(groupId: groupId, accessToken: accessToken) { (response, error) in
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
 **groupId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**OrderShopGroupBase**](OrderShopGroupBase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **receiveReturnApiV1PickupStaffReturnsRefundRequestIdReceivePost**
```swift
    open class func receiveReturnApiV1PickupStaffReturnsRefundRequestIdReceivePost(refundRequestId: Int, receiveReturnRequest: ReceiveReturnRequest, accessToken: String? = nil, completion: @escaping (_ data: RefundRequestRead?, _ error: Error?) -> Void)
```

Receive Return

Take in a returned item. The line becomes `returned_to_point`; the seller's confirm-return still releases the refund.

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let refundRequestId = 987 // Int | 
let receiveReturnRequest = ReceiveReturnRequest(conditionNote: "conditionNote_example") // ReceiveReturnRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Receive Return
LogisticsAPI.receiveReturnApiV1PickupStaffReturnsRefundRequestIdReceivePost(refundRequestId: refundRequestId, receiveReturnRequest: receiveReturnRequest, accessToken: accessToken) { (response, error) in
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
 **refundRequestId** | **Int** |  | 
 **receiveReturnRequest** | [**ReceiveReturnRequest**](ReceiveReturnRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**RefundRequestRead**](RefundRequestRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rejectHoldingItemsApiV1PickupStaffHoldingsHoldingIdRejectPost**
```swift
    open class func rejectHoldingItemsApiV1PickupStaffHoldingsHoldingIdRejectPost(holdingId: Int, rejectItemsRequest: RejectItemsRequest, accessToken: String? = nil, completion: @escaping (_ data: HoldingRead?, _ error: Error?) -> Void)
```

Reject Holding Items

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let holdingId = 987 // Int | 
let rejectItemsRequest = RejectItemsRequest(holdingItemIds: [123], reason: "reason_example") // RejectItemsRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Reject Holding Items
LogisticsAPI.rejectHoldingItemsApiV1PickupStaffHoldingsHoldingIdRejectPost(holdingId: holdingId, rejectItemsRequest: rejectItemsRequest, accessToken: accessToken) { (response, error) in
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
 **holdingId** | **Int** |  | 
 **rejectItemsRequest** | [**RejectItemsRequest**](RejectItemsRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**HoldingRead**](HoldingRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resolveReconciliationAdminApiV1AdminReconciliationsReconciliationIdResolvePatch**
```swift
    open class func resolveReconciliationAdminApiV1AdminReconciliationsReconciliationIdResolvePatch(reconciliationId: Int, resolveReconciliationRequest: ResolveReconciliationRequest, accessToken: String? = nil, completion: @escaping (_ data: ReconciliationRead?, _ error: Error?) -> Void)
```

Resolve Reconciliation Admin

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let reconciliationId = 987 // Int | 
let resolveReconciliationRequest = ResolveReconciliationRequest(resolutionNote: "resolutionNote_example") // ResolveReconciliationRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Resolve Reconciliation Admin
LogisticsAPI.resolveReconciliationAdminApiV1AdminReconciliationsReconciliationIdResolvePatch(reconciliationId: reconciliationId, resolveReconciliationRequest: resolveReconciliationRequest, accessToken: accessToken) { (response, error) in
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
 **reconciliationId** | **Int** |  | 
 **resolveReconciliationRequest** | [**ResolveReconciliationRequest**](ResolveReconciliationRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ReconciliationRead**](ReconciliationRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **resolveShipmentDiscrepancyApiV1AdminShipmentsShipmentIdResolveDiscrepancyPatch**
```swift
    open class func resolveShipmentDiscrepancyApiV1AdminShipmentsShipmentIdResolveDiscrepancyPatch(shipmentId: Int, resolveDiscrepancyRequest: ResolveDiscrepancyRequest, accessToken: String? = nil, completion: @escaping (_ data: ShipmentRead?, _ error: Error?) -> Void)
```

Resolve Shipment Discrepancy

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let shipmentId = 987 // Int | 
let resolveDiscrepancyRequest = ResolveDiscrepancyRequest(items: [DiscrepancyItemResolution(itemId: 123, resolvedQuantity: 123, status: PickupPointShipmentItemStatus())], resolutionNote: "resolutionNote_example") // ResolveDiscrepancyRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Resolve Shipment Discrepancy
LogisticsAPI.resolveShipmentDiscrepancyApiV1AdminShipmentsShipmentIdResolveDiscrepancyPatch(shipmentId: shipmentId, resolveDiscrepancyRequest: resolveDiscrepancyRequest, accessToken: accessToken) { (response, error) in
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
 **shipmentId** | **Int** |  | 
 **resolveDiscrepancyRequest** | [**ResolveDiscrepancyRequest**](ResolveDiscrepancyRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**ShipmentRead**](ShipmentRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **suspendPickupStaffApiV1PickupStaffStaffStaffIdSuspendPatch**
```swift
    open class func suspendPickupStaffApiV1PickupStaffStaffStaffIdSuspendPatch(staffId: Int, accessToken: String? = nil, completion: @escaping (_ data: PickupPointStaffRead?, _ error: Error?) -> Void)
```

Suspend Pickup Staff

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let staffId = 987 // Int | 
let accessToken = "accessToken_example" // String |  (optional)

// Suspend Pickup Staff
LogisticsAPI.suspendPickupStaffApiV1PickupStaffStaffStaffIdSuspendPatch(staffId: staffId, accessToken: accessToken) { (response, error) in
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
 **staffId** | **Int** |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**PickupPointStaffRead**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updatePickupPointApiV1AdminPickupPointsPointIdPatch**
```swift
    open class func updatePickupPointApiV1AdminPickupPointsPointIdPatch(pointId: Int, pickupPointUpdateRequest: PickupPointUpdateRequest, accessToken: String? = nil, completion: @escaping (_ data: PickupPointRead?, _ error: Error?) -> Void)
```

Update Pickup Point

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let pointId = 987 // Int | 
let pickupPointUpdateRequest = PickupPointUpdateRequest(name: "name_example", address: "TODO", latitude: Latitude_1(), longitude: Longitude_1(), capacityUnits: 123, operatingHours: "TODO", contactPhone: "contactPhone_example", regionId: 123) // PickupPointUpdateRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Pickup Point
LogisticsAPI.updatePickupPointApiV1AdminPickupPointsPointIdPatch(pointId: pointId, pickupPointUpdateRequest: pickupPointUpdateRequest, accessToken: accessToken) { (response, error) in
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
 **pointId** | **Int** |  | 
 **pickupPointUpdateRequest** | [**PickupPointUpdateRequest**](PickupPointUpdateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**PickupPointRead**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updatePickupPointStatusApiV1AdminPickupPointsPointIdStatusPatch**
```swift
    open class func updatePickupPointStatusApiV1AdminPickupPointsPointIdStatusPatch(pointId: Int, pickupPointStatusUpdateRequest: PickupPointStatusUpdateRequest, accessToken: String? = nil, completion: @escaping (_ data: PickupPointRead?, _ error: Error?) -> Void)
```

Update Pickup Point Status

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let pointId = 987 // Int | 
let pickupPointStatusUpdateRequest = PickupPointStatusUpdateRequest(status: PickupPointStatus()) // PickupPointStatusUpdateRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Pickup Point Status
LogisticsAPI.updatePickupPointStatusApiV1AdminPickupPointsPointIdStatusPatch(pointId: pointId, pickupPointStatusUpdateRequest: pickupPointStatusUpdateRequest, accessToken: accessToken) { (response, error) in
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
 **pointId** | **Int** |  | 
 **pickupPointStatusUpdateRequest** | [**PickupPointStatusUpdateRequest**](PickupPointStatusUpdateRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**PickupPointRead**](PickupPointRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **updatePickupStaffRoleApiV1PickupStaffStaffStaffIdRolePatch**
```swift
    open class func updatePickupStaffRoleApiV1PickupStaffStaffStaffIdRolePatch(staffId: Int, updateStaffRoleRequest: UpdateStaffRoleRequest, accessToken: String? = nil, completion: @escaping (_ data: PickupPointStaffRead?, _ error: Error?) -> Void)
```

Update Pickup Staff Role

### Example
```swift
// The following code samples are still beta. For any issue, please report via http://github.com/OpenAPITools/openapi-generator/issues/new
import EmarketSellerSDK

let staffId = 987 // Int | 
let updateStaffRoleRequest = UpdateStaffRoleRequest(role: PickupPointStaffRole()) // UpdateStaffRoleRequest | 
let accessToken = "accessToken_example" // String |  (optional)

// Update Pickup Staff Role
LogisticsAPI.updatePickupStaffRoleApiV1PickupStaffStaffStaffIdRolePatch(staffId: staffId, updateStaffRoleRequest: updateStaffRoleRequest, accessToken: accessToken) { (response, error) in
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
 **staffId** | **Int** |  | 
 **updateStaffRoleRequest** | [**UpdateStaffRoleRequest**](UpdateStaffRoleRequest.md) |  | 
 **accessToken** | **String** |  | [optional] 

### Return type

[**PickupPointStaffRead**](PickupPointStaffRead.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

