package one.reevdev.modesense.core.data.feature.askmedicine.repository

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import one.reevdev.medosense.core.common.Result
import one.reevdev.modesense.core.data.feature.askmedicine.gemini.AskMedicineDataSource
import one.reevdev.modesense.core.data.feature.askmedicine.gemini.model.AskMedicineResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AskMedicineRepositoryImpl @Inject constructor(
    private val askMedicineDataSource: AskMedicineDataSource
) : AskMedicineRepository {
    override fun askMedicine(image: Bitmap): Flow<Result<AskMedicineResponse>> = flow {
        emit(Result.Loading())
        try {
            val response = askMedicineDataSource.askMedicineByImage(image)
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}