package com.example.realmadrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    private lateinit var editTextEmailAddress2 : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var registerbutton : Button
    private lateinit var buttonlogin : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()
        registerlisteners()
    }

    private fun init(){
        editTextEmailAddress2 = findViewById(R.id.editTextEmailAddress2)
        editTextPassword = findViewById(R.id.editTextPassword)
        registerbutton = findViewById(R.id.registerbutton)
        buttonlogin = findViewById(R.id.buttonlogin)
    }
    private fun registerlisteners(){
        registerbutton.setOnClickListener {
            val email = editTextEmailAddress2.text.toString()
            val password = editTextPassword.text.toString()


            if (email.length < 10 || password.length < 8 ){
                Toast.makeText(this, "შეცდომა", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this,LoginActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this, "შეცდომა", Toast.LENGTH_SHORT).show()
                    }

                }


        }
        buttonlogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

}