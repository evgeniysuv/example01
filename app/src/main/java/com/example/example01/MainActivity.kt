package com.example.example01


import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.atomic.AtomicBoolean

private const val TAG = "myTag"

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button01: Button
    private lateinit var button02: Button
    private lateinit var button03: Button
    private lateinit var textView: TextView
    private lateinit var counterView: TextView
    private lateinit var timeRemainingTextView: TextView
    private lateinit var timer: CountDownTimer

    private var counter = 0
    private var initialCountDown: Long = 10000
    private var countDownInterval: Long = 1000

    private var isStarted: AtomicBoolean = AtomicBoolean(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button01 = findViewById(R.id.activity_main__push_me_button01)
        button02 = findViewById(R.id.activity_main__push_me_button02)
        button03 = findViewById(R.id.activity_main__push_me_button03)
        textView = findViewById(R.id.exampleTextView)
        counterView = findViewById(R.id.counterView)
        timeRemainingTextView = findViewById(R.id.timeRemainingTextView)

        counterView.text = getString(R.string.text_counter, counter)
        timeRemainingTextView.text =
            getString(R.string.time_remaining, initialCountDown / 1000, " сек")

        button01.setOnClickListener(this)
        button02.setOnClickListener(this)
        button03.setOnClickListener(this)

        Log.d(TAG, "Application initialized")
    }

    private fun initTimer() {
        timeRemainingTextView.text =
            getString(R.string.time_remaining, initialCountDown / 1000, " сек")
        timer = object : CountDownTimer(initialCountDown, countDownInterval) {

            override fun onFinish() {
                textView.text = "Time is over"
            }

            override fun onTick(millisUntilFinished: Long) {
                timeRemainingTextView.text =
                    getString(R.string.time_remaining, millisUntilFinished / 1000, " сек")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Test", "Main activity started")
    }

    override fun onClick(v: View?) {
        startGame()
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
        incrementCounter()
        toast?.show()
    }

    private fun startGame() {
        if (!isStarted.get()) {
            isStarted.set(true)
            initTimer()
            timer.start()
            Toast.makeText(this, "Game started", Toast.LENGTH_SHORT).show()
        }
    }

    private fun incrementCounter() {
        val newCounter = getString(R.string.text_counter, ++counter)
        counterView.text = newCounter

    }
}
