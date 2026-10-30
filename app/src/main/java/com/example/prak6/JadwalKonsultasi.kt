package com.example.prak6

// Model data satu item jadwal konsultasi
data class JadwalKonsultasi(
    val nama: String,
    val layanan: String,
    val tanggal: String,
    val waktu: String,
    val status: String = "Menunggu"
)
