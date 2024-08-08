package one.reevdev.medosense.core.domain.feature.consult.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Prescription(
    val medicine: String,
    val dosage: String,
    val frequency: String,
    val duration: String,
    val notes: String
) : Parcelable