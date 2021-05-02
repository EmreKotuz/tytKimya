package com.example.tytkimya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_animasyon.*

class animasyon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animasyon)

        //val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb);
        // val yazi = findViewById(R.id.yazi) as TextView
        //val subtitlee = findViewById(R.id.yazi) as TextView
        val stt = AnimationUtils.loadAnimation(this, R.anim.animation)

        val animation = AnimationUtils.loadAnimation(this, R.anim.animation)
        val subtitle = findViewById(R.id.image) as ImageView
        image.startAnimation(animation)
        subtitle.startAnimation(stt)

        // yazi . startAnimation (ttb)
        //  subtitlee.startAnimation(ttb)


        object : CountDownTimer(2000, 2000) {
            override fun onFinish() {

                var intent = Intent(applicationContext, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)

            }
            override fun onTick(millisUntilFinished: Long) {
            }

        }.start()
    }   }
