package com.example.app

import com.example.ejemplo_app.Usuario
import java.sql.Timestamp

class Proyecto(
    var id: Int,
    var nombre: String,
    var usuarioPropietario: Usuario,
    var fechaPublicacion: Timestamp,
    var imagen: Int,
    var estado: Boolean,
    var descripcion: String,
    var ubicacion: String,
    var duracion: String,//TODO: elegir si en dias, semanas o meses
    var modoTrabajo: String,
    var idioma: String,
    var numeroParticipantes: Int,
    var tecnologias: ArrayList<Tecnologia>,
    var usuariosInteresados: ArrayList<Usuario>,
    var usuariosSeleccionados: ArrayList<Usuario>
) {
    init {
        tecnologias = ArrayList()
        usuariosInteresados = ArrayList()
    }
}

enum class ModoDeTrabajo {
    REMOTO,
    PRESENCIAL,
    MIXTO
}

enum class Estado {
    ABIERTO,
    CERRADO
}

enum class Idioma {
    ESPAÑOL,
    INGLES,
    FRANCES,
    ALEMAN,
    ITALIANO,
    PORTUGUES,
    CHINO,
    OTRO
}

enum class Comunidad {
    ANDALUCIA,
    ARAGON,
    ASTURIAS,
    BALEARES,
    CANARIAS,
    CANTABRIA,
    CASTILLA_LA_MANCHA,
    CASTILLA_Y_LEON,
    CATALUÑA,
    CEUTA,
    EXTREMADURA,
    GALICIA,
    LA_RIOJA,
    MADRID,
    MELILLA,
    MURCIA,
    NAVARRA,
    PAIS_VASCO,
    VALENCIA
}
