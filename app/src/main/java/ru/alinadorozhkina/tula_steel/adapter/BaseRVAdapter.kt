package ru.alinadorozhkina.tula_steel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.alinadorozhkina.tula_steel.entities.Product

class BaseRVAdapter(
    private val products: List<Product>,
    private val itemLayoutId: Int,
    private val bind: ((View, data: Product) -> Unit)
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

        fun bind(product: Product) {
            bind(root, product)
        }
    }
}