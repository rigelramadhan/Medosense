package one.reevdev.medosense.core.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.reevdev.medosense.core.domain.feature.askmedicine.usecase.AskMedicineInteractor
import one.reevdev.medosense.core.domain.feature.askmedicine.usecase.AskMedicineUseCase
import one.reevdev.medosense.core.domain.feature.consult.usecase.ConsultInteractor
import one.reevdev.medosense.core.domain.feature.consult.usecase.ConsultUseCase

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun provideConsultUseCase(consultInteractor: ConsultInteractor): ConsultUseCase

    @Binds
    fun provideAskMedicineUseCase(askMedicineInteractor: AskMedicineInteractor): AskMedicineUseCase
}