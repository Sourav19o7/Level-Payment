package com.example.levelpayment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class Payment: AppCompatActivity() {
    var firebaseDatabase: FirebaseDatabase? = null

    var databaseReference: DatabaseReference? = null

    private var retrieveTV: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paymentwindow)
        //Log.i("No:","20")
    }

    fun discount(view: View)
    {
        firebaseDatabase = FirebaseDatabase.getInstance()

        databaseReference = firebaseDatabase!!.getReference("Data")

        retrieveTV = findViewById(R.id.idEdtAmt)

        getdata()
    }

    private fun getdata() {

        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(String::class.java)
                retrieveTV!!.text = value
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Payment, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}