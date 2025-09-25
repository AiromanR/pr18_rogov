package com.example.pr18_rogov

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import android.view.View

class MainActivity : AppCompatActivity() {

    lateinit var pref:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun firstClick(view: View) {
        Snackbar.make(view,"Нажат стандартный SnackBar", Snackbar.LENGTH_LONG).show()
    }
    fun secondClick(view: View) {
        val snackbar = Snackbar.make(view, R.string.second_message, Snackbar.LENGTH_LONG)

        snackbar.setAction(R.string.second_message2, View.OnClickListener {
            Snackbar.make(view, R.string.second_message3, Snackbar.LENGTH_LONG).show()
        })
        snackbar.setActionTextColor(Color.rgb(58,149,166));
        snackbar.show()
    }

    fun thirdClick(view: View) {
        pref = getPreferences(MODE_PRIVATE)
        val count = pref.getInt("countMemory", 0) + 1
        Snackbar.make(view, "Кнопка нажата $count раз", Snackbar.LENGTH_LONG).show()
        val ed = pref.edit()
        ed.putInt("countMemory", count)
        ed.apply()
    }
}