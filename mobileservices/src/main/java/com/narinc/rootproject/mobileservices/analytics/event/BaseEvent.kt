package com.narinc.rootproject.mobileservices.analytics.event

import android.os.Bundle

open class BaseEvent constructor(
    val name: String
) {

    internal enum class Key(val value: String) {
        ACTION("action"), STATUS("status");
    }

    private val bundle = Bundle()

    open fun putString(key: String, value: String) {
        bundle.putString(key, value)
    }

    protected open fun putDouble(key: String?, value: Double) {
        bundle.putDouble(key, value)
    }

    protected open fun putBoolean(key: String?, value: Boolean) {
        bundle.putBoolean(key, value)
    }

    open fun getAsBundle(): Bundle {
        return bundle
    }
}
