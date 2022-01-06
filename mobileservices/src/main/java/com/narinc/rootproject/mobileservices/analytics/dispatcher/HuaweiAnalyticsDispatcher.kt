package com.narinc.rootproject.mobileservices.analytics.dispatcher

import android.app.Activity
import android.content.Context
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance
import com.narinc.rootproject.mobileservices.BuildConfig
import com.narinc.rootproject.mobileservices.analytics.event.BaseEvent

class HuaweiAnalyticsDispatcher : AnalyticsDispatcher {

    private lateinit var hiAnalytics: HiAnalyticsInstance

    override fun init(context: Context) {
        if (BuildConfig.DEBUG) {
            return
        }
        hiAnalytics = HiAnalytics.getInstance(context)
    }

    override fun sendEvent(event: BaseEvent) {
        if (BuildConfig.DEBUG) {
            return
        }
        hiAnalytics.onEvent(event.name, event.getAsBundle())
    }

    override fun sendScreenView(activity: Activity, screenName: String) {
        if (BuildConfig.DEBUG) {
            return
        }
        hiAnalytics.setCurrentActivity(activity, screenName, screenName)
    }
}
