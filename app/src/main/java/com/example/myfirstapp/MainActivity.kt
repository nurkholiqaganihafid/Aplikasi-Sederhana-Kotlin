package com.example.myfirstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView

    //Navigation Drawer
    lateinit var toggle: ActionBarDrawerToggle

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.title = "My First App - Nurkholiq"

        // Navigation drawer
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)

        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){

                R.id.nav_home -> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
                R.id.nav_message -> Toast.makeText(applicationContext, "Clicked Message", Toast.LENGTH_SHORT).show()
                R.id.nav_sync -> Toast.makeText(applicationContext, "Clicked Sync", Toast.LENGTH_SHORT).show()
                R.id.nav_trash -> Toast.makeText(applicationContext, "Clicked Trash", Toast.LENGTH_SHORT).show()
                R.id.nav_setting -> Toast.makeText(applicationContext, "Clicked Setting", Toast.LENGTH_SHORT).show()
                R.id.nav_login -> Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext, "Clicked Share", Toast.LENGTH_SHORT).show()
                R.id.nav_rate_us -> Toast.makeText(applicationContext, "Clicked Rate us", Toast.LENGTH_SHORT).show()

            }

            true

        }
        // akhir

        /* Pindah Aktivity Explicit Intent*/
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        /* Pindah Aktivity dengan Data */
        val btnPindahDenganDataAktivity: Button = findViewById(R.id.btn_move_activity_data)
        btnPindahDenganDataAktivity.setOnClickListener(this)

        /*Pindah Aktivitas dengan No. HP - Implicit Intent*/
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        /* Pindah Aktivity Google Pixle */
        val btnMoveGooglePixel: Button = findViewById(R.id.btn_move_google_pixle)
        btnMoveGooglePixel.setOnClickListener(this)

        edtPanjang = findViewById(R.id.edt_panjang)
        edtLebar = findViewById(R.id.edt_lebar)
        edtTinggi = findViewById(R.id.edt_tinggi)
        btnHitung = findViewById(R.id.btn_hitung)
        tvHasil = findViewById(R.id.tv_hasil)

        btnHitung.setOnClickListener(this)

        if (savedInstanceState !=null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }

    //Navigation Drawer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
    // nav_akhir

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_hitung) {
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()


            var isEmptyFields = false

            if (inputPanjang.isEmpty()) {
                isEmptyFields = true
                edtPanjang.error = "Field ini tidak boleh kosong"
            }

            if (inputLebar.isEmpty()) {
                isEmptyFields = true
                edtLebar.error = "Field ini tidak boleh kosong"
            }

            if (inputTinggi.isEmpty()) {
                isEmptyFields = true;
                edtTinggi.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val volume =
                    inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                tvHasil.text = volume.toString()
            }
        }

        /* Tombol Klik Pindah Aktivity Explicit Intent*/
        when (p0?.id) {
            R.id.btn_move_activity -> {
                /*memberikan context (this@MainActivity) dan kelas activity tujuan (MoveActivity::class.java) pada konstruktor kelas intent. */
                val pindahIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(pindahIntent)
            }

            R.id.btn_move_activity_data -> {
                val pindahDenganDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                pindahDenganDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Nurkholiq Agani Hafid")
                pindahDenganDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 22)
                startActivity(pindahDenganDataIntent)
            }

            /* Implicit Intent */
            R.id.btn_dial_number -> {
                val nomorTelpon = "085179237488"
                val panggilTelponIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomorTelpon"))
                startActivity(panggilTelponIntent)
            }
            R.id.btn_move_google_pixle -> {
                val pindahGooglePixle = Intent (this@MainActivity, MoveGooglePixel::class.java)
                startActivity(pindahGooglePixle)
            }
        }
    }
}