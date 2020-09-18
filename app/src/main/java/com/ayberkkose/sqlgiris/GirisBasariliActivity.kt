package com.ayberkkose.sqlgiris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_giris_basarili.*

class GirisBasariliActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris_basarili)

        userNameTextView.text=intent.getStringExtra("username")
    }
}