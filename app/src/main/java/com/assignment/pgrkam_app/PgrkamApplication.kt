package com.assignment.pgrkam_app

import android.app.Application
import com.posthog.android.PostHog
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PgrkamApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val posthog =
            PostHog.Builder(this, "phc_O4twmKgiDmct6WN5bXI7LuOvYMj54XTlXpwRQnali2V","https://app.posthog.com")
                .captureApplicationLifecycleEvents()
                .recordScreenViews()
                .build()
        PostHog.setSingletonInstance(posthog)
    }

}