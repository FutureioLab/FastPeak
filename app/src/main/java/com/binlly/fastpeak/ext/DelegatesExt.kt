package com.binlly.fastpeak.ext

import com.binlly.fastpeak.base.Preference
import com.binlly.fastpeak.service.Services

/**
 * Created by yy on 2017/9/1.
 */


object DelegatesExt {
    fun <T: Any> preference(which: String, key: String, default: T) = Preference(Services.app,
            which, key, default)
}