package com.dupontandre.footballdata.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.dupontandre.footballdata.room.entities.Competicion

@Dao
interface DaoCompeticion{
    @Query("SELECT * FROM Competicion")
    fun selectAll() : List<Competicion>

    @Insert
    fun insert(competicion: Competicion)

    @Delete
    fun delete(competicion: Competicion)
}