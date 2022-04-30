package ru.alinadorozhkina.tula_steel.fragments

import androidx.core.util.Pair
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.activities.PictureActivity
import ru.alinadorozhkina.tula_steel.adapter.BaseRVAdapter
import ru.alinadorozhkina.tula_steel.adapter.OnItemClickListener
import ru.alinadorozhkina.tula_steel.databinding.CertificatesBinding
import ru.alinadorozhkina.tula_steel.entities.*

class FragmentCertificates : Fragment(), OnItemClickListener {

    private var vb: CertificatesBinding? = null

    private val gost34028_2016: List<AppEntity> = listOf(
        Certificate1_1(),
        Certificate1_2(),
        Certificate1_3(),
        Certificate1_4(),
        Certificate1_5(),
        Certificate1_6()
    )

    private val gost57814_82: List<AppEntity> = listOf(
        Certificate2_1()
    )

    private val gostBelarus: List<AppEntity> = listOf(
        Certificate3_1(),
        Certificate3_2(),
        Certificate3_3(),
    )

    private val gostEurope: List<AppEntity> = listOf(
        Certificate4_1(),
        Certificate4_2(),
        Certificate4_3(),
        Certificate4_4(),
        Certificate4_5(),
        Certificate4_6(),
        Certificate4_7(),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = CertificatesBinding.inflate(inflater, container, false).apply {
        vb = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV(gost34028_2016)

        vb?.tvCertificates5781482?.setOnClickListener {
            updateUI(gost57814_82, R.string.certificates_34028_2016 )
//            vb?.tvCertificates340282016?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificates5781482?.setTextColor(resources.getColor(R.color.blue_dark))
//            vb?.tvCertificatesBelarus?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificatesEurope?.setTextColor(resources.getColor(R.color.light_font_grey))
        }

        vb?.tvCertificatesBelarus?.setOnClickListener {
            updateUI(gostBelarus, R.string.certificates_belarus )
//            vb?.tvCertificates340282016?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificates5781482?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificatesBelarus?.setTextColor(resources.getColor(R.color.blue_dark))
//            vb?.tvCertificatesEurope?.setTextColor(resources.getColor(R.color.light_font_grey))
        }

        vb?.tvCertificatesEurope?.setOnClickListener {
            updateUI(gostEurope, R.string.certificates_europe )
//            vb?.tvCertificates340282016?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificates5781482?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificatesBelarus?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificatesEurope?.setTextColor(resources.getColor(R.color.blue_dark))
        }

        vb?.tvCertificates340282016?.setOnClickListener {
            updateUI(gost34028_2016, R.string.certificates_34028_2016 )
//            vb?.tvCertificates340282016?.setTextColor(resources.getColor(R.color.blue_dark))
//            vb?.tvCertificates5781482?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificatesBelarus?.setTextColor(resources.getColor(R.color.light_font_grey))
//            vb?.tvCertificatesEurope?.setTextColor(resources.getColor(R.color.light_font_grey))
        }
    }

    private fun updateUI(data: List<AppEntity>, text: Int) {
        vb?.tvCertificateTitle?.text = getString(text)
        initRV(data)
    }

    private fun initRV(data: List<AppEntity>) = with(vb) {
        this?.rvCertificate?.adapter = BaseRVAdapter(
            requireContext(),
            this@FragmentCertificates,
            data
        )
    }

    override fun onItemClick(entity: AppEntity, imageView: ImageView) {
        val intent = Intent(activity, PictureActivity::class.java)
        val imageViewPair = Pair<View, String>(imageView, getString(R.string.transition_certificate))
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), imageViewPair)
        intent.putExtra("Picture", Picture(entity.id,entity.title, entity.path))
        startActivity(intent, options.toBundle())
    }
}