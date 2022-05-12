package ru.alinadorozhkina.tula_steel.activities

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.ViewPagerAdapter
import ru.alinadorozhkina.tula_steel.databinding.ActivityProductLayoutBinding
import ru.alinadorozhkina.tula_steel.entities.*
import ru.alinadorozhkina.tula_steel.fragments.*

const val padding: Int = 180
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
        countDownTimer = object : CountDownTimer(SECONDS, 1000) {
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
            0.0 -> {
                vb?.labelHeader?.text = getString(all.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                all.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(0, 0, padding, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }
            1.0 -> {
                vb?.labelHeader?.text = getString(tovarnaiaZagotovka.title)
                val tovarnaia = BaseFragment.newInstance(tovarnaiaZagotovka.products[0])
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, tovarnaia)
                    .commit()
//                val dataFragments: MutableList<Fragment> = mutableListOf()
//                tovarnaiaZagotovka.products.forEach {
//                    dataFragments.add(BaseFragment.newInstance(it))
//                }
//                vb?.viewPager2?.clipToPadding = false
//                vb?.viewPager2?.setPadding(155, 0, 155, 0)
//                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }
            2.0 -> {
                vb?.labelHeader?.text = getString(fasonnyiProkat.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                fasonnyiProkat.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(100, 0, padding, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }

            2.1 -> {
                vb?.labelHeader?.text = getString(R.string.category_fasonnyi_prokat)
                val shveller = BaseFragment.newInstance(fasonnyiProkat.products[0])
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, shveller)
                    .commit()
            }

            2.2 -> {
                vb?.labelHeader?.text = getString(R.string.category_fasonnyi_prokat)
                val shveller = BaseFragment.newInstance(fasonnyiProkat.products[1])
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, shveller)
                    .commit()
            }
            3.0 -> {
                vb?.labelHeader?.text = getString(sortovoiProkat.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                sortovoiProkat.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(0, 0, padding, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }

            3.1 -> {
                vb?.labelHeader?.text = getString(R.string.category_sortovoi_prokat)
                val krug = BaseFragment.newInstance(sortovoiProkat.products[0])
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, krug)
                    .commit()
            }

            3.2 -> {
                vb?.labelHeader?.text = getString(R.string.category_sortovoi_prokat)
                val polosa = BaseFragment.newInstance(sortovoiProkat.products[1])
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, polosa)
                    .commit()
            }
            4.0 -> {
                vb?.labelHeader?.text = getString(armaturnyiProkat.title)
                val dataFragments: MutableList<Fragment> = mutableListOf()
                armaturnyiProkat.products.forEach {
                    dataFragments.add(BaseFragment.newInstance(it))
                }
                vb?.viewPager2?.clipToPadding = false
                vb?.viewPager2?.setPadding(0, 0, padding, 0)
                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
            }

            4.1 -> {
                vb?.labelHeader?.text = getString(R.string.category_armaturnyi_prokat)
                val prutki = BaseFragment.newInstance(armaturnyiProkat.products[0])
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, prutki)
                    .commit()
            }

            4.2 -> {
                vb?.labelHeader?.text = getString(R.string.category_armaturnyi_prokat)
                val motki = BaseFragment.newInstance(armaturnyiProkat.products[1])
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, motki)
                    .commit()
            }

            5.0 -> {
//                val dataFragments: MutableList<Fragment> = mutableListOf()
//                katanka.products.forEach {
//                    dataFragments.add(BaseFragment.newInstance(it))
//                }
//                vb?.viewPager2?.clipToPadding = false
//                vb?.viewPager2?.setPadding(155, 0, 155, 0)
//                vb?.viewPager2?.adapter = ViewPagerAdapter(dataFragments, supportFragmentManager)
                vb?.labelHeader?.text = getString(katanka.title)
                val katanka = BaseFragment.newInstance(katanka.products[0])
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, katanka)
                    .commit()
            }

            6.0 -> {
                vb?.labelHeader?.text = getString(R.string.about)
                val certificate = FragmentAbout()
                supportFragmentManager.beginTransaction().add(R.id.frame_for_fragments, certificate)
                    .commit()
            }

            7.0 -> {
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
    }

    override fun onDestroy() {
        vb = null
        super.onDestroy()
    }

    override fun onStop() {
        countDownTimer.cancel()
        super.onStop()
    }
}

