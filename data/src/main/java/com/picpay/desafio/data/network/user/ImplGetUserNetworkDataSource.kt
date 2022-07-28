package com.picpay.desafio.data.network.user

import com.picpay.desafio.domain.exception.Error
import com.picpay.desafio.data.model.UserDTO
import com.picpay.desafio.data.network.PicPayApiService
import com.picpay.desafio.domain.utils.Either
import retrofit2.Response
import javax.inject.Inject

class ImplGetUserNetworkDataSource @Inject constructor(private val service: PicPayApiService) :
    GetUserNetworkDataSource {
    override suspend fun getUserNetwork(): Response<List<UserDTO>> {
        return service.getUsers()
    }
}