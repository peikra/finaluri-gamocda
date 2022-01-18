package com.example.realmadrid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.realmadrid.databinding.ActivityProfileBinding
import com.example.realmadrid.databinding.ActivitySaveInformationBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SaveInformationActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySaveInformationBinding
    private lateinit var database : DatabaseReference
    private lateinit var buttonnback : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaveInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonsave.setOnClickListener {
            val firstname = binding.firstname.text.toString()
            val lastname = binding.lastname.text.toString()
            val age = binding.age.text.toString()


            database = FirebaseDatabase.getInstance().getReference("UserInfo")
            val userinfo = UserInfo(firstname,lastname,age)
            database.child(firstname).setValue(userinfo).addOnSuccessListener {

                binding.firstname.text.clear()
                binding.lastname.text.clear()
                binding.age.text.clear()

                Toast.makeText(this, "ინფორმაცია წარმატებით დამახსოვრდა", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{
                Toast.makeText(this, "შეცდომაა", Toast.LENGTH_SHORT).show()
            }
        }
        init()
        listener()




    }
    private fun init(){
       buttonnback = findViewById(R.id.buttonback)
    }
    private fun listener(){
        buttonnback.setOnClickListener {
            startActivity(Intent(this,ProfileActivity::class.java))
        }
    }


    }
