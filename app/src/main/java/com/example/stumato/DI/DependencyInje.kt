package com.example.stumato.DI

import com.example.stumato.Api.TrueCallerApi
import com.example.stumato.data.RepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependencyInje {


    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://oauth-account-noneu.truecaller.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTrueCallerApi (retrofit: Retrofit) : TrueCallerApi{
        return (retrofit.create(TrueCallerApi::class.java))
    }

    @Singleton
    @Provides
    fun provideRepo(api : TrueCallerApi) : RepoImp = RepoImp(api)



}