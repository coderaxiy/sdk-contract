
# OrderShopGroupRead

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** |  |  |
| **orderId** | **kotlin.Int** |  |  |
| **shopId** | **kotlin.Int** |  |  |
| **status** | [**OrderShopGroupStatus**](OrderShopGroupStatus.md) |  |  |
| **subtotal** | **kotlin.String** |  |  |
| **shippingFee** | **kotlin.String** |  |  |
| **cancellationReason** | **kotlin.String** |  |  |
| **warehouseReceivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **deliveredAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **shop** | [**ShopSummaryRead**](ShopSummaryRead.md) |  |  |
| **lines** | [**kotlin.collections.List&lt;OrderLineRead&gt;**](OrderLineRead.md) |  |  [optional] |



