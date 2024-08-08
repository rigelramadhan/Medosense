package one.reevdev.modesense.core.data.feature.askmedicine.gemini.model

data class AskMedicineResponse(
    val medicineName: String,
    val purpose: String,
    val medicineDosage: String,
    val notes: String
)
