package com.example.bmicalculatormvvmhilt.di.module

import com.example.bmicalculatormvvmhilt.viewmodel.BmiViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBmiViewModel(): BmiViewModel = BmiViewModel()
}
