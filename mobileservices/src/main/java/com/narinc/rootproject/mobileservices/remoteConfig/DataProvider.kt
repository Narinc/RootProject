package com.narinc.rootproject.mobileservices.remoteConfig

import javax.inject.Inject

class DataProvider @Inject constructor(
    private val configProvider: RemoteConfigProvider
) : RemoteConfigProvider {
    override fun invoke(callback: RemoteConfigProvider.Callback) {
        configProvider.invoke(callback)
    }

    override fun getString(config: DataConfig): String {
        return configProvider.getString(config)
    }

    override fun getInt(config: DataConfig): Int {
        return configProvider.getInt(config)
    }
}
