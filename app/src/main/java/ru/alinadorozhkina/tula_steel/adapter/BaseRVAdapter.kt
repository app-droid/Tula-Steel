package ru.alinadorozhkina.tula_steel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.alinadorozhkina.tula_steel.entities.AppEntity

interface OnItemClickListener {
    fun onItemClick(entity: AppEntity)
}

class BaseRVAdapter(
    private val onItemClickListener: OnItemClickListener,
    private val products: List<AppEntity>,
    private val itemLayoutId: Int,
    private val bind: ((View, data: AppEntity) -> Unit)
) : RecyclerView.Adapter<BaseRVAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(itemLayoutId, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size

    inner class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        //private val ui: ItemCardBinding = ItemCardBinding.bind(root)

        fun bind(product: AppEntity) {
            bind(root, product)
            root.setOnClickListener {
                onItemClickListener.onItemClick(product)
            }
        }
    }
}