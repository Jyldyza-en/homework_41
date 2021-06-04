package kg.tutorialapp.homework41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        replaceFragment(HomeFragment())


        toggle = ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close)

        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()
        drawerLayout.addDrawerListener(toggle)


        navigationView.setNavigationItemSelectedListener {

            drawerLayout.closeDrawer(GravityCompat.START)

            when(it.itemId){
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.first -> {
                    replaceFragment(FirstFragment())
                    true
                }
                R.id.second -> {
                    replaceFragment(SecondFragment())
                    true
                }
                else -> {
                    false
                }

            }
        }
    }

    private fun AppCompatActivity.replaceFragment(fragment:Fragment) {

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.host,fragment)
                .addToBackStack(null)
                .commit()
    }
}





