package com.example.dell.navigationdrawer

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.dell.navigationdrawer.fragments.ListaPeliculasFragment
import com.example.dell.navigationdrawer.fragments.RegisterFragment
import com.example.dell.navigationdrawer.modelos.Pelicula
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener, RegisterFragment.RegistrarPelicula {

    var listPelicula = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            cargarFragment(RegisterFragment())
        } else {
            listPelicula = savedInstanceState.getParcelableArrayList("datosPeliculas")
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                cargarFragment(RegisterFragment())
            }
            R.id.nav_gallery -> {
                val bundle = Bundle()
                bundle.putParcelableArrayList("peliculas", listPelicula)
                val listaPeliculasFragment = ListaPeliculasFragment()
                listaPeliculasFragment.arguments = bundle
                cargarFragment(listaPeliculasFragment)
            }
            R.id.nav_slideshow -> {
            }
            R.id.nav_manage -> {
            }
            R.id.nav_share -> {
            }
            R.id.nav_send -> {
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun cargarFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor, fragment)
                .commit()
    }

    override fun registrar(pelicula: Pelicula) {
        listPelicula.add(pelicula)
        Log.e("MAIN_ACTIVITY", "lista ${listPelicula.size}")
        listPelicula.forEach {
            Log.e("OBJETO_MAIN_ACTIVITY", "objeto $it")
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelableArrayList("datosPeliculas", listPelicula)
    }
}
