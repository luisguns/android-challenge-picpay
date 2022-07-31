package com.picpay.desafio.data.network.datasource

import com.picpay.desafio.data.network.model.UserDTO
import retrofit2.Response

interface UserNetworkDatasource {
    suspend fun getUserNetwork() : List<UserDTO>
}