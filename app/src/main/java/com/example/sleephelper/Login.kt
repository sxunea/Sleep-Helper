package com.example.sleephelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 로그인
        val login : Button = findViewById(R.id.btn_login)


        // 회원가입
        val join : Button = findViewById(R.id.btn_join)
        join.setOnClickListener{
            setContentView(R.layout.activity_join)
        }
    }

}