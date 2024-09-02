package one.reevdev.modesense.core.data.gemini.prompt

import one.reevdev.medosense.core.common.utils.toJson

object InstructionPrompt {

    fun initializeIllnessAnalysisResponse() = """
        From this point on, you will be consulted by the user about his/her illness and medicines. 
        Give response as I instructed.
    """.trimIndent()

    private fun consultationRule() = """
        Example response when enough information:
        ${SampleData.enoughDiggingResponse.toJson()}
        
        Example response when more information is needed:
        ${SampleData.notEnoughDiggingResponse.toJson()}
        
        Make sure to analyze the symptoms carefully and guide the user towards seeking professional medical advice.
    """.trimIndent()

    private fun medConfirmationRule() = """
        Example response when the medicine is correct:
        ${SampleData.medicineConfirmationResponseCorrect.toJson()}
        
        Example response when the medicine is incorrect:
        ${SampleData.medicineConfirmationResponseIncorrect.toJson()}
    """.trimIndent()

    fun initiateConstulation(symptoms: String) = """
        I want you to diagnose a possible illness based on the following symptoms:
        
        1. First, analyze the symptoms and determine if the information is sufficient to make a preliminary diagnosis.
        2. If more information is needed, specify what additional questions should be asked to gather more details (YES/NO QUESTION ONLY).
        3. If the symptoms are enough for a preliminary diagnosis, provide a detailed illness analysis, including possible conditions, recommended actions, and advice. Also give medicines recommendation PLEASE.
        4. Always return the following values in JSON format:
            - "status": "Enough" if you have enough information to diagnose, or "NotEnough" if more information is needed.
            - "question": A follow-up question to ask the patient for further details, or null if no further questioning is required.
            - "illnessAnalysis": A thorough analysis of the illness if the status is "Enough", or null if the status is "NotEnough".
            
        Here's the information provided by the patient:
        Symptoms: "$symptoms"
        
        ${consultationRule()}
    """.trimIndent()

    fun answerQuestion(isYes: Boolean) = """
        The user answered with: ${if (isYes) "yes" else "no"}
        
        If more information is needed, specify what additional questions should be asked to gather more details (YES/NO QUESTION ONLY)
        
        ${consultationRule()}
    """.trimIndent()

    fun medicineImageConfirmation() = """
        The user wants to ask for confirmation about the medicine through an image. Here's the image.
        
        ${medConfirmationRule()}
    """.trimIndent()
}