package ru.alinadorozhkina.tula_steel.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.BaseRVAdapter
import ru.alinadorozhkina.tula_steel.databinding.ActivityMainBinding
import ru.alinadorozhkina.tula_steel.databinding.ItemCardMainBinding
import ru.alinadorozhkina.tula_steel.entities.*
import android.content.Intent

const val ProkatRiadovoi: Int = 1
const val ProkatKonstrukchionnyi: Int = 2
const val KvadratnaiaZagotovka: Int = 3


class MainActivity : AppCompatActivity() {
    private var vb: ActivityMainBinding? = null

    private val allProducts: List<Product> = listOf(
        ArmaturaGladkaia(),
        ArmaturaPeriodicheskaia(),
        UgolokRapnopolochnyi(),
        UgolokNerapnopolochnyi(),
        Shveller(),
        Dvutavra(),
        Krug(),
        Kvadrat(),
        Shestigrannik(),
        Polosa(),
        Katanka(),
        KvadratnaiaZagotovka()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        initRV()
        initNavigation()
    }

    fun initNavigation () = with(vb) {
        this!!.menuRiadovoi.setOnClickListener {
            intent(ProkatRiadovoi)
        }
    }

    private fun initRV() = with(vb) {
        this!!.rvAllProducts.adapter = BaseRVAdapter(
            allProducts,
            R.layout.item_card_main,
        )
        { view, data ->
            bind(view, data)
        }
    }

    private fun bind(view: View, data: Product) {
        val rvBinding = ItemCardMainBinding.bind(view)
        with(rvBinding) {
            tvTitle.text = data.name
            ivPicture.setImageResource(data.picture)
        }
    }

    private fun intent (id: Int) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("ID", id)
        startActivity(intent)
    }

    override fun onDestroy() {
        vb = null
        super.onDestroy()
    }
}