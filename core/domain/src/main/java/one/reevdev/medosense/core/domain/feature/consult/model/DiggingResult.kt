package one.reevdev.medosense.core.domain.feature.consult.model

import one.reevdev.medosense.core.common.utils.emptyString

data class DiggingResult(
    val status: DiggingStatus = DiggingStatus.NotEnough,
    val question: String = emptyString(),
    val illnessAnalysis: IllnessAnalysis? = null
)
