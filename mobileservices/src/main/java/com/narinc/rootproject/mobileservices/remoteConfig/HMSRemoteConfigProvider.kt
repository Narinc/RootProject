package com.narinc.rootproject.mobileservices.remoteConfig

import com.huawei.agconnect.remoteconfig.AGConnectConfig
import com.narinc.rootproject.mobileservices.R
import timber.log.Timber

class HMSRemoteConfigProvider : RemoteConfigProvider {

    private val config: AGConnectConfig = AGConnectConfig.getInstance()

    override fun invoke(callback: RemoteConfigProvider.Callback) {
        config.applyDefault(R.xml.remote_config_defaults)
        config.fetch().addOnSuccessListener {
            config.apply(it)
            val version = it.getValueAsString(RemoteConfigProvider.UPDATE_VERSION)
            callback.onSuccess(version)
        }.addOnFailureListener {
            callback.onFailure()
            Timber.e(it)
        }
    }

    override fun getString(config: DataConfig): String {
        return this.config.getValueAsString(config.value)
    }

    override fun getInt(config: DataConfig): Int {
        return this.config.getValueAsDouble(config.value).toInt()
    }
}
