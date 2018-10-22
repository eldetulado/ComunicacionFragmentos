package com.example.dell.navigationdrawer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dell.navigationdrawer.modelos.Pelicula
import kotlinx.android.synthetic.main.item_pelicula.view.*

class AdapterPeliculas(val context: Context?) : RecyclerView.Adapter<AdapterPeliculas.ViewHolder>() {
    private val list = ArrayList<Pelicula>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_pelicula, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = list[position]
        holder.nombre.text = pelicula.nombre
        holder.descripcion.text = pelicula.descripcion
        if (context != null) {
            if (pelicula.stock)
                holder.cardview.setCardBackgroundColor(context.resources.getColor(R.color.colorAccent))
            else
                holder.cardview.setCardBackgroundColor(context.resources.getColor(android.R.color.white))
        }
    }

    fun addItem(pelicula: Pelicula) {
        list.add(pelicula)
        notifyItemInserted(list.size - 1)
    }

    fun addItemList(lista: ArrayList<Pelicula>) {
        list.addAll(lista)
        notifyDataSetChanged()
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.nombrePelicula
        val descripcion = view.descripcionPelicula
        val cardview = view.cardView
    }
}