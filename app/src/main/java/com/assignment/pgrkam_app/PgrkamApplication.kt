package com.assignment.pgrkam_app

import android.app.Application
import com.posthog.android.PostHog
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PgrkamApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val posthog =
            PostHog.Builder(
                this,
                "phc_hWR3oOZKslKrvx4p2uYgJTcqLDM4AaDd1TTnfA0djxh",
                "https://610a-103-215-237-106.ngrok-free.app"
            )
                .captureApplicationLifecycleEvents()
                .recordScreenViews()
                .build()
        PostHog.setSingletonInstance(posthog)
    }

}