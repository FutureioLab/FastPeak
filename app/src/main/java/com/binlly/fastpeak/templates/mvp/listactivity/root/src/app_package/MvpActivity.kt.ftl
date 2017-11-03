package ${packageName}

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
<#if includeCppSupport!false>
import android.widget.TextView
</#if>
<#if applicationPackage?? && generateLayout>
import ${applicationPackage}.R
</#if>

import kotlinx.android.synthetic.main.${layoutName}.*


class ${moduleName}Activity: BaseMvpActivity<${moduleName}Presenter>(), ${moduleName}Contract.View {

    private lateinit var adapter: ${moduleName}Adapter
    private lateinit var observer: RxObserver<${moduleName}Model>

<#if generateLayout>
    override fun getContentView(): Int {
        return R.layout.${layoutName}
    }
</#if>

    override fun initView(savedInstanceState: Bundle?) {
        swipe.setOnRefreshListener { refresh() }

        recycler.layoutManager = LinearLayoutManager(this)
        adapter = ${moduleName}Adapter(this)
        recycler.adapter = adapter

        adapter.setEnableLoadMore(true)
        adapter.setOnLoadMoreListener({ loadMore() }, recycler)

        observer = object: RxObserver<${moduleName}Model>() {
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

    override fun onRefresh(list: List<${moduleName}Model.Model>) {
        swipe.isRefreshing = false
        adapter.setNewData(list)
    }

    override fun onLoadMore(list: List<${moduleName}Model.Model>) {
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
