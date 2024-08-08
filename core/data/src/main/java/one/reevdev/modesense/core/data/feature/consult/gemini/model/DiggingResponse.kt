package one.reevdev.modesense.core.data.feature.consult.gemini.model

data class DiggingResponse(
    val status: String,
    val question: String,
    val illnessAnalysis: IllnessAnalysisData? = null
)
