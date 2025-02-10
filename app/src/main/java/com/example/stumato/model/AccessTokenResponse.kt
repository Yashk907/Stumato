package com.example.stumato.model

data class AccessTokenResponse(
    val access_token: String,
    val expires_in: Int,
    val token_type: String
)
