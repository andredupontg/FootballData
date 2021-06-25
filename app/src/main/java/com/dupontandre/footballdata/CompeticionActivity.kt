package com.dupontandre.footballdata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.dupontandre.footballdata.room.AppDatabase

class CompeticionActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competicion)
        saveLocalCompeticionRoom()
        mostrarCompeticiones()
    }

    private fun saveLocalCompeticionRoom(){
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "FootballDatabase"
        ).build()
        val daoCompeticion = db.daoCompeticion()
        val competicion = com.dupontandre.footballdata.room.entities.Competicion(
            1,
            "Premier League",
            12
        )
        val hilo  = Thread{
            daoCompeticion.insert(competicion)
        }.start()
    }

    private fun mostrarCompeticiones(){
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "FootballDatabase"
            ).build()
        val hilo = Thread{
            val listaCompeticiones = db.daoCompeticion().selectAll()
            Log.i("CompeticionActivity", listaCompeticiones.size.toString())
            listaCompeticiones.forEach{competicion ->
                Log.i("CompeticionActivity", competicion.nombre)
            }
        }
        hilo.start()
    }
}


