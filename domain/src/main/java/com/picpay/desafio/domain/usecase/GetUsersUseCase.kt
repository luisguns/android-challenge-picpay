package com.picpay.desafio.domain.usecase

import com.picpay.desafio.domain.BaseUseCase
import com.picpay.desafio.domain.exception.Error
import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.repository.IGetUserRepository
import com.picpay.desafio.domain.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: IGetUserRepository):
    BaseUseCase<Either<List<User>?, Error>> {

    override suspend fun execute(): Flow<Either<List<User>?, Error>> {
        return repository.getUsers()
    }

}