package com.binlly.gankee.repo

import com.binlly.gankee.base.net.HttpResult
import com.binlly.gankee.business.girl.FeedGirl
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GirlService {

    @FormUrlEncoded
    @POST(com.binlly.gankee.api.ApiConfig.URL_FEED_GIRL)
    @com.binlly.gankee.repo.mock.MOCK(com.binlly.gankee.api.ApiConfig.URL_FEED_GIRL)
    fun request(@FieldMap fieldMap: Map<String, String>): Observable<HttpResult<List<FeedGirl>?>>
}
