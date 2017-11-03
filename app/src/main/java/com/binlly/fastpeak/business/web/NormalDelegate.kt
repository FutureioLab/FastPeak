package com.binlly.fastpeak.business.web

import android.content.Context
import android.widget.TextView
import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.adapter.BaseDelegate
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by yy on 2017/10/25.
 */
class NormalDelegate(context: Context): BaseDelegate<WebModel>(context) {

    override val layoutResId: Int
        get() = R.layout.weblist_item_normal

    override fun childConvert(holder: BaseViewHolder, item: WebModel) {
        val text = holder.getView<TextView>(R.id.text)
        text.text = item.s
        text.setBackgroundColor(item.color)
    }
}