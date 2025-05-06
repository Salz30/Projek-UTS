package com.example.projekgallery //nama paket dari projek yang dibuat

import android.content.Context   // Digunakan untuk menyimpan data
import android.content.Intent   // Digunakan untuk satu activity ke activity lain
import android.os.Bundle    // Digunakan untuk menyimpan data
import android.util.Log    // Digunakan untuk melakukan logging
import android.widget.Button    // Digunakan untuk tombol
import android.widget.EditText   // Digunakan untuk input teks
import android.widget.Toast  // Digunakan untuk menampilkan pesan toast
import androidx.activity.enableEdgeToEdge   // Digunakan untuk mengaktifkan fitur edge-to-edge
import androidx.appcompat.app.AppCompatActivity   //Kelas dasar untuk aktivitas yang menggunakan fitur dukungan dari Android

class RegisterActivity : AppCompatActivity() {  // Kelas RegisterActivity turunan dari AppCompatActivity

    private lateinit var usernameInput: EditText   // Variabel untuk input username
    private lateinit var passwordInput: EditText  // Variabel untuk input password
    private lateinit var registerBtn: Button    // Variabel untuk tombol register

    override fun onCreate(savedInstanceState: Bundle?) {   // Metode yang dipanggil saat aktivitas dibuat
        super.onCreate(savedInstanceState)   // Memanggil metode kelas induk
        enableEdgeToEdge()   // Mengaktifkan fitur edge-to-edge
        setContentView(R.layout.activity_register)   // Mengatur tampilan aktivitas dari layout activity_register

        usernameInput = findViewById(R.id.editTextUsername)  // Inisialisasi variabel usernameInput dengan komponen EditText dari layout
        passwordInput = findViewById(R.id.editTextPassword)  // Inisialisasi variabel passwordInput dengan komponen EditText dari layout
        registerBtn = findViewById(R.id.buttonRegister)   // Inisialisasi variabel registerBtn dengan komponen Button dari layout

        registerBtn.setOnClickListener {    // Menambahkan listener klik pada tombol register
            val username = usernameInput.text.toString()    // Mengambil teks dari input username dan menyimpannya dalam variabel username
            val password = passwordInput.text.toString()    // Mengambil teks dari input password dan menyimpannya dalam variabel password

            Log.d("RegisterActivity", "Mencoba melakukan registrasi dengan username: $username")    // Melakukan logging untuk username yang akan didaftarkan

            if (username.isNotEmpty() && password.isNotEmpty()) {   // Memeriksa apakah username dan password tidak kosong
                // Simpan ke SharedPreferences
                val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)     // Membuat objek SharedPreferences untuk menyimpan data pengguna
                val editor = sharedPreferences.edit()   // Membuat objek Editor untuk mengubah data dalam SharedPreferences
                editor.putString("username", username)  // Menyimpan username ke dalam SharedPreferences dengan kunci "username"
                editor.putString("password", password)  // Menyimpan password ke dalam SharedPreferences dengan kunci "password"
                editor.apply()  // Menyimpan perubahan ke SharedPreferences secara asinkron

                Log.d("RegisterActivity", "Registrasi berhasil untuk username: $username")  // Melakukan logging untuk registrasi berhasil
                Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()    // Menampilkan pesan toast registrasi berhasil

                // Navigasi ke LoginActivity
                val intent = Intent(this, LoginActivity::class.java)    // Membuat objek Intent untuk berpindah ke LoginActivity
                startActivity(intent)   // Memulai aktivitas baru
            } else {    // Jika username atau password kosong
                Log.w("RegisterActivity", "Username atau password kosong")  // Melakukan logging untuk username atau password kosong
                Toast.makeText(this, "Username dan Password harus diisi", Toast.LENGTH_SHORT).show()    // Menampilkan pesan toast bahwa username dan password harus diisi
            }
        }
    }
}