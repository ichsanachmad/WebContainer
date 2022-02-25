package com.aster.webcontainer

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.isVisible
import com.aster.webcontainer.databinding.ActivityWebContainerBinding
import com.aster.webcontainer.listener.WebContainerBridge
import com.aster.webcontainer.listener.WebContainerListener

/**
 * @author ichsanachmad
 */
internal class WebContainerActivity : AppCompatActivity() {
    private val binding by lazy { ActivityWebContainerBinding.inflate(layoutInflater) }

    private val url by lazy { intent.getStringExtra(EXTRA_WC_URL) ?: "" }

    private val chromeClientProp by lazy {
        object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                setProgressLoadWebView(newProgress)
            }
        }
    }

    private val webViewClientProp by lazy {
        object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return false
            }
        }
    }

    private var isLoaded: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupActionBar()
        setupListener()
        setupWebContainer()
    }

    private fun setupActionBar() {
        binding.toolbar.apply {
            setSupportActionBar(this)
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        binding.webContainer.apply {
            when {
                isLoaded && canGoBack() -> goBack()
                else -> finish()
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebContainer() {
        Log.e(TAG, "UserAgent: ${System.getProperty(USER_AGENT_PROPERTY_KEY)}")
        binding.webContainer.apply {
            webViewClient = webViewClientProp
            webChromeClient = chromeClientProp
            settings.apply {
                useWideViewPort = true
                loadWithOverviewMode = true
                javaScriptEnabled = true
                userAgentString = System.getProperty(USER_AGENT_PROPERTY_KEY)
            }
            loadUrl(this@WebContainerActivity.url)
        }
    }

    private fun setupListener() {
        listener?.let {
            binding.webContainer.addJavascriptInterface(WebContainerBridge(it), CALLBACK_KEY)
        }
    }

    private fun setProgressLoadWebView(progress: Int) {
        binding.apply {
            progressBar.progress = progress
            toolbar.title = when {
                progress < MAX_PROGRESS -> {
                    supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_close_24)
                    isLoaded = false
                    getString(R.string.loading)
                }
                else -> {
                    supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
                    isLoaded = true
                    webContainer.title
                }
            }
            progressBar.isVisible = !isLoaded
        }
    }

    companion object {
        private const val TAG = "WebContainer"
        private const val USER_AGENT_PROPERTY_KEY = "http.agent"
        private const val EXTRA_WC_URL = "web_container_url"
        private const val CALLBACK_KEY = "AndroidAppCallback"
        private const val MAX_PROGRESS = 100

        private var listener: WebContainerListener? = null

        private var applicationContext: Context? = null

        @JvmStatic
        fun initialize(application: Application) {
            applicationContext = application.applicationContext
        }

        @JvmStatic
        fun openWebContainer(url: String) {
            startActivity(url)
        }

        @JvmStatic
        fun openWebContainerWithListener(
            url: String,
            listener: WebContainerListener
        ) {
            startActivity(url)
            this.listener = listener
        }

        private fun startActivity(url: String) {
            applicationContext?.let {
                Intent(it, WebContainerActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    putExtra(EXTRA_WC_URL, url)
                    it.startActivity(this)
                }
            }
                ?: throw IllegalStateException("WebContainer not initialized yet, please init in Application with WebContainer.init(application: Application)")
        }
    }
}