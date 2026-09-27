
# ModerationQueueItemRead

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** |  |  |
| **shopId** | **kotlin.Int** |  |  |
| **categoryId** | **kotlin.Int** |  |  |
| **brandId** | **kotlin.Int** |  |  |
| **title** | **kotlin.String** |  |  |
| **slug** | **kotlin.String** |  |  |
| **description** | **kotlin.String** |  |  |
| **hasVariants** | **kotlin.Boolean** |  |  |
| **basePrice** | **kotlin.String** |  |  |
| **stockQuantity** | **kotlin.Int** |  |  |
| **platformSku** | **kotlin.String** |  |  |
| **sellerSku** | **kotlin.String** |  |  |
| **status** | [**ProductStatus**](ProductStatus.md) |  |  |
| **rejectionReason** | **kotlin.String** |  |  |
| **needsAttention** | **kotlin.Boolean** |  |  |
| **moderatedBy** | **kotlin.Int** |  |  |
| **moderatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **images** | [**kotlin.collections.List&lt;ProductImageRead&gt;**](ProductImageRead.md) |  |  [optional] |
| **variants** | [**kotlin.collections.List&lt;ProductVariantRead&gt;**](ProductVariantRead.md) |  |  [optional] |
| **attributeValues** | [**kotlin.collections.List&lt;ProductAttributeValueRead&gt;**](ProductAttributeValueRead.md) |  |  [optional] |
| **flags** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |



