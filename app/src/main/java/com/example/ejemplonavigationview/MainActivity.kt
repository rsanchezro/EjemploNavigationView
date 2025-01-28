package com.example.ejemplonavigationview

import android.app.ActionBar
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ejemplonavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mibinding:ActivityMainBinding
    lateinit var mi_toolbar:Toolbar
    lateinit var mi_drawer:DrawerLayout
    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mibinding=ActivityMainBinding.inflate(layoutInflater)
      enableEdgeToEdge()
        setContentView(mibinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mi_drawerlayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //DrawerLayout
        mi_drawer=findViewById(R.id.mi_drawerlayout)

        //Toolbar
       // mi_toolbar=findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(mibinding.myToolbar)
        //Ponemos icono al menu
       // supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_restaurant_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mibinding.apply {

            toggle=ActionBarDrawerToggle(this@MainActivity,miDrawerlayout,R.string.abierto,R.string.cerrado)
            miDrawerlayout.addDrawerListener(toggle)
            toggle.syncState()
           // supportActionBar?.setDisplayHomeAsUpEnabled(true)
           // supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_action_restaurant_menu)


            navigationView.setNavigationItemSelectedListener {
                when(it.itemId)
                {
                    R.id.faltas->Toast.makeText(this@MainActivity,"FALTAS",Toast.LENGTH_LONG).show()
                    R.id.positivos->Toast.makeText(this@MainActivity,"POSITIVOS",Toast.LENGTH_LONG).show()
                    R.id.trabajos->Toast.makeText(this@MainActivity,"TRABAJOS",Toast.LENGTH_LONG).show()
                    R.id.BD->Toast.makeText(this@MainActivity,"BD",Toast.LENGTH_LONG).show()
                    else -> Toast.makeText(this@MainActivity,"RESTO",Toast.LENGTH_LONG).show()
                }
                mi_drawer.closeDrawers()
                true

            }
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            //supportActionBar?.setDisplayHomeAsUpEnabled(true)
          return true
        }
        return super.onOptionsItemSelected(item)
    }
}