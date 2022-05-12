package ru.alinadorozhkina.tula_steel.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.bumptech.glide.Glide
import com.google.android.material.appbar.MaterialToolbar
import ru.alinadorozhkina.tula_steel.databinding.ActivityPictureBinding
import ru.alinadorozhkina.tula_steel.entities.AppEntity
import android.R
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

const val SECONDS: Long = 60000

class PictureActivity : AppCompatActivity() {

    private var vb: ActivityPictureBinding? = null
    lateinit var countDownTimer: CountDownTimer
    private var picture: AppEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityPictureBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        setUpToolbar()
        setUpTimer()
        setUpPictureLoading()
    }

    private fun setUpPictureLoading() {
        picture = intent.getParcelableExtra("Picture")
        picture?.let { picture ->
            Log.d("Picture activity", picture.toString())
            vb?.tvCertificateTitle?.text = getString(picture.title)
            supportPostponeEnterTransition()
            vb?.image?.load(picture.path) {
                supportStartPostponedEnterTransition()
            }
        }
    }

    private fun setUpTimer() {
        countDownTimer = object : CountDownTimer(SECONDS, 1000) {
            override fun onTick(millisUntilFinished: Long) = Unit
            override fun onFinish() = toMain()
        }.start()
    }

    private fun setUpToolbar() {
        val toolbar: MaterialToolbar? = vb?.topAppBar
        setSupportActionBar(toolbar)
        toolbar!!.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun toMain() {
        startActivity(MainActivity.getStartIntent(this))
        finish()
    }

    override fun onBackPressed() {
        toMain()
    }

    override fun onUserInteraction() {
        countDownTimer.cancel()
        countDownTimer.start()
        Log.d("PictureActivity", "onUserInteraction()")

    }

    override fun onDestroy() {
        vb = null
        super.onDestroy()
    }

    override fun onStop() {
        countDownTimer.cancel()
        super.onStop()
    }

    companion object {
        fun getStartIntent(context: Context) = Intent(context, PictureActivity::class.java)
    }
}

    fun ImageView.load(url: Int, onLoadingFinished: () -> Unit = {}) {
        val listener = object : RequestListener<Drawable> {
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target <Drawable>?, isFirstResource: Boolean): Boolean {
                onLoadingFinished()
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                onLoadingFinished()
                return false
            }
        }
        Glide.with(this)
            .load(url)
            .apply(RequestOptions.placeholderOf(R.drawable.picture_frame))
            .listener(listener)
            .into(this)
    }