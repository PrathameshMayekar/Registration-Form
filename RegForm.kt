package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.DBHelper

class RegForm : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)
        var dbHelper = DBHelper (applicationContext)

        val submitbtn = this.findViewById<Button>(R.id.submitbtn);

        fun register():Boolean? {
            val firstname = this.findViewById<EditText>(R.id.firstname);
            val lastname = this.findViewById<EditText>(R.id.lastname);
            val housenumber = this.findViewById<EditText>(R.id.housenumber);
            val city = this.findViewById<EditText>(R.id.city);
            val state = this.findViewById<EditText>(R.id.state);
            val pincode = this.findViewById<EditText>(R.id.pincode);
            val phonenumber = this.findViewById<EditText>(R.id.phonenumber);
            val email = this.findViewById<EditText>(R.id.email);
            val manufacturer = this.findViewById<EditText>(R.id.manufacturer);
            val model = this.findViewById<EditText>(R.id.model);
            val year = this.findViewById<EditText>(R.id.year);

            return dbHelper.registerUser(
                phonenumber.text.toString(),
                firstname.text.toString(),
                lastname.text.toString(),
                housenumber.text.toString(),
                city.text.toString(),
                state.text.toString(),
                pincode.text.toString(),
                email.text.toString(),
                manufacturer.text.toString(),
                model.text.toString(),
                year.text.toString());

        }


        submitbtn.setOnClickListener {

            if (register() == true) {
                Toast.makeText(applicationContext, "Successfully Registered", Toast.LENGTH_SHORT).show()

                var intent = Intent(this, SuccessfullyRegistered::class.java)
                startActivity(intent)

            }

            else {
                Toast.makeText(applicationContext, " Sorry Unable to register!", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, SuccessfullyRegistered::class.java)
                startActivity(intent)
            }

        }

    }

    class SuccessfullyRegistered {

    }
}