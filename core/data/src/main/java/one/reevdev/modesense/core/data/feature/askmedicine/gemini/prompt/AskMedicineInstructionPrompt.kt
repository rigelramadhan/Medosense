package one.reevdev.modesense.core.data.feature.askmedicine.gemini.prompt

object AskMedicineInstructionPrompt {

    fun askMedicineByImage() = """
        I want you to tell me what medicine is in the picture sent.
        
        Please ensure the output is structured and formatted as JSON (WITHOUT ANY FORMATTING PLEASE).
        
        Example response:
        ${AskMedicineSampleData.askMedicineResponse}
    """.trimIndent()
}