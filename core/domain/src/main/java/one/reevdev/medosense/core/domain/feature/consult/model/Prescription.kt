package one.reevdev.medosense.core.domain.feature.consult.model

data class Prescription(
    val medicine: String,
    val dosage: String,
    val frequency: String,
    val duration: String,
    val notes: String
)