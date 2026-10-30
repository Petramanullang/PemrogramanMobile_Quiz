package com.example.prak6

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RingkasanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ringkasan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nama = intent.getStringExtra("EXTRA_NAMA") ?: "-"
        val layanan = intent.getStringExtra("EXTRA_LAYANAN") ?: "-"
        val tanggal = intent.getStringExtra("EXTRA_TANGGAL") ?: "-"
        val waktu = intent.getStringExtra("EXTRA_WAKTU") ?: "-"

        findViewById<TextView>(R.id.tvNama).text = getString(R.string.ringkasan_nama, nama)
        findViewById<TextView>(R.id.tvLayanan).text = getString(R.string.ringkasan_layanan, layanan)
        findViewById<TextView>(R.id.tvTanggal).text = getString(R.string.ringkasan_tanggal, tanggal)
        findViewById<TextView>(R.id.tvWaktu).text = getString(R.string.ringkasan_waktu, waktu)

        val teksJadwal = "Jadwal Konsultasi\n" +
                "Peserta: $nama\n" +
                "Layanan: $layanan\n" +
                "Tanggal: $tanggal\n" +
                "Pukul: $waktu\n"

        val btnBagikan = findViewById<Button>(R.id.btnBagikan)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        btnBagikan.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Jadwal Konsultasi")
                putExtra(Intent.EXTRA_TEXT, teksJadwal)
            }
            startActivity(Intent.createChooser(share, "Bagikan Jadwal Melalui"))
        }

        btnEmail.setOnClickListener {
            val email = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("admin@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Jadwal Konsultasi - $nama")
                putExtra(Intent.EXTRA_TEXT, teksJadwal)
            }
            try {
                startActivity(email)
            } catch (_: ActivityNotFoundException) {
                Toast.makeText(this, "Tidak ada aplikasi email", Toast.LENGTH_SHORT).show()
            }
        }

        btnKembali.setOnClickListener {
            finish()
        }
    }
}