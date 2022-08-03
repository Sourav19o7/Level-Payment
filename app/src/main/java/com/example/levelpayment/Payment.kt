package com.example.levelpayment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.levelpayment.databinding.PaymentwindowBinding
import com.google.firebase.database.*
import kotlinx.coroutines.*

class Payment : AppCompatActivity() {
    var firebaseDatabase: FirebaseDatabase? = null

    var databaseReference: DatabaseReference? = null

    private lateinit var binding: PaymentwindowBinding

    private val paymentValue: PaymentValue = PaymentValue("100 $/yr")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Using data binding to connect layout and UI directly
        binding = DataBindingUtil.setContentView(this, R.layout.paymentwindow)
        binding.paymentValue = paymentValue

        //Using Coroutines for in-app messaging with firebase console
        binding.idDiscount.setOnClickListener() {
            runBlocking {
                discount(it)
            }
        }
    }


    //discount() function is suspend, hence can only be called by another
    //coroutine or suspend function
    suspend fun discount(view: View) = coroutineScope {
        launch {
            firebaseDatabase = FirebaseDatabase.getInstance()

            databaseReference = firebaseDatabase!!.getReference("Data")

            getdata(binding)
        }
    }
}

//getdata() is a extension function, a feature of Kotlin
suspend fun Payment.getdata(binding: PaymentwindowBinding) = coroutineScope {
    launch {
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.getValue(String::class.java)
                binding.idEdtAmt.setText(value)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@getdata, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
