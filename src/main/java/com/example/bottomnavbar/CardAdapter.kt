package com.example.bottomnavbar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CardAdapter(
    var context: Context?,
    var textViewResourceId: Int,
    var elementos: MutableList<Proyecto>?
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var vista = convertView
        val holder: ViewHolder
        if (vista == null) {
            val vi = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            vista = vi.inflate(R.layout.cartas, null)
            holder = ViewHolder()
            holder.texto = vista.findViewById<View>(R.id.descripcion) as TextView

            vista.tag = holder
        } else {
            holder = vista.tag as ViewHolder
        }
        val proyecto = elementos!![position]

        if (proyecto != null) {
            holder.texto.text = proyecto.texto
        }
        return vista
    }

    override fun getCount(): Int {
        return elementos!!.size
    }

    override fun getItem(position: Int): Proyecto {
        return elementos!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    internal class ViewHolder {
        lateinit var texto: TextView
    }
}