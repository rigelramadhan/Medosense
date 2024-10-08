package one.reevdev.modesense.core.data.gemini.model

data class IllnessAnalysisData(
    val illness: String,
    val confidenceLevel: Double,
    val prescription: List<PrescriptionData>
)
