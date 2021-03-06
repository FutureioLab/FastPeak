package com.binlly.fastpeak.repo


import com.binlly.fastpeak.api.ApiConfig
import com.binlly.fastpeak.base.net.ReqParams
import com.binlly.fastpeak.base.net.RetrofitManager
import com.binlly.fastpeak.base.rx.IoTransformer
import com.binlly.fastpeak.business.demo.fragment.DemoFragmentModel
import com.binlly.fastpeak.business.demo.model.DemoModel
import com.binlly.fastpeak.repo.service.DemoService
import io.reactivex.Observer

/**
 * Created by binlly on 16/9/7.
 */

object DemoRepo {
    private val TAG = DemoRepo::class.java.simpleName

    private val mService = RetrofitManager.create(DemoService::class.java)
    private val mMockService = RetrofitManager.createMock(
            DemoService::class.java)
    private val mServiceProxy = DynamicProxy(mService, mMockService).getProxy<DemoService>()

    fun putUserCache(demo: DemoModel) {
        val key = ApiConfig.URL_DEMO
        RepoCache.put(key, demo)
    }

    fun requestDemo(observer: Observer<DemoModel>) {
        val params = ReqParams(TAG)
        try {
            mServiceProxy.requestDemo(params.getFieldMap()).compose(IoTransformer()).subscribe(
                    observer)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun requestImageList(observer: Observer<DemoFragmentModel>) {
        val params = ReqParams(TAG)
        try {
            mServiceProxy.requestImageList(params.getFieldMap()).compose(IoTransformer()).subscribe(
                    observer)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}