package com.example.interesting_fact_about_numbers.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NumbersFact::class], version = 14)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): Dao

    companion object{
        fun getDb(context: Context): MainDb {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDb::class.java,
                "NumbersData1.db"
            ).fallbackToDestructiveMigration().build()
        }
    }
}