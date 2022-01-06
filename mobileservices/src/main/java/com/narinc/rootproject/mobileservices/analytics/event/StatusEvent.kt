package com.narinc.rootproject.mobileservices.analytics.event

import com.narinc.rootproject.mobileservices.analytics.type.ClickType

/**
 * This event can be used to keep track of any event.
 * You can track the start or end of an event.
 */
class StatusEvent : BaseEvent {
    constructor(type: ClickType) : super(type.value) {
        putString(Key.STATUS.value, type.value)
    }

    constructor(type: ClickType, bundle: String) : super(type.value) {
        putString(Key.STATUS.value, bundle)
    }
}
