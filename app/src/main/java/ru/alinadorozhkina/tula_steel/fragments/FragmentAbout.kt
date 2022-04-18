package ru.alinadorozhkina.tula_steel.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.alinadorozhkina.tula_steel.activities.PictureActivity
import ru.alinadorozhkina.tula_steel.databinding.FragmentAboutBinding
import ru.alinadorozhkina.tula_steel.entities.PCD32
import ru.alinadorozhkina.tula_steel.entities.ProductionPlan

class FragmentAbout : Fragment() {

    private var vb: FragmentAboutBinding? = null
    private val productionPlan = ProductionPlan()
    private val pcD32 = PCD32()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentAboutBinding.inflate(inflater, container, false).apply {
        vb = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb?.buttonSchema?.setOnClickListener {
            val intent = Intent(activity, PictureActivity::class.java)
            intent.putExtra("Picture", productionPlan)
            startActivity(intent)
        }

        vb?.buttonPcd32?.setOnClickListener {
            val intent = Intent(activity, PictureActivity::class.java)
            intent.putExtra("Picture", pcD32)
            startActivity(intent)
        }
    }
}