package com.example.bottomnavbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.app.Proyecto
import com.example.bottomnavbar.databinding.ActivityMainBinding
import com.example.pruebafragment.BlankFragmenPrueba
import com.example.pruebafragment.BlankFragmentPrueba2
import java.lang.System.currentTimeMillis

class MainActivity : AppCompatActivity() {
  //  private var adapterBandera: CardAdapter? = null
   // private var listaProyectos: MutableList<Proyecto> = rellenarProyectos()
    private lateinit var binding: ActivityMainBinding


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cambiaFragment(BlankFragmenPrueba())

    //    adapterBandera = CardAdapter(this, R.layout.cartas, listaProyectos)

        binding.filtrar.setOnClickListener{
            when(it.id){
                R.id.filtrar -> cambiaFragment(Filtrado_Fragment())
            }
        }


            val spinner = findViewById<Spinner>(R.id.spinner)
           // val tecnologias  = findViewById<Spinner>(R.id.tecnologia_nuevoProyecto)
            //val idiomas  = findViewById<Spinner>(R.id.idioma_nuevoProyecto)
            //val tiempo = findViewById<Spinner>(R.id.tipo)


            val lista = resources.getStringArray(R.array.ubicacion)
            val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,lista)

            spinner.adapter = adaptador


        ArrayAdapter.createFromResource(this, R.array.ubicacion,android.R.layout.simple_spinner_item).also {

            adapterBandera -> adapterBandera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

         //   spinner.adapter = adapterBandera
        }


        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                    R.id.item_1 -> cambiaFragment(BlankFragmenPrueba())

                    R.id.item_2 -> cambiaFragment(nuevo_proyecto_fragment())

                    R.id.item_3 -> cambiaFragment(BlankFragmentPrueba2())

                    R.id.item_4 -> cambiaFragment(Perfil_Fragment())

                else -> {

                }

            }

            true
        }

        R.id.nuevo
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.cambiar_imagen ->{}

            R.id.crear ->{

                if(R.id.nombre_nuevoProyecto != null && R.id.ubicacion_nuevoProyecto != null &&
                    R.id.cantidad_nuevoProyecto != 0 && R.id.descripcion_nuevoProyecto != null &&
                    R.id.tecnologia_nuevoProyecto != null && R.id.idioma_nuevoProyecto != null &&
                    R.id.numero_tiempo != null && R.id.tipo != null &&
                    ((R.id.nuevo != null && R.id.empezado == null) || (R.id.nuevo == null && R.id.empezado != null))
                    && ((R.id.presencial_modo_nuevoProyecto != null && R.id.teletrabajo_modo_nuevoProyecto == null) ||
                            (R.id.presencial_modo_nuevoProyecto == null && R.id.teletrabajo_modo_nuevoProyecto != null))){

                        var nombreProyecto = R.id.nombre_nuevoProyecto.toString()
                        var ubicacionProyecto = R.id.ubicacion_nuevoProyecto.toString()
                        var cantidadProyecto = R.id.cantidad_nuevoProyecto
                        var descripcionProyecto = R.id.descripcion_nuevoProyecto.toString()
                        var tecnologiaProyecto = R.id.tecnologia_nuevoProyecto.toString()
                        var idiomaProyecto = R.id.idioma_nuevoProyecto.toString()
                        var estado = R.id.estado_nuevoProyecto
                        var fechaActual = currentTimeMillis().toString()
                        var tiempo = R.id.numero_tiempo.toString() + " " + R.id.tipo.toString()
                        if(R.id.nuevo != null) {
                            var localizacion = "Nuevo"
                        }
                        else{
                            var localizacion = "Empezado"
                        }
                        if(R.id.presencial_modo_nuevoProyecto != null){
                          var modo = "Presencial"
                        }
                        else{
                            var modo = "Telematico"
                        }

                        var proyecto : Proyecto

                        proyecto = Proyecto("", nombreProyecto,
                            null, fechaActual, -1,
                            false, descripcionProyecto, ubicacionProyecto, tiempo, "Telematico",
                            idiomaProyecto, cantidadProyecto, tecnologiaProyecto, null, null)

                }
            }
        }




        return true
    }


   // private fun rellenarProyectos(): MutableList<Proyecto> {
   //     val listado: MutableList<Proyecto> = mutableListOf()

   //     for (i in 1..10) {

   //         listado.add(Proyecto("Proyecto $i")
   //     }

   //     return listado
   // }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_navigation_menu, menu)
        return true
    }


    private fun cambiaFragment(fragment: Fragment) {

        val fragmento = supportFragmentManager
        val transaccion = fragmento.beginTransaction()

        transaccion.replace(R.id.contenedor, fragment)
        transaccion.addToBackStack(null)
        transaccion.commit()


    }
}