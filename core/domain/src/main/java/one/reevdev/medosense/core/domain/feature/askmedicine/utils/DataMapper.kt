package one.reevdev.medosense.core.domain.feature.askmedicine.utils

import one.reevdev.medosense.core.domain.feature.askmedicine.model.AskMedicineResult
import one.reevdev.modesense.core.data.feature.askmedicine.gemini.model.AskMedicineResponse

fun AskMedicineResponse.toDomain() = AskMedicineResult(
    medicineName = medicineName,
    purpose = purpose,
    medicineDosage = medicineDosage,
    notes = notes
)