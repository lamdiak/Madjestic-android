package com.devrich.madjestic.baseController

import android.app.Application
import android.content.Context
import com.devrich.madjestic.BuildConfig
import timber.log.Timber
import kotlin.properties.Delegates

class ApplicationController: Application() {

    init {
        instance = this
    }

    companion object {
        var isDebug by Delegates.notNull<Boolean>() // two way to acces debug value
        private var instance: ApplicationController? = null
        fun context(): Context = instance!!.applicationContext
    }



    override fun onCreate() {
        super.onCreate()
        isDebug = true
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree()) // config Timber in debug mode
        }
    }
}