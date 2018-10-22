package com.example.dell.navigationdrawer.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dell.navigationdrawer.AdapterPeliculas

import com.example.dell.navigationdrawer.R
import com.example.dell.navigationdrawer.modelos.Pelicula
import kotlinx.android.synthetic.main.fragment_lista_peliculas.view.*

class ListaPeliculasFragment : Fragment() {

    var list: ArrayList<Pelicula>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        list = arguments?.getParcelableArrayList("peliculas")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false)
//        cargarDatos(view.listaPeliculas)
        val adapter = AdapterPeliculas(activity?.applicationContext)
        view.listaPeliculas.layoutManager = LinearLayoutManager(context)
        view.listaPeliculas.adapter = adapter
        if (list != null) {
            adapter.addItemList(list!!)
        }
        return view
    }

}
