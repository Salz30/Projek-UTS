package com.example.projekgallery   //nama paket dari projek yang dibuat

import android.os.Bundle    // Digunakan untuk menyimpan data
import android.content.Intent   // Digunakan untuk satu activity ke activity lain
import android.net.Uri    // Digunakan untuk operasi URI
import androidx.appcompat.app.AppCompatActivity   //Kelas dasar untuk aktivitas yang menggunakan fitur dukungan dari Android
import androidx.recyclerview.widget.RecyclerView    // Digunakan untuk recyclerview
import androidx.recyclerview.widget.StaggeredGridLayoutManager  // Digunakan untuk recyclerview
import android.view.LayoutInflater   // Digunakan untuk membuat tampilan dari layout
import android.view.View    // Digunakan untuk menampilkan tampilan
import android.view.ViewGroup   // Digunakan untuk menampilkan tampilan
import android.widget.ImageView   // Digunakan untuk menampilkan gambar
import com.bumptech.glide.Glide   // Digunakan untuk memuat gambar dari URL

class GalleryActivity : AppCompatActivity() {   // Kelas GalleryActivity turunan dari AppCompatActivity

    private lateinit var recyclerView: RecyclerView    // Variabel untuk recyclerview
    private val imageUrls = listOf(    // Daftar URL gambar yang akan ditampilkan
        "https://i.pinimg.com/736x/59/0e/bf/590ebf99228b2e98589685f3ad84b6a7.jpg",
        "https://i.pinimg.com/736x/01/33/5c/01335cf6a028de208feb754a13d12a63.jpg",
        "https://i.pinimg.com/736x/e7/bc/f3/e7bcf3938e72a8e46c0321bd87d17074.jpg",
        "https://i.pinimg.com/736x/3c/bb/1a/3cbb1a3a5d8ff82c1b16f74d319e80d0.jpg",
        "https://i.pinimg.com/736x/60/a3/2c/60a32c450a1eb8e8b241aba1cecbce0c.jpg",
        "https://i.pinimg.com/736x/c7/13/f4/c713f48c516389cd9c47dcfa87636d57.jpg",
        "https://i.pinimg.com/736x/a9/6d/eb/a96debb71d00f2647cd7c2a0e0cd8a5e.jpg",
        "https://i.pinimg.com/736x/93/03/6a/93036aaa3b538c2f67c93cb94c8034e7.jpg",
        "https://i.pinimg.com/736x/2c/92/54/2c9254848977d4a9402889ba9a01d429.jpg",
        "https://i.pinimg.com/736x/46/4d/2c/464d2cd92f8f4e35c6668b1a4b156fe0.jpg"

    )

    override fun onCreate(savedInstanceState: Bundle?) {   // Metode yang dipanggil saat aktivitas dibuat
        super.onCreate(savedInstanceState)    // Memanggil metode kelas induk
        setContentView(R.layout.activity_gallery)   // Mengatur tampilan aktivitas dari layout activity_gallery

        recyclerView = findViewById(R.id.galleryRecyclerView)    // Inisialisasi variabel recyclerView dengan komponen RecyclerView dari layout
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)     // Mengatur layout manager untuk RecyclerView menjadi StaggeredGridLayoutManager dengan 2 kolom dan orientasi vertikal
        recyclerView.adapter = GalleryAdapter(imageUrls)    // Mengatur adapter untuk RecyclerView dengan GalleryAdapter yang telah dibuat
    }

    private inner class GalleryAdapter(private val images: List<String>) :   // Kelas GalleryAdapter turunan dari
        RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {      // RecyclerView.Adapter yang digunakan untuk menampilkan gambar

        inner class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {     // Kelas GalleryViewHolder turunan dari RecyclerView.ViewHolder yang digunakan untuk menampilkan gambar
            val imageView: ImageView = itemView.findViewById(R.id.imageViewItem)    // Inisialisasi variabel imageView dengan komponen ImageView dari layout
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {    // Metode yang dipanggil saat ViewHolder baru dibuat
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)    // Membuat tampilan dari layout item_image
            return GalleryViewHolder(view)   // Mengembalikan ViewHolder dengan tampilan yang telah dibuat
        }

        override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {    // Metode yang dipanggil saat ViewHolder harus ditampilkan
            val imageUrl = images[position]     // Mengambil URL gambar dari daftar berdasarkan posisi
            Glide.with(holder.imageView.context)    // Menggunakan Glide untuk memuat gambar dari URL
                .load(imageUrl)     // Mengatur URL gambar yang akan ditampilkan
                .centerCrop()       // Mengatur agar gambar terpotong agar sesuai dengan tampilan
                .into(holder.imageView) // Menampilkan gambar ke dalam ImageView

            // Tambahkan ini untuk menangani klik
            holder.itemView.setOnClickListener {   // Menambahkan listener klik pada setiap item gambar
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(imageUrl))    // Membuat Intent untuk membuka URL gambar
                holder.itemView.context.startActivity(intent)   // Memulai aktivitas baru untuk membuka URL gambar
            }
        }
        override fun getItemCount() = images.size   // Metode yang mengembalikan jumlah item dalam RecyclerView
    }
}