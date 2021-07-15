package com.example.task2week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager
    var count = 0
//    val count2 = findViewById<TextView>(R.id.fragCount)
//    val fragmentManager = supportFragmentManager

    lateinit var fragmentManager: FragmentManager






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val count2 = findViewById<TextView>(R.id.fragCount)
        val count3 = findViewById<TextView>(R.id.fag1)

        fragmentManager = supportFragmentManager
        fragmentManager.addOnBackStackChangedListener {
            count2.text = "Fragment ${fragmentManager.backStackEntryCount}"
//            count3.text = "Fragment ${fragmentManager.backStackEntryCount}"
        }


        val actionBar = supportActionBar

        if (actionBar != null)
            actionBar.title = "Second Activity"
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }



        button1.setOnClickListener {
            addFragment()
//            if (count == 0 ){
//                addFragment()
//                count ++
//            } else if(count == 1){
//                addFragmentTwo()
//                count ++
//            }else if(count == 2){
//                addFragmentThree()
//                count ++
//            }else if(count == 3){
//                count = 0
//            }
        }

        button2.setOnClickListener {
            onBackPressed()
        }


    }

    fun addFragment(){
        fragmentManager = supportFragmentManager
        val fragment: Fragment = when(fragmentManager.backStackEntryCount){
//            0 -> BlankFragment()
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> BlankFragment()
        }
        if (fragment != null) {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment).addToBackStack(null)
            transaction.commit()
        }
//        val transaction = manager.beginTransaction()
//        val fragment = Fragment1()
//        transaction.replace(R.id.fragmentContainerView,fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
    }

    fun addFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = Fragment2()
        transaction.replace(R.id.fragmentContainerView,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun addFragmentThree(){
        val transaction = manager.beginTransaction()
        val fragment = Fragment3()
        transaction.replace(R.id.fragmentContainerView,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}


