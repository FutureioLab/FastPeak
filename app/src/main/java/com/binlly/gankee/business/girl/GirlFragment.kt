package com.binlly.gankee.business.girl

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.binlly.gankee.R
import com.binlly.gankee.base.mvp.BaseMvpFragment
import com.binlly.gankee.base.widget.divider.divider.HorizontalDividerItemDecoration
import com.binlly.gankee.business.home.adapter.GirlAdapter
import com.binlly.gankee.business.photo.PhotoViewActivity
import com.binlly.gankee.ext.dp2px
import com.binlly.gankee.ext.getColor
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*


class GirlFragment: BaseMvpFragment<GirlPresenter>(), GirlContract.View,
                    BaseQuickAdapter.RequestLoadMoreListener {

    private lateinit var adapter: GirlAdapter

    override fun getContentViewId(): Int = R.layout.fragment_girl

    override fun initView() {
        adapter = GirlAdapter()
        adapter.setOnLoadMoreListener(this, recycler)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
        val h = 10
        recycler.addItemDecoration(HorizontalDividerItemDecoration.Builder(context).size(h.dp2px()).color(
                getColor(R.color.divider_color)).build())

        adapter.setMessageHandler { action, position, item, args, view ->
            when (action) {
                GirlAdapter.ACTION_TO_PREVIEW -> {
                    val intent = Intent(context, PhotoViewActivity::class.java)
                    intent.putExtra("position", position)
                    intent.putStringArrayListExtra("photo_list",
                            getPhotoList() as ArrayList<String>?)
                    try {
                        val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                context as Activity,
                                view as View,
                                "photo")
                        startActivity(intent, activityOptionsCompat.toBundle())
                    } catch (e: Exception) {
                        startActivity(intent)
                    }
                }
            }
        }

        swipe.setOnRefreshListener {
            P.refresh()
        }
        P.refresh()
    }

    private fun getPhotoList(): List<String?> {
        return adapter.data.filterNotNull().map { it.url }
    }

    override fun onReload() {
        super.onReload()
        swipe.isRefreshing = false
        P.refresh()
    }

    override fun onLoadMoreRequested() {
        P.loadmore()
    }

    override fun refresh(list: List<FeedGirl>) {
        swipe.isRefreshing = false
        adapter.setNewData(list)
    }

    override fun loadMore(list: List<FeedGirl>) {
        adapter.addData(list)
    }

    override fun loadEnd() {
        adapter.loadMoreEnd()
    }

    override fun loadComplete() {
        adapter.loadMoreComplete()
    }

    override fun loadFail() {
        adapter.loadMoreFail()
    }
}
