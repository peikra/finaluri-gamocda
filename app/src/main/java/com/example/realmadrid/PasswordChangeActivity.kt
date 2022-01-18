package com.example.realmadrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var editTextNewPassword : EditText
    private lateinit var buttonchange : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)
        init()
        registerlistener()
    }

    private fun init(){
        editTextNewPassword = findViewById(R.id.editTextNewPassword)
        buttonchange = findViewById(R.id.buttonchange)
    }
    private fun registerlistener(){
        buttonchange.setOnClickListener {
            val newpassword = editTextNewPassword.text.toString()
            if (newpassword.isEmpty() || newpassword.length < 9 ){
                Toast.makeText(this, "თქვენ მიერ შეყვანილი პაროლი უნდა აღემატებოდეს 9 სიმბოლოს", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newpassword)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "წარმატებით შეიცვალა", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "შეცდომაა", Toast.LENGTH_SHORT).show()
                    }

                }
        }
    }
}