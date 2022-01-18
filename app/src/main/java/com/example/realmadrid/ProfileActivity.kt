package com.example.realmadrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileActivity : AppCompatActivity() {

    private lateinit var buttonchangepassword : Button
    private lateinit var buttonlogout : Button
    private lateinit var buttonnextpage : Button
    private lateinit var buttonsaveinformation : Button






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        registerlistener()







    }
    private fun init(){
        buttonchangepassword = findViewById(R.id.buttonchangepassword)
        buttonlogout = findViewById(R.id.buttonlogout)
        buttonnextpage = findViewById(R.id.buttonnextpage)
        buttonsaveinformation = findViewById(R.id.buttonsaveinformation)


    }
    private fun registerlistener(){
        buttonlogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }
        buttonchangepassword.setOnClickListener {
            startActivity(Intent(this,PasswordChangeActivity::class.java))
        }
        buttonnextpage.setOnClickListener {
            startActivity(Intent(this,NewPageActivity::class.java))
        }
        buttonsaveinformation.setOnClickListener {
            startActivity(Intent(this,SaveInformationActivity::class.java))
        }




    }


    }
