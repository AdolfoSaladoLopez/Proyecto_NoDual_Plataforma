package com.example.ejemplo_app

import com.example.app.Proyecto

class Usuario(
    var id: String,
    var nombre: String,
    var apellidos: String,
    var email: String,
    var contrasena: String, //TODO hay que cifrarla
    var imagen: Int,
    var descripcion: String,
    var administrador: Boolean,
    var proyectosCreados: ArrayList<Proyecto>?,
    var proyectosInteresados: ArrayList<Proyecto>?,
    var tecnologia: String
) {
    constructor() : this(
        "", "",
        "", "", "",
        -1, "", false, null, null,
        "null"
    )

    init {
        proyectosCreados = ArrayList()
        proyectosInteresados = ArrayList()

    }
}

