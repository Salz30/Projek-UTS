package com.example.projekgallery //nama paket dari projek gallery yang akan dibuat

import android.content.Intent   // Digunakan untuk satu activity ke activity lain
import android.os.Bundle    // Digunakan untuk menyimpan data
import android.os.Handler   // Digunakan untuk menunda perpindahan ke MainActivity
import androidx.appcompat.app.AppCompatActivity     // Kelas dasar untuk aktivitas yang menggunakan fitur dukungan dari Android

class SplashScreenActivity : AppCompatActivity() {      // Kelas SplashScreenActivity turunan dari AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {    // Metode yang dipanggil saat aktivitas dibuat
        super.onCreate(savedInstanceState)      // Memanggil metode kelas induk
        setContentView(R.layout.activity_splash_screen) // Sesuaikan dengan layout splash screen Anda

        // Menggunakan Handler untuk menunggu beberapa detik sebelum berpindah ke MainActivity
        Handler().postDelayed({     // Handler untuk menunda perpindahan
            // Intent untuk berpindah ke MainActivity
            val intent = Intent(this, LoginActivity::class.java)    // Intent untuk berpindah ke LoginActivity
            startActivity(intent)       // Memulai aktivitas baru
            finish() // Menutup SplashScreenActivity agar tidak bisa kembali
        }, 3000) // Waktu tunggu dalam milidetik (3000 ms = 3 detik)
    }
}