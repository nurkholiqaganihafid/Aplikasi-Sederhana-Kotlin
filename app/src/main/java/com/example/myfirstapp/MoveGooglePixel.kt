package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog

class MoveGooglePixel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_google_pixel)

        supportActionBar?.title = "One Piece"

        val button: Button = findViewById(R.id.btn_share)

        button.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                this@MoveGooglePixel, R.style.BottomSheetDialogTheme
            )

            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.layout_bottom_sheet, findViewById<LinearLayout>(R.id.bottomSheet)
            )

            bottomSheetView.findViewById<View>(R.id.buttonShare).setOnClickListener {
                Toast.makeText(this@MoveGooglePixel, "Share...", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()

        }

    }
}