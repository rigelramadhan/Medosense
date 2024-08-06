package one.reevdev.medosense.feature.consult.navigation

import kotlinx.serialization.Serializable
import one.reevdev.medosense.feature.common.navigation.Route

object ConsultRoutes {

    @Serializable
    data object InputIllness : Route

    @Serializable
    data object Confirmation : Route
}