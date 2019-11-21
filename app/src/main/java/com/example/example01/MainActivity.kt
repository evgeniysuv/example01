package com.example.example01


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val TAG = "myTag"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button01: Button
    private lateinit var button02: Button
    private lateinit var button03: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button01 = findViewById(R.id.activity_main__push_me_button01)
        button02 = findViewById(R.id.activity_main__push_me_button02)
        button03 = findViewById(R.id.activity_main__push_me_button03)
        textView = findViewById(R.id.textView)

        button01.setOnClickListener(this)
        button02.setOnClickListener(this)
        button03.setOnClickListener(this)

        Log.d(TAG, "Application initialized")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Test", "Main activity started")
    }

    override fun onClick(v: View?) {
        var toast: Toast? = null
        when (v?.id) {
            R.id.activity_main__push_me_button01 -> {
                Log.d(TAG, "Обработка нажатия на кнопку 1")
                textView.text = "Button 01 pushed"
                toast = Toast.makeText(this, "Button 1 pushed successfully", Toast.LENGTH_LONG)
            }
            R.id.activity_main__push_me_button02 -> {
                Log.d(TAG, "Обработка нажатия на кнопку 2")
                textView.text = "Button 02 pushed"
                toast = Toast.makeText(this, "Button 2 pushed successfully", Toast.LENGTH_LONG)
            }
            R.id.activity_main__push_me_button03 -> {
                Log.d(TAG, "Обработка нажатия на кнопку 3")
                textView.text = "Button 03 pushed"
                toast = Toast.makeText(this, "Button 3 pushed successfully", Toast.LENGTH_LONG)
            }
        }
        toast?.view?.setBackgroundColor(Color.GREEN)
        toast?.show()
    }
}
