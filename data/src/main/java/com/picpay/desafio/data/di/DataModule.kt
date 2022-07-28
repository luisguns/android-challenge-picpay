package com.picpay.desafio.data.di

import com.picpay.desafio.data.network.user.GetUserNetworkDataSource
import com.picpay.desafio.data.repository.ImpGetUserRepository
import com.picpay.desafio.domain.repository.IGetUserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideGetUserRepository(userNetworkDataSource: GetUserNetworkDataSource) : IGetUserRepository {
        return ImpGetUserRepository(userNetworkDataSource)
    }
}