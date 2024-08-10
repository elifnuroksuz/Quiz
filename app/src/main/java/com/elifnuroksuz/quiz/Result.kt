package com.elifnuroksuz.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val userName = intent.getStringExtra(setData.name)
        val score = intent.getStringExtra(setData.score)
        val totalQuestion = intent.getStringExtra("total size")

        val congoTextView = findViewById<TextView>(R.id.congo)
        val scoreTextView = findViewById<TextView>(R.id.Score)
        val button = findViewById<Button>(R.id.button)

        congoTextView.text = "Congratulations ${userName} !!"
        scoreTextView.text = "${score} / ${totalQuestion}"

        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
