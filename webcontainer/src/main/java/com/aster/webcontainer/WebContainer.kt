package com.aster.webcontainer

import android.app.Application
import android.content.Context
import com.aster.webcontainer.listener.WebContainerListener

/**
 * @author ichsanachmad
 */
class WebContainer {
    companion object {
        fun init(application: Application) {
            WebContainerActivity.initialize(application)
        }

        fun launch(url: String) {
            WebContainerActivity.openWebContainer(url)
        }

        fun launch(url: String, listener: WebContainerListener) {
            WebContainerActivity.openWebContainerWithListener(url, listener)
        }
    }
}