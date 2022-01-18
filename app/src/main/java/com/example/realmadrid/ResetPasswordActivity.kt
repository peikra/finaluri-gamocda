package com.example.realmadrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var editTextEmailAddress : EditText
    private lateinit var buttonsend : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        init()
        registerlisteners()
    }
    private fun init (){
        editTextEmailAddress = findViewById(R.id.editTextEmailAddress)
        buttonsend = findViewById(R.id.buttonsend)
    }
    private fun registerlisteners(){
        buttonsend.setOnClickListener {
            val email = editTextEmailAddress.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this, "გთხოვთ შეიყვანოთ მეილი", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "გთხოვთ შეამოწმეთ მეილი", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "შეცდომა", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

}