package com.narinc.rootproject.mobileservices.analytics.event

import com.narinc.rootproject.mobileservices.analytics.type.ClickType

/**
 * This event is used to click any field.
 * ex: like clicking a card or button
 */
class ClickEvent : BaseEvent {
    constructor(type: ClickType) : super(type.value) {
        putString(Key.ACTION.value, type.value)
    }

    constructor(type: ClickType, bundle: String) : super(type.value) {
        putString(Key.ACTION.value, bundle)
    }
}
