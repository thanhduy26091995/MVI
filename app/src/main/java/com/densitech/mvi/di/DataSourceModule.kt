package com.densitech.mvi.di

import com.densitech.data.datasource.local.INoteLocalDataSource
import com.densitech.data.datasource.local.NoteLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindLocalNoteDataSource(impl: NoteLocalDataSourceImpl): INoteLocalDataSource
}