package com.narinc.rootproject.mobileservices.analytics.dispatcher

import android.app.Activity
import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.narinc.rootproject.mobileservices.BuildConfig
import com.narinc.rootproject.mobileservices.analytics.event.BaseEvent

class FirebaseAnalyticsDispatcher : AnalyticsDispatcher {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun init(context: Context) {
        if (BuildConfig.DEBUG) {
            return
        }
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    override fun sendEvent(event: BaseEvent) {
        if (BuildConfig.DEBUG) {
            return
        }
        firebaseAnalytics.logEvent(event.name, event.getAsBundle())
    }

    override fun sendScreenView(activity: Activity, screenName: String) {
        if (BuildConfig.DEBUG) {
            return
        }
        firebaseAnalytics.setCurrentScreen(activity, screenName, screenName)
    }
}
