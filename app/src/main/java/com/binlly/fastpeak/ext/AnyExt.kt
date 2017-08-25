package com.binlly.fastpeak.ext

import com.google.gson.Gson

/**
 * Created by yy on 2017/8/23.
 */

private val gson by lazy { Gson() }

fun Any.toJson(): String {
    return gson.toJson(this)
}

