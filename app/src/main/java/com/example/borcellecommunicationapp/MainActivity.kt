package com.example.borcellecommunicationappapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.borcellecommunicationapp.LoginActivity
import com.example.borcellecommunicationapp.R
import com.example.borcellecommunicationapp.SignupActivity

class MainActivity : AppCompatActivity() {
    lateinit var mbtnsignup:Button
    lateinit var mbtnlogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mbtnsignup=findViewById(R.id.btnRegister)
        mbtnlogin=findViewById(R.id.mBtnRegister)

        mbtnsignup.setOnClickListener {
            val intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }

        mbtnlogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }
    }
}

