package com.example.interesting_fact_about_numbers.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "numbers")
data class NumbersFact (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "number")
    var number: String,
    @ColumnInfo(name = "fact")
    var fact: String,
        )
