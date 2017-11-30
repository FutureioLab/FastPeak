package com.binlly.fastpeak.service

import android.os.Handler
import android.os.Looper

import com.binlly.fastpeak.app.App
import com.binlly.fastpeak.service.account.AccountService
import com.binlly.fastpeak.service.account.AccountServiceImpl
import com.binlly.fastpeak.service.remoteconfig.RemoteConfigService
import com.binlly.fastpeak.service.remoteconfig.RemoteConfigServiceImpl

object Services {

    lateinit var app: App
    private val mHandler = Handler(Looper.getMainLooper())

    fun remove(callbacks: Runnable) {
        mHandler.removeCallbacks(callbacks)
    }

    fun post(post: Runnable) {
        mHandler.post(post)
    }

    fun postDelayed(post: Runnable, delayMillis: Long) {
        mHandler.postDelayed(post, delayMillis)
    }

    fun postDelayed(delayMillis: Long = 0L, post: () -> Unit) {
        mHandler.postDelayed(post, delayMillis)
    }

    fun removeRunnable(post: (() -> Unit)?): Boolean {
        post ?: return false
        post.let {
            mHandler.removeCallbacks(post)
            return true
        }
    }

    private val accountService: AccountService by lazy { AccountServiceImpl.registerInstance() }

    private val remoteConfigService: RemoteConfigService by lazy { RemoteConfigServiceImpl.registerInstance() }

    fun app(): App {
        return App.app
    }


    fun account(): AccountService {
        return accountService
    }

    fun remoteConfig(): RemoteConfigService {
        return remoteConfigService
    }
}