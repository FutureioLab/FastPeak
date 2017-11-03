package com.binlly.fastpeak.business.web

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.mvp.BaseMvpActivity
import com.binlly.fastpeak.base.rx.RxObserver
import kotlinx.android.synthetic.main.activity_web_list.*


class WebListActivity: BaseMvpActivity<WebListPresenter>(), WebListContract.View {

    private lateinit var adapter: WebListAdapter
    private lateinit var observer: RxObserver<WebListModel>

    override fun getContentView(): Int {
        return R.layout.activity_web_list
    }

    override fun initView(savedInstanceState: Bundle?) {
        swipe.setOnRefreshListener { refresh() }

        recycler.layoutManager = LinearLayoutManager(this)
        adapter = WebListAdapter(this)
        recycler.adapter = adapter

        adapter.setEnableLoadMore(true)
        adapter.setOnLoadMoreListener({ loadMore() }, recycler)

        observer = object: RxObserver<WebListModel>() {
            // do nothing
        }

        refresh()
    }

    private fun refresh() {
        P().request(observer)
    }

    private fun loadMore() {
        P().loadMore(observer)
    }

    override fun onRefresh(list: List<WebModel>) {
        swipe.isRefreshing = false
        adapter.setNewData(list)
    }

    override fun onLoadMore(list: List<WebModel>) {
        adapter.addData(list)
    }

    override fun loadComplete() {
        adapter.loadMoreComplete()
    }

    override fun loadEnd() {
        adapter.loadMoreEnd()
    }

    override fun loadFail() {
        adapter.loadMoreFail()
    }
}
