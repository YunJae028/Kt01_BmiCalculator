package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        val bmi = weight/Math.pow( height / 100.0,2.0)

        when{ //자바 switch  문과 같음
            bmi >= 35 -> resulttextView.text = "고도 비만"
            bmi >= 30 -> resulttextView.text = "2단계 비만"
            bmi >= 25 -> resulttextView.text = "1단계 비만"
            bmi >= 23 -> resulttextView.text = "과체중"
            bmi >= 18.5 -> resulttextView.text = "정상"
            else -> resulttextView.text = "저체중"
        }

        when{
            bmi >= 23 ->
                imageView.setImageResource(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
            bmi >= 18.5 ->
                imageView.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp)
            else ->
                imageView.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp)
        }

        toast("$bmi")

    }
}
