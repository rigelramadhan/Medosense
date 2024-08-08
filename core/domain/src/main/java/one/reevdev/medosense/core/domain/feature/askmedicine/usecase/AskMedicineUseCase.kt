package one.reevdev.medosense.core.domain.feature.askmedicine.usecase

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import one.reevdev.medosense.core.common.Result
import one.reevdev.medosense.core.domain.feature.askmedicine.model.AskMedicineResult

interface AskMedicineUseCase {

    fun askMedicine(image: Bitmap): Flow<Result<AskMedicineResult>>
}