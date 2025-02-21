package com.dev.imuslim.di

import com.dev.imuslim.model.Constance.BASE_URL
import com.dev.imuslim.network.IMuslimApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object IMuslimModule {

    // i need to make instance of my Retrofit
    @Singleton // i need to use this annotation to make just once instance for this lib
    @Provides
    fun provideRetrofitInstanceApi(): IMuslimApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(IMuslimApi::class.java)
    }
}