package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    /* Const/Konstanta yaitu sebuah variabel yang nilainya tetap,
    biasanya digunakan sebagai key(kunci) yang dipakai untuk mengirim dan menerima data. sebelum onCreate */
    companion object {
        const val EXTRA_AGE = "extra_ege"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        supportActionBar?.title = "Biodata"

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Nama : $name \nUmur Kamu : $age Tahun"
        tvDataReceived.text = text
    }
}