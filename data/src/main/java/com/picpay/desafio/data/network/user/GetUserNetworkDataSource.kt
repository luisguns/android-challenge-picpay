package com.picpay.desafio.data.network.user

import com.picpay.desafio.domain.exception.Error
import com.picpay.desafio.data.model.UserDTO
import com.picpay.desafio.domain.utils.Either
import retrofit2.Response

interface GetUserNetworkDataSource {
    suspend fun getUserNetwork() : Response<List<UserDTO>>
}