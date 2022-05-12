package ru.alinadorozhkina.tula_steel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.alinadorozhkina.tula_steel.R
import ru.alinadorozhkina.tula_steel.databinding.ItemPictureAboutBinding
import ru.alinadorozhkina.tula_steel.entities.AppEntity
import ru.alinadorozhkina.tula_steel.entities.Picture


class PictureAdapter(
    val context: Context,
) : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    private val pictures: List<Picture> = listOf(
        Picture(1.0, 1, R.drawable.about_picture1),
        Picture(1.0, 1, R.drawable.about_picture2),
        Picture(1.0, 1, R.drawable.about_picture3),
        Picture(1.0, 1, R.drawable.about_picture4),
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_picture_about, parent, false)
        return PictureViewHolder(view)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(pictures[position] )
    }

    override fun getItemCount() = pictures.size

    inner class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ui: ItemPictureAboutBinding = ItemPictureAboutBinding.bind(itemView)

        fun bind(product: AppEntity) {
            ui.ivPictureAbout.setImageResource(product.path)
        }
    }

}