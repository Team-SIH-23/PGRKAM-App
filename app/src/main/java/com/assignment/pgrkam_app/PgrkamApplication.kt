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
                "phc_o1HXu9FckrqYTc9YKbFlPeZrXkk40BYZlto5LmAiQ0L",
                "https://a7ae-2402-e280-2146-325-7de6-90c1-fafe-79b1.ngrok-free.app/"
            )
                .captureApplicationLifecycleEvents()
                .recordScreenViews()
                .build()
        PostHog.setSingletonInstance(posthog)
    }

}