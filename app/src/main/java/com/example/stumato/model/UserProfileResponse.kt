package com.example.stumato.model

data class UserProfileResponse(
    val sub: String,
    val given_name: String?,
    val family_name: String?,
    val phone_number: String,
    val email: String?,
    val picture: String?,
    val gender: String?,
    val phone_number_country_code: String?,
    val phone_number_verified: Boolean
)