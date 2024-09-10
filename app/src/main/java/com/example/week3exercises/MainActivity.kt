package com.example.week3exercises

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bannerText)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("mainActivity", "onCreate() called")

        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {

            // Making Toast
            Toast.makeText(this, "Login button clicked", Toast.LENGTH_LONG).show()

            val screen2Intent = Intent(this@MainActivity, MainActivity2::class.java )
            screen2Intent.putExtra("Location", "GWU")
            startActivity(screen2Intent)
        }
    }

    override fun onResume(){
        super.onResume()
        Log.d("mainActivity","onResume called")
    }

    override fun onPause(){
        super.onPause()
        Log.d("mainActivity","onPause called")
    }

    override fun onDestroy(){

        Log.d("MainActivity", "onDestroy() called")
        super.onDestroy()
    }
}