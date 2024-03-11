package com.example.assignment6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricket_score_view)
        val cricketScoreView: CricketScoreView = findViewById(R.id.cricket_score_view)
        cricketScoreView.setRuns(intArrayOf(3, 6, 1, 4, 2))

    }
}