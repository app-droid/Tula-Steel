package ru.alinadorozhkina.tula_steel.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.entities.*
import android.content.Intent
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import ru.alinadorozhkina.tula_steel.adapter.MultiRVAdapter
import ru.alinadorozhkina.tula_steel.adapter.OnItemMultiClickListener
import ru.alinadorozhkina.tula_steel.databinding.ActivityMainLayoutBinding
import ru.alinadorozhkina.tula_steel.fragments.*
import android.view.MotionEvent

import android.view.View.OnTouchListener
import ru.alinadorozhkina.tula_steel.databinding.MainActivityLayoutBinding
import ru.alinadorozhkina.tula_steel.databinding.MainBinding


class MainActivity : AppCompatActivity(), OnItemMultiClickListener,
    NavigationView.OnNavigationItemSelectedListener {
    private var vb: MainActivityLayoutBinding? = null
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView

    private val categories: List<AppEntity> = listOf(
        All(),
        TovarnaiaZagotovka(),
        FasonnyiProkat(),
        SortovoiProkat(),
        ArmaturnyiProkat(),
        Katanka()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = MainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        initNavDrawer()
        initRV()
        vb?.buttonAboutCompany?.setOnClickListener {
            intent(6)
        }
        vb?.buttonCertificates?.setOnClickListener {
            intent(7)
        }
//        vb?.cardCertificates?.setOnClickListener {
//            intent(7)
//        }
//
//        vb?.cardAbout?.setOnClickListener {
//            intent(6)
//        }

        //settings()
    }

    private fun settings() = with(vb) {
    }

    private fun initRV() = with(vb) {
        this!!.rvProduction.adapter = MultiRVAdapter(
            this@MainActivity,
            categories,
            this@MainActivity
        )
    }

    private fun initNavDrawer() {
        val toolbar: MaterialToolbar? = vb?.topAppBar
        setSupportActionBar(toolbar)
        drawer = vb?.drawerLayout!!
        navigationView = vb?.navView!!
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        toggle.isDrawerIndicatorEnabled = false
        toggle.toolbarNavigationClickListener = View.OnClickListener {
            drawer.openDrawer(
                GravityCompat.START
            )
        }
        toolbar?.setNavigationIcon(R.drawable.ic_baseline_menu_24)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onItemClick(entity: AppEntity) {
        intent(entity.id)
    }

    private fun intent(id: Int) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.alpha)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> intent(1)
            R.id.item2 -> intent(2)
            R.id.item3 -> intent(3)
            R.id.item4 -> intent(4)
            R.id.item5 -> intent(5)
            R.id.item6 -> intent(6)
            R.id.item7 -> intent(7)
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
        vb = null
    }

    override fun onBackPressed() {
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)

    }
}