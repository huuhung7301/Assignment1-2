package com.example.assignment1_2

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var nu = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num = findViewById<TextView>(R.id.num)
        val score = findViewById<Button>(R.id.button1)
        val steal = findViewById<Button>(R.id.button2)
        val reset = findViewById<Button>(R.id.button3)
        nu = num.text.toString().toInt()
        var mediaPlayer = MediaPlayer.create(this, R.raw.digital_watch_alarm_long)
        score.setOnClickListener{
            if(nu in 0..14){
                nu += 1
                num.text = nu.toString()
                when (nu) {
                    5 -> num.setTextColor(Color.parseColor("Blue"))
                    10 -> num.setTextColor(Color.parseColor("Green"))
                    15 -> mediaPlayer.start()
                }
            }
        }
        steal.setOnClickListener{
            if(nu in 1..15){
                nu -= 1
                num.text = nu.toString()
                when (nu) {
                    4 -> num.setTextColor(Color.parseColor("Black"))
                    9 -> num.setTextColor(Color.parseColor("Blue"))
                }
            }
        }
        reset.setOnClickListener {
            nu = 0
            num.text = nu.toString()
        }
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("key", nu)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val userInt=savedInstanceState.getInt("key")
        nu = userInt
        val num = findViewById<TextView>(R.id.num)
        num.text=nu.toString()
    }

}