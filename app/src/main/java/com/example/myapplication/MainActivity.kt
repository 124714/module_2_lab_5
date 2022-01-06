package com.example.myapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val good = findViewById<RadioButton>(R.id.good)
        val bad  = findViewById<RadioButton>(R.id.bad)
        moodChange(good)
        moodChange(bad)
        record()

    }

    fun moodChange(view: View) {
        val mood = findViewById<ImageView>(R.id.mood)
        if (view.id == R.id.good) {
            view.setOnClickListener {
                mood.setImageResource(R.drawable.cheerful)
            }
        }
        if (view.id == R.id.bad) {
            view.setOnClickListener {
                mood.setImageResource(R.drawable.cry)
            }
        }
    }

    fun record(){
        val nameEvent   = findViewById<EditText>(R.id.vevent)
        val timeEvent   = findViewById<EditText>(R.id.vtime)
        val dateEvent   = findViewById<EditText>(R.id.vdate)
        val notionEvent = findViewById<EditText>(R.id.vpost)
        var outputString : String

        val save = findViewById<Button>(R.id.save)
        save.setOnClickListener{
            outputString = "Записано!\n" +
                            "Cобытие: ${nameEvent.text.toString()}\n" +
                            "Дата: ${timeEvent.text.toString()}\n" +
                            "Время: ${dateEvent.text.toString()}\n" +
                            "Заметки:${notionEvent.text.toString()}\n";

            var toast : Toast = Toast.makeText(this, outputString, Toast.LENGTH_LONG)
            toast.show()
            nameEvent.setText("")
            timeEvent.setText("")
            dateEvent.setText("")
            notionEvent.setText("")
        }
    }
}