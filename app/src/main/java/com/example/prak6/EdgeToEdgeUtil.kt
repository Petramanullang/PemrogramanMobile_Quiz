package com.example.prak6

import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

// Sejak targetSdk 35+ tampilan edge-to-edge wajib, sehingga bagian atas layout
// tertutup status bar/action bar dan bagian bawah tertutup navigation bar.
// Fungsi ini menambahkan padding sesuai tinggi system bar ke root layout.
fun AppCompatActivity.terapkanInsetSistem() {
    val root = findViewById<ViewGroup>(android.R.id.content).getChildAt(0) ?: return
    val paddingAtasAwal = root.paddingTop
    val paddingBawahAwal = root.paddingBottom
    ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
        val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.updatePadding(top = paddingAtasAwal + bars.top, bottom = paddingBawahAwal + bars.bottom)
        insets
    }
}
