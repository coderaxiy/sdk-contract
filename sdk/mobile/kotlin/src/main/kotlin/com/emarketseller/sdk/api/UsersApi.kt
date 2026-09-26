package com.emarketseller.sdk.api

import com.emarketseller.sdk.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import com.emarketseller.sdk.model.AssignRoleRequest
import com.emarketseller.sdk.model.HTTPValidationError
import com.emarketseller.sdk.model.RoleRead
import com.emarketseller.sdk.model.UserAdminCreate
import com.emarketseller.sdk.model.UserPasswordSet
import com.emarketseller.sdk.model.UserRead
import com.emarketseller.sdk.model.UserUpdate

interface UsersApi {
    /**
     * POST api/v1/users/
     * Admin Create User
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param userAdminCreate 
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @POST("api/v1/users/")
    suspend fun adminCreateUserApiV1UsersPost(@Body userAdminCreate: UserAdminCreate, ): Response<UserRead>

    /**
     * POST api/v1/users/{user_id}/roles
     * Assign Role To User
     * 
     * Responses:
     *  - 201: Successful Response
     *  - 422: Validation Error
     *
     * @param userId 
     * @param assignRoleRequest 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<RoleRead>]
     */
    @POST("api/v1/users/{user_id}/roles")
    suspend fun assignRoleToUserApiV1UsersUserIdRolesPost(@Path("user_id") userId: kotlin.Int, @Body assignRoleRequest: AssignRoleRequest, ): Response<kotlin.collections.List<RoleRead>>

    /**
     * POST api/v1/users/{user_id}/deactivate
     * Deactivate User
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param userId 
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @POST("api/v1/users/{user_id}/deactivate")
    suspend fun deactivateUserApiV1UsersUserIdDeactivatePost(@Path("user_id") userId: kotlin.Int, ): Response<UserRead>

    /**
     * GET api/v1/users/{user_id}
     * Get User
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param userId 
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @GET("api/v1/users/{user_id}")
    suspend fun getUserApiV1UsersUserIdGet(@Path("user_id") userId: kotlin.Int, ): Response<UserRead>

    /**
     * GET api/v1/users/{user_id}/roles
     * Get User Roles
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param userId 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<RoleRead>]
     */
    @GET("api/v1/users/{user_id}/roles")
    suspend fun getUserRolesApiV1UsersUserIdRolesGet(@Path("user_id") userId: kotlin.Int, ): Response<kotlin.collections.List<RoleRead>>

    /**
     * GET api/v1/users/
     * List Users
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param skip  (optional, default to 0)
     * @param limit  (optional, default to 100)
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<UserRead>]
     */
    @GET("api/v1/users/")
    suspend fun listUsersApiV1UsersGet(@Query("skip") skip: kotlin.Int? = 0, @Query("limit") limit: kotlin.Int? = 100, ): Response<kotlin.collections.List<UserRead>>

    /**
     * POST api/v1/users/{user_id}/reactivate
     * Reactivate User
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param userId 
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @POST("api/v1/users/{user_id}/reactivate")
    suspend fun reactivateUserApiV1UsersUserIdReactivatePost(@Path("user_id") userId: kotlin.Int, ): Response<UserRead>

    /**
     * DELETE api/v1/users/{user_id}/roles/{role_id}
     * Remove Role From User
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param userId 
     * @param roleId 
     * @param accessToken  (optional)
     * @return [kotlin.collections.List<RoleRead>]
     */
    @DELETE("api/v1/users/{user_id}/roles/{role_id}")
    suspend fun removeRoleFromUserApiV1UsersUserIdRolesRoleIdDelete(@Path("user_id") userId: kotlin.Int, @Path("role_id") roleId: kotlin.Int, ): Response<kotlin.collections.List<RoleRead>>

    /**
     * POST api/v1/users/{user_id}/password
     * Set User Password
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param userId 
     * @param userPasswordSet 
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @POST("api/v1/users/{user_id}/password")
    suspend fun setUserPasswordApiV1UsersUserIdPasswordPost(@Path("user_id") userId: kotlin.Int, @Body userPasswordSet: UserPasswordSet, ): Response<UserRead>

    /**
     * PATCH api/v1/users/{user_id}
     * Update User
     * 
     * Responses:
     *  - 200: Successful Response
     *  - 422: Validation Error
     *
     * @param userId 
     * @param userUpdate 
     * @param accessToken  (optional)
     * @return [UserRead]
     */
    @PATCH("api/v1/users/{user_id}")
    suspend fun updateUserApiV1UsersUserIdPatch(@Path("user_id") userId: kotlin.Int, @Body userUpdate: UserUpdate, ): Response<UserRead>

}
