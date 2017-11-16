package com.binlly.gankee.business.home.adapter

import android.view.View
import android.widget.ImageView
import com.binlly.gankee.R
import com.binlly.gankee.business.home.FeedAll
import com.binlly.gankee.ext.dp2px
import com.binlly.gankee.ext.load
import com.chad.library.adapter.base.BaseViewHolder
import com.fangxin.assessment.base.adapter.ItemViewDelegate

/**
 * Created by yy on 2017/11/16.
 */
class OtherDelegate: ItemViewDelegate<FeedAll, BaseViewHolder> {

    override fun getItemViewLayoutId(): Int {
        return R.layout.item_home_other
    }

    override fun onCreateDefViewHolder(view: View): BaseViewHolder? {
        return null
    }

    override fun convert(holder: BaseViewHolder, item: FeedAll) {
        holder.setText(R.id.text_name, item.desc)
        holder.setText(R.id.text_date, item.createdAt)
        holder.setText(R.id.text_type, item.type)
        val image = holder.getView<ImageView>(R.id.image_cover)
        if (item.images == null || item.images.isEmpty()) {
            image.visibility = View.GONE
        } else {
            image.visibility = View.VISIBLE
            val w = 80
            val url = "${item.images[0]}?imageView2/0/w/${w.dp2px()}" //请求小图
            image.load(url)
        }
    }
}