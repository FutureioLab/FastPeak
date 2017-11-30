package com.binlly.fastpeak.business.test.adapter

import android.content.Context
import android.widget.TextView

import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.adapter.BaseDelegate
import com.binlly.fastpeak.business.test.model.TestModel
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by binlly on 2017/5/13.
 */

class SectionDelegate(context: Context): BaseDelegate<TestModel>(context) {

    override val layoutResId: Int
        get() = R.layout.test_item_section

    override fun childConvert(holder: BaseViewHolder, item: TestModel) {
        val text = holder.getView<TextView>(R.id.text)
        text.text = item.section
    }
}
