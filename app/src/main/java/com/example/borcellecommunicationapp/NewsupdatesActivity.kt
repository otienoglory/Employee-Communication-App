package com.example.borcellecommunicationapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView


class NewsupdatesActivity : AppCompatActivity() {
    lateinit var web: WebView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newsupdates)
        web=findViewById(R.id.mYwebView)

        val webSettings  = web.settings
        webSettings.javaScriptEnabled = true
        web.loadUrl("https:https://gizmodo.com")


    }
}