package ru.alinadorozhkina.tula_steel.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import ru.alinadorozhkina.tula_steel.databinding.ActivityPictureBinding
import ru.alinadorozhkina.tula_steel.databinding.ActivityProductBinding
import ru.alinadorozhkina.tula_steel.entities.Picture

class PictureActivity : AppCompatActivity() {

    private var vb: ActivityPictureBinding? = null

    var picture: Picture? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityPictureBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        picture= intent.getParcelableExtra("Picture")
        vb?.image?.let {
            Glide
                .with(this)
                .load(picture?.path)
                .into(it)
        }
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, PictureActivity::class.java)
    }
}