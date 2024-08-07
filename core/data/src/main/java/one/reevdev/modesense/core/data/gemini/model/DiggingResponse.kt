package one.reevdev.modesense.core.data.gemini.model

data class DiggingResponse(
    val status: String,
    val question: String,
    val illnessAnalysis: IllnessAnalysis? = null
)
