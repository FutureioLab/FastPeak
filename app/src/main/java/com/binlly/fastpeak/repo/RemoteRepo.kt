package com.binlly.fastpeak.repo

import com.binlly.fastpeak.api.RemoteService
import com.binlly.fastpeak.base.PREFERENCE_NAME_REMOTE_CONFIG
import com.binlly.fastpeak.base.Preference
import com.binlly.fastpeak.base.net.ReqParams
import com.binlly.fastpeak.base.net.RetrofitManager
import com.binlly.fastpeak.base.rx.IoTransformer
import com.binlly.fastpeak.service.Services
import com.binlly.fastpeak.service.remoteconfig.RemoteMockModel
import io.reactivex.Observer
import retrofit2.Retrofit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by yy on 2017/10/10.
 */
object RemoteRepo {
    private val TAG = RemoteRepo::class.java.simpleName

    const val PREFERENCE_KEY_HOST = "host"

    var mockHost: String by MockHostDelegate()
    var mRetrofit: Retrofit = RetrofitManager.createRetrofit(mockHost)
    var mService = mRetrofit.create(RemoteService::class.java)

    fun requestMock(observer: Observer<RemoteMockModel>) {
        val params = ReqParams(TAG)
        try {
            mService.requestMock(params.getFieldMap()).compose(IoTransformer()).subscribe(observer)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

class MockHostDelegate: ReadWriteProperty<Any?, String> {
    private var host: String by Preference(Services.app, PREFERENCE_NAME_REMOTE_CONFIG,
            RemoteRepo.PREFERENCE_KEY_HOST, "http://127.0.0.1")

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return host
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        if (host == value) return
        host = value
        RemoteRepo.mRetrofit = RetrofitManager.createRetrofit(host)
        RemoteRepo.mService = RemoteRepo.mRetrofit.create(RemoteService::class.java)
        Services.remoteConfig().pullMockConfig({}) //改变地址之后重新拉取并更新mock配置
    }
}


