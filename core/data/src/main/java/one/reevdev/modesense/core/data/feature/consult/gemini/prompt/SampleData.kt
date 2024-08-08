package one.reevdev.modesense.core.data.feature.consult.gemini.prompt

import one.reevdev.medosense.core.common.utils.emptyString
import one.reevdev.modesense.core.data.feature.consult.gemini.model.DiggingResponse
import one.reevdev.modesense.core.data.feature.consult.gemini.model.IllnessAnalysisData
import one.reevdev.modesense.core.data.feature.consult.gemini.model.MedicineConfirmationResponse
import one.reevdev.modesense.core.data.feature.consult.gemini.model.PrescriptionData

object SampleData {

    val prescription = PrescriptionData(
        medicine = "Paracetamol",
        dosage = "500mg",
        frequency = "Once a day",
        duration = "3 days",
        notes = "Take with food"
    )

    val illnessAnalysis = IllnessAnalysisData(
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