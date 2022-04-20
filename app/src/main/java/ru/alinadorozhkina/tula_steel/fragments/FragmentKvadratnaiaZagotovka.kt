package ru.alinadorozhkina.tula_steel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.BaseRVAdapter
import ru.alinadorozhkina.tula_steel.adapter.OnItemClickListener
import ru.alinadorozhkina.tula_steel.databinding.FragmentKvadratnaiaZagotovkaBinding
import ru.alinadorozhkina.tula_steel.databinding.ItemCardMainBinding
import ru.alinadorozhkina.tula_steel.entities.AppEntity
import ru.alinadorozhkina.tula_steel.entities.KvadratnaiaZagotovka

class FragmentKvadratnaiaZagotovka : Fragment(), OnItemClickListener {

    private var vb: FragmentKvadratnaiaZagotovkaBinding? = null
    private val kvadratnaiaZagotovka:List<AppEntity> = listOf(
        KvadratnaiaZagotovka()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentKvadratnaiaZagotovkaBinding.inflate(inflater, container, false).apply {
        vb = this
        initRV()
    }.root

    private fun initRV() = with(vb) {
        this?.rvKvadratnaiaZagotovka?.adapter = BaseRVAdapter(
            this@FragmentKvadratnaiaZagotovka,
            kvadratnaiaZagotovka,
            R.layout.item_card_main,
        )
        { view, data ->
            bind(view, data)
        }
    }

    private fun bind(view: View, data: AppEntity) {
        val rvBinding = ItemCardMainBinding.bind(view)
        with(rvBinding) {
            tvTitle.text = getString(data.title)
            ivPicture.setImageResource(data.path)
        }
    }

    override fun onItemClick(entity: AppEntity) {
        Toast.makeText(activity, "click", Toast.LENGTH_LONG).show()
    }

}