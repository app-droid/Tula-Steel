package ru.alinadorozhkina.tula_steel.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.appbar.MaterialToolbar
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.databinding.ActivityProductBinding
import ru.alinadorozhkina.tula_steel.fragments.FragmentAbout
import ru.alinadorozhkina.tula_steel.fragments.FragmentKvadratnaiaZagotovka
import ru.alinadorozhkina.tula_steel.fragments.FragmentProkatKonstruktcionnyi
import ru.alinadorozhkina.tula_steel.fragments.FragmentProkatRiadovoi


class ProductActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var vb: ActivityProductBinding? = null
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityProductBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        val toolbar: MaterialToolbar? = vb?.topAppBar
        setSupportActionBar(toolbar)
        drawer = vb?.drawerLayout!!
        navigationView = vb?.navView!!
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

        val arguments = intent.extras
        val id = arguments!!["ID"]

        when (id) {
            1 -> {
                val riadovoiProkat = FragmentProkatRiadovoi()
                supportFragmentManager.beginTransaction().add(R.id.content_frame, riadovoiProkat)
                    .commit()
            }

            2 -> {
                val konstProkat = FragmentProkatKonstruktcionnyi()
                supportFragmentManager.beginTransaction().add(R.id.content_frame, konstProkat)
                    .commit()
            }

            3 -> {
                val kvadratnaia = FragmentKvadratnaiaZagotovka()
                supportFragmentManager.beginTransaction().add(R.id.content_frame, kvadratnaia)
                    .commit()

            }

            5 -> {
                val about = FragmentAbout()
                supportFragmentManager.beginTransaction().add(R.id.content_frame, about)
                    .commit()

            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                startActivity(MainActivity.getStartIntent(this))
                finish()
            }
            R.id.item2 -> {
                val riadovoiProkat = FragmentProkatRiadovoi()
                supportFragmentManager.beginTransaction().replace(R.id.content_frame, riadovoiProkat)
                    .commit()

            }
            R.id.item3 -> {
                val konstProkat = FragmentProkatKonstruktcionnyi()
                supportFragmentManager.beginTransaction().replace(R.id.content_frame, konstProkat)
                    .commit()

            }
            R.id.item4 -> {
                val kvadratnaia = FragmentKvadratnaiaZagotovka()
                supportFragmentManager.beginTransaction().replace(R.id.content_frame, kvadratnaia)
                    .commit()

            }
            R.id.item5 -> {
                Toast.makeText(this, "5", Toast.LENGTH_LONG).show()

            }
            R.id.item6 -> {
                val about = FragmentAbout()
                supportFragmentManager.beginTransaction().replace(R.id.content_frame, about)
                    .commit()
            }

            R.id.item7 -> {
                Toast.makeText(this, "7", Toast.LENGTH_LONG).show()

            }
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

//    companion object {
//        fun getStartIntent(context: Context) = Intent(context, RiadovoiProkatActivity::class.java)
//    }
}