package com.example.sleephelper

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.applandeo.materialcalendarview.CalendarView
import com.applandeo.materialcalendarview.EventDay
import com.example.sleephelper.databinding.ActivityCalendarBinding
import java.util.*
import kotlin.collections.ArrayList


class CalendarActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCalendar()

        setBottomNavigation()
        setFabAdd()
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