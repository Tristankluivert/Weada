package com.kluivert.weada.db.database

import android.content.Context
import androidx.room.*
import com.kluivert.weada.db.dao.CurrentWeatherDao
import com.kluivert.weada.db.dao.WeatherLocationDao
import com.kluivert.weada.db.entity.CurrentWeatherEntry
import com.kluivert.weada.db.entity.WeatherLocation
import com.kluivert.weada.utils.Converters


@Database(entities = [CurrentWeatherEntry::class, WeatherLocation::class], version = 1)
@TypeConverters(value = [(Converters::class)])
abstract class WeadaDatabase : RoomDatabase() {

    abstract fun currentWeatherDao(): CurrentWeatherDao
    abstract fun weatherLocationDao(): WeatherLocationDao

    companion object {
        @Volatile
        private var instance: WeadaDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                WeadaDatabase::class.java,
                "forecast.db"
            ).build()
    }
}