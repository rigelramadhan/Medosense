package one.reevdev.medosense.core.domain.feature.consult.model

data class IllnessAnalysis(
    val illness: String,
    val confidenceLevel: Double,
    val prescription: List<Prescription>
)
