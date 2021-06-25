package com.dupontandre.footballdata.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Competicion(
    @PrimaryKey val id : Int,
    @ColumnInfo(name = "nombre") val nombre : String,
    @ColumnInfo(name = "numeroTemporadas") val numeroTemporadas : Int,
)