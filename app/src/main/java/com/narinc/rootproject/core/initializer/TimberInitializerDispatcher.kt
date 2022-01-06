package com.narinc.rootproject.core.initializer

import android.content.Context
import com.narinc.rootproject.BuildConfig
import com.narinc.rootproject.mobileservices.crash.ReleaseTree
import timber.log.Timber

class TimberInitializerDispatcher : InitializerDispatcher {
    override fun init(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree(context))
        }
    }
}
