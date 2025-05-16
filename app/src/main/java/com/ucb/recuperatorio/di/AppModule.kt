package com.ucb.recuperatorio.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.ucb.data.ILocalRecordatorioDataSource
import com.ucb.data.RecordatorioRepository
import com.ucb.framework.recordatoriosF.RecordatoriosLocalDataSource
import com.ucb.usecase.RegistrarRecordatorio

@Module
@InstallIn(SingletonComponent::class)
object RecordatorioModule {

    @Provides
    fun provideLocalDataSource(@ApplicationContext context: Context): ILocalRecordatorioDataSource {
        return RecordatoriosLocalDataSource(context)
    }

    @Provides
    fun provideRepository(local: ILocalRecordatorioDataSource): RecordatorioRepository {
        return RecordatorioRepository(local)
    }

    @Provides
    fun provideUseCase(repository: RecordatorioRepository): RegistrarRecordatorio {
        return RegistrarRecordatorio(repository)
        }
}
