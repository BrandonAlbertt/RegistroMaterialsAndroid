package com.example.diseo.entidad

data class Docente(
    var idE: Int = 0,
    var nombreE: String = "",
    var paternoE: String = "",
    var maternoE: String = "",
    var generoE: String = "",
    var sueldoE: Double = 0.0,
    var hijosE: Int = 0
)
