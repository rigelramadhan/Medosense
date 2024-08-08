package one.reevdev.modesense.core.data.feature.consult.gemini.model

data class IllnessAnalysisData(
    val illness: String,
    val confidenceLevel: Double,
    val prescription: List<PrescriptionData>
)
