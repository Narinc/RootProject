package com.narinc.rootproject.mobileservices.remoteConfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.narinc.rootproject.mobileservices.R
import timber.log.Timber

class FirebaseRemoteConfigProvider : RemoteConfigProvider {

    companion object {
        private const val MIN_FETCH_INTERVAL = 3600
    }

    private val config: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

    override fun invoke(callback: RemoteConfigProvider.Callback) {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(MIN_FETCH_INTERVAL.toLong())
            .build()
        config.setConfigSettingsAsync(configSettings)
        config.setDefaultsAsync(R.xml.remote_config_defaults) // If you get error from RemoteConfig it will use this xml

        config.fetchAndActivate().addOnCompleteListener {
            if (it.isSuccessful) {
                if (it.result) {
                    callback.onUpdate()
                } else callback.onSuccess()

                config.activate()
            } else {
                callback.onFailure()
                Timber.e(it.exception)
            }
        }
    }

    override fun getString(config: DataConfig): String {
        return this.config.getString(config.value)
    }

    override fun getInt(config: DataConfig): Int {
        return this.config.getDouble(config.value).toInt()
    }
}
