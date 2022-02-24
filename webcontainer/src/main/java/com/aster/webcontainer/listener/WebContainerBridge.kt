package com.aster.webcontainer.listener

import android.webkit.JavascriptInterface

/**
 * @author ichsanachmad
 */
internal class WebContainerBridge(private val listener: WebContainerListener) {
    @JavascriptInterface
    fun callback(json: String) {
        listener.callback(json)
    }
}