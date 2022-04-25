package ru.alinadorozhkina.tula_steel.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.BaseRVAdapter
import ru.alinadorozhkina.tula_steel.databinding.ActivityMainBinding
import ru.alinadorozhkina.tula_steel.databinding.ItemCardMainBinding
import ru.alinadorozhkina.tula_steel.entities.*
import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import ru.alinadorozhkina.tula_steel.adapter.MultiRVAdapter
import ru.alinadorozhkina.tula_steel.adapter.OnItemClickListener
import ru.alinadorozhkina.tula_steel.databinding.ActivityMainLayoutBinding
import ru.alinadorozhkina.tula_steel.fragments.*

class MainActivity : AppCompatActivity(), OnItemClickListener,
    NavigationView.OnNavigationItemSelectedListener {
    private var vb: ActivityMainLayoutBinding? = null
    private lateinit var drawer: DrawerLayout
    private lateinit var navigationView: NavigationView

    private val categories: List<AppEntity> = listOf(
        Title(),
        TovarnaiaZagotovka(),
        Katanka_(),
        SortovoiProkat(),
        ArmaturnyiProkat(),
        FasonnyiProkat()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        initNavDrawer()
        initRV()
    }

    private fun initRV()= with(vb){
        this!!.rvCategoryMain.adapter = MultiRVAdapter(
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
        Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
        intent(entity.id)
    }

    private fun intent (id: Int) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
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
        super.onDestroy()
        vb = null
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}