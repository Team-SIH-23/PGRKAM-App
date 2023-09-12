package com.assignment.pgrkam_app

import android.app.Application
import com.posthog.android.PostHog
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class PgrkamApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val posthog =
            PostHog.Builder(this, "phx_mNTyr58SbJPVvEl0Yk79lM3zMFKEA0cNoHDYrWzoqpw")
                .captureApplicationLifecycleEvents()
                .recordScreenViews()
                .build()
        PostHog.setSingletonInstance(posthog)
    }

}