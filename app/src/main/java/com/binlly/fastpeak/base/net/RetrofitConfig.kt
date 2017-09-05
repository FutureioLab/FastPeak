package com.binlly.fastpeak.base.net

import com.binlly.fastpeak.BuildConfig

/**
 * Created by yy on 2017/8/23.
 */
object RetrofitConfig {
    private const val BASE_URL: String = "https://api.futureio.top/"
    private const val BASE_URL_DEBUG: String = "http://test.api.futureio.top/"

    fun getBaseUrl(): String {
        return if (BuildConfig.DEBUG) BASE_URL_DEBUG else BASE_URL
    }

    val debugHost: String
        get() = BASE_URL_DEBUG

    val onlineHost: String
        get() = BASE_URL
}