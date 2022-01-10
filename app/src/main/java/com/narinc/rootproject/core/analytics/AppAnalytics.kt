package com.narinc.rootproject.core.analytics

import android.app.Activity
import com.narinc.rootproject.mobileservices.analytics.dispatcher.AnalyticsDispatcher
import com.narinc.rootproject.mobileservices.analytics.event.BaseEvent
import javax.inject.Inject

class AppAnalytics @Inject constructor(
    private val dispatchers: List<AnalyticsDispatcher>
) {

    fun sendEvent(event: BaseEvent) {
        for (dispatcher in dispatchers) {
            dispatcher.sendEvent(event)
        }
    }

    fun sendScreenView(activity: Activity, screenName: String) {
        for (dispatcher in dispatchers) {
            dispatcher.sendScreenView(activity, screenName)
        }
    }
}
