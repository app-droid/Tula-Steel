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
import ru.alinadorozhkina.tula_steel.databinding.FragmentProkatKonstruktcionnyiBinding
import ru.alinadorozhkina.tula_steel.databinding.FragmentProkatRiadovoiBinding
import ru.alinadorozhkina.tula_steel.databinding.ItemCardMainBinding
import ru.alinadorozhkina.tula_steel.entities.*


class FragmentProkatKonstruktcionnyi : Fragment(), OnItemClickListener {

    var vb: FragmentProkatKonstruktcionnyiBinding? = null

    private val prokatKonstruktcionnyi: List<AppEntity> = listOf(
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
            this@FragmentProkatKonstruktcionnyi,
            prokatKonstruktcionnyi,
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