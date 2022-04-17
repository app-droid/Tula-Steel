package ru.alinadorozhkina.tula_steel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.databinding.FragmentProkatRiadovoiBinding

class FragmentProkatRiadovoi : Fragment() {

    var bindingNullable: FragmentProkatRiadovoiBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentProkatRiadovoiBinding.inflate(inflater, container, false).apply {
        bindingNullable = this
    }.root

    companion object {
        fun newInstance() = FragmentProkatRiadovoi
    }
}