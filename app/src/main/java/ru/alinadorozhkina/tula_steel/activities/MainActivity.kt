package ru.alinadorozhkina.tula_steel.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.BaseRVAdapter
import ru.alinadorozhkina.tula_steel.databinding.ActivityMainBinding
import ru.alinadorozhkina.tula_steel.databinding.ItemCardMainBinding
import ru.alinadorozhkina.tula_steel.entities.*

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
        init()
    }

    private fun init() = with(vb) {
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
}