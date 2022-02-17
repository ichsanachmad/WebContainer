package com.aster.webcontainer

import android.content.Context

/**
 * @author ichsanachmad
 */
object WebContainer {
    fun launch(context: Context, url: String) {
       WebContainerActivity.openWebContainer(context, url)
    }
}