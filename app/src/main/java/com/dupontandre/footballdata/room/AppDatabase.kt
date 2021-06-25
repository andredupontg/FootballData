package com.dupontandre.footballdata.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dupontandre.footballdata.room.dao.DaoCompeticion
import com.dupontandre.footballdata.room.dao.DaoEquipo
import com.dupontandre.footballdata.room.entities.Competicion
import com.dupontandre.footballdata.room.entities.Equipo

@Database(entities = arrayOf(Competicion::class, Equipo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoCompeticion() : DaoCompeticion
    abstract fun daoEquipo() : DaoEquipo
}