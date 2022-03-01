package com.aster.webcontainer.util

/**
 * @author ichsanachmad
 */
fun String.isUrl(): Boolean {
    val regex = "((http?|https|ftp|file)://)?(([Ww]){3}.)?[a-zA-Z0-9]+.[a-zA-Z]+"
    return matches(regex.toRegex())
}