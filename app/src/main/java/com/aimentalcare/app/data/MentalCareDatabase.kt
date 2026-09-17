package com.aimentalcare.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        CheckInEntity::class,
        LifestyleEntity::class,
        UserEntity::class,
        StressResultEntity::class,
        TrustedContactEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class MentalCareDatabase : RoomDatabase() {

    abstract fun checkInDao(): CheckInDao

    companion object {
        @Volatile
        private var INSTANCE: MentalCareDatabase? = null

        fun getDatabase(context: Context): MentalCareDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MentalCareDatabase::class.java,
                    "mental_care_db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
