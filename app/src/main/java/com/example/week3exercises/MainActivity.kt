package com.example.week3exercises

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnLogin: Button
    private lateinit var etUsername: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("mainActivity", "onCreate() called")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bannerText)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLogin = findViewById(R.id.btnLogin)
        etUsername = findViewById(R.id.etUsername)

        etUsername.addTextChangedListener(textWatcher)

        btnLogin.setOnClickListener {

            // Making Toast
            Toast.makeText(this, "Login button clicked", Toast.LENGTH_LONG).show()

            val screen2Intent = Intent(this@MainActivity, MainActivity2::class.java )
            screen2Intent.putExtra("Location", "GWU")
            startActivity(screen2Intent)
        }
    }

    // Android Lifecycle
    override fun onResume(){
        super.onResume()
        Log.d("mainActivity","onResume() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("mainActivity","onStart() called")
    }

    override fun onPause(){
        super.onPause()
        Log.d("mainActivity","onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop() called")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("MainActivity", "onDestroy() called")
    }

    // TextWatcher
    private val textWatcher: TextWatcher = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            Log.d("MainActivity", "Inside beforeTextChanged() for $s.")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            Log.d("MainActivity", "Inside onTextChanged() for $s. Start: $start, before: $before, count: $count")
        }

        override fun afterTextChanged(s: Editable?) {
            Log.d("MainActivity", "Inside afterTextChanged() for $s")
        }

    }

}