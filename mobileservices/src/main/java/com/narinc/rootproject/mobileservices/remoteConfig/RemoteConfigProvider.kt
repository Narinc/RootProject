package com.narinc.rootproject.mobileservices.remoteConfig

interface RemoteConfigProvider {
    interface Callback {
        fun onUpdate()
        fun onSuccess()
        fun onSuccess(version: String)
        fun onFailure()
    }

    companion object {
        const val UPDATE_VERSION = "update-version"
    }

    operator fun invoke(callback: Callback)

    fun getString(config: DataConfig): String

    fun getInt(config: DataConfig): Int
}
