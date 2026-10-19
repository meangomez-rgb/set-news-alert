package com.setnews.alert

import android.app.Activity
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.graphics.Color
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var status: TextView
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scroll = ScrollView(this)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 48, 32, 32)
        }
        scroll.addView(layout)
        setContentView(scroll)
        fun label(s: String, size: Float): TextView = TextView(this).apply {
            text = s
            textSize = size
            setTextColor(Color.rgb(20, 35, 55))
            setPadding(0, 10, 0, 22)
            layout.addView(this)
        }
        label("SET News Alert", 28f)
        label("เวอร์ชันทดสอบฟรี • Android", 17f)
        status = label("พร้อมทดสอบการแจ้งเตือนในเครื่อง", 15f)
        layout.addView(Button(this).apply {
            text = "ทดสอบแจ้งเตือนใน 20 วินาที"
            setOnClickListener {
                status.text = "เริ่มนับ 20 วินาที — เปิดแอปค้างไว้ก่อน"
                handler.postDelayed({ notifyLocal() }, 20_000)
            }
        })
        label("รุ่นนี้ยังไม่มีข่าวสดและ Push จากเซิร์ฟเวอร์ จะเพิ่มหลังทดสอบ APK และเชื่อมแหล่งข้อมูลที่ใช้งานได้ฟรี", 14f)
    }
    private fun notifyLocal() {
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(NotificationChannel("test", "ทดสอบ SET News Alert", NotificationManager.IMPORTANCE_HIGH))
        val notification = Notification.Builder(this, "test")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("SET News Alert")
            .setContentText("ทดสอบแจ้งเตือน 20 วินาทีสำเร็จ")
            .setAutoCancel(true)
            .build()
        manager.notify(20, notification)
        status.text = "สั่งแสดงการแจ้งเตือนแล้ว ตรวจแถบแจ้งเตือนของมือถือ"
    }
}
