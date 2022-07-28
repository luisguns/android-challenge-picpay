package com.picpay.desafio.domain

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<R> {

    suspend fun execute() : Flow<R>

}