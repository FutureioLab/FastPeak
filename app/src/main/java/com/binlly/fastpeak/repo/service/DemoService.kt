package com.binlly.fastpeak.repo.service

import com.binlly.fastpeak.api.ApiConfig
import com.binlly.fastpeak.base.net.HttpResult
import com.binlly.fastpeak.business.demo.fragment.DemoFragmentModel
import com.binlly.fastpeak.business.demo.model.DemoModel
import com.binlly.fastpeak.repo.mock.MOCK
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by binlly on 16/6/24.
 */
interface DemoService {

    @FormUrlEncoded
    @POST(ApiConfig.URL_DEMO)
    @MOCK(ApiConfig.URL_DEMO)
    fun requestDemo(@FieldMap fieldMap: Map<String, String>): Observable<HttpResult<DemoModel>>

    @FormUrlEncoded
    @POST(ApiConfig.URL_IMAGE_LIST)
    @MOCK(ApiConfig.URL_IMAGE_LIST)
    fun requestImageList(@FieldMap fieldMap: Map<String, String>): Observable<HttpResult<DemoFragmentModel>>
}