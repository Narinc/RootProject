package com.narinc.rootproject.mobileservices.remoteConfig

import java.util.HashMap

/**
 * this enum includes keys for config
 */
enum class DataConfig(val value: String) {

    FORCE_UPDATE("force_update"); // this is an example key

    private val map: MutableMap<String, DataConfig> = HashMap()

    init {
        for (config in values()) {
            map[config.value] = config
        }
    }
}
