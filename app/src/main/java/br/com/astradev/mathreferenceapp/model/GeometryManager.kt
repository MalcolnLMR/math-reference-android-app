package br.com.astradev.mathreferenceapp.model

import br.com.astradev.mathreferenceapp.model.geometry.GeometryComponent
import br.com.astradev.mathreferenceapp.model.geometry.objects.FormulaNames
import br.com.astradev.mathreferenceapp.model.geometry.objects.getCuboid
import br.com.astradev.mathreferenceapp.model.geometry.objects.getRect

/*
    2d
*   1 Círculo: Raio
    1 Quadrado: Aresta
    2 Retângulo: Base, Altura
    2 Polígono Regular com N Lados: qtdLados, Aresta

    3d
    1 Romboedro: Aresta
    4 Trapezoide Irregular: Aresta A, Aresta B, Aresta C, Aresta D
    3 Cubóide: Altura, Comprimento, Profundidade
* */


fun getGeometryList(): MutableList<GeometryComponent>{
    val geometryComponents = mutableListOf(
        getRect(),
        getCuboid()
    )

    return geometryComponents
}

fun getGeometryComponent(name: String) : GeometryComponent?{
    return getGeometryList().find { it.name == name }
}

fun printAllFormulaResults(obj: GeometryComponent?){
    if(obj == null) return

    for (mathComponent in obj.formulas){
        print("Nome: ${mathComponent.nome} -- Formula: ${mathComponent.formulaText} -- Resultado: ")
        println(mathComponent.formula.invoke(
            mapOf(
                FormulaNames.WIDTH to 2.0,
                FormulaNames.HEIGHT to 2.0
            )
        ))
    }
}