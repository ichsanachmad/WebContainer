package com.aster.webcontainer

import android.content.Context
import com.aster.webcontainer.listener.WebContainerListener

/**
 * @author ichsanachmad
 */
class WebContainer {
    companion object {
        fun launch(context: Context, url: String) {
            WebContainerActivity.openWebContainer(context, url)
        }

        fun launch(context: Context, url: String, listener: WebContainerListener) {
            WebContainerActivity.openWebContainerWithListener(context, url, listener)
        }
    }
}