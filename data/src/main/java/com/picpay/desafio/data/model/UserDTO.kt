package com.picpay.desafio.data.model

import com.google.gson.annotations.SerializedName

data class UserDTO (
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
)