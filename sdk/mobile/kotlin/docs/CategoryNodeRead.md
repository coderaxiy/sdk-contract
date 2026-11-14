
# CategoryNodeRead

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** |  |  |
| **parentId** | **kotlin.Int** |  |  |
| **slug** | **kotlin.String** |  |  |
| **iconUrl** | **kotlin.String** |  |  |
| **sortOrder** | **kotlin.Int** |  |  |
| **isLeaf** | **kotlin.Boolean** |  |  |
| **productCount** | **kotlin.Int** |  |  |
| **iconKey** | **kotlin.String** | Category icon upload key; null clears the icon on PATCH |  [optional] |
| **iconSvg** | **kotlin.String** | Sanitized static SVG markup; null for raster uploads and legacy URLs |  [optional] |
| **translations** | [**kotlin.collections.List&lt;TranslationRead&gt;**](TranslationRead.md) |  |  [optional] |
| **children** | [**kotlin.collections.List&lt;CategoryNodeRead&gt;**](CategoryNodeRead.md) |  |  [optional] |



