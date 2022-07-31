package com.picpay.desafio.domain.repository

import com.picpay.desafio.domain.model.User
import com.picpay.desafio.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IGetUserRepository {
    suspend fun getUsers() : Flow<Resource<List<User>>>
}