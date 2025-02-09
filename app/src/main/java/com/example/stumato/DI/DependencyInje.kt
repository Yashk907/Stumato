package com.example.stumato.DI

import com.example.stumato.data.RepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependencyInje {

    @Singleton
    @Provides
    fun provideRepo() : RepoImp = RepoImp()
}