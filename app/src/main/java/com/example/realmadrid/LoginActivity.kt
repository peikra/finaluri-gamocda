package com.example.realmadrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var editTextTextEmailAddress : EditText
    private lateinit var editTextTextPassword : EditText
    private lateinit var loginbutton : Button
    private lateinit var registerbutton : Button
    private lateinit var resetpasswordbutton : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        registerlisteners()
    }

    private fun init(){
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        loginbutton = findViewById(R.id.loginbutton)
        registerbutton = findViewById(R.id.registerbutton)
        resetpasswordbutton = findViewById(R.id.resetpasswordbutton)
    }
    private fun registerlisteners(){
        registerbutton.setOnClickListener {
            val Intent = Intent(this,RegistrationActivity::class.java)
            startActivity(Intent)
        }
        resetpasswordbutton.setOnClickListener {
            val Intent = Intent(this,ResetPasswordActivity::class.java)
            startActivity(Intent)
        }
        loginbutton.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            if (email.isEmpty() && password.isEmpty()){
                Toast.makeText(this, "შეცდომა", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        gotoprofile()

                    }else{
                        Toast.makeText(this, "შეცდომა", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
    private fun gotoprofile(){
        startActivity(Intent(this,ProfileActivity::class.java))
        finish()
    }
}