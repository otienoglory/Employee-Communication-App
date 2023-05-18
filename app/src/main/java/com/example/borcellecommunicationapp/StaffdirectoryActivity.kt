package com.example.borcellecommunicationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast


class StaffdirectoryActivity : AppCompatActivity() {
    lateinit var staff:ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staffdirectory)
        staff=findViewById(R.id.mstaffdirectory)
        staff.setOnItemClickListener { adapterView, view, i, l ->
                val name = adapterView.getItemAtPosition(i).toString()
                Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        }



    }
}
