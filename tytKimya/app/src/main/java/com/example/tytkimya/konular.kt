package com.example.tytkimya

import android.content.Intent
import android.net.Uri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotuzapp.tytkimya.haberler
import kotlinx.android.synthetic.main.activity_konular.*
import kotlinx.android.synthetic.main.activity_mesaj.*
import java.util.*

class konular : AppCompatActivity() {
    val randommmm= arrayListOf(R.mipmap.a,R.mipmap.aaa,R.mipmap.aaaa,R.mipmap.e)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konular)



        whatsappKonular.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.whatsapp.com/GRZSUy3EFbLKzOemS6ZRKk"))
            startActivity(i)
        }

        haber.setOnClickListener {
            var intent = Intent(this,haberler::class.java)
            startActivity(intent)
        }
        diger.setOnClickListener {
            whatsappKonular.visibility=View.VISIBLE
            textView25.visibility=View.VISIBLE
            textView52.visibility=View.VISIBLE
            yorum.visibility=View.VISIBLE
            textView45.visibility=View.VISIBLE
        }

        yorum.setOnClickListener {
            var intent=Intent(this, kullaniciYorum::class.java)
            startActivity(intent)
        }
        kimyaGelisimi.setOnClickListener {
            var intent=Intent(this, kimyaGelisimiActivity::class.java)
            startActivity(intent)
        }
        kimyaKanun.setOnClickListener {
            var intent=Intent(this, kimyaKanunActivity::class.java)
            startActivity(intent)
        }
        maddeveozellikButton.setOnClickListener {
            var intent=Intent(this,maddeVeOzellikleriActivity::class.java)
            startActivity(intent)
        }
        molButton.setOnClickListener {
            var intent=Intent(this,molKavramActivity::class.java)
            startActivity(intent)
        }
        atomButton.setOnClickListener {
            var intent=Intent(this,atomveYapisiActivity::class.java)
            startActivity(intent)
        }
        bilesikButton.setOnClickListener {
            var intent=Intent(this,bilesiklerActivity::class.java)
            startActivity(intent)
        }
        peryodikButton.setOnClickListener {
            var intent=Intent(this,peryodikTabloActivity::class.java)
            startActivity(intent)
        }



        imageee.setOnClickListener {
            val random = Random()
            val button = random.nextInt(randommmm.count())
            imageee.setImageResource(randommmm[button])
        }
        val random = Random()
        val button = random.nextInt(randommmm.count())
        imageee.setImageResource(randommmm[button])


    }
}
