package com.example.ejemplonavigationview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    lateinit var mi_toolbar:Toolbar
    lateinit var mi_drawer:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mi_drawerlayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //DrawerLayout
        mi_drawer=findViewById(R.id.mi_drawerlayout)

        //Toolbar
        mi_toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(mi_toolbar)
        //Ponemos icono al menu
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_restaurant_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}