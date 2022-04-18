package ru.alinadorozhkina.tula_steel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.BaseRVAdapter
import ru.alinadorozhkina.tula_steel.databinding.FragmentProkatKonstruktcionnyiBinding
import ru.alinadorozhkina.tula_steel.databinding.FragmentProkatRiadovoiBinding
import ru.alinadorozhkina.tula_steel.databinding.ItemCardMainBinding
import ru.alinadorozhkina.tula_steel.entities.*


class FragmentProkatKonstruktcionnyi : Fragment() {

    var vb: FragmentProkatKonstruktcionnyiBinding? = null

    private val prokatKonstruktcionnyi: List<Product> = listOf(
        Krug(),
        Kvadrat(),
        Shestigrannik(),
        Polosa()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentProkatKonstruktcionnyiBinding.inflate(inflater, container, false).apply {
        vb = this
        initRV()
    }.root

    private fun initRV() = with(vb) {
        this?.rvProkatKonstrukchionnyi?.adapter = BaseRVAdapter(
            prokatKonstruktcionnyi,
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