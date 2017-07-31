package com.example.lynn.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

class DetailActivity : AppCompatActivity() {
    val TAG = "DetailActivity"
    val hashmap = HashMap<String,String>()
    val treemap = TreeMap<String,String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        hashmap.put("A","1")
        hashmap.put("D","4")
        hashmap.put("C","3")
        hashmap.put("B","2")
        for((key, value) in hashmap){
            Log.d(TAG,"Hash Map[$key] = $value")
        }
        Log.d(TAG,"Hash Map:"+hashmap)

        treemap.put("A","1")
        treemap.put("D","4")
        treemap.put("C","3")
        treemap.put("B","2")
        for((key, value) in treemap){
            Log.d(TAG,"Tree Map[$key] = $value")
        }
        Log.d(TAG,"Tree Map:"+treemap)
    }
}
