package com.example.realmadrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem


import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration

import androidx.viewpager.widget.ViewPager
import com.example.realmadrid.Adapter.ViewPagerAdapter
import com.example.realmadrid.Fragments.FirstFragment
import com.example.realmadrid.Fragments.SecondFragment
import com.example.realmadrid.Fragments.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


import kotlin.collections.ArrayList

class NewPageActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_page)
        viewPager = findViewById(R.id.viewpager)

        val botom : BottomNavigationView = findViewById(R.id.navigationview)

        botom.setOnNavigationItemSelectedListener(bottomnavview)






        val menuadapter = ViewPagerAdapter(initfragments(),supportFragmentManager)
        viewPager.adapter = menuadapter












                    }



    val bottomnavview = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId){
            R.id.home -> {
                viewPager.currentItem = 0
            }
            R.id.history -> {
                viewPager.currentItem = 1
            }
            R.id.titles -> {
                viewPager.currentItem = 2
            }
        }





        true


    }





}









    private fun initfragments():ArrayList<Fragment>{
        return arrayListOf(
            FirstFragment.newinstance(),
            SecondFragment.newinstance(),
            ThirdFragment.newinstance()



        )
    }







