package com.example.prak6

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DaftarJadwalKonsultasi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_jadwal_konsultasi)

        // Jaga judul & tombol Kembali agar tidak tertutup system bar (edge-to-edge)
        terapkanInsetSistem()

        val rvJadwal = findViewById<RecyclerView>(R.id.rvJadwal)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        val adapter = JadwalKonsultasiAdapter(
            daftarJadwal = buatDataJadwal(),
            onItemClick = { jadwal ->
                Toast.makeText(
                    this,
                    "${jadwal.nama}\n${jadwal.layanan}\n${jadwal.tanggal} pukul ${jadwal.waktu}",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onHapus = { jadwal ->
                Toast.makeText(this, "Jadwal ${jadwal.nama} dihapus", Toast.LENGTH_SHORT).show()
            }
        )

        rvJadwal.layoutManager = LinearLayoutManager(this)
        rvJadwal.adapter = adapter

        btnKembali.setOnClickListener { finish() }
    }

    // 12 data dummy jadwal konsultasi (minimal 10 sesuai ketentuan kuis)
    private fun buatDataJadwal(): MutableList<JadwalKonsultasi> = mutableListOf(
        JadwalKonsultasi("Andi Pratama", "Konsultasi Akademik", "10/11/2026", "09:00"),
        JadwalKonsultasi("Bunga Lestari", "Konsultasi Skripsi", "11/11/2026", "10:30"),
        JadwalKonsultasi("Cahyo Nugroho", "Konsultasi Beasiswa", "12/11/2026", "13:00"),
        JadwalKonsultasi("Dewi Anggraini", "Konsultasi Karier", "13/11/2026", "14:30"),
        JadwalKonsultasi("Eko Saputra", "Konsultasi Akademik", "14/11/2026", "08:00"),
        JadwalKonsultasi("Fitri Handayani", "Konsultasi Skripsi", "16/11/2026", "09:30"),
        JadwalKonsultasi("Gilang Ramadhan", "Konsultasi Beasiswa", "17/11/2026", "11:00"),
        JadwalKonsultasi("Hana Safitri", "Konsultasi Karier", "18/11/2026", "13:30"),
        JadwalKonsultasi("Irfan Hakim", "Konsultasi Akademik", "19/11/2026", "15:00"),
        JadwalKonsultasi("Jessica Siregar", "Konsultasi Skripsi", "20/11/2026", "10:00"),
        JadwalKonsultasi("Kevin Manurung", "Konsultasi Beasiswa", "23/11/2026", "08:30"),
        JadwalKonsultasi("Lia Simanjuntak", "Konsultasi Karier", "24/11/2026", "14:00")
    )
}
