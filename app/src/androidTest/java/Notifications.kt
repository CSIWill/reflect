import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*
import android.R

class Notifications : AppCompatActivity() {

    private val CHANNEL_ID = "example 1"
    private val CHANNEL_ID2 = "example 2"
    private val notificationId = 101
    private val notificationId1 = 202
    private val GROUP_KEY_MOODNJOURNAL = "com.example.myapplication"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        createNotificationChannel()

        butt.setOnClickListener {
        sendNotification()
        }

        butt1.setOnClickListener{
            sendNotification1()
        }


    }



    private fun createNotificationChannel () {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Journal Notifications"
            val descriptionText = "Notifications to journal"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID,name,importance).apply { description=descriptionText }
            val notificationManager:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            val name1="Mood Tracker Notifications"
            val descriptionText1 = "Notifications to track mood"
            val importance1 = NotificationManager.IMPORTANCE_DEFAULT
            val channel1 = NotificationChannel(CHANNEL_ID2,name1, importance1).apply {description = descriptionText1}
            val notificationManager1:NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager1.createNotificationChannel(channel1)
        }

    }

    private fun sendNotification(){

        val intent = Intent(this, Notifications::class.java).apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NEW_TASK }
        val pendingIntent = PendingIntent.getActivity(this,0,intent, 0)

        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.journalicon)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setLargeIcon(bitmap)
            .setSmallIcon(R.drawable.journalicon)
            .setContentTitle("Journal")
            .setContentText("Time to journal!")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
            //clears notification from tray after clicking on it
            .setAutoCancel(true)
            .setGroup(GROUP_KEY_MOODNJOURNAL)
        with(NotificationManagerCompat.from(this)){
            notify(notificationId, builder.build())
        }


    }

    private fun sendNotification1(){

        val intent = Intent(this, Notifications::class.java).apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NEW_TASK }
        val pendingIntent = PendingIntent.getActivity(this,0,intent, 0)

        val bitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.journalicon)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)

            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Mood Tracker")
            .setContentText("Time to track your mood!")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(NotificationCompat.VISIBILITY_PRIVATE)
                //clears notification from tray after clicking on it
            .setAutoCancel(true)
            .setGroup(GROUP_KEY_MOODNJOURNAL)
        with(NotificationManagerCompat.from(this)){
            notify(notificationId1, builder.build())
        }

    }
}