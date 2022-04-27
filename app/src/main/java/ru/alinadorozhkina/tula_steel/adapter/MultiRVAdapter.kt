package ru.alinadorozhkina.tula_steel.adapter

import android.content.Context
import android.provider.Settings.System.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.databinding.MainCategoryItemViewBinding
import ru.alinadorozhkina.tula_steel.databinding.MainTitleItemViewBinding
import ru.alinadorozhkina.tula_steel.entities.AppEntity

class MultiRVAdapter(
    val context: Context,
    private var data: List<AppEntity>,
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == TYPE_TITLE) {
            MainTitleItemViewHolder(
                inflater.inflate(
                    R.layout.main_title_item_view, parent,
                    false
                ) as View
            )
        } else {
            MainCategoryItemViewHolder(
                inflater.inflate(
                    R.layout.main_category_item_view, parent,
                    false
                ) as View
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_TITLE) {
            holder as MainTitleItemViewHolder
            holder.bind(data[position])
        } else {
            holder as MainCategoryItemViewHolder
            holder.bind(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].id == 0) TYPE_TITLE else
            TYPE_CATEGORIES
    }

    inner class MainCategoryItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ui: MainCategoryItemViewBinding = MainCategoryItemViewBinding.bind(itemView)

        fun bind(data: AppEntity) {
            ui.ivPicture.setImageResource(data.path)
            ui.tvTitle.text = context.getString(data.title)
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(data)
            }
        }
    }

    inner class MainTitleItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ui: MainTitleItemViewBinding = MainTitleItemViewBinding.bind(itemView)

        fun bind(data: AppEntity) {
            ui.tvOurProduction.text = context.getString(data.title)
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(data)
            }
        }
    }

    companion object {
        private const val TYPE_TITLE = 0
        private const val TYPE_CATEGORIES = 1
    }

}