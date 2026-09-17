package com.aimentalcare.app.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class StressChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var scores: List<Int> = listOf(35, 48, 62, 71, 79, 84, 65)
    private val days = listOf("M", "T", "W", "T", "F", "S", "S")

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#0F766E")
        strokeWidth = 6f
        style = Paint.Style.STROKE
    }

    private val dotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#0F766E")
        style = Paint.Style.FILL
    }

    private val gridPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#E2E8F0")
        strokeWidth = 2f
        pathEffect = DashPathEffect(floatArrayOf(10f, 10f), 0f)
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#52796F")
        textSize = 32f
        textAlign = Paint.Align.CENTER
    }

    fun setScores(newScores: List<Int>) {
        if (newScores.isNotEmpty()) {
            this.scores = newScores
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val w = width.toFloat()
        val h = height.toFloat()

        val paddingLeft = 80f
        val paddingBottom = 60f
        val paddingTop = 40f
        val paddingRight = 40f

        val graphWidth = w - paddingLeft - paddingRight
        val graphHeight = h - paddingTop - paddingBottom

        // Draw horizontal grid lines for 20, 40, 60, 80, 100
        val levels = listOf(20, 40, 60, 80, 100)
        for (lvl in levels) {
            val y = paddingTop + graphHeight * (1f - (lvl / 100f))
            canvas.drawLine(paddingLeft, y, w - paddingRight, y, gridPaint)
        }

        val count = scores.size.coerceAtMost(7)
        val stepX = graphWidth / (count - 1).coerceAtLeast(1)

        val path = Path()
        val points = mutableListOf<PointF>()

        for (i in 0 until count) {
            val cx = paddingLeft + i * stepX
            val cy = paddingTop + graphHeight * (1f - (scores[i] / 100f))
            points.add(PointF(cx, cy))

            if (i == 0) {
                path.moveTo(cx, cy)
            } else {
                path.lineTo(cx, cy)
            }

            // Draw Day text label
            val dayText = if (i < days.size) days[i] else "D${i+1}"
            canvas.drawText(dayText, cx, h - 10f, textPaint)
        }

        // Draw trend line
        canvas.drawPath(path, linePaint)

        // Draw points and values
        for (i in points.indices) {
            val p = points[i]
            canvas.drawCircle(p.x, p.y, 10f, dotPaint)
            
            // Draw value text
            val scoreText = "${scores[i]}%"
            canvas.drawText(scoreText, p.x, p.y - 18f, textPaint)
        }
    }
}
