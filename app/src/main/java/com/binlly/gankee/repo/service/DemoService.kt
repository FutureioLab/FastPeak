package com.binlly.gankee.repo.service

import com.binlly.gankee.base.net.HttpResult
import com.binlly.gankee.business.demo.fragment.DemoFragmentModel
import com.binlly.gankee.business.demo.model.DemoModel
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by binlly on 16/6/24.
 */
interface DemoService {

    @FormUrlEncoded
    @POST(com.binlly.gankee.api.ApiConfig.URL_DEMO)
    @com.binlly.gankee.repo.mock.MOCK(com.binlly.gankee.api.ApiConfig.URL_DEMO)
    fun requestDemo(@FieldMap fieldMap: Map<String, String>): Observable<HttpResult<DemoModel>>

    @FormUrlEncoded
    @POST(com.binlly.gankee.api.ApiConfig.URL_IMAGE_LIST)
    @com.binlly.gankee.repo.mock.MOCK(com.binlly.gankee.api.ApiConfig.URL_IMAGE_LIST)
    fun requestImageList(@FieldMap fieldMap: Map<String, String>): Observable<HttpResult<DemoFragmentModel>>
}