package com.picpay.desafio.data.di

import com.picpay.desafio.data.BuildConfig
import com.picpay.desafio.data.network.PicPayApiService
import com.picpay.desafio.data.network.user.GetUserNetworkDataSource
import com.picpay.desafio.data.network.user.ImplGetUserNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitService(okHttpClient: OkHttpClient) : PicPayApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.API_URL_DATA)
            .client(okHttpClient)
            .build()
            .create(PicPayApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        } else {
            OkHttpClient.Builder().build()
        }
    }

    @Singleton
    @Provides
    fun provideGetUserNetworkDataSource(picPayService: PicPayApiService) : GetUserNetworkDataSource {
        return ImplGetUserNetworkDataSource(picPayService)
    }
}