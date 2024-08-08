package one.reevdev.medosense.core.domain.feature.consult.utils

import one.reevdev.medosense.core.domain.feature.consult.model.DiggingResult
import one.reevdev.medosense.core.domain.feature.consult.model.DiggingStatus
import one.reevdev.medosense.core.domain.feature.consult.model.IllnessAnalysis
import one.reevdev.medosense.core.domain.feature.consult.model.MedicineConfirmationResult
import one.reevdev.medosense.core.domain.feature.consult.model.Prescription
import one.reevdev.modesense.core.data.gemini.model.DiggingResponse
import one.reevdev.modesense.core.data.gemini.model.IllnessAnalysisData
import one.reevdev.modesense.core.data.gemini.model.MedicineConfirmationResponse
import one.reevdev.modesense.core.data.gemini.model.PrescriptionData

fun DiggingResponse.toDomain() = DiggingResult(
    status = DiggingStatus.valueOf(status),
    question = question,
    illnessAnalysis = illnessAnalysis?.toDomain()
)

fun IllnessAnalysisData.toDomain() = IllnessAnalysis(
    illness = illness,
    confidenceLevel = confidenceLevel,
    prescription = prescription.map { it.toDomain() }
)

fun PrescriptionData.toDomain() = Prescription(
    medicine = medicine,
    dosage = dosage,
    frequency = frequency,
    duration = duration,
    notes = notes
)

fun MedicineConfirmationResponse.toDomain() = MedicineConfirmationResult(
    response = response,
    isCorrect = isCorrect
)