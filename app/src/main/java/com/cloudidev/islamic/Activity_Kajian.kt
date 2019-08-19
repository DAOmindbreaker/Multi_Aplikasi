package com.cloudidev.islamic

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_kajian.*

class Activity_Kajian : AppCompatActivity() {


    private val url = "https://muslim.or.id/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kajian)

        val settings = webView.settings;
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)

        settings.javaScriptEnabled = true
        settings.setAppCacheEnabled(true)
        settings.cacheMode = WebSettings.LOAD_DEFAULT
        settings.setAppCachePath(cacheDir.path)

        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = true

        settings.blockNetworkImage = false
        settings.loadsImagesAutomatically = true

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true

            settings.useWideViewPort = true
            settings.loadWithOverviewMode = true
            settings.javaScriptCanOpenWindowsAutomatically = true

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                settings.mediaPlaybackRequiresUserGesture = false
            }


            settings.domStorageEnabled = true
            settings.setSupportMultipleWindows(true)
            settings.loadWithOverviewMode = true
            settings.allowContentAccess = true
            settings.setGeolocationEnabled(true)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                settings.allowUniversalAccessFromFileURLs = true
            }

            settings.allowFileAccess = true

            webView.fitsSystemWindows = true

            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)

            webView.loadUrl(url)

            webView.webViewClient = object : WebViewClient() {

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    progressBar.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    progressBar.visibility = View.GONE
                }
            }

            fun onBackPressed() {
                val builder = AlertDialog.Builder(this)
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    builder.setCancelable(false)
                    builder.setIcon(R.drawable.ic_gallery)
                    builder.setTitle("App Web View")
                    builder.setMessage("Do you want to exit?")
                    builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                        finish()
                    })

                    builder.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                        dialog.cancel()
                    })
                    val alert = builder.create()
                    alert.show()
                }
            }
        }
    }
}