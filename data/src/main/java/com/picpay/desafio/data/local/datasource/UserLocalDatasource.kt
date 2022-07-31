package com.picpay.desafio.data.local.datasource


import com.picpay.desafio.data.local.model.UserEntity
import com.picpay.desafio.domain.model.User

interface UserLocalDatasource {

    suspend fun insertUser(user: List<UserEntity>)
    suspend fun deleteAllUser()
    suspend fun getAllUser(): List<UserEntity>?
}