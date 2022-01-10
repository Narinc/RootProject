package com.narinc.rootproject.mobileservices

import android.content.Context
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailabilityLight
import com.huawei.hms.api.HuaweiApiAvailability
import com.narinc.rootproject.mobileservices.analytics.dispatcher.AnalyticsDispatcher
import com.narinc.rootproject.mobileservices.remoteConfig.FirebaseRemoteConfigProvider
import com.narinc.rootproject.mobileservices.remoteConfig.HMSRemoteConfigProvider
import com.narinc.rootproject.mobileservices.remoteConfig.RemoteConfigProvider

class MobileServices(context: Context) {
    private var services: Services = Services.GMS

    init {
        if (isGmsAvailable(context) && isHmsAvailable(context)) {
            services = Services.HMS
        }
    }

    fun getAnalyticDispatchers(context: Context): List<AnalyticsDispatcher> {
        val dispatchers: MutableList<AnalyticsDispatcher> = mutableListOf()
        if (isGmsAvailable(context)) {
            dispatchers.add(Services.GMS.getAnalyticsDispatcher())
        }
        if (isHmsAvailable(context)) {
            dispatchers.add(Services.HMS.getAnalyticsDispatcher())
        }
        return dispatchers
    }

    fun getRemoteConfigProvider(context: Context): RemoteConfigProvider {
        return if (isHmsAvailable(context)) {
            HMSRemoteConfigProvider()
        } else FirebaseRemoteConfigProvider()
    }

    companion object {
        fun isGmsAvailable(context: Context): Boolean {
            return ConnectionResult.SUCCESS ==
                GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context)
        }

        fun isHmsAvailable(context: Context): Boolean {
            return com.huawei.hms.api.ConnectionResult.SUCCESS ==
                HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context)
        }

        fun isMobileServicesAvailable(context: Context): Boolean {
            var isAvailable = isGmsAvailable(context)
            if (!isAvailable) {
                isAvailable = isHmsAvailable(context)
            }
            return isAvailable
        }
    }
}
