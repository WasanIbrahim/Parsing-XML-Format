package com.example.parsingxmlformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRV: RecyclerView
    lateinit var students: List<Students>

    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRV = findViewById(R.id.myRV)

        students = listOf()

        val parser = XmlPullParser()
        val iStream = assets.open("students.xml")
        students = parser.parse(iStream)
        adapter = RecyclerViewAdapter(students)
        myRV.adapter = adapter
        myRV.layoutManager = LinearLayoutManager(this) // main activity

        Log.d("list", "$students")




//        try{
//
//
//        }catch (e: Exception) {
//            e.printStackTrace()
//
//        }

    }
}