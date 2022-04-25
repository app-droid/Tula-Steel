package ru.alinadorozhkina.tula_steel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.databinding.FragmentAboutBinding
import ru.alinadorozhkina.tula_steel.databinding.FragmentDetailedProductBinding
import ru.alinadorozhkina.tula_steel.entities.Product


class BaseFragment : Fragment() {
    private var vb: FragmentDetailedProductBinding? = null

    private val product: Product?
        get() = arguments?.getParcelable("Product")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailedProductBinding.inflate(inflater, container, false).apply {
        vb = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product?.let { product ->
            vb?.ivMainPicture?.setImageResource(product.picture)
            vb?.tvProductTitle?.text = getString(product.title)
            product.description?.let {
                vb?.tvDescription?.text = getString(it)  }

            vb?.layoutStub?.layoutResource = product.itemLayoutId
            vb?.layoutStub?.inflate()

            product.marki?.let {
                vb?.tvMarkaValue?.text = getString(it)  } ?: vb?.linearForMainContent?.removeViews(4, 2)

            vb?.tvUpakovkaValue?.text = getString(product.upakovka)
        }
    }


    companion object {

        fun newInstance(product: Product): BaseFragment = run {
            val args = Bundle()
            args.putParcelable("Product", product)
            val fragment = BaseFragment()
            fragment.arguments = args
            return fragment
        }
    }
}