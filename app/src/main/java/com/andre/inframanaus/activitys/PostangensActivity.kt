package com.andre.inframanaus.activitys

import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.andre.inframanaus.R
import androidx.core.view.GravityCompat
import androidx.navigation.ui.*
import com.andre.inframanaus.databinding.ActivityPostangensBinding

class PostangensActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityPostangensBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostangensBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarPostangens.toolbar)

        binding.appBarPostangens.fab.setOnClickListener { view ->
                startActivity(Intent(this, MenuServicosActivity::class.java))

        }

        //Navegação
        setupNavigation()







//        button_logout.setOnClickListener{
//
//        }
    }

    fun setupNavigation(){
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_postangens)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_postagens, R.id.nav_politicas, R.id.nav_sobre, R.id.nav_disconnect
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val button_logout = binding.navLogout

        val logout = button_logout.menu

        navView.setNavigationItemSelectedListener{
            if (it.itemId == R.id.nav_disconnect){
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
            } else{
                NavigationUI.onNavDestinationSelected(it, navController)
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            true
        }

    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_postangens)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}