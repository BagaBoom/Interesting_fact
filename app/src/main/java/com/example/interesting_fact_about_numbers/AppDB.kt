package com.example.interesting_fact_about_numbers


import android.app.Application
import androidx.room.Room.databaseBuilder
import com.example.interesting_fact_about_numbers.db.MainDb

class AppDB : Application() {
    private var database: MainDb? = null

    companion object {
        lateinit var instance: AppDB
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = databaseBuilder(this, MainDb::class.java, "data")
            .allowMainThreadQueries() //   .addMigrations(ALL_MIGRATIONS)
            .fallbackToDestructiveMigration()
            .build()

    }

    fun getDatabase(): MainDb? {
        return database
    }
}
