package com.example.app

import com.example.ejemplo_app.Usuario
import java.sql.Timestamp

class Proyecto(
    var id: String,
    var nombre: String,
    var usuarioPropietario: Usuario?,
    var fechaPublicacion: String?,
    var imagen: Int,
    var estado: Boolean,
    var descripcion: String,
    var ubicacion: String,
    var duracion: String,//TODO: elegir si en dias, semanas o meses
    var modoTrabajo: String,
    var idioma: String,
    var numeroParticipantes: Int,
    var tecnologia: String,
    var usuariosInteresados: ArrayList<Usuario>?,
    var usuariosSeleccionados: ArrayList<Usuario>?
) {
    constructor() : this(
        "", "",
        null, null, -1,
        false, "", "", "", "",
        "", -1, "null", null, null
    )


    init {
        usuariosInteresados = ArrayList()
    }
}