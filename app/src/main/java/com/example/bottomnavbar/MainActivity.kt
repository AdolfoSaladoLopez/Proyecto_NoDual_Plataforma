package com.example.bottomnavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.databinding.ActivityMainBinding
import com.example.pruebafragment.BlankFragmenPrueba
import com.example.pruebafragment.BlankFragmentPrueba2
import com.google.android.material.bottomnavigation.BottomNavigationMenuView

class MainActivity : AppCompatActivity() {
    private var adapterBandera: CardAdapter? = null
    private var listaProyectos: MutableList<Proyecto> = rellenarProyectos()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cambiaFragment(BlankFragmenPrueba())

        adapterBandera = CardAdapter(this, R.layout.cartas, listaProyectos)

        binding.filtrar.setOnClickListener{
            when(it.id){
                R.id.filtrar -> cambiaFragment(Filtrado_Fragment())
            }
        }

//        val spinner: Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(this, R.array.ubicacion,android.R.layout.simple_spinner_item).also {

            adapterBandera -> adapterBandera.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            //spinner.adapter = adapterBandera
        }


        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                    R.id.item_1 -> cambiaFragment(BlankFragmenPrueba())

                    //R.id.item_2 ->

                    R.id.item_3 -> cambiaFragment(BlankFragmentPrueba2())

                    R.id.item_4 -> cambiaFragment(Perfil_Fragment())

                else -> {

                }

            }

            true
        }
    }


    private fun rellenarProyectos(): MutableList<Proyecto> {
        val listado: MutableList<Proyecto> = mutableListOf()

        for (i in 1..10) {

            listado.add(Proyecto("Proyecto $i"))
        }

        return listado
    }

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