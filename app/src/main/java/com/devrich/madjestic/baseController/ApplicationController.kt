package com.devrich.madjestic.baseController

import android.app.Application
import com.devrich.madjestic.BuildConfig
import timber.log.Timber
import kotlin.properties.Delegates

open class ApplicationController: Application() {


    companion object {
        var isDebug by Delegates.notNull<Boolean>() // two way to acces debug value
    }

    override fun onCreate() {
        super.onCreate()

        isDebug = true

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree()) // config Timber in debug mode
        }
    }
}