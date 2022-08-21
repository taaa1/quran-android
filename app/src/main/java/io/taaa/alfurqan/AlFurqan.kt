package io.taaa.alfurqan

import android.app.Application
import com.google.android.material.color.DynamicColors

class AlFurqan: Application() {
    override fun onCreate() {
        super.onCreate()

        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}