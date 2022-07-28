package com.picpay.desafio.domain.repository

import com.picpay.desafio.domain.exception.Error
import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.utils.Either
import kotlinx.coroutines.flow.Flow

interface IGetUserRepository {
    suspend fun getUsers() : Flow<Either<List<User>?, Error>>
}