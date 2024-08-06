package one.reevdev.medosense.core.domain.feature.consult.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class IllnessAnalysis(
    val illness: String,
    val confidenceLevel: Double,
    val prescription: List<Prescription>
) : Parcelable
