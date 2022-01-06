package com.narinc.rootproject.mobileservices

import com.narinc.rootproject.mobileservices.analytics.dispatcher.AnalyticsDispatcher
import com.narinc.rootproject.mobileservices.analytics.dispatcher.FirebaseAnalyticsDispatcher
import com.narinc.rootproject.mobileservices.analytics.dispatcher.HuaweiAnalyticsDispatcher

enum class Services {
    GMS {
        override fun getAnalyticsDispatcher(): AnalyticsDispatcher {
            return FirebaseAnalyticsDispatcher()
        }
    },
    HMS {
        override fun getAnalyticsDispatcher(): AnalyticsDispatcher {
            return HuaweiAnalyticsDispatcher()
        }
    };

    abstract fun getAnalyticsDispatcher(): AnalyticsDispatcher
}
