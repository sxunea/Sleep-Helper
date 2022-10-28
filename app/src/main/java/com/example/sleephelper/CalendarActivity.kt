package com.example.sleephelper

import android.R
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
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

        val events: MutableList<EventDay> = ArrayList()

        val calendar: Calendar = Calendar.getInstance()
        events.add(EventDay(calendar, R.drawable.ic_delete))
//or
//or
//or if you want to specify event label color
//or if you want to specify event label color

        val calendarView: CalendarView = binding.calendarView as CalendarView
        calendarView.setEvents(events)


    }
}