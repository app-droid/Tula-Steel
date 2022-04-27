package ru.alinadorozhkina.tula_steel.activities

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.ViewPagerAdapter
import ru.alinadorozhkina.tula_steel.databinding.ActivityProductLayoutBinding
import ru.alinadorozhkina.tula_steel.entities.*
import ru.alinadorozhkina.tula_steel.fragments.*


class ProductActivity : AppCompatActivity() {

    private var vb: ActivityProductLayoutBinding? = null
    private val all: All = All()
    private val tovarnaiaZagotovka: TovarnaiaZagotovka = TovarnaiaZagotovka()
    private val katanka: Katanka = Katanka()
    private val sortovoiProkat: SortovoiProkat = SortovoiProkat()
    private val armaturnyiProkat: ArmaturnyiProkat = ArmaturnyiProkat()
    private val fasonnyiProkat: FasonnyiProkat = FasonnyiProkat()

    lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityProductLayoutBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        setUpToolbar()
        val arguments = intent.extras
        setUpViewPager(arguments!!["ID"])
        setUpTimer()
    }

    private fun setUpTimer(){
        countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) = Unit
            override fun onFinish() {
                MainActivity.getStartIntent(this@ProductActivity)
                finish()
            }
        }.start()
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
            0 -> {
                vb?.labelHeader?.text = getString(all.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                all.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(155, 0, 155, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }
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
            4 -> {
                vb?.labelHeader?.text = getString(armaturnyiProkat.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                armaturnyiProkat.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(155, 0, 155, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }

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

            7 -> {
                vb?.labelHeader?.text = "Сертификаты"
                val certificate = FragmentCertificates()
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, certificate)
                    .commit()
            }
        }
    }

    override fun onUserInteraction() {
       countDownTimer.cancel()
        countDownTimer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        vb = null
    }
}

