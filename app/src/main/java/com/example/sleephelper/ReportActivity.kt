package com.example.sleephelper

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sleephelper.databinding.ActivityReportBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate


class ReportActivity : AppCompatActivity() {


    //private var sleepDataList: ArrayList<SleepData>? = null
    private var binding: ActivityReportBinding? = null
    private var chart : LineChart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        chart = binding?.sleepLineChart


        val values = ArrayList<Entry>()

        for(i in 1..100){
            var value : Float = Math.random().toFloat()
            values.add(Entry(i.toFloat(), value))
        }

        val set1 = LineDataSet(values, "Sleep Chart")

        val dataSets:ArrayList<ILineDataSet> = ArrayList()
        dataSets.add(set1)

        val data : LineData = LineData(dataSets)

        chart?.legend?.textColor = Color.parseColor("#FCA311")
        chart?.xAxis?.textColor = Color.parseColor("#E5E5E5")
        chart?.axisLeft?.textColor = Color.parseColor("#E5E5E5")
        chart?.axisRight?.textColor = Color.parseColor("#14213D")

        set1.setColor(Color.parseColor("#FCA311"))
        set1.setCircleColor(Color.parseColor("#FCA311"))
        set1.setDrawCircles(false)
        set1.setDrawValues(false)

        chart?.setData(data)
    }
}
