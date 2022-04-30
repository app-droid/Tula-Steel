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

class PictureActivity : AppCompatActivity() {

    private var vb: ActivityPictureBinding? = null
    lateinit var countDownTimer: CountDownTimer
    private var picture: AppEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityPictureBinding.inflate(layoutInflater)
        setContentView(vb?.root)
        setUpPictureLoading()
        setUpToolbar()
        setUpTimer()
    }

    private fun setUpPictureLoading() {
        picture= intent.getParcelableExtra("Picture")
        picture?.let { picture ->
            vb?.tvCertificateTitle?.text = getString(picture.title)
            vb?.image?.let {
                Glide
                    .with(this)
                    .load(picture.path)
                    .into(it)
            }
        }
    }

    private fun setUpTimer(){
        countDownTimer = object : CountDownTimer(40000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                Log.d("ProductActivity", "onTick")
            }
            override fun onFinish() {
                Log.d("ProductActivity", "onFinish")
                finish()
            }
        }.start()
    }

    private fun setUpToolbar() {
        val toolbar: MaterialToolbar? = vb?.topAppBar
        setSupportActionBar(toolbar)
        toolbar!!.setNavigationOnClickListener {
            finish()
        }
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