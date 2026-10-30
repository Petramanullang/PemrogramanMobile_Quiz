package com.example.prak6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JadwalKonsultasiAdapter(
    private val daftarJadwal: MutableList<JadwalKonsultasi>,
    private val onItemClick: (JadwalKonsultasi) -> Unit,
    private val onHapus: (JadwalKonsultasi) -> Unit
) : RecyclerView.Adapter<JadwalKonsultasiAdapter.JadwalViewHolder>() {

    class JadwalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvInisial: TextView = itemView.findViewById(R.id.tvInisial)
        val tvNama: TextView = itemView.findViewById(R.id.tvNama)
        val tvLayanan: TextView = itemView.findViewById(R.id.tvLayanan)
        val tvTanggalWaktu: TextView = itemView.findViewById(R.id.tvTanggalWaktu)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
        val btnHapus: ImageButton = itemView.findViewById(R.id.btnHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jadwal_konsultasi, parent, false)
        return JadwalViewHolder(view)
    }

    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
        val jadwal = daftarJadwal[position]
        holder.tvInisial.text = jadwal.nama.first().uppercase()
        holder.tvNama.text = jadwal.nama
        holder.tvLayanan.text = jadwal.layanan
        holder.tvTanggalWaktu.text = holder.itemView.context.getString(
            R.string.tanggal_waktu, jadwal.tanggal, jadwal.waktu
        )
        holder.tvStatus.text = jadwal.status

        holder.itemView.setOnClickListener { onItemClick(jadwal) }
        holder.btnHapus.setOnClickListener {
            val posisi = holder.bindingAdapterPosition
            if (posisi == RecyclerView.NO_POSITION) return@setOnClickListener
            val dihapus = daftarJadwal.removeAt(posisi)
            notifyItemRemoved(posisi)
            onHapus(dihapus)
        }
    }

    override fun getItemCount(): Int = daftarJadwal.size
}
