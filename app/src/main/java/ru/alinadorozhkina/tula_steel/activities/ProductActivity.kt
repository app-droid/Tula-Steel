package ru.alinadorozhkina.tula_steel.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.databinding.ActivityProductLayoutBinding
import ru.alinadorozhkina.tula_steel.entities.Product
import ru.alinadorozhkina.tula_steel.entities.TovarnaiaZagotovka
import ru.alinadorozhkina.tula_steel.fragments.*


class ProductActivity : AppCompatActivity() {

    private var vb: ActivityProductLayoutBinding? = null

    val tovarnaiaZagotovka: TovarnaiaZagotovka = TovarnaiaZagotovka()
    val listTovarnaiaZagotovka: List<Product> = tovarnaiaZagotovka.products


//    private lateinit var drawer: DrawerLayout
//    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityProductLayoutBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        val toolbar: MaterialToolbar? = vb?.topAppBar
        setSupportActionBar(toolbar)
        toolbar!!.setNavigationOnClickListener {
            finish()
        }


        val arguments = intent.extras
        val id = arguments!!["ID"]

        when (id) {
            1 -> {
                val baseFragment = BaseFragment.newInstance(listTovarnaiaZagotovka[0])
                supportFragmentManager.beginTransaction().add(R.id.content_frame, baseFragment)
                    .commit()
            }
        }
        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
//        val toolbar: MaterialToolbar? = vb?.topAppBar
//        setSupportActionBar(toolbar)
//        drawer = vb?.drawerLayout!!
//        navigationView = vb?.navView!!
//        val toggle = ActionBarDrawerToggle(
//            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
//        )
//        drawer.addDrawerListener(toggle)
//        toggle.syncState()
//
//        navigationView.setNavigationItemSelectedListener(this)
//
//        val arguments = intent.extras
//        val id = arguments!!["ID"]
//
//        when (id) {
//            1 -> {
//                val riadovoiProkat = FragmentProkatRiadovoi()
//                supportFragmentManager.beginTransaction().add(R.id.content_frame, riadovoiProkat)
//                    .commit()
//            }
//
//            2 -> {
//                val konstProkat = FragmentProkatKonstruktcionnyi()
//                supportFragmentManager.beginTransaction().add(R.id.content_frame, konstProkat)
//                    .commit()
//            }
//
//            3 -> {
//                val kvadratnaia = FragmentKvadratnaiaZagotovka()
//                supportFragmentManager.beginTransaction().add(R.id.content_frame, kvadratnaia)
//                    .commit()
//
//            }
//
//            5 -> {
//                val about = FragmentAbout()
//                supportFragmentManager.beginTransaction().add(R.id.content_frame, about)
//                    .commit()
//
//            }
//
//            6 -> {
//                val certificate = FragmentCertificates()
//                supportFragmentManager.beginTransaction().add(R.id.content_frame, certificate)
//                    .commit()
//
//            }
//
//        }
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.item1 -> {
//                startActivity(MainActivity.getStartIntent(this))
//                finish()
//            }
//            R.id.item2 -> {
//                val riadovoiProkat = FragmentProkatRiadovoi()
//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, riadovoiProkat)
//                    .commit()
//
//            }
//            R.id.item3 -> {
//                val konstProkat = FragmentProkatKonstruktcionnyi()
//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, konstProkat)
//                    .commit()
//
//            }
//            R.id.item4 -> {
//                val kvadratnaia = FragmentKvadratnaiaZagotovka()
//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, kvadratnaia)
//                    .commit()
//
//            }
//            R.id.item5 -> {
//                Toast.makeText(this, "5", Toast.LENGTH_LONG).show()
//
//            }
//            R.id.item6 -> {
//                val about = FragmentAbout()
//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, about)
//                    .commit()
//            }
//
//            R.id.item7 -> {
//                val certificate = FragmentCertificates()
//                supportFragmentManager.beginTransaction().replace(R.id.content_frame, certificate)
//                    .commit()
//
//            }
//        }
//
//        drawer.closeDrawer(GravityCompat.START)
//        return true
//    }

//    companion object {
//        fun getStartIntent(context: Context) = Intent(context, RiadovoiProkatActivity::class.java)
//    }
}