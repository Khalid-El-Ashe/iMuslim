package com.dev.imuslim.di

import com.dev.imuslim.model.Constance.BASE_URL
import com.dev.imuslim.network.IMuslimApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object IMuslimModule {

    /** i need to make instance of my Retrofit */
    @Singleton
    @Provides
    fun provideRetrofitInstanceApi(): IMuslimApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create()
    }
}