package one.reevdev.modesense.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.reevdev.modesense.core.data.feature.consult.repository.ConsultRepository
import one.reevdev.modesense.core.data.feature.consult.repository.ConsultRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun provideConsultRepository(consultRepositoryImpl: ConsultRepositoryImpl): ConsultRepository
}