
# DocumentRead

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** |  |  |
| **sellerId** | **kotlin.Int** |  |  |
| **shopId** | **kotlin.Int** |  |  |
| **type** | [**DocumentType**](DocumentType.md) |  |  |
| **fileKey** | **kotlin.String** |  |  |
| **status** | [**DocumentStatus**](DocumentStatus.md) |  |  |
| **rejectionReason** | **kotlin.String** |  |  |
| **reviewedBy** | **kotlin.Int** |  |  |
| **reviewedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **fileUrl** | **kotlin.String** | Signed, time-limited link (STORAGE_PRESIGNED_URL_EXPIRE_SECONDS) — documents live in the private bucket. Fetch a fresh one to view again. |  [readonly] |



