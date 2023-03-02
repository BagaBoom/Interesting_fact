package com.example.interesting_fact_about_numbers

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.location.LocationManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.room.Room.databaseBuilder
import androidx.room.migration.Migration
import com.example.interesting_fact_about_numbers.db.MainDb

public class AppDB : Application() {
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

    public fun getDatabase(): MainDb? {
        return database
    }


}
