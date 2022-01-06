package com.narinc.rootproject.mobileservices.analytics.dispatcher

import android.app.Activity
import android.content.Context
import com.narinc.rootproject.mobileservices.analytics.event.BaseEvent

interface AnalyticsDispatcher {
    /**
     * Init this dispatcher. This method called when application first created.
     * If used analytics tool needs a initialization process, this is place to implement them.
     *
     * @param context Application context
     */
    fun init(context: Context)

    /**
     * Send an analytics event with this dispatcher.
     *
     * @param event Event to send.
     */
    fun sendEvent(event: BaseEvent)

    /**
     * Send or log current displayed screen.
     *
     * @param activity   Activity holding the screen
     * @param screenName Name of screen
     */
    fun sendScreenView(activity: Activity, screenName: String)
}
