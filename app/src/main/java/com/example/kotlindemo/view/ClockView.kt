package com.example.kotlindemo.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.*
import kotlin.math.min


/**
 * 自定义的 时钟
 */
class ClockView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    // 时针宽度
    private val mHourPointWidth = 15f

    // 分针宽度
    private val mMinutePointWidth = 10f

    // 秒针宽度
    private val mSecondPointWidth = 4f

    // 指针矩形弧度
    private val mPointRange = 20F


    //默认的圆的半径
    private var radius = 300.0f


    //view的宽度
    private var mWidth = 0

    //view的 高度
    private var mHeight = 0

    //表盘的宽度
    private val mCircleWidth = 4.0f

    // 设置表盘整点刻度尺寸
    private val scaleMax = 50

    // 设置表盘非整点刻度尺寸
    private val scaleMin = 25

    // 刻度与数字间距
    private val mNumberSpace = 10f


    //画笔
    private val mPaint: Paint by lazy {
        Paint()
    }

    //矩形
    private val mRect: Rect by lazy {
        Rect()
    }

    init {
        mPaint.textSize = 35F
        mPaint.typeface = Typeface.DEFAULT_BOLD
        mPaint.isAntiAlias = true
    }

    /**
     * 测量
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = onMeasuredSpec(widthMeasureSpec) + (mCircleWidth * 2).toInt()
        mHeight = onMeasuredSpec(heightMeasureSpec) + (mCircleWidth * 2).toInt()
        radius = (mWidth - mCircleWidth * 2) / 2
        setMeasuredDimension(mWidth, mHeight)

    }

    /**
     * 计算
     */

    fun onMeasuredSpec(measureSpec: Int): Int {
        var specViewSize = 0
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        when (specMode) {
            MeasureSpec.EXACTLY -> {
                specViewSize = specSize
            }
            MeasureSpec.AT_MOST -> {
                //计算宽高以最小值 做半径
                specViewSize = min((radius * 2).toInt(), specSize)
            }
        }
        return specViewSize
    }


    /**
     * 进行绘制
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //设置圆心X轴位置
        val centerX: Float = (mWidth / 2).toFloat()
        //设置圆心Y轴的位置
        val centerY: Float = (mHeight / 2).toFloat()

        canvas?.translate(centerX, centerY)
        //1、绘制最外层的圆
        drawClock(canvas)
        //2、表盘 60个刻度 1到12点整数 属于长刻度 ,其余属于段刻度
        drawClockScale(canvas)
        //3、绘制指针
        drawPointer(canvas)
        postInvalidateDelayed(1000)


    }

    //绘制外层圆
    private fun drawClock(canvas: Canvas?) {
        //设置外层圆画笔宽度
        mPaint.strokeWidth = mCircleWidth
        //设置 画笔颜色
        mPaint.color = Color.BLACK
        //设置 画笔空心风格
        mPaint.style = Paint.Style.STROKE
        //绘制圆方法
        canvas?.drawCircle(0f, 0f, radius, mPaint)

    }

    //
    private fun drawClockScale(canvas: Canvas?) {

        for (index in 1..60) {
            //刻度绘制 以12点钟为准 每次将表盘旋转 6度 后续绘制都以12点钟为基准绘制
            canvas?.rotate(6f, 0f, 0f)
            //绘制长刻度线
            if (index % 5 == 0) {
                //设置 长刻度画笔宽度
                mPaint.strokeWidth = 4.0f
                //绘制刻度线
                canvas?.drawLine(0F, -radius, 0f, -radius + scaleMax, mPaint)
                //绘制文本
                canvas?.save()
                //设置画笔宽度
                mPaint.style = Paint.Style.FILL
                mPaint.getTextBounds(
                        (index / 5).toString(), 0, (index / 5).toString().length, mRect
                )

                canvas?.translate(0f, -radius + mNumberSpace + scaleMax + (mRect.height() / 2))
                canvas?.rotate((index * -6).toFloat())
                canvas?.drawText((index / 5).toString(), -mRect.width() / 2.toFloat(), mRect.height().toFloat() / 2, mPaint)
                canvas?.restore()


                //绘制短刻度线
            } else {
                //设置短刻度画笔宽度
                mPaint.strokeWidth = 2.0f
                canvas?.drawLine(0f, -radius, 0f, -radius + scaleMin, mPaint)

            }
        }

    }

    //
    private fun drawPointer(canvas: Canvas?) {

        // 获取当前时间：时分秒
        val calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR]
        val minute = calendar[Calendar.MINUTE]
        val second = calendar[Calendar.SECOND]
        // 计算时分秒转过的角度
        val angleHour = (hour + minute.toFloat() / 60) * 360 / 12
        val angleMinute = (minute + second.toFloat() / 60) * 360 / 60
        val angleSecond = second * 360 / 60

        // 绘制时针
        canvas?.save()
        // 旋转到时针的角度
        canvas?.rotate(angleHour, 0F, 0F)
        val rectHour = RectF(
                -mHourPointWidth / 2,
                -radius / 2,
                mHourPointWidth / 2,
                radius / 6
        )
        // 设置时针画笔属性
        mPaint.color = Color.GREEN
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = mHourPointWidth
        canvas?.drawRoundRect(rectHour, mPointRange, mPointRange, mPaint)
        canvas?.restore()

        // 绘制分针
        canvas?.save()
        // 旋转到分针的角度
        canvas?.rotate(angleMinute, 0F, 0F)
        val rectMinute = RectF(
                -mMinutePointWidth / 2,
                -radius * 3.5f / 5,
                mMinutePointWidth / 2,
                radius / 6
        )
        // 设置分针画笔属性
        mPaint.color = Color.BLACK
        mPaint.strokeWidth = mMinutePointWidth
        canvas?.drawRoundRect(rectMinute, mPointRange, mPointRange, mPaint)
        canvas?.restore()

        // 绘制秒针
        canvas?.save()
        // 旋转到分针的角度
        canvas?.rotate(angleSecond.toFloat(), 0F, 0F)
        val rectSecond = RectF(
                -mSecondPointWidth / 2,
                -radius + 10,
                mSecondPointWidth / 2,
                radius / 6
        )
        // 设置秒针画笔属性
        mPaint.strokeWidth = mSecondPointWidth
        mPaint.color = Color.RED
        canvas?.drawRoundRect(rectSecond, mPointRange, mPointRange, mPaint)
        canvas?.restore()

        // 绘制原点
        mPaint.style = Paint.Style.FILL
        canvas?.drawCircle(
                0F,
                0F, mSecondPointWidth * 4, mPaint
        )
    }
}
