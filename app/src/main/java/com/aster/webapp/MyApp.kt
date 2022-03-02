package com.aster.webapp

import android.app.Application
import com.aster.webcontainer.WebContainer

/**
 * @author ichsanachmad
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        WebContainer.init(this)
    }
}