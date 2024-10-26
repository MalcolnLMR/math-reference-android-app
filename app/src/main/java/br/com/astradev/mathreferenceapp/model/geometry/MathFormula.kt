package br.com.astradev.mathreferenceapp.model.geometry

data class MathFormula(
    val nome: String,
    val formulaText: String,
    val formula: (Map<String, Double>) -> Double
)

data class MathFormula2(
    val nome: String,
    val formulaText: String,
    val formula: () -> Double
)
