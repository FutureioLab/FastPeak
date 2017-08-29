package com.binlly.fastpeak.ext

import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.glide.progress.OnGlideImageViewListener
import com.binlly.fastpeak.base.glide.progress.OnProgressListener
import com.binlly.fastpeak.base.glide.progress.ProgressManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


/**
 * Created by yy on 2017/8/29.
 */

private val mMainHandler = Handler(Looper.getMainLooper())

fun ImageView.loadCircle(uri: Any?, holder: Int = resources.getColor(R.color.place_holder),
                         listener: OnGlideImageViewListener? = null) {
    val options = RequestOptions().placeholder(holder).error(holder).circleCrop()
    load(uri, options, listener)
}

fun ImageView.loadNoCache(uri: Any?, holder: Int = resources.getColor(R.color.place_holder),
                          listener: OnGlideImageViewListener? = null) {
    val options = RequestOptions().placeholder(holder).error(holder).diskCacheStrategy(
            DiskCacheStrategy.NONE)
    load(uri, options, listener)
}

fun ImageView.load(uri: Any?, holder: Int = resources.getColor(R.color.place_holder),
                   listener: OnGlideImageViewListener? = null) {
    val options = RequestOptions().placeholder(holder).error(holder)
    load(uri, options, listener)
}

fun ImageView.load(uri: Any?, options: RequestOptions, listener: OnGlideImageViewListener? = null) {
    if (checkUriParams(uri)) addListener(this, listener)

    val requestBuilder = Glide.with(context).load(uri).apply(options)
    listener?.let {
        requestBuilder.listener(object: RequestListener<Drawable> {
            override fun onResourceReady(resource: Drawable?, model: Any?,
                                         target: Target<Drawable>?, dataSource: DataSource?,
                                         isFirstResource: Boolean): Boolean {
                ProgressManager.removeProgressListener(this@load)
                return false
            }

            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?,
                                      isFirstResource: Boolean): Boolean {
                ProgressManager.removeProgressListener(this@load)
                return false
            }
        }).into(this)
    } ?: requestBuilder.into(this)
}

fun ImageView.loadGif(uri: Any?, holder: Int = resources.getColor(R.color.place_holder),
                      listener: OnGlideImageViewListener? = null) {
    if (checkUriParams(uri)) addListener(this, listener)

    val options = RequestOptions().placeholder(holder).error(holder)
    val requestBuilder = Glide.with(context).load(uri).apply(options)
    listener?.let {
        requestBuilder.listener(object: RequestListener<Drawable> {
            override fun onResourceReady(resource: Drawable?, model: Any?,
                                         target: Target<Drawable>?, dataSource: DataSource?,
                                         isFirstResource: Boolean): Boolean {
                ProgressManager.removeProgressListener(this@loadGif)
                return false
            }

            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?,
                                      isFirstResource: Boolean): Boolean {
                ProgressManager.removeProgressListener(this@loadGif)
                return false
            }
        }).into(this)
    } ?: requestBuilder.into(this)
}

private fun addListener(imageView: ImageView, listener: OnGlideImageViewListener?) {
    listener?.let {
        val internalProgressListener = object: OnProgressListener {
            override fun onProgress(imageUrl: String, bytesRead: Long, totalBytes: Long,
                                    isDone: Boolean, exception: GlideException?) {
                mMainHandler.post {
                    val percent = (bytesRead * 1.0f / totalBytes * 100.0f).toInt()
                    listener.onProgress(percent, isDone, exception)
                }
                if (isDone) ProgressManager.removeProgressListener(imageView)
            }
        }
        ProgressManager.addProgressListener(imageView, internalProgressListener)
    }
}

private fun checkUriParams(uri: Any?): Boolean {
    return uri?.let { (uri as? String)?.startsWith("http") } ?: false
}