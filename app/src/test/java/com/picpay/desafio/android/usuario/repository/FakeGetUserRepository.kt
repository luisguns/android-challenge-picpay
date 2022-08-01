package com.picpay.desafio.android.usuario.repository


import com.picpay.desafio.android.usuario.util.FakeUserList
import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.repository.IGetUserRepository
import com.picpay.desafio.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class FakeSuccesGetUserRepository: IGetUserRepository {
    override suspend fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Success(FakeUserList.getFakeList()))
    }
}

class FakeErrorGetUserRepository: IGetUserRepository {
    override suspend fun getUsers(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Error(FAKE_MSG))
    }

    companion object {
        const val FAKE_MSG = "This is a error msg test"
    }
}