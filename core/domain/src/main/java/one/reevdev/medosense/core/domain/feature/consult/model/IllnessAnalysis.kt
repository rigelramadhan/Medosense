package one.reevdev.medosense.core.domain.feature.consult.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import one.reevdev.medosense.core.common.utils.emptyString

@Parcelize
@Serializable
data class IllnessAnalysis(
    val illness: String = emptyString(),
    val confidenceLevel: Double = 0.0,
    val prescription: List<Prescription> = emptyList()
) : Parcelable
