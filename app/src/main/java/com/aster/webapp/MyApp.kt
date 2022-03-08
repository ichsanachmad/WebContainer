package com.aster.webapp

import android.app.Application
import com.aster.webcontainer.WebContainer
import com.aster.webcontainer.util.useragent.UserAgent

/**
 * @author ichsanachmad
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        WebContainer.init(this, UserAgent.CHROME)
    }
}