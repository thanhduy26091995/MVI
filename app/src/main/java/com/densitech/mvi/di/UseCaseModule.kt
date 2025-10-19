package com.densitech.mvi.di

import com.densitech.domain.repository.INoteRepository
import com.densitech.domain.usecase.note.GetAllNotesUseCase
import com.densitech.domain.usecase.note.GetNoteDetailUseCase
import com.densitech.domain.usecase.note.InsertNoteUseCase
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
        return GetAllNotesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetNoteDetailUseCase(repository: INoteRepository): GetNoteDetailUseCase {
        return GetNoteDetailUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideInsertNoteUseCase(repository: INoteRepository): InsertNoteUseCase {
        return InsertNoteUseCase(repository, Dispatchers.IO)
    }

    @Provides
    @Singleton
    fun provideUpdateNoteUseCase(repository: INoteRepository): InsertNoteUseCase {
        return InsertNoteUseCase(repository, Dispatchers.IO)
    }

    @Provides
    @Singleton
    fun provideDeleteNoteUseCase(repository: INoteRepository): InsertNoteUseCase {
        return InsertNoteUseCase(repository, Dispatchers.IO)
    }
}