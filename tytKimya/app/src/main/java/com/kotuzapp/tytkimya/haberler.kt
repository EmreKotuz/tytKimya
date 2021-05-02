package com.kotuzapp.tytkimya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tytkimya.R
import kotlinx.android.synthetic.main.activity_haberler.*

class haberler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haberler)

        webHaber.loadUrl("https://teknoek.com/index.php")
    }
}
