package com.jay.local.pref

import android.content.Context
import androidx.core.content.edit
import com.jay.local.constants.LocalConstants
import javax.inject.Inject
import javax.inject.Singleton

class PreferenceHelperImpl(
    applicationContext: Context
) : PreferenceHelper {

    private val preference = applicationContext.getSharedPreferences(
        LocalConstants.PREF_PACKAGE_NAME,
        Context.MODE_PRIVATE
    )

    override var lastLocalTime: Long
        get() = preference.getLong(LocalConstants.PREF_KEY_LAST_LOCAL, 0)
        @Synchronized
        set(value) {
            preference.edit {
                putLong(LocalConstants.PREF_KEY_LAST_LOCAL, value)
            }
        }
}