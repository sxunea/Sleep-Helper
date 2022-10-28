package com.example.sleephelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sleephelper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReport.setOnClickListener(){
            intent = Intent(this, ReportActivity::class.java)
            startActivity(intent)
        }

        binding.btnCalendar.setOnClickListener(){
            intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }
    }
}