package com.binlly.fastpeak.business.test.adapter

import android.content.Context
import android.widget.TextView

import com.binlly.fastpeak.R
import com.binlly.fastpeak.business.test.model.TestModel
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by binlly on 2017/5/13.
 */

class BuildDelegate(context: Context): BaseDelegate(context) {

    override val layoutResId: Int
        get() = R.layout.test_item_key_value

    override fun childConvert(holder: BaseViewHolder, item: TestModel) {
        val key = holder.getView<TextView>(R.id.key)
        val value = holder.getView<TextView>(R.id.value)
        value.setTextIsSelectable(true)
        key.text = item.build.key
        value.text = item.build.value
        value.setTextColor(item.valueColor)
    }
}
