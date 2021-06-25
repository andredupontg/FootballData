package com.dupontandre.footballdata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.dupontandre.footballdata.room.AppDatabase

class EquipoActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipo)
        saveLocalEquipoRoom()
        mostrarEquipos()
    }

    private fun saveLocalEquipoRoom(){
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "FootballDatabase"
        ).build()
        val daoEquipo = db.daoEquipo()
        val equipo = com.dupontandre.footballdata.room.entities.Equipo(
            1,
            "Chelsea",
            "Stamford Bridge",
            12
        )
        val hilo  = Thread{
            daoEquipo.insert(equipo)
        }.start()
    }

    private fun mostrarEquipos(){
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "FootballDatabase"
        ).build()
        val hilo = Thread{
            val listaEquipos = db.daoEquipo().selectAll()
            Log.i("EquipoActivity", listaEquipos.size.toString())
            listaEquipos.forEach{equipo ->
                Log.i("EquipoActivity", equipo.nombre)
            }
        }
        hilo.start()
    }
}

