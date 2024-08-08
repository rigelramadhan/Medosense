package one.reevdev.modesense.core.data.feature.askmedicine.repository

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import one.reevdev.medosense.core.common.Result
import one.reevdev.modesense.core.data.feature.askmedicine.gemini.model.AskMedicineResponse

interface AskMedicineRepository {

    fun askMedicine(image: Bitmap): Flow<Result<AskMedicineResponse>>
}