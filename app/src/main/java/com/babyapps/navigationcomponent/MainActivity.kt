package com.babyapps.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Hide action bar
        //supportActionBar?.hide()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.homeFragment, R.id.searchFragment), drawer_layout)

        //This removes back icon from action bar for bot nav menu
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottom_nav.setupWithNavController(navController)

        nav_view.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    //This method brings user to the Settings fragment by navcontroller when user clicks settings inside menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId.equals(R.id.aboutAppFragment)) {
            val action = NavGraphDirections.actionGlobalAboutAppFragment()
            navController.navigate(action)
            true
        } else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}