package com.example.tytkimya

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mesaj.*

class mesaj : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesaj)


        cografya.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.kotuzapp.tytcografya"))
            startActivity(i)
        }

        matematik.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.matematik.emre4.tytmatematik"))
            startActivity(i)
        }

        temelmatematik.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.matematik.emre4.a10admdamatematik"))
            startActivity(i)
        }

        bitu.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.kotuz.mesajbulutu"))
            startActivity(i)
        }

        whatsapp.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk"))
            startActivity(i)
        }


    }
}
