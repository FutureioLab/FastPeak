package com.binlly.fastpeak.business.web

import com.binlly.fastpeak.base.model.IModel
import com.chad.library.adapter.base.entity.MultiItemEntity

data class WebListModel(val list: MutableList<WebModel>): IModel {
    companion object {
        const val TYPE_NORMAL = 0
        const val TYPE_WEB = 1
    }
}

data class WebModel(var s: String, val color: Int, val isWeb: Boolean, var isRefresh: Boolean):
        MultiItemEntity {
    override fun getItemType(): Int {
        return if (isWeb) 1 else 0
    }
}
