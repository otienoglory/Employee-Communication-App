package com.example.borcellecommunicationapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViewsService
import android.widget.TextView


class AbtcompanyActivity : AppCompatActivity() {
lateinit var detail:TextView
lateinit var service: TextView
lateinit var abtser:TextView
lateinit var emp:TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abtcompany)
        detail=findViewById(R.id.mtxtdetails)
        service=findViewById(R.id.mtxtdetailservice)
        abtser=findViewById(R.id.mtxtservices)
        emp=findViewById(R.id.mtxtemployees)

    }
}