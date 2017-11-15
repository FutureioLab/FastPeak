package com.binlly.gankee.base.net

/**
 * Author:  yy
 * Date:    2016/4/30
 * Desc:    网络请求返回
 */
class HttpResult<T> {
    var result: T? = null
    var status: Status = Status()

    class Status {
        var status_code: Int = 0
        var status_reason: String? = null
    }
}
