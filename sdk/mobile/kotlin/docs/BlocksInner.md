
# BlocksInner

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **title** | [**LocalizedText**](LocalizedText.md) |  |  |
| **type** | [**inline**](#Type) |  |  |
| **text** | [**LocalizedText**](LocalizedText.md) |  |  |
| **artwork** | [**LocalizedArtwork**](LocalizedArtwork.md) |  |  |
| **id** | **kotlin.Int** |  |  [optional] |
| **sortOrder** | **kotlin.Int** |  |  [optional] |
| **productIds** | **kotlin.collections.List&lt;kotlin.Int&gt;** |  |  [optional] |
| **homeKind** | [**inline**](#HomeKind) |  |  [optional] |
| **homeSortOrder** | **kotlin.Int** |  |  [optional] |
| **categoryIds** | **kotlin.collections.List&lt;kotlin.Int&gt;** |  |  [optional] |


<a id="Type"></a>
## Enum: type
| Name | Value |
| ---- | ----- |
| type | products, text, image, categories |


<a id="HomeKind"></a>
## Enum: home_kind
| Name | Value |
| ---- | ----- |
| homeKind | none, discount, recommendation |



