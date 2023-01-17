package com.example.ejemplo_app

import com.example.app.Proyecto
import com.example.app.Tecnologia

class Usuario(var id:Int,
              var nombre:String,
              var apellidos:String,
              var email:String,
              var contrasena:String, //TODO hay que cifrarla
              var imagen:Int,
              var descripcion:String,
              var administrador:Boolean,
              var proyectosCreados:ArrayList<Proyecto>,
              var proyectosInteresados:ArrayList<Proyecto>,
              var tecnologias:ArrayList<Tecnologia>
               ) {

    init {
        proyectosCreados = ArrayList()
        proyectosInteresados = ArrayList()
        tecnologias = ArrayList()
    }
}

