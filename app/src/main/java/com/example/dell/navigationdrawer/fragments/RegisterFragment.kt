package com.example.dell.navigationdrawer.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dell.navigationdrawer.R
import com.example.dell.navigationdrawer.modelos.Pelicula
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {

    lateinit var registrarPelicula: RegistrarPelicula
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnGuardar.setOnClickListener {
            val nombre = view.nombre.text.toString().trim()
            val etiqueta = view.etiqueta.text.toString()
            val descripcion = view.descripcion.text.toString()
            val sw = view.swStock.isChecked
            Log.e("REGISTER_FRAGMENT", "Datos guardar: $nombre - $etiqueta - $descripcion - $sw")
            val pelicula = Pelicula(nombre, etiqueta, descripcion, sw)
            registrarPelicula.registrar(pelicula)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        registrarPelicula = context as RegistrarPelicula
    }

    interface RegistrarPelicula{
        fun registrar(pelicula: Pelicula)
    }
}

