package com.aimentalcare.app.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CheckInDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCheckIn(checkIn: CheckInEntity): Long

    @Query("SELECT * FROM check_ins ORDER BY timestamp DESC")
    fun getAllCheckIns(): LiveData<List<CheckInEntity>>

    @Query("SELECT * FROM check_ins ORDER BY timestamp DESC LIMIT 7")
    suspend fun getRecentCheckIns(): List<CheckInEntity>

    @Query("SELECT * FROM check_ins ORDER BY timestamp DESC LIMIT 1")
    fun getLatestCheckIn(): LiveData<CheckInEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStressResult(result: StressResultEntity): Long

    @Query("SELECT * FROM StressResults ORDER BY timestamp DESC")
    fun getAllStressResults(): LiveData<List<StressResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLifestyle(log: LifestyleEntity): Long

    @Query("SELECT * FROM lifestyle_logs ORDER BY timestamp DESC LIMIT 1")
    fun getLatestLifestyle(): LiveData<LifestyleEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrustedContact(contact: TrustedContactEntity): Long

    @Query("SELECT * FROM TrustedContacts LIMIT 1")
    fun getTrustedContact(): LiveData<TrustedContactEntity?>
}
