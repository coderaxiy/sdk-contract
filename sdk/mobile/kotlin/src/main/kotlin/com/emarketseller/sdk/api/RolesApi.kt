package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.AssignPermissionRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.PermissionRead
import com.emarketseller.sdk.model.RoleCreate
import com.emarketseller.sdk.model.RoleRead

interface RolesApi {
    /**
     * POST api/v1/roles/{role_id}/permissions
     * Assign Permission To Role
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param roleId 
     * @param assignPermissionRequest 
     * @param accessToken  (optional)
     * @return [RoleRead]
     */
    @POST("api/v1/roles/{role_id}/permissions")
    suspend fun assignPermissionToRoleApiV1RolesRoleIdPermissionsPost(@Path("role_id") roleId: kotlin.Int, @Body assignPermissionRequest: AssignPermissionRequest, ): Response<RoleRead>

    /**
     * POST api/v1/roles/
     * Create Role
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param roleCreate 
     * @param accessToken  (optional)
     * @return [RoleRead]
     */
    @POST("api/v1/roles/")
    suspend fun createRoleApiV1RolesPost(@Body roleCreate: RoleCreate, ): Response<RoleRead>

    /**
     * DELETE api/v1/roles/{role_id}
     * Delete Role
     * 
     * Responses:
     *  - 204: Successful Response
     *  - 422: Validation Error
     *
     * @param roleId 
     * @param accessToken  (optional)
     * @return [Unit]
     */
    @DELETE("api/v1/roles/{role_id}")
    suspend fun deleteRoleApiV1RolesRoleIdDelete(@Path("role_id") roleId: kotlin.Int, ): Response<Unit>

    /**
     * GET api/v1/roles/{role_id}
     * Get Role
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param roleId 
     * @param accessToken  (optional)
     * @return [RoleRead]
     */
    @GET("api/v1/roles/{role_id}")
    suspend fun getRoleApiV1RolesRoleIdGet(@Path("role_id") roleId: kotlin.Int, ): Response<RoleRead>

    /**
     * GET api/v1/permissions/
     * List Permissions
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<PermissionRead>]
     */
    @GET("api/v1/permissions/")
    suspend fun listPermissionsApiV1PermissionsGet(): Response<kotlin.collections.List<PermissionRead>>

    /**
     * GET api/v1/roles/
     * List Roles
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<RoleRead>]
     */
    @GET("api/v1/roles/")
    suspend fun listRolesApiV1RolesGet(): Response<kotlin.collections.List<RoleRead>>

    /**
     * DELETE api/v1/roles/{role_id}/permissions/{permission_id}
     * Remove Permission From Role
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param roleId 
     * @param permissionId 
     * @param accessToken  (optional)
     * @return [RoleRead]
     */
    @DELETE("api/v1/roles/{role_id}/permissions/{permission_id}")
    suspend fun removePermissionFromRoleApiV1RolesRoleIdPermissionsPermissionIdDelete(@Path("role_id") roleId: kotlin.Int, @Path("permission_id") permissionId: kotlin.Int, ): Response<RoleRead>

}
