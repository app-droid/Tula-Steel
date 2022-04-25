package ru.alinadorozhkina.tula_steel.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.appbar.MaterialToolbar
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.ViewPagerAdapter
import ru.alinadorozhkina.tula_steel.databinding.ActivityProductLayoutBinding
import ru.alinadorozhkina.tula_steel.entities.*
import ru.alinadorozhkina.tula_steel.fragments.*


class ProductActivity : AppCompatActivity() {

    private var vb: ActivityProductLayoutBinding? = null
    private val tovarnaiaZagotovka: TovarnaiaZagotovka = TovarnaiaZagotovka()
    private val katanka: Katanka = Katanka()
    private val sortovoiProkat: SortovoiProkat = SortovoiProkat()
    private val armaturnyiProkat: ArmaturnyiProkat = ArmaturnyiProkat()
    private val fasonnyiProkat: FasonnyiProkat = FasonnyiProkat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityProductLayoutBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        setUpToolbar()
        val arguments = intent.extras
        setUpViewPager(arguments!!["ID"])
    }

    private fun setUpToolbar() {
        val toolbar: MaterialToolbar? = vb?.topAppBar
        setSupportActionBar(toolbar)
        toolbar!!.setNavigationOnClickListener {
            MainActivity.getStartIntent(this)
            finish()
        }
    }

    private fun setUpViewPager(id: Any?) {
        when (id) {
            1 -> {
                vb?.labelHeader?.text = getString(tovarnaiaZagotovka.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                tovarnaiaZagotovka.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(155, 0, 155, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }
            2 -> {
                val dataFragments: MutableList<Fragment> = mutableListOf()
                katanka.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(155, 0, 155, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
                vb?.labelHeader?.text = getString(katanka.title)
            }
            3 -> {
                vb?.labelHeader?.text = getString(sortovoiProkat.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                sortovoiProkat.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(155, 0, 155, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }
            4 -> vb?.labelHeader?.text = getString(armaturnyiProkat.title)

            5 -> {
                vb?.labelHeader?.text = getString(fasonnyiProkat.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                fasonnyiProkat.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(155, 0, 155, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }
            6 -> {
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        vb = null
    }
}

