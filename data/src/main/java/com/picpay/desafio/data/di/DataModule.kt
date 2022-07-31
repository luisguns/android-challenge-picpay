package com.picpay.desafio.data.di

import com.picpay.desafio.data.local.datasource.UserLocalDatasource
import com.picpay.desafio.data.network.datasource.UserNetworkDatasource
import com.picpay.desafio.data.repository.ImpGetUserRepository
import com.picpay.desafio.domain.repository.IGetUserRepository
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
    fun provideGetUserRepository(userNetworkDataSource: UserNetworkDatasource, userLocalDatasource: UserLocalDatasource) : IGetUserRepository {
        return ImpGetUserRepository(userNetworkDataSource, userLocalDatasource)
    }
}