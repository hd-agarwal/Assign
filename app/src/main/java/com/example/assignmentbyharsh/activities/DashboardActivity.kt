package com.example.assignmentbyharsh.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentbyharsh.R
import com.example.assignmentbyharsh.databinding.ActivityDashboardBinding
import com.example.assignmentbyharsh.fragments.BlankFragmentA
import com.example.assignmentbyharsh.fragments.BlankFragmentB
import com.example.assignmentbyharsh.fragments.BlankFragmentC
import com.example.assignmentbyharsh.fragments.GraphFragment
import com.firebase.ui.auth.AuthUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class DashboardActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _binding.bottomNav.setOnNavigationItemSelectedListener(navListener)
        when (_binding.bottomNav.selectedItemId) {
            R.id.nav_frag_1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, GraphFragment()).commitNow()
            }
            R.id.nav_frag_2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, BlankFragmentA()).commitNow()
            }
            R.id.nav_frag_3 -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.container,
                    BlankFragmentB()
                ).commitNow()
            }
            R.id.nav_frag_4 -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.container,
                    BlankFragmentC()
                ).commitNow()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                showLogoutConfirmDialog()
            }
            else -> {
            }
        }
        return true
    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_frag_1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, GraphFragment()).commitNow()
                }
                R.id.nav_frag_2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, BlankFragmentA()).commitNow()
                }
                R.id.nav_frag_3 -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.container,
                        BlankFragmentB()
                    ).commitNow()
                }
                R.id.nav_frag_4 -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.container,
                        BlankFragmentC()
                    ).commitNow()
                }
            }
            true
        }

    private fun showLogoutConfirmDialog() {
        val logoutAlert = AlertDialog.Builder(this)
        logoutAlert.apply {
            setTitle("Sign out")
            setMessage("Are you sure you want to sign out?")
            setPositiveButton("Sign out") { _, _ ->
                AuthUI.getInstance().signOut(this@DashboardActivity).addOnCompleteListener {
                    Toast.makeText(
                        this@DashboardActivity,
                        "Signed out successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@DashboardActivity, MainActivity::class.java))
                    finish()
                }

            }
            setNegativeButton("Cancel") { _, _ -> }
        }
        logoutAlert.show()
    }
}