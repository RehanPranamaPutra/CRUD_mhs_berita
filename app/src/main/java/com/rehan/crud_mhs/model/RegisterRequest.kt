package com.rehan.crud_mhs.model

data class RegisterRequest(
    val username : String,
    val fullname : String,
    val email : String,
    val password : String
)
