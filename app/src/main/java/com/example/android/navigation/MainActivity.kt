/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // TODO (05) Add private lateinit var drawerLayout
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        // TODO (06) Initialize drawerLayout var from binding
        drawerLayout = binding.drawerLayout
        // TODO (01) Find the navController from myNavHostFragment
        // Since we're using KTX, you can call this.findNavController
        var navController = this.findNavController(R.id.myNavHostFragment)
        // TODO (02) Link the navController to our ActionBar || TODO (07) Add the DrawerLayout as the second parameter to setupActionBarWithNavController
        // By calling NavigationUI.setupActionBarWithNavController
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        // TODO  (08) Hook the navigation UI up to the navigation view. (navView)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    // TODO (03) Override onSupportNavigateUp
    // Find the navController and then call navController.navigateUp
    // press CONTROL + O, and search onSupportNavigateUp
    override fun onSupportNavigateUp(): Boolean {
        var navController = this.findNavController(R.id.myNavHostFragment)
        // return navController.navigateUp()
        // TODO (09) Replace navController.navigateUp with NavigationUI.navigateUp with drawerLayout parameter
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
