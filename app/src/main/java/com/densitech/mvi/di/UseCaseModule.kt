package com.densitech.mvi.di

import com.densitech.domain.repository.INoteRepository
import com.densitech.domain.usecase.note.GetAllNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(repository: INoteRepository): GetAllNotesUseCase {
        return GetAllNotesUseCase(repository, Dispatchers.IO)
    }
}