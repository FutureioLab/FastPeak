package com.binlly.fastpeak.business.web

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.adapter.BaseDelegate
import com.chad.library.adapter.base.BaseViewHolder


/**
 * Created by yy on 2017/10/25.
 */
class WebDelegate(context: Context): BaseDelegate<WebModel>(context) {

    override val layoutResId: Int
        get() = R.layout.weblist_item_web

    private lateinit var viewHolder: ViewHolder
    private var url: String? = null

    override fun onCreateDefViewHolder(view: View): BaseViewHolder? {
        viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun childConvert(holder: BaseViewHolder, item: WebModel) {
        if (item.isRefresh && (url != item.s) && holder is ViewHolder) {
            item.isRefresh = false
            url = item.s
            holder.webview.loadUrl(url)
        }
    }

    class ViewHolder(view: View): BaseViewHolder(view) {
        val webview: WebView = view.findViewById(R.id.webview)

        init {
            initWebView(webview)
        }

        @TargetApi(Build.VERSION_CODES.KITKAT) private fun initWebView(webview: WebView) {
//            webview.settings.loadWithOverviewMode = true
            webview.settings.javaScriptEnabled = true
            webview.settings.builtInZoomControls = true
            webview.settings.domStorageEnabled = true
            webview.settings.setGeolocationEnabled(true)
            webview.settings.cacheMode = WebSettings.LOAD_NO_CACHE
            webview.settings.useWideViewPort = true
            webview.setLayerType(View.LAYER_TYPE_NONE, null)
            webview.webChromeClient = WebChromeClient()
            webview.webViewClient = WebViewClient()
        }
    }
}