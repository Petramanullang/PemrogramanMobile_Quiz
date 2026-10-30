package com.example.prak6

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

// Splash screen awal: tampil 2,5 detik lalu pindah ke MainActivity
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val pindahKeMain = Runnable {
        startActivity(Intent(this, MainActivity::class.java))
        finish() // splash dihapus dari back stack agar tombol Back tidak kembali ke sini
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler.postDelayed(pindahKeMain, DURASI_SPLASH)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(pindahKeMain)
    }

    companion object {
        private const val DURASI_SPLASH = 2500L
    }
}
