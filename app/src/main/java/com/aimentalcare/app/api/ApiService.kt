package com.aimentalcare.app.api

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

data class TextAnalyzeRequest(
    val text: String,
    @SerializedName("sleep_hrs")
    val sleepHrs: Float? = null,
    @SerializedName("work_hrs")
    val workHrs: Float? = null,
    @SerializedName("exercise_mins")
    val exerciseMins: Int? = null
)

data class TextAnalyzeResponse(
    val text: String,
    @SerializedName("stress_level")
    val stressLevel: String,
    @SerializedName("status_description")
    val statusDescription: String,
    @SerializedName("stress_score")
    val stressScore: Int,
    val confidence: Double,
    val indicators: List<String>,
    @SerializedName("is_crisis")
    val isCrisis: Boolean,
    val recommendations: List<String>
)

data class BurnoutRequest(
    val scores: List<Int>
)

data class BurnoutResponse(
    @SerializedName("burnout_risk")
    val burnoutRisk: String,
    @SerializedName("is_burnout_pattern")
    val isBurnoutPattern: Boolean,
    @SerializedName("trend_message")
    val trendMessage: String,
    @SerializedName("average_score")
    val averageScore: Double,
    val recommendations: List<String>
)

interface ApiService {
    @POST("api/analyze_text")
    suspend fun analyzeText(@Body request: TextAnalyzeRequest): Response<TextAnalyzeResponse>

    @POST("api/analyze_burnout")
    suspend fun analyzeBurnout(@Body request: BurnoutRequest): Response<BurnoutResponse>
}
