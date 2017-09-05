package com.binlly.fastpeak

import com.binlly.fastpeak.ext.DelegatesExt

/**
 * Created by yy on 2017/9/1.
 */

object Build {

    const val PREFERENCE_BUILD = "build"
    const val KEY_ENV = "env"

    const val ENV_DEBUG = "env_debug"
    const val ENV_ONLINE = "env_online"

    val defaultEnv = if (BuildConfig.DEBUG) ENV_DEBUG else ENV_ONLINE
    var env by DelegatesExt.preference(PREFERENCE_BUILD, KEY_ENV, defaultEnv)
}