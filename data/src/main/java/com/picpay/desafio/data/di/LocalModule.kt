package com.picpay.desafio.data.di

import android.app.Application
import androidx.room.Room
import com.picpay.desafio.data.local.database.PicPayDatabase
import com.picpay.desafio.data.local.datasource.ImpUserLocalDataSource
import com.picpay.desafio.data.local.datasource.UserLocalDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): PicPayDatabase =
        Room.databaseBuilder(app,
        PicPayDatabase::class.java,
        PicPayDatabase.DATABASE_NAME)
        .build()

    @Provides
    @Singleton
    fun provideUserLocalDatasource(database: PicPayDatabase): UserLocalDatasource {
        return ImpUserLocalDataSource(database)
    }
}