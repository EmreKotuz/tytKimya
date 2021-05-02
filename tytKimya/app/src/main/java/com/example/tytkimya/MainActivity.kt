package com.example.tytkimya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotuzapp.tytkimya.kronometre
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        konularButton.setOnClickListener {
            var intent=Intent(this,konular::class.java)
            startActivity(intent)

        }

        kisaNott.setOnClickListener {
            var intent=Intent(this, kisaNotlarActivity::class.java)
            startActivity(intent)
        }
        bitu.setOnClickListener {
            var intent=Intent(this, kronometre::class.java)
            startActivity(intent)
        }
    }
}
