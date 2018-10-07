package com.akki.cubiclib

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.graphics.Shader
import android.graphics.LinearGradient


class BezierPath : View {

    var path: Path? = null
    var paint: Paint? = null
    var width: Int? = 0
    var height: Int? = 0
    var fillColors = 0
    var curveStartPoint: String? = null
    var curveType: String? = null
    var startColor = 0
    var endColor = 0

    constructor(context: Context) : this(context, null) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    fun init(attrs: AttributeSet?) {
        paint = Paint()
        paint?.style = Paint.Style.FILL
        paint?.strokeWidth = 3f


        path = Path()

        if (attrs == null)
            return

        val a = context.obtainStyledAttributes(attrs, R.styleable.BezierPath, 0, 0)
        fillColors = a.getColor(R.styleable.BezierPath_fill_color, Color.GREEN)
        curveStartPoint = a.getString(R.styleable.BezierPath_curve_start)
        curveType = a.getString(R.styleable.BezierPath_curve_type)
        startColor = a.getColor(R.styleable.BezierPath_start_color, Color.GREEN)
        endColor = a.getColor(R.styleable.BezierPath_end_color, Color.GREEN)

        paint?.color = fillColors
        a.recycle()

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (curveType != null) {
            when (curveType) {
                "bezier" -> {
                    drawBezier(canvas)
                }
                "cubic" -> {
                    drawCubic(canvas)
                }
                "linear" -> {
                    drawLine(canvas)
                }
                else -> {
                    drawCubic(canvas)
                }
            }
        } else {
            drawCubic(canvas)
        }
    }

    private fun drawBezier(canvas: Canvas?) {
        if (curveStartPoint == "right") {
            val curveStarting = measuredHeight * 70 / 100
            val curveEnd = measuredHeight * 30 / 100

            path?.moveTo(measuredWidth.toFloat(), 0f)
            path?.lineTo(measuredWidth.toFloat(), curveStarting.toFloat())
            path?.cubicTo(measuredWidth?.toFloat() - (measuredWidth*20/100).toFloat(), measuredHeight.toFloat(), (measuredWidth*60/100).toFloat(), measuredHeight.toFloat() - 100, 0f, curveEnd.toFloat())
            path?.lineTo(0f, 0f)
            path?.close()
            paint?.shader = LinearGradient(0f, 0f, measuredWidth / 2f, measuredHeight / 2f,startColor,endColor, Shader.TileMode.MIRROR)

            canvas?.drawPath(path, paint)
        } else {
            val curveStarting = measuredHeight * 70 / 100
            val curveEnd = measuredHeight * 30 / 100

            path?.moveTo(0f, 0f)
            path?.lineTo(0f, curveStarting.toFloat())
            path?.cubicTo((measuredWidth*20/100).toFloat(), measuredHeight.toFloat(), (measuredWidth*40/100).toFloat(), measuredHeight.toFloat() - 100, measuredWidth?.toFloat()!!, curveEnd.toFloat())
            path?.lineTo(measuredWidth.toFloat(), 0f)
            path?.close()
            paint?.shader = LinearGradient(0f, 0f, measuredWidth / 2f, measuredHeight / 2f, startColor, endColor, Shader.TileMode.MIRROR)

            canvas?.drawPath(path, paint)
        }
    }

    private fun drawCubic(canvas: Canvas?) {
        val curveStarting = measuredHeight * 50 / 100
        val curveEnd = measuredHeight * 50 / 100
        path?.moveTo(0f, 0f)
        path?.lineTo(0f, curveStarting.toFloat())
        path?.cubicTo(measuredWidth / 4f, measuredHeight.toFloat(), measuredWidth / 2 + measuredWidth / 4f, measuredHeight.toFloat(), measuredWidth.toFloat(), curveEnd.toFloat())
        path?.lineTo(measuredWidth.toFloat(), 0f)
        path?.close()
        paint?.shader = LinearGradient(0f, 0f, measuredWidth / 2f, measuredHeight / 2f, startColor, endColor, Shader.TileMode.CLAMP)
        canvas?.drawPath(path, paint)
    }

    private fun drawLine(canvas: Canvas?) {
        if (curveStartPoint != null) {
            if (curveStartPoint == "left") {
                val curveStarting = measuredHeight * 100 / 100
                val curveEnd = measuredHeight * 35 / 100
                path?.moveTo(0f, 0f)
                path?.lineTo(0f, curveStarting.toFloat())
                path?.lineTo(measuredWidth.toFloat(), curveEnd.toFloat())
                path?.lineTo(measuredWidth.toFloat(), 0f)
                path?.close()
                paint?.shader = LinearGradient(0f, 0f, measuredWidth / 2f, measuredHeight / 2f,startColor, endColor, Shader.TileMode.MIRROR)

                canvas?.drawPath(path, paint)
            } else {
                val curveStarting = measuredHeight * 100 / 100
                val curveEnd = measuredHeight * 35 / 100
                path?.moveTo(measuredWidth.toFloat(), 0f)
                path?.lineTo(measuredWidth.toFloat(), curveStarting.toFloat())
                path?.lineTo(0f, curveEnd.toFloat())
                path?.lineTo(0f, 0f)
                path?.close()
                paint?.shader = LinearGradient(0f, 0f, measuredWidth / 2f, measuredHeight / 2f, startColor, endColor, Shader.TileMode.MIRROR)

                canvas?.drawPath(path, paint)
            }
        } else {
            val curveStarting = measuredHeight * 100 / 100
            val curveEnd = measuredHeight * 35 / 100
            path?.moveTo(0f, 0f)
            path?.lineTo(0f, curveStarting.toFloat())
            path?.lineTo(measuredWidth.toFloat(), curveEnd.toFloat())
            path?.lineTo(measuredWidth.toFloat(), 0f)
            path?.close()
            paint?.shader = LinearGradient(0f, 0f, measuredWidth / 2f, measuredHeight / 2f, Color.BLACK, Color.RED, Shader.TileMode.MIRROR)

            canvas?.drawPath(path, paint)
        }

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val parentWidth = View.MeasureSpec.getSize(widthMeasureSpec)
        val parentHeight = View.MeasureSpec.getSize(heightMeasureSpec)
        var widthMode: Int = MeasureSpec.getMode(widthMeasureSpec)
        width = measuredWidth
        height = measuredHeight

        Log.e("parentWidht", "" + parentWidth + "")
        Log.e("parentHeight", "" + parentHeight + "")
        Log.e("widht", "" + width + "")
        Log.e("height", "" + height + "")

        // var heightMode: Int = MeasureSpec.getMode(heightMeasureSpec)
        when (widthMode) {
            MeasureSpec.AT_MOST -> {
                Log.e("TAG", "matchparent")
            }
            MeasureSpec.EXACTLY -> {
                Log.e("TAG", "exactly$parentWidth")
            }
            MeasureSpec.UNSPECIFIED -> {
                Log.e("TAG", "unspecified")
            }

        }
        this.setMeasuredDimension(parentWidth, parentHeight)
    }
}