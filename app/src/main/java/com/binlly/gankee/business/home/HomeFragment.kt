package com.binlly.gankee.business.home

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import com.binlly.gankee.R
import com.binlly.gankee.base.mvp.BaseMvpFragment
import com.binlly.gankee.base.widget.divider.divider.HorizontalDividerItemDecoration
import com.binlly.gankee.business.home.adapter.HomeAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseMvpFragment<HomePresenter>(), HomeContract.View,
                    BaseQuickAdapter.RequestLoadMoreListener {

    private lateinit var adapter: HomeAdapter

    override fun getContentViewId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        adapter = HomeAdapter()
        adapter.setOnLoadMoreListener(this, recycler)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
        recycler.addItemDecoration(HorizontalDividerItemDecoration.Builder(context).size(1).color(
                Color.rgb(0xe8, 0xe8, 0xe8)).build())

        swipe.setOnRefreshListener {
            P.refresh()
        }
        P.refresh()
    }

    override fun onReload() {
        super.onReload()
        P.refresh()
    }

    override fun refresh(list: List<FeedAll>) {
        swipe.isRefreshing = false
        adapter.setNewData(list)
    }

    override fun onLoadMoreRequested() {
        P.loadmore()
    }

    override fun loadMore(list: List<FeedAll>) {
        adapter.addData(list)
    }

    override fun loadComplete() {
        adapter.loadMoreComplete()
    }

    override fun loadEnd() {
        adapter.loadMoreEnd()
    }

    override fun loadFail() {
        swipe.isRefreshing = false
        adapter.loadMoreFail()
    }
}
