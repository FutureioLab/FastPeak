package com.binlly.fastpeak.api

import com.binlly.fastpeak.base.net.HttpResult
import com.binlly.fastpeak.service.remoteconfig.RemoteMockModel
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by binlly on 16/6/24.
 */
interface RemoteService {

    @FormUrlEncoded
    @POST(ApiConfig.URL_CONFIG_MOCK)
    fun requestMock(@FieldMap fieldMap: Map<String, String>): Observable<HttpResult<RemoteMockModel>>
}