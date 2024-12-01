package com.example.userinterface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnNextActivity: Button = findViewById(R.id.btnNextActivity)
        btnNextActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout) // Ce code lie le DrawerLayout dans le code Kotlin pour pouvoir le contrôler, comme l'ouvrir ou le fermer lorsque nécessaire.
        val navView: NavigationView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener { // Ce Listener permet de gérer les actions lorsqu'un élément du menu de navigation est sélectionné, comme rediriger vers une activité spécifique.
            when (it.itemId) {
                R.id.nav_main -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_second -> {
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_easter_egg -> {
                    Toast.makeText(this, "Félicitations, vous avez trouvé l'Easter Egg ! Vous gagnez 1 point bonus.", Toast.LENGTH_LONG).show()
                }
            }
            drawerLayout.closeDrawers()
            true
        }

    }
}