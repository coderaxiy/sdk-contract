
# CategoryRead

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **id** | **kotlin.Int** |  |  |
| **parentId** | **kotlin.Int** |  |  |
| **slug** | **kotlin.String** |  |  |
| **iconUrl** | **kotlin.String** |  |  |
| **sortOrder** | **kotlin.Int** |  |  |
| **isLeaf** | **kotlin.Boolean** |  |  |
| **isActive** | **kotlin.Boolean** |  |  |
| **requiresDocuments** | **kotlin.Boolean** |  |  |
| **requiredDocumentTypes** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  |
| **allowsVariants** | **kotlin.Boolean** |  |  |
| **returnWindowDays** | **kotlin.Int** |  |  |
| **defaultCommissionRuleId** | **kotlin.Int** |  |  |
| **createdAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **updatedAt** | [**java.time.OffsetDateTime**](java.time.OffsetDateTime.md) |  |  |
| **iconKey** | **kotlin.String** | Category icon upload key; null clears the icon on PATCH |  [optional] |
| **iconSvg** | **kotlin.String** | Sanitized static SVG markup; null for raster uploads and legacy URLs |  [optional] |
| **translations** | [**kotlin.collections.List&lt;TranslationRead&gt;**](TranslationRead.md) |  |  [optional] |



