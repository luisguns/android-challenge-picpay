package com.picpay.desafio.data.local.datasource

import com.picpay.desafio.data.local.database.PicPayDatabase
import com.picpay.desafio.data.local.model.UserEntity
import com.picpay.desafio.data.mapper.toDomainModel
import com.picpay.desafio.data.mapper.toLocalDataModel
import com.picpay.desafio.domain.model.User
import javax.inject.Inject

class ImpUserLocalDataSource (private val database: PicPayDatabase) : UserLocalDatasource{
    override suspend fun insertUser(user: List<UserEntity>) {
        return database.userDao().insertUser(user)
    }

    override suspend fun deleteAllUser() {
        return database.userDao().deleteAllUser()
    }

    override suspend fun getAllUser(): List<UserEntity>? {
        return database.userDao().getAllUser()
    }
}