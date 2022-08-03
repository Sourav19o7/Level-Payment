package com.example.levelpayment

import android.os.Bundle
//import android.util.Log
import android.view.View
//import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.levelpayment.databinding.PaymentwindowBinding
import com.google.firebase.database.*

class Payment: AppCompatActivity() {
    var firebaseDatabase: FirebaseDatabase? = null

    var databaseReference: DatabaseReference? = null

    private lateinit var binding : PaymentwindowBinding

    private val paymentValue: PaymentValue = PaymentValue("100 $/yr")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.paymentwindow)
        //Log.i("No:","20")
        binding = DataBindingUtil.setContentView(this, R.layout.paymentwindow)
        binding.paymentValue = paymentValue
    }

    fun discount(view: View)
    {
        firebaseDatabase = FirebaseDatabase.getInstance()

        databaseReference = firebaseDatabase!!.getReference("Data")


        getdata()
    }

    private fun getdata() {

        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(String::class.java)
                binding.idEdtAmt.setText(value)
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Payment, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}