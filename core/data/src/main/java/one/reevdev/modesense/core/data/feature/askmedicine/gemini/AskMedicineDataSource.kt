package one.reevdev.modesense.core.data.feature.askmedicine.gemini

import android.graphics.Bitmap
import one.reevdev.modesense.core.data.feature.askmedicine.gemini.api.AskMedicineGeminiApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AskMedicineDataSource @Inject constructor(
    private val askMedicineGeminiApi: AskMedicineGeminiApi
) {

    suspend fun askMedicineByImage(image: Bitmap) = askMedicineGeminiApi.askMedicineByImage(image)
}