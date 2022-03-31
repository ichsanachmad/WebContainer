package com.aster.webcontainer.extension

/**
 * @author ichsanachmad
 */
fun String.isUrl(): Boolean {
    val regex = "((http(s)?|ftp|file)://)?(([wW]){3}.)?[a-zA-Z0-9-._]+\\.[a-zA-Z0-9.]+[a-zA-Z0-9/?=%*+&#~]+"
    return matches(regex.toRegex())
}