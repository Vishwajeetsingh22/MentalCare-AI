package com.aimentalcare.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "check_ins")
data class CheckInEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val timestamp: Long = System.currentTimeMillis(),
    val userText: String,
    val stressLevel: String, // LOW, MODERATE, HIGH, CRITICAL
    val statusDescription: String,
    val stressScore: Int, // 0 - 100
    val confidence: Double,
    val indicatorsCsv: String, // Comma separated indicators
    val isCrisis: Boolean,
    val recommendationsCsv: String // Pipe or semi-colon separated
)
