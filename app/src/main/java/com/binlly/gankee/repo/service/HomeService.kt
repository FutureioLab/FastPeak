package com.binlly.gankee.repo

import com.binlly.gankee.base.net.HttpResult
import com.binlly.gankee.business.PAGE_SIZE
import com.binlly.gankee.business.home.FeedAll
import io.reactivex.Observable
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {

    @FormUrlEncoded
    @GET("${com.binlly.gankee.api.ApiConfig.URL_HOME_FEED_ALL}{$PAGE_SIZE}/page")
    fun requestFeedAll(@Path("page") page: Int): Observable<HttpResult<List<FeedAll>>>
}
