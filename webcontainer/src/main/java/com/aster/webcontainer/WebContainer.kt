package com.aster.webcontainer

import android.app.Application
import android.content.Context
import com.aster.webcontainer.listener.WebContainerListener

/**
 * @author ichsanachmad
 */
object WebContainer {

    @JvmStatic
    fun init(application: Application) {
        WebContainerActivity.initialize(application)
    }

    @JvmStatic
    fun launch(url: String) {
        WebContainerActivity.openWebContainer(url)
    }

    @JvmStatic
    fun launch(url: String, enableSwipeRefresh: Boolean) {
        WebContainerActivity.openWebContainer(url, enableSwipeRefresh)
    }

    @JvmStatic
    fun launch(url: String, listener: WebContainerListener) {
        WebContainerActivity.openWebContainerWithListener(url, listener)
    }

    @JvmStatic
    fun launch(url: String, enableSwipeRefresh: Boolean, listener: WebContainerListener) {
        WebContainerActivity.openWebContainerWithListener(url, listener, enableSwipeRefresh)
    }
}