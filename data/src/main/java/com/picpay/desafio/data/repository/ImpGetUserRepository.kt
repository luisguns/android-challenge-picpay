package com.picpay.desafio.data.repository

import android.util.Log
import com.picpay.desafio.data.local.datasource.UserLocalDatasource
import com.picpay.desafio.data.mapper.toDomainModel
import com.picpay.desafio.data.mapper.toLocalDataModel
import com.picpay.desafio.data.network.datasource.UserNetworkDatasource
import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.repository.IGetUserRepository
import com.picpay.desafio.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class ImpGetUserRepository @Inject constructor(
    private val networkDataSource: UserNetworkDatasource,
    private val localDataSource: UserLocalDatasource) : IGetUserRepository {


    override suspend fun getUsers(): Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading())
            val userList = networkDataSource.getUserNetwork()
            localDataSource.insertUser(userList.map { it.toLocalDataModel() })
            emit(Resource.Success(userList.map { it.toDomainModel() }))
        }
        catch (e: HttpException) {
            Log.e(TAG, "HttpException: ${e.code()}")
            localDataSource.getAllUser()?.let { listUser ->
                emit(Resource.Success(listUser.map { it.toDomainModel() }))
                Log.i(TAG, "HttpException: Get From Cache")
                return@flow
            }
            emit(Resource.Error(e.code().toString() ))
        }
        catch (e: Exception) {
            Log.e(TAG, "Exception: ${e.message}")
            localDataSource.getAllUser()?.let { listUser ->
                emit(Resource.Success(listUser.map { it.toDomainModel() }))
                Log.i(TAG, "Exception: Get From Cache")
                return@flow
            }
            emit(Resource.Error(e.message ?: NOT_IDENTIFY_EXCEPTION))
        }
    }

    companion object {
        const val TAG = "GetUserRepository"
        const val NOT_IDENTIFY_EXCEPTION = "Exception not identify"
    }
}