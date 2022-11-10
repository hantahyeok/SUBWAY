package com.hde.subway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hde.subway.R
import androidx.navigation.ui.AppBarConfiguration
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.hde.subway.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        //val navController = navHostFragment.navController

        //binding.bnv.setupWithNavController(navController)
        NavigationUI.setupWithNavController(binding.bnv, findNavController(R.id.nav_host))

        savedInstanceState

    }



}