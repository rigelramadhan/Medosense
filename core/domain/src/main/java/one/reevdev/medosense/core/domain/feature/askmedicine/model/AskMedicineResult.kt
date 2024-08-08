package one.reevdev.medosense.core.domain.feature.askmedicine.model

import one.reevdev.medosense.core.common.utils.emptyString

data class AskMedicineResult(
    val medicineName: String = emptyString(),
    val purpose: String = emptyString(),
    val medicineDosage: String = emptyString(),
    val notes: String = emptyString()
)
