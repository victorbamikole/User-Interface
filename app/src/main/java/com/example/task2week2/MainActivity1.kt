package com.example.task2week2

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main1.*

class MainActivity1 : AppCompatActivity() {

    var handler = Handler(Looper.getMainLooper())
    var lCount = 0
    var pCount = 0
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("landscape", lCount)
        outState.putInt("Portrait", pCount)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        next.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        if (savedInstanceState!= null){
            lCount = savedInstanceState.getInt("landscape")
            pCount = savedInstanceState.getInt("Portrait")
        }
        handler.postDelayed({
            text1.text = "On Create"
        }, 1000)
    }

    override fun onStart() {
        super.onStart()
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            lCount++
            text_2.text = "Count of PORTRAIT mode is $pCount"
        }else{
            pCount++
            text_2.text = "Count of landscape mode is $lCount"
        }
        handler.postDelayed({
            text1.text = "On start"
        }, 2500)

    }

    override fun onStop() {
        super.onStop()
        handler.postDelayed({
            text1.text = "on Stop"
        }, 1500)
    }

    override fun onPause() {
        super.onPause()
        text1.text = "On Pause"
    }

    override fun onRestart() {
        super.onRestart()
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            lCount--
        }else{
            pCount--
        }
        handler.postDelayed({
            text1.text = "On Restart"
        }, 2000)

    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed({
            text1.text = "On Resume"
        }, 3000)

    }

    override fun onDestroy() {
        super.onDestroy()
        handler.postDelayed({
            text1.text = "On Destroy"
        }, 5000)

    }
}



