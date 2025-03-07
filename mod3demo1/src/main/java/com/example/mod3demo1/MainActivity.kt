package com.example.mod3demo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        R class resources
        val etName = findViewById<EditText>(R.id.et_name)
        val etAge = findViewById<EditText>(R.id.et_age)
        val btn = findViewById<Button>(R.id.button)

//        socl raccourci, choisir avec {} callback
        btn.setOnClickListener {
            val name = etName.text.toString();
            val age = etAge.text.toString();

//            .show() permet d'afficher l'instance de Toast
            Toast.makeText(this, "Toi =$name, t'as = $age", Toast.LENGTH_LONG).show();
            Snackbar.make(etName, "Toi = $name, t'as = $age", Snackbar.LENGTH_LONG).show();
        }
    }
}