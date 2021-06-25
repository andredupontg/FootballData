package com.dupontandre.footballdata.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dupontandre.footballdata.room.entities.Equipo

@Dao
interface DaoEquipo {
    @Query("SELECT * FROM Equipo")
    fun selectAll() : List<Equipo>

    @Insert
    fun insert(equipo: Equipo)

    @Delete
    fun delete(equipo: Equipo)
}