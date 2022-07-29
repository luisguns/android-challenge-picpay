package com.picpay.desafio.domain.di

import com.picpay.desafio.domain.repository.IGetUserRepository
import com.picpay.desafio.domain.usecase.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideUserUseCase(repository: IGetUserRepository) : GetUsersUseCase{
        return GetUsersUseCase(repository)
    }
}