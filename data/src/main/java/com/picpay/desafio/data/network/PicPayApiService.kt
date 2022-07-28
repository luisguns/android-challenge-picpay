package com.picpay.desafio.data.network

import com.picpay.desafio.data.model.UserDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PicPayApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<UserDTO>>
}