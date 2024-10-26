package br.com.astradev.mathreferenceapp.model.geometry.objects

import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.model.geometry.GeometryComponent
import br.com.astradev.mathreferenceapp.model.geometry.MathFormula
import kotlin.math.pow
import kotlin.math.sqrt


fun getRect() : GeometryComponent{
    return GeometryComponent(
        name = "Retângulo",
        icon = R.drawable.cube,
        formulas = mutableListOf(
            MathFormula(nome = FormulaNames.AREA_2D, formulaText = "b * h"){
                    data: Map<String, Double> ->
                data[FormulaNames.BASE]!! * data[FormulaNames.HEIGHT]!!
            },
            MathFormula(nome = FormulaNames.PERIMETER_2D, formulaText = "2b + 2h"){
                data: Map<String, Double> ->
                (2 * data[FormulaNames.BASE]!!) + (2 * data[FormulaNames.HEIGHT]!!)
            },
            MathFormula(nome = FormulaNames.DIAGONAL, formulaText = "√(b² + h²)"){
                    data: Map<String, Double> ->
                sqrt((data[FormulaNames.BASE]!!.pow(2) + (data[FormulaNames.BASE]!!.pow(2))))
            }
        ),
        map = {
            mapOf(FormulaNames.BASE to 0.0, FormulaNames.HEIGHT to 0.0)
        }
    )
}