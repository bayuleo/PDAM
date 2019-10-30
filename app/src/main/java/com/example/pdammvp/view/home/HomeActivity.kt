package com.example.pdammvp.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
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
                supportFragmentManager.beginTransaction().hide(historyFragment).hide(profileFragment).show(homeFragment).commit()
                return@OnNavigationItemSelectedListener true
            }

            R.id.btn_history -> {
                if (historyFragment.isAdded){
                    supportFragmentManager.beginTransaction().show(historyFragment).hide(profileFragment).hide(homeFragment).commit()
                }else{
                    supportFragmentManager.beginTransaction().hide(homeFragment).hide(profileFragment).add(R.id.home_fragment, historyFragment, "historyFragment").show(historyFragment).commit()
                }
                return@OnNavigationItemSelectedListener true
            }

            R.id.btn_exit -> {
                if (profileFragment.isAdded){
                    supportFragmentManager.beginTransaction().hide(historyFragment).show(profileFragment).hide(homeFragment).commit()
                }else {
                    supportFragmentManager.beginTransaction().hide(homeFragment).hide(historyFragment).add(R.id.home_fragment, profileFragment, "profileFragment").show(profileFragment).commit()
                }
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

        supportFragmentManager.beginTransaction().add(R.id.home_fragment, homeFragment, "homeFragment").commit()

        nav_home.setOnNavigationItemSelectedListener(mOnNavigationItemSelected)

    }

}
