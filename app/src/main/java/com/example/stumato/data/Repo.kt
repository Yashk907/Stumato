package com.example.stumato.data

import com.example.stumato.model.User

interface Repo {
    suspend fun RegisterUserManual(user: User)
    suspend fun RegisterUser1Click(user: User)
}