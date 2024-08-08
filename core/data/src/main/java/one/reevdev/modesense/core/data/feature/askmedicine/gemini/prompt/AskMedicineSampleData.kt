package one.reevdev.modesense.core.data.feature.askmedicine.gemini.prompt

import one.reevdev.modesense.core.data.feature.askmedicine.gemini.model.AskMedicineResponse

object AskMedicineSampleData {

    val askMedicineResponse = AskMedicineResponse(
        medicineName = "Medicine name (example: Paracetamol)",
        purpose = "The purpose (explain comprehensively but easy to understand)",
        medicineDosage = "i.e. 500mg",
        notes = "Notes about the medicine"
    )
}