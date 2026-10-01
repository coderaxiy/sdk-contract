
# RefundRequestRead

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** |  |  |
| **orderLineId** | **kotlin.Int** |  |  |
| **requestedBy** | [**RefundRequestedBy**](RefundRequestedBy.md) |  |  |
| **requesterUserId** | **kotlin.Int** |  |  |
| **reasonCode** | [**RefundReasonCode**](RefundReasonCode.md) |  |  |
| **reasonText** | **kotlin.String** |  |  |
| **status** | [**RefundStatus**](RefundStatus.md) |  |  |
| **refundAmount** | **kotlin.String** |  |  |
| **whoBearsCost** | [**WhoBearsCost**](WhoBearsCost.md) |  |  |
| **evidenceUrls** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  |
| **resolvedBy** | **kotlin.Int** |  |  |
| **resolvedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **escalatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **resolutionNote** | **kotlin.String** |  |  |
| **pointReceivedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **evidence** | [**kotlin.collections.List&lt;RefundEvidenceRead&gt;**](RefundEvidenceRead.md) | The buyer&#39;s photos. &#x60;url&#x60; is signed and short-lived — display it, never store it. |  [readonly] |



