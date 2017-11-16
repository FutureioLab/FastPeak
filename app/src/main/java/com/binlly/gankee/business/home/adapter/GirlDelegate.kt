package com.binlly.gankee.business.home.adapter

import android.view.View
import android.widget.ImageView
import com.binlly.gankee.R
import com.binlly.gankee.business.home.FeedAll
import com.binlly.gankee.ext.load
import com.chad.library.adapter.base.BaseViewHolder
import com.fangxin.assessment.base.adapter.ItemViewDelegate

/**
 * Created by yy on 2017/11/16.
 */
class GirlDelegate: ItemViewDelegate<FeedAll, BaseViewHolder> {

    override fun getItemViewLayoutId(): Int {
        return R.layout.item_home_girl
    }

    override fun onCreateDefViewHolder(view: View): BaseViewHolder? {
        return null
    }

    override fun convert(holder: BaseViewHolder, item: FeedAll) {
        val image = holder.getView<ImageView>(R.id.image)
        image.load(item.url)
    }
}