package br.com.astradev.mathreferenceapp.model.geometry

import androidx.annotation.DrawableRes


data class GeometryComponent(
    val name: String,
    @DrawableRes val icon: Int,
    val formulas: MutableList<MathFormula>,
    val map: () -> Map<String, Double>
)