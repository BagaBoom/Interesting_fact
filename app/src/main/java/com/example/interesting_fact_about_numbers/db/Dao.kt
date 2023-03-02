package com.example.interesting_fact_about_numbers.db


import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertItem(item: NumbersFact)
    @Query("SELECT * FROM numbers")
    fun getAllItem(): Flow<List<NumbersFact>>

    @Query("SELECT * FROM numbers")
    fun getAllItemNotLive(): List<NumbersFact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: NumbersFact?)

    @Update
    fun update(item: NumbersFact?)

    @Delete
    fun delete(item: NumbersFact?)

    @Query("SELECT * FROM numbers WHERE id =:id")
    fun loadSingle(id: Int): NumbersFact?

    @Query("DELETE FROM numbers")
    fun nukeTable()

}