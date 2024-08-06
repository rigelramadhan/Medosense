package one.reevdev.medosense.feature.consult.navigation

import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import one.reevdev.medosense.core.domain.feature.consult.model.IllnessAnalysis
import one.reevdev.medosense.feature.common.navigation.Route

object ConsultRoutes {

    @Serializable
    data object InputIllness : Route

    @Serializable
    data object Confirmation : Route

    @Serializable
    data object IllnessRouter : Route

    @Serializable
    data class AnalysisResult(val analysis: IllnessAnalysis) : Route
}

val AnalysisResultParameterType = object : NavType<IllnessAnalysis>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): IllnessAnalysis? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, IllnessAnalysis::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): IllnessAnalysis {
        return Json.decodeFromString(IllnessAnalysis.serializer(), value)
    }

    override fun put(bundle: Bundle, key: String, value: IllnessAnalysis) {
        bundle.putParcelable(key, value)
    }

}