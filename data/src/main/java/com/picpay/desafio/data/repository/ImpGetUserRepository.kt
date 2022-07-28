package com.picpay.desafio.data.repository

import com.picpay.desafio.data.mapper.toDomainModel
import com.picpay.desafio.data.model.UserDTO
import com.picpay.desafio.data.network.user.GetUserNetworkDataSource
import com.picpay.desafio.domain.exception.Error
import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.repository.IGetUserRepository
import com.picpay.desafio.domain.utils.Either
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ImpGetUserRepository @Inject constructor(private val networkDataSource: GetUserNetworkDataSource) : IGetUserRepository{
    override suspend fun getUsers(): Flow<Either<List<User>?, Error>> = flow {
        try {
            networkDataSource.getUserNetwork().let {
                if(it.isSuccessful) {
                    val body: List<UserDTO>? = it.body()
                    emit(Either.success(body?.map { userDTO -> userDTO.toDomainModel() }))
                } else {
                    emit(Either.fail(Error(it.message())))
                }
            }
        } catch (e: Exception) {
            emit(Either.fail(Error(e.message ?: "Exception not identify")))
        }
    }


}