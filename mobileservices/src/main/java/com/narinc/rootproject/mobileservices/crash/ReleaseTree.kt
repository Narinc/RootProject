package com.narinc.rootproject.mobileservices.crash

import android.content.Context
import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.huawei.agconnect.crash.AGConnectCrash
import com.narinc.rootproject.mobileservices.MobileServices
import timber.log.Timber

class ReleaseTree constructor(
    private val context: Context
) : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        // Sending crash report to Firebase CrashAnalytics
        FirebaseCrashlytics.getInstance().recordException(Exception(message))

        if (MobileServices.isHmsAvailable(context)) {
            AGConnectCrash.getInstance().recordException(Exception(message))
        }
    }
}
