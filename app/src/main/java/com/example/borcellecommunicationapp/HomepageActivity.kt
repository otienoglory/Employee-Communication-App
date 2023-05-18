package com.example.borcellecommunicationapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class HomepageActivity : AppCompatActivity() {
    lateinit var aboutcompany:Button
    lateinit var staffdirectory:Button
    lateinit var trainingresources:Button
    lateinit var newsandupdates:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        aboutcompany=findViewById(R.id.btnAbout)
        staffdirectory=findViewById(R.id.btnstaff)
        trainingresources=findViewById(R.id.btntrain)
        newsandupdates=findViewById(R.id.btnnews)


        trainingresources.setOnClickListener {
            var tembea = Intent(this,TrainingresourcesActivity::class.java)
            startActivity(tembea)
        }
        aboutcompany.setOnClickListener {
            var intent = Intent(this ,AbtcompanyActivity::class.java)
            startActivity(intent)
        }
        staffdirectory.setOnClickListener {
            var intent = Intent(this,StaffdirectoryActivity::class.java)
            startActivity(intent)
        }


    }
}