package one.reevdev.modesense.core.data.gemini.model

data class IllnessAnalysis(
    val illness: String,
    val confidenceLevel: Double,
    val prescription: List<Prescription>
)
