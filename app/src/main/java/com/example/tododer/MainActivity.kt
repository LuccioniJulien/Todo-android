package com.example.tododer

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Appbar configuration for navigation with the nav graph
        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
    }


    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}

