package com.example.kartheek.festapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : DaggerAppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_info -> {
                message.setText(R.string.title_information)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_schedule -> {
                message.setText(R.string.title_schedule)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_feed -> {
                message.setText(R.string.title_feed)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                message.setText(R.string.title_map)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
