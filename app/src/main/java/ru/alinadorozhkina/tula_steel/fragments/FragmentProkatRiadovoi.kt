package ru.alinadorozhkina.tula_steel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.adapter.BaseRVAdapter
import ru.alinadorozhkina.tula_steel.adapter.OnItemClickListener
import ru.alinadorozhkina.tula_steel.databinding.FragmentProkatRiadovoiBinding
import ru.alinadorozhkina.tula_steel.databinding.ItemCardMainBinding
import ru.alinadorozhkina.tula_steel.entities.*

class FragmentProkatRiadovoi : Fragment(), OnItemClickListener {

    var vb: FragmentProkatRiadovoiBinding? = null
    private val prokatRiadovoi: List<AppEntity> = listOf(
//        ArmaturaGladkaia(),
//        ArmaturaPeriodicheskaia(),
//        UgolokRapnopolochnyi(),
//        UgolokNerapnopolochnyi(),
//        Shveller(),
//        Dvutavra()
    )

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        initRV()
//    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentProkatRiadovoiBinding.inflate(inflater, container, false).apply {
        vb = this
        initRV()
    }.root

    private fun initRV() = with(vb) {
        this?.rvProkatRiadovoi?.adapter = BaseRVAdapter(
            this@FragmentProkatRiadovoi,
            prokatRiadovoi,
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
        TODO("Not yet implemented")
    }
}