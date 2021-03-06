package com.example.reflect

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
// import android.os.Build
import androidx.appcompat.app.AppCompatActivity
// import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_notifications.*
import java.util.concurrent.atomic.AtomicInteger

class Notifications : AppCompatActivity() {
    val CHANNEL_ID = "Journal"
    val CHANNEL_ID2 = "Mood"
    //val notificationJournalId = 101
    //  val notificationMoodId = 202

    class NotificationID {
        private val c: AtomicInteger = AtomicInteger(0)
        fun getID(): Int {
            return c.incrementAndGet()
        }
    }

    val GROUP_KEY_MOODANDJOURNAL = "com.example.myapplication"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        createNotificationChannel()


        journal_butt.setOnClickListener {
            sendJournalNotif()
        }

        mood_butt.setOnClickListener {
            sendMoodNotif()
        }
    }

    private fun createNotificationChannel() {
        val name = "Journal com.example.reflect.Notifications"
        val descriptionText = "com.example.reflect.Notifications to journal"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        val name1 = "Mood Tracker com.example.reflect.Notifications"
        val descriptionText1 = "com.example.reflect.Notifications to track mood"
        val importance1 = NotificationManager.IMPORTANCE_DEFAULT
        val channel1 = NotificationChannel(CHANNEL_ID2, name1, importance1).apply {
            description = descriptionText1
        }
        val notificationManager1: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager1.createNotificationChannel(channel1)
    }

    private fun sendJournalNotif() {
        val intent =
            Intent(this, Notifications::class.java).apply { PendingIntent.FLAG_IMMUTABLE }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val bitmap =
            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.redjournal)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setLargeIcon(bitmap)
            .setSmallIcon(R.drawable.redjournal)
            .setContentTitle("Journal")
            .setContentText("It's time to journal!")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
            //clears notification from tray after clicking on it
            .setAutoCancel(true)
            .setGroup(GROUP_KEY_MOODANDJOURNAL)
        with(NotificationManagerCompat.from(this)) {
            notify(NotificationID().getID(), builder.build())
        }
    }

    private fun sendMoodNotif() {

        val intent =
            Intent(this, Notifications::class.java).apply { PendingIntent.FLAG_IMMUTABLE }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val bitmap1 =
            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.redjournal)
        val builder = NotificationCompat.Builder(this, CHANNEL_ID2)
            .setSmallIcon(R.drawable.redjournal)
            .setLargeIcon(bitmap1)
            .setContentTitle("Mood Tracker")
            .setContentText("Have a moment? It's time to track your mood!")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
            //clears notification from tray after clicking on it
            .setAutoCancel(true)
            .setGroup(GROUP_KEY_MOODANDJOURNAL)
        with(NotificationManagerCompat.from(this)) {
            notify(NotificationID().getID(), builder.build())
        }

    }

}

