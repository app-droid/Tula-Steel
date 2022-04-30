package ru.alinadorozhkina.tula_steel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.databinding.ItemCertificateCardBinding
import ru.alinadorozhkina.tula_steel.entities.AppEntity

interface OnItemClickListener {
    fun onItemClick(entity: AppEntity, imageView: ImageView)
}

class BaseRVAdapter(
    val context: Context,
    private val onItemClickListener: OnItemClickListener,
    private val products: List<AppEntity>,
) : RecyclerView.Adapter<BaseRVAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_certificate_card, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(products[position] )
    }

    override fun getItemCount() = products.size

    inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ui: ItemCertificateCardBinding = ItemCertificateCardBinding.bind(itemView)

        fun bind(product: AppEntity) {
            ui.tvTitle.text = context.getString(product.title)
            ui.ivPictureCertificate.setImageResource(product.path)
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(product, ui.ivPictureCertificate)
            }
        }
    }
}