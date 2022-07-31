package com.picpay.desafio.domain.usecase

import com.picpay.desafio.domain.BaseUseCase
import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.repository.IGetUserRepository
import com.picpay.desafio.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: IGetUserRepository):
    BaseUseCase<Resource<List<User>>> {

    override suspend fun execute(): Flow<Resource<List<User>>> {
        return repository.getUsers()
    }

}