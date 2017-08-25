package com.binlly.fastpeak.repo


import com.binlly.fastpeak.base.net.ReqParams
import com.binlly.fastpeak.base.net.RetrofitManager
import com.binlly.fastpeak.base.rx.IoTransformer
import com.binlly.fastpeak.api.ApiConfig
import com.binlly.fastpeak.api.DemoService
import com.binlly.fastpeak.business.demo.model.DemoModel
import io.reactivex.Observer

/**
 * Created by binlly on 16/9/7.
 */

object DemoRepo {
    private val TAG = DemoRepo::class.java.simpleName

    private val mService = RetrofitManager.create(
            DemoService::class.java)

    fun putUserCache(demo: DemoModel) {
        val key = ApiConfig.URL_DEMO
        RepoCache.put(key, demo)
    }

    fun requestDemo(observer: Observer<DemoModel>) {
        val params = ReqParams(TAG)
        try {
            mService.requestDemo(params.getFieldMap()).compose(IoTransformer()).subscribe(observer)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}