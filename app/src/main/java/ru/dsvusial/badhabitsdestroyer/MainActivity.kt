package ru.dsvusial.badhabitsdestroyer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.dsvusial.badhabitsdestroyer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.fragment_splash)

        Handler(Looper.myLooper()!!).postDelayed({
            setContentView(binding.root)

            setSupportActionBar(binding.toolbar)
            // getting reference to the navigation controller from navigation host
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment
            val navController = navHostFragment.navController

            //enable vanigation when item clikced by linking the drawer to the navigation controller
            //setupWithNavController method links the drawers navigation view to the navigation controller
            val navView = binding.navView
            NavigationUI.setupWithNavController(navView, navController)
            // builds a configuration that links the toolbar to the navigatin graph
            // and applies it to the toolbar
            val builder = AppBarConfiguration.Builder(navController.graph)
            //to open drawer with "burger" button
            builder.setOpenableLayout(binding.drawerLayout)
            val appBarConfiguration = builder.build()
            binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        }, 1000)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController) ||
                return super.onOptionsItemSelected(item)
    }
}