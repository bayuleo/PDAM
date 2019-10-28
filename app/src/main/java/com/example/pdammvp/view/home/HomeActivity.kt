package com.example.pdammvp.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pdammvp.R
import com.example.pdammvp.view.history.HistoryFragment
import com.example.pdammvp.view.profile.ProfileFragment
import com.facebook.FacebookSdk
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*


public class HomeActivity : AppCompatActivity() {

    val homeFragment = HomeFragment()
    val historyFragment = HistoryFragment()
    val profileFragment = ProfileFragment()

    private val mOnNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.btn_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.home_fragment, homeFragment).commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.btn_history -> {
                supportFragmentManager.beginTransaction().replace(R.id.home_fragment, historyFragment).commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.btn_exit -> {
                supportFragmentManager.beginTransaction().replace(R.id.home_fragment, profileFragment).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        FacebookSdk.sdkInitialize(getApplicationContext())

        initLayout()
    }

    private fun initLayout() {

//        supportFragmentManager.beginTransaction().replace(R.id.home_fragment, homeFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.home_fragment, homeFragment).commit()

        nav_home.setOnNavigationItemSelectedListener(mOnNavigationItemSelected)

    }

}
