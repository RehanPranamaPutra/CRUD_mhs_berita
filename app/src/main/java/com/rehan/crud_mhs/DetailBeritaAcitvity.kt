package com.rehan.crud_mhs

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailBeritaAcitvity : AppCompatActivity() {

    private lateinit var imgDetailBerita : ImageView
    private lateinit var txtDetailTitle : TextView
    private lateinit var txtDetailIsiBerita : TextView
    private lateinit var txtTanggalBerita : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_berita_acitvity)

        imgDetailBerita = findViewById(R.id.imgDetailBerita)
        txtDetailTitle = findViewById(R.id.txtDetailTitle)
        txtDetailIsiBerita = findViewById(R.id.txtDetailIsiBerita)
        txtTanggalBerita = findViewById(R.id.txtDetailTglBerita)


        val title = intent.getStringExtra("title")
        val isiBerita = intent.getStringExtra("isi_berita")
        val tglBerita = intent.getStringExtra("tgl_berita")
        val img = intent.getStringExtra("gambar_berita")

        Glide.with(this)
            .load("http://192.168.211.66/beritadb/gambar_berita/$img")
            .centerCrop()
            .into(imgDetailBerita)


        txtDetailTitle.text = title
        txtDetailIsiBerita.text = isiBerita
        txtTanggalBerita.text = tglBerita


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}