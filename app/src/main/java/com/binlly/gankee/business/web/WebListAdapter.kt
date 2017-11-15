package com.binlly.gankee.business.web

import android.content.Context
import com.fangxin.assessment.base.adapter.MultipleItemAdapter

/**
 * Created by yy on 2017/10/25.
 */
class WebListAdapter(context: Context): MultipleItemAdapter<WebModel>(null) {

    init {
        addItemViewDelegate(WebListModel.TYPE_NORMAL, NormalDelegate(context))
        addItemViewDelegate(WebListModel.TYPE_WEB, WebDelegate(context))
    }
}