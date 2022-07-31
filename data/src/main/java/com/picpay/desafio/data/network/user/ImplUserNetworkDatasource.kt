package com.picpay.desafio.data.network.user

import com.picpay.desafio.data.network.datasource.UserNetworkDatasource
import com.picpay.desafio.data.network.model.UserDTO
import com.picpay.desafio.data.network.PicPayApiService
import retrofit2.Response
import javax.inject.Inject

class ImplUserNetworkDatasource @Inject constructor(private val service: PicPayApiService) :
    UserNetworkDatasource {
    override suspend fun getUserNetwork(): List<UserDTO>{
        return service.getUsers()
    }
}