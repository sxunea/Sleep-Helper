package com.example.sleephelper

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import com.example.sleephelper.databinding.ActivityCalendarBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import java.util.*


class CalendarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCalendarBinding
    private lateinit var chart : LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCalendar()

        binding.calendarView.setOnDayClickListener(OnDayClickListener { eventDay ->
            val clickedDayCalendar = eventDay.calendar

            binding.slidePanel.panelState = SlidingUpPanelLayout.PanelState.ANCHORED

        })

        setChart()

        setBottomNavigation()
        setFabAdd()
    }

    private fun setChart(){
        chart = binding.sleepLineChart


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

    private fun setFabAdd(){
        binding!!.fabAdd.setOnClickListener(){
            intent = Intent(this, WritingDiaryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setBottomNavigation(){
        binding!!.bottomNavigation.setOnItemSelectedListener(){
            when(it.itemId){
                R.id.nav_report -> {
                    intent = Intent(this, ReportActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_alarm -> {
                    intent = Intent(this, RecommendTimeActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_myPage -> {
                    intent = Intent(this, MypageActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }

    private fun setCalendar(){
        val events: MutableList<EventDay> = ArrayList()



        val calendar: Calendar = Calendar.getInstance()
        events.add(EventDay(calendar, R.drawable.emoji_good))


        val calendarView: CalendarView = binding.calendarView as CalendarView
        calendarView.setEvents(events)
    }
}