package com.example.assignment6
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class CricketScoreView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private var runsInEachOver = IntArray(5) //Array containing runs scored in each over
    private val paint = Paint()
    private val path = Path()

    init {
        paint.color = Color.BLUE
        paint.strokeWidth = 5f
        paint.style = Paint.Style.STROKE
        paint.textSize = 40f
        paint.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width
        val height = height

        val xStep = width / (runsInEachOver.size + 1)
        val yStep = height / 10

        //Draw x-axis
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), height.toFloat(), paint)

        //Draw y-axis
        canvas.drawLine(0f, 0f, 0f, height.toFloat(), paint)

        //Draw x-axis labels
        for (i in 1 until runsInEachOver.size + 1) {
            val dotX = i * xStep.toFloat()
            val dotY = height.toFloat()
            canvas.drawText("$i", dotX, height - 50f, paint)
        }

        //Draw y-axis labels
        for (i in 1..10) {
            val dotX = 40f
            val dotY = height - i * yStep.toFloat()
            canvas.drawText("${i * 10}", dotX, dotY + 15f, paint)
        }

        var startX = xStep
        path.reset()

        for (i in runsInEachOver.indices) {
            val runs = runsInEachOver[i]
            val dotX = startX.toFloat()
            val dotY = height - runs * yStep.toFloat()

            if (i == 0) {
                path.moveTo(dotX, dotY)
            } else {
                path.lineTo(dotX, dotY) //Draw a line to the next point
                canvas.drawCircle(dotX, dotY, 5f, paint)
            }

            startX += xStep //to next over
        }

        canvas.drawPath(path, paint) //Draw the polyline
    }

    fun setRuns(runs: IntArray) {
        runsInEachOver = runs
        invalidate() //Redraw
    }
}
