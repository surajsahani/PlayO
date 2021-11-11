package com.suraj.playo.ui.newslist

import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Animatable
import android.net.ConnectivityManager
import android.os.Bundle
import android.provider.Settings
import android.view.KeyEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.suraj.playo.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    private val URL = "https://news.google.com/"
    private var isAlreadyCreated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        startLoaderAnimation()

        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(false)

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                endLoaderAnimate()
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                endLoaderAnimate()
                showErrorDialog("Error",
                    "No internet connection. Please check your connection.",
                    this@WebViewActivity)
            }
        }

        webView.loadUrl(URL)
    }

    override fun onResume() {
        super.onResume()

        if(isAlreadyCreated && !isNetworkAvailable()) {
            isAlreadyCreated = false
            showErrorDialog("Error", "No internet connection. Please check your connection."
                    ,this@WebViewActivity)
        }
    }
    private fun isNetworkAvailable(): Boolean {
        val connectionManager =
            this@WebViewActivity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo

        return networkInfo !=null && networkInfo.isConnectedOrConnecting
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
    private fun showErrorDialog(title: String,message: String, context: Context) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setNegativeButton("Cancel", {_,_->
            this@WebViewActivity.finish()
        })
        dialog.setNeutralButton("Settings", {_,_->
            startActivity(Intent(Settings.ACTION_SETTINGS))
        })
        dialog.create().show()
    }
    private fun endLoaderAnimate() {
        loaderImage.clearAnimation()
        loaderImage.visibility = View.GONE
    }
    private fun startLoaderAnimation() {
        val objectAction = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                val startHeight = 170
                val newHeight = (startHeight + (startHeight + 40) * interpolatedTime).toInt()
                loaderImage.layoutParams.height = newHeight
                loaderImage.requestLayout()
            }

            override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
                super.initialize(width, height, parentWidth, parentHeight)
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }
        
        objectAction.repeatCount = -1
        objectAction.repeatMode = ValueAnimator.REVERSE
        objectAction.duration = 1000
        loaderImage.startAnimation(objectAction)
    }
}