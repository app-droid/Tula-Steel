package ru.alinadorozhkina.tula_steel.activities

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_CLOSE
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import androidx.fragment.app.transaction
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
        Log.d("ProductActivity", "onCreate")
        setUpToolbar()
        val arguments = intent.extras
        setUpViewPager(arguments!!["ID"])
        setUpTimer()
    }

    private fun setUpTimer(){
        countDownTimer = object : CountDownTimer(40000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("ProductActivity", "onTick")
            }
            override fun onFinish() {
                Log.d("ProductActivity", "onFinish")
                toMain()
            }
        }.start()
    }

    private fun setUpToolbar() {
        val toolbar: MaterialToolbar? = vb?.topAppBar
        setSupportActionBar(toolbar)
        toolbar!!.setNavigationOnClickListener {
           toMain()
        }
    }

    private fun toMain() {
        startActivity(MainActivity.getStartIntent(this))
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.alpha)
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
                vb?.labelHeader?.text = getString(R.string.about)
                val certificate = FragmentAbout()
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, certificate)
                    .commit()
            }

            7 -> {
                vb?.labelHeader?.text = getString(R.string.certificates)
                val certificate = FragmentCertificates()
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, certificate)
                    .commit()
            }
        }
    }

    override fun onUserInteraction() {
       countDownTimer.cancel()
        countDownTimer.start()
        Log.d("ProductActivity", "onUserInteraction()")

    }

    override fun onDestroy() {
        Log.d("ProductActivity", "onDestroy()")
        vb = null
        super.onDestroy()
    }

    override fun onStop() {
        Log.d("ProductActivity", "onStop")
        countDownTimer.cancel()
        super.onStop()
    }
}

