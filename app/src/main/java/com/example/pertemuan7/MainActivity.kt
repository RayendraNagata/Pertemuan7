package com.example.pertemuan7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengatur judul aplikasi
        val textViewAppTitle = findViewById<TextView>(R.id.textViewAppTitle)
        textViewAppTitle.text = getString(R.string.app_title)

        // Navigasi ke AddTaskActivity ketika button diklik
        val buttonAddTask = findViewById<Button>(R.id.buttonAddTask)
        buttonAddTask.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }
}
