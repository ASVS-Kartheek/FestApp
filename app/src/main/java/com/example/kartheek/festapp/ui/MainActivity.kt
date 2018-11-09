package com.example.kartheek.festapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kartheek.festapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private const val FRAGMENT_ID = R.id.fragment_container
    }

    private lateinit var currentFragment: MainNavigationFragment

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
        // Add a listener to prevent reselects from being treated as selects.
        navigation.setOnNavigationItemReselectedListener {}

        if (savedInstanceState == null) {
            // Show Schedule on first creation
            navigation.selectedItemId = R.id.navigation_schedule
        } else {
            // Find the current fragment
            currentFragment =
                    supportFragmentManager.findFragmentById(FRAGMENT_ID) as? MainNavigationFragment
                    ?: throw IllegalStateException("Activity recreated, but no fragment found!")
        }
    }
}
