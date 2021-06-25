package com.dupontandre.footballdata.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Equipo(
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "nombre") val nombre : String,
    @ColumnInfo(name = "estadio") val estadio : String,
    @ColumnInfo(name = "puntaje") val puntaje : Int
    )

