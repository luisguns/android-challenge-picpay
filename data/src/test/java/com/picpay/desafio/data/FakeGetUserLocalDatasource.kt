package com.picpay.desafio.data

import com.picpay.desafio.data.local.datasource.UserLocalDatasource
import com.picpay.desafio.data.local.model.UserEntity

class FakeGetUserLocalDatasource: UserLocalDatasource {

    var listLocal = ArrayList<UserEntity>()


    override suspend fun insertUser(user: List<UserEntity>) {
        listLocal.addAll(user)
    }

    override suspend fun deleteAllUser() {
        listLocal = emptyList<UserEntity>() as ArrayList<UserEntity>
    }

    override suspend fun getAllUser(): List<UserEntity>? {
        return if (listLocal.isEmpty()) null else listLocal
    }
}