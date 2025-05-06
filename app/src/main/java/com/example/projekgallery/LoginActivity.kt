package com.example.projekgallery //nama paket dari projek yang dibuat

import android.content.Context  // Digunakan untuk menyimpan data
import android.content.Intent   // Digunakan untuk satu activity ke activity lain
import android.os.Bundle    // Digunakan untuk menyimpan data
import android.util.Log    // Digunakan untuk melakukan logging
import android.widget.Button    // Digunakan untuk tombol
import android.widget.EditText  // Digunakan untuk input teks
import android.widget.Toast   // Digunakan untuk menampilkan pesan toast
import androidx.activity.enableEdgeToEdge   // Digunakan untuk mengaktifkan fitur edge-to-edge
import androidx.appcompat.app.AppCompatActivity    // Kelas dasar untuk aktivitas yang menggunakan fitur dukungan dari Android

class LoginActivity : AppCompatActivity() {  // Kelas LoginActivity turunan dari AppCompatActivity
    lateinit var usernameInput: EditText    // Variabel untuk input username
    lateinit var passwordInput: EditText    // Variabel untuk input password
    lateinit var loginBtn: Button   // Variabel untuk tombol login
    lateinit var buttonRegister: Button    // Variabel untuk tombol register

    override fun onCreate(savedInstanceState: Bundle?) {    // Metode yang dipanggil saat aktivitas dibuat
        super.onCreate(savedInstanceState)    // Memanggil metode kelas induk
        enableEdgeToEdge()      // Mengaktifkan fitur edge-to-edge
        setContentView(R.layout.activity_login)     // Mengatur tampilan aktivitas dari layout activity_login

        usernameInput = findViewById(R.id.username_input)    // Inisialisasi variabel usernameInput dengan komponen EditText dari layout
        passwordInput = findViewById(R.id.password_input)   // Inisialisasi variabel passwordInput dengan komponen EditText dari layout
        loginBtn = findViewById(R.id.login_btn)     // Inisialisasi variabel loginBtn dengan komponen Button dari layout
        buttonRegister = findViewById(R.id.register_btn) // Inisialisasi buttonRegister

        loginBtn.setOnClickListener {   // Menambahkan listener klik pada tombol login
            val username = usernameInput.text.toString()    // Mengambil teks dari input username dan menyimpannya dalam variabel username
            val password = passwordInput.text.toString()    // Mengambil teks dari input password dan menyimpannya dalam variabel password
            Log.i("test credentials", "Username : $username and Password : $password")  // Melakukan logging untuk username dan password yang dimasukkan

            // Ambil data dari SharedPreferences
            val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)     // Membuat objek SharedPreferences untuk mengambil data pengguna
            val savedUsername = sharedPreferences.getString("username", "")   // Mengambil username dari SharedPreferences dengan kunci "username"
            val savedPassword = sharedPreferences.getString("password", "")   // Mengambil password dari SharedPreferences dengan kunci "password"

            // Periksa apakah data sesuai
            if (username == savedUsername && password == savedPassword) {
                // Data login sesuai, navigasi ke GalleryActivity
                val intent = Intent(this, GalleryActivity::class.java)
                startActivity(intent)
            } else {
                // Data login salah
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show() // Menampilkan pesan toast bahwa data login salah
            }
        }

        buttonRegister.setOnClickListener {     // Menambahkan listener klik pada tombol register
            // Log saat tombol register diklik di halaman login
            Log.d("LoginActivity", "Tombol Register diklik di halaman login")
            // Menampilkan Toast pada halaman login
            Toast.makeText(this, "Pindah ke halaman Register", Toast.LENGTH_SHORT).show()

            // Navigasi ke RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)    // Membuat objek Intent untuk berpindah ke RegisterActivity
            startActivity(intent)   // Memulai aktivitas baru
        }
    }
}