package com.example.levelpayment

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RelativeLayout>(R.id.homePage).setOnClickListener(){
            //Log.i("No:","16")
            val intent = Intent(this, Payment::class.java)
            startActivity(intent)
        }

    }
}