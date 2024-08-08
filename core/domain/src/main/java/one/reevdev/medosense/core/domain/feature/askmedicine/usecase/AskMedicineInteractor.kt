package one.reevdev.medosense.core.domain.feature.askmedicine.usecase

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import one.reevdev.medosense.core.common.Result
import one.reevdev.medosense.core.common.utils.mapFlowData
import one.reevdev.medosense.core.domain.feature.askmedicine.model.AskMedicineResult
import one.reevdev.medosense.core.domain.feature.askmedicine.utils.toDomain
import one.reevdev.modesense.core.data.feature.askmedicine.repository.AskMedicineRepository
import javax.inject.Inject

class AskMedicineInteractor @Inject constructor(
    private val askMedicineRepository: AskMedicineRepository
) : AskMedicineUseCase {
    override fun askMedicine(image: Bitmap): Flow<Result<AskMedicineResult>> {
        return askMedicineRepository.askMedicine(image).mapFlowData {
            it.toDomain()
        }
    }
}