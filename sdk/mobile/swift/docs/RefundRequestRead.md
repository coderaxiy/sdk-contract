# RefundRequestRead

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **Int** |  | 
**orderLineId** | **Int** |  | 
**requestedBy** | [**RefundRequestedBy**](RefundRequestedBy.md) |  | 
**requesterUserId** | **Int** |  | 
**reasonCode** | [**RefundReasonCode**](RefundReasonCode.md) |  | 
**reasonText** | **String** |  | 
**status** | [**RefundStatus**](RefundStatus.md) |  | 
**refundAmount** | **String** |  | 
**whoBearsCost** | [**WhoBearsCost**](WhoBearsCost.md) |  | 
**evidenceUrls** | **[String]** |  | 
**resolvedBy** | **Int** |  | 
**resolvedAt** | **Date** |  | 
**escalatedAt** | **Date** |  | 
**resolutionNote** | **String** |  | 
**pointReceivedAt** | **Date** |  | 
**createdAt** | **Date** |  | 
**evidence** | [RefundEvidenceRead] | The buyer&#39;s photos. &#x60;url&#x60; is signed and short-lived — display it, never store it. | [readonly] 

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


