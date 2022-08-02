package com.picpay.desafio.data

import com.picpay.desafio.data.local.datasource.UserLocalDatasource
import com.picpay.desafio.data.local.model.UserEntity
import com.picpay.desafio.data.mapper.toLocalDataModel

class FakeGetEmptyUserLocalDatasource: UserLocalDatasource {

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

class FakeGetUserLocalDatasource: UserLocalDatasource {

    private var listLocal = FakeUserList.getFakeListLocal().map { it.toLocalDataModel() } as ArrayList<UserEntity>


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