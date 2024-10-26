package br.com.astradev.mathreferenceapp.model.geometry.objects

import br.com.astradev.mathreferenceapp.R
import br.com.astradev.mathreferenceapp.model.geometry.GeometryComponent
import br.com.astradev.mathreferenceapp.model.geometry.MathFormula
import kotlin.math.pow
import kotlin.math.sqrt

fun getCuboid(): GeometryComponent{
    return GeometryComponent(
        name = "Cubóide",
        icon = R.drawable.cube,
        formulas = mutableListOf(
            MathFormula(nome = FormulaNames.AREA_3D, formulaText = "2 * (l * w + l * h + w * h)") {
                    data: Map<String, Double> ->
                2 * (data[FormulaNames.WIDTH]!!  * data[FormulaNames.LENGTH]!!  +
                     data[FormulaNames.LENGTH]!! * data[FormulaNames.HEIGHT]!!  +
                     data[FormulaNames.WIDTH]!!  * data[FormulaNames.HEIGHT]!!)
            },
            MathFormula(nome = FormulaNames.DIAGONAL, formulaText = "√(l² + w² + h²)") {
                    data: Map<String, Double> ->
                sqrt((data[FormulaNames.LENGTH]!!.pow(2.0) +
                      data[FormulaNames.WIDTH]!! .pow(2.0) +
                      data[FormulaNames.HEIGHT]!!.pow(2.0)))
            },
            MathFormula(nome = FormulaNames.PERIMETER_3D, formulaText = "4 * (l + w + h)"){
                    data: Map<String, Double> ->
                4 * (data[FormulaNames.LENGTH]!! +
                     data[FormulaNames.WIDTH]!!  +
                     data[FormulaNames.HEIGHT]!!)
            },
            MathFormula(nome = FormulaNames.VOLUME, formulaText = "l * w * h"){
                    data: Map<String, Double> ->
                data[FormulaNames.LENGTH]!! *
                data[FormulaNames.WIDTH]!!  *
                data[FormulaNames.HEIGHT]!!
            },
            MathFormula(nome = FormulaNames.LATERAL_SURFACE, formulaText = "2 * (l * h + w * h)"){
                    data: Map<String, Double> ->
                2 * ((data[FormulaNames.LENGTH]!! * data[FormulaNames.HEIGHT]!!) +
                     (data[FormulaNames.WIDTH]!!  * data[FormulaNames.HEIGHT]!!))
            },
            MathFormula(nome = FormulaNames.SURFACE, formulaText = "2 * (l * w + l * h + w * h)") {
                    data: Map<String, Double> ->
                2 * (data[FormulaNames.WIDTH]!!  * data[FormulaNames.LENGTH]!! +
                     data[FormulaNames.LENGTH]!! * data[FormulaNames.HEIGHT]!! +
                     data[FormulaNames.WIDTH]!!  * data[FormulaNames.HEIGHT]!!)
            }
        ),
        map = {
            mapOf(FormulaNames.WIDTH to 0.0, FormulaNames.HEIGHT to 0.0, FormulaNames.LENGTH to 0.0)
        }
    )
}
