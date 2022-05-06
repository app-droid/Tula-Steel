package ru.alinadorozhkina.tula_steel.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.MultiRVAdapter
import ru.alinadorozhkina.tula_steel.adapter.OnItemMultiClickListener
import ru.alinadorozhkina.tula_steel.adapter.PictureAdapter
import ru.alinadorozhkina.tula_steel.databinding.ActivityMainBinding
import ru.alinadorozhkina.tula_steel.databinding.ActivityMainLayoutBinding
import ru.alinadorozhkina.tula_steel.entities.*

class MainActivity2 : AppCompatActivity(), OnItemMultiClickListener,
    NavigationView.OnNavigationItemSelectedListener  {

    private var vb: ActivityMainBinding? = null

    private val productionPlan = ProductionPlan()
    private val pcD32 = PCD32()
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView

    private val categories: List<AppEntity> = listOf(
        All(),
        ArmaturnyiProkat(),
        SortovoiProkat(),
        Katanka(),
        FasonnyiProkat(),
        TovarnaiaZagotovka()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        initNavDrawer()
        initRV()
    }

    private fun initRV() = with(vb) {
        this!!.rvCategoryMain.adapter = MultiRVAdapter(
            this@MainActivity2,
            categories,
            this@MainActivity2
        )

        vb?.buttonSchema?.setOnClickListener {
            val intent = Intent(this@MainActivity2, PictureActivity::class.java)
            intent.putExtra("Picture", productionPlan)
            startActivity(intent)
        }

        vb?.buttonPcd32?.setOnClickListener {
            val intent = Intent(this@MainActivity2, PictureActivity::class.java)
            intent.putExtra("Picture", pcD32)
            startActivity(intent)
        }

        vb?.rvPicture?.adapter = PictureAdapter(this@MainActivity2)
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