package com.aster.webcontainer

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author ichsanachmad
 */
@RunWith(AndroidJUnit4::class)
class WebContainerTest {

    @Before
    fun setup() {
        WebContainer.init(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun onCall_WebContainer_launch_String_should_open_WebView() {
        WebContainer.launch("www.google.com")

        assertDisplayed(R.id.webContainer)
        assertNotDisplayed(R.id.progressBar)
    }
}