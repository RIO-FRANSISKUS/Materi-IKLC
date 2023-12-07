package com.example.rumahadatapps

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class RumahAdatDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rumah_adat_detail)

        val ivRumahAdat: ImageView = findViewById(R.id.image_rumah_adat)
        val iv1: ImageView = findViewById(R.id.image1)
        val iv2: ImageView = findViewById(R.id.image2)
        val iv3: ImageView = findViewById(R.id.image3)
        val tvNameRumahAdat: TextView = findViewById(R.id.titleTextView)
        val tvOriginRumahAdat: TextView = findViewById(R.id.OriginTextView)
        val tvDescRumahAdat: TextView = findViewById(R.id.descriptionTextView)
        val tvphilosophy: TextView = findViewById(R.id.philosophy)
        val btnShare: Button = findViewById(R.id.action_share)

        val rumahAdat = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("key_rumah_adat", RumahAdat::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("key_rumah_adat")
        }

        if (rumahAdat != null){
            ivRumahAdat.setImageResource(rumahAdat.photo)
            tvNameRumahAdat.text = rumahAdat.name
            tvOriginRumahAdat.text = rumahAdat.origin
            tvDescRumahAdat.text = rumahAdat.description
            tvphilosophy.text = rumahAdat.philosophy

            loadImage(rumahAdat.image1, iv1)
            loadImage(rumahAdat.image2, iv2)
            loadImage(rumahAdat.image3, iv3)
        }

        btnShare.setOnClickListener{
            val url = rumahAdat?.source

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, url)
            val chooser = Intent.createChooser(intent, "Share Using: ")
            startActivity(chooser)
        }

    }

    private fun loadImage(url: String?, imageView: ImageView) {
        if (url.isNullOrEmpty()) {
            imageView.setImageResource(R.drawable.ic_baseline_share_24)
            return
        }

        val fixedUrl = url.replace("&amp", "&")
        Picasso.get()
            .load(fixedUrl)
            .placeholder(R.drawable.ic_baseline_share_24)
            .error(R.drawable.ic_launcher_background)
            .resize(300, 300)
            .into(imageView)
    }
}