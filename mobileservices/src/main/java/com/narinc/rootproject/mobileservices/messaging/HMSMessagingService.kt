package com.narinc.rootproject.mobileservices.messaging

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.huawei.hms.push.HmsMessageService
import com.huawei.hms.push.RemoteMessage
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber

class HMSMessagingService : HmsMessageService() {

    companion object {
        private const val CHANNEL_ID = "Default"
        private const val CHANNEL_NAME = "Default channel"

        private const val KEY_ACTION = "action"
        private const val KEY_TITLE = "title"
        private const val KEY_BODY = "body"

        private const val NOTIFICATION_REQUEST_CODE = 0
    }

    private val dataMap = mutableMapOf<String, String>()

    override fun onNewToken(newToken: String) {
        super.onNewToken(newToken)
        Timber.d(newToken)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        dataMap.clear()

        if (remoteMessage.data.isNotEmpty()) {
            try {
                val data = JSONObject(remoteMessage.data)
                val action = data.getString(KEY_ACTION)
                dataMap[KEY_ACTION] = action
            } catch (e: JSONException) {
                Timber.e(e)
            }
        }

        remoteMessage.notification?.let {
            val title = it.title ?: return
            val body = it.body ?: return
            dataMap[KEY_TITLE] = title
            dataMap[KEY_BODY] = body
            sendNotification()
        }
    }

    private fun sendNotification() {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                channel.enableLights(true)
                channel.enableVibration(true)
                it.createNotificationChannel(channel)
            }
            it.notify(0, getNotification())
        } ?: run {
            Timber.e(NullPointerException("notificationManager can't null!"))
        }
    }

    private fun getNotification() =
        NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(dataMap[KEY_TITLE])
            .setContentText(dataMap[KEY_BODY])
            .setAutoCancel(true)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setContentIntent(getPendingIntent())
            .build()

    private fun getPendingIntent(): PendingIntent {
        val intent = Intent(Intent.ACTION_VIEW).setClassName(packageName, "MainActivity")
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        for ((key, value) in dataMap) {
            intent.putExtra(key, value)
        }

        return PendingIntent.getActivity(
            this,
            NOTIFICATION_REQUEST_CODE,
            intent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            } else {
                PendingIntent.FLAG_UPDATE_CURRENT
            }
        )
    }
}
