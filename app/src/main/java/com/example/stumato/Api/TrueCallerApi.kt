package com.example.stumato.Api

import com.example.stumato.model.AccessTokenResponse
import com.example.stumato.model.UserProfileResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface TrueCallerApi {
    //api call to fetch access token
    @FormUrlEncoded
    @POST("token")
    suspend fun fetchAccessToken(
        @Header("Content-Type") contentType: String = "application/x-www-form-urlencoded",
        @Field("grant_type") grantType: String = "authorization_code",
        @Field("client_id") clientId: String,
        @Field("code") authCode: String,
        @Field("code_verifier") codeVerifier: String
    ): Response<AccessTokenResponse>



    //api call to get userInfo using accesstoken
    @GET("userinfo")
    suspend fun fetchUserInfo(@Header("Authorization") authHeader: String): Response<UserProfileResponse>
}