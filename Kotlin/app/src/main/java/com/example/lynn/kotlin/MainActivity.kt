package com.example.lynn.kotlin

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.io.PrintStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.util.concurrent.Delayed
import kotlin.concurrent.schedule
import kotlin.concurrent.timer
import com.github.kittinunf.fuel.*
import java.util.concurrent.TimeUnit
import android.content.IntentFilter
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    var mScanning = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val bluetoothAdapter = bluetoothManager.adapter
        var beacons : ArrayList<BluetoothDevice>?= arrayListOf<BluetoothDevice>()
        var listItems : ArrayList<String>?= arrayListOf<String>()
        //扫描结果的回调，开始扫描后会多次调用该方法
        val mLeScanCallback = BluetoothAdapter.LeScanCallback { device, rssi, scanRecord ->
            //通过对比设备的 mac 地址获取需要的实例
            if(device.name == "HERE_Beacon"&&!beacons!!.contains(device)){
                Log.d(TAG,"name:"+device.name+"  address:"+device.address)
                beacons!!.add(device)
                listItems!!.add("name:"+device.name+"  address:"+device.address)
                Log.d(TAG,"devicelist:"+listItems+"  beacons:"+beacons)
            }
        }

        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled){
            bluetoothAdapter.enable()
        }else{
            mScanning = true
            bluetoothAdapter?.startLeScan(mLeScanCallback)
        }

    }

}
