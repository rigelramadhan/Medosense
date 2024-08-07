package one.reevdev.modesense.core.data.gemini.prompt

import one.reevdev.medosense.core.common.utils.emptyString
import one.reevdev.modesense.core.data.gemini.model.DiggingResponse
import one.reevdev.modesense.core.data.gemini.model.IllnessAnalysis
import one.reevdev.modesense.core.data.gemini.model.MedicineConfirmationResponse
import one.reevdev.modesense.core.data.gemini.model.Prescription

object SampleData {

    val prescription = Prescription(
        medicine = "Paracetamol",
        dosage = "500mg",
        frequency = "Once a day",
        duration = "3 days",
        notes = "Take with food"
    )

    val illnessAnalysis = IllnessAnalysis(
        illness = "Influenza",
        confidenceLevel = 0.95,
        prescription = listOf(prescription)
    )

    val notEnoughDiggingResponse = DiggingResponse(
        status = "NotEnough",
        question = "Can you describe when the symptoms started and if they have changed over time?",
        illnessAnalysis = null
    )

    val enoughDiggingResponse = DiggingResponse(
        status = "Enough",
        question = emptyString(),
        illnessAnalysis = illnessAnalysis
    )

    val medicineConfirmationResponseCorrect = MedicineConfirmationResponse(
        response = "This is the analysis result of the image",
        isCorrect = true
    )

    val medicineConfirmationResponseIncorrect = MedicineConfirmationResponse(
        response = "This is the analysis result of the image",
        isCorrect = false
    )
}