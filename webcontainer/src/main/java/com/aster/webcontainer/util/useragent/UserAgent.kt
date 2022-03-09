package com.aster.webcontainer.util.useragent

/**
 * @author ichsanachmad
 */
enum class UserAgent(val type: String) {
    CHROME(UserAgentType.CHROME),
    FIREFOX(UserAgentType.FIREFOX),
    OPERA(UserAgentType.OPERA),
    SAFARI(UserAgentType.SAFARI),
    DEFAULT_DEVICE(System.getProperty("http.agent") ?: UserAgentType.CHROME)
}