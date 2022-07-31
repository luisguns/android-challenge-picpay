package com.picpay.desafio.data.network

import com.picpay.desafio.data.network.model.UserDTO
import retrofit2.Response
import retrofit2.http.GET

interface PicPayApiService {
    @GET("users")
    suspend fun getUsers(): List<UserDTO>
}