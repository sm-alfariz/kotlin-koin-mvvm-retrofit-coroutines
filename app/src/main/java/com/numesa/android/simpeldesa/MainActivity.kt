/*************************************************
 * Created by Efendi Hariyadi on 6/18/20 9:16 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 6/18/20 9:16 PM
 ************************************************/

package com.numesa.android.simpeldesa
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
        // set transparent status bar
        setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        window.statusBarColor = Color.TRANSPARENT
    }

    private fun setupNavigation() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_nav_closed_icon)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        toolbar.setNavigationIcon(R.drawable.ic_nav_closed_icon)
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.nav_host_fragment),
            drawerLayout
        )
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        menuItem.isChecked = true
        toolbar.setNavigationIcon(R.drawable.ic_nav_closed_icon)
        drawerLayout.closeDrawers()
        when (menuItem.itemId) {
            //R.id.nav_home -> navController.navigate(R.id.firstFragment)
            R.id.nav_to_gallery -> navController.navigate(R.id.nav_gallery)
            R.id.nav_to_slideshow -> navController.navigate(R.id.nav_slideshow)
        }
        return true
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_notify -> {
                val itemNotify =
                    Snackbar.make(navigationView, "Notification on progress...", Snackbar.LENGTH_SHORT)
                itemNotify.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}