package com.radzhabov.sportsoccer.main.di

import com.radzhabov.sportsoccer.main.data.remote.FootballApi
import com.radzhabov.sportsoccer.main.domain.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideFootballApi(retrofit: Retrofit): FootballApi =
        retrofit.create(FootballApi::class.java)
}