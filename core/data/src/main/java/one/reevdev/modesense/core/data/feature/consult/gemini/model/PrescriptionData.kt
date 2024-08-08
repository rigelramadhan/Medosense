package one.reevdev.modesense.core.data.feature.consult.gemini.model

data class PrescriptionData(
    val medicine: String,
    val dosage: String,
    val frequency: String,
    val duration: String,
    val notes: String
)