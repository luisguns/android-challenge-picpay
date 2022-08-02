package com.picpay.desafio.data

import com.picpay.desafio.data.mapper.toNetworkModel
import com.picpay.desafio.data.network.datasource.UserNetworkDatasource
import com.picpay.desafio.data.network.model.UserDTO
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response


class FakeExceptionGetUserNetworkDatasource: UserNetworkDatasource {
    override suspend fun getUserNetwork(): List<UserDTO> {
        throw Exception()
    }
}

class FakeHttpExceptionGetUserNetworkDatasource: UserNetworkDatasource {
    override suspend fun getUserNetwork(): List<UserDTO> {
        throw HttpException(Response.error<ResponseBody>(CODE_HTTP_FAKE_ERROR ,ResponseBody.create("plain/text".toMediaTypeOrNull(),"some content")))
    }

    companion object {
        const val CODE_HTTP_FAKE_ERROR = 500
    }
}

class FakeGetUserNetworkDatasource: UserNetworkDatasource {
    override suspend fun getUserNetwork(): List<UserDTO> {
        val user = FakeUserList.getFakeList().map { it.toNetworkModel() }
        return user
    }
}