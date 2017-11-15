package com.binlly.gankee.business.web

import android.content.Context
import android.content.Intent
import android.graphics.Color
import com.binlly.gankee.base.mvp.BaseActivityPresenterImpl
import com.binlly.gankee.base.rx.RxObserver
import java.util.*

class WebListPresenter(context: Context,
                       mView: WebListContract.View): BaseActivityPresenterImpl<WebListContract.View>(
        context, mView), WebListContract.Presenter {

    private val PAGE_SIZE = 5
    private var page = 0

    private val urls = listOf("https://www.zhihu.com/question/67027731",
            "https://www.zhihu.com/question/36314137/answer/249723126")

    private val datas = makeFakeDatas(20)

    override fun handleIntent(intent: Intent): Boolean {
        return true
    }

    override fun request(observer: RxObserver<WebListModel>) {
        page = 0
        V().onRefresh(getSlice(0 until PAGE_SIZE))
        page++
    }

    override fun loadMore(observer: RxObserver<WebListModel>) {
        val from = page * PAGE_SIZE
        if (from >= datas.size) {
            V().hideLoading()
            V().loadEnd()
            return
        }
        val to = if (datas.size > from + PAGE_SIZE) from + PAGE_SIZE else datas.size
        V().onLoadMore(getSlice(from until to))
        V().loadComplete()
        page++
    }

    private fun getSlice(range: IntRange): List<WebModel> {
        return datas.slice(range).onEach {
            if (it.isWeb) {
                it.isRefresh = true
                it.s = urls[Random().nextInt(2)]
            }
        }
    }

    private fun makeFakeDatas(size: Int): List<WebModel> {
        val list = arrayListOf<WebModel>()
        val random = Random()
        (0 until size).map {
            val color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256))
            val s = if (it == 0) urls[random.nextInt(2)] else "第${it}项"
            WebModel(s, color, it == 0, true)
        }.forEach {
            list.add(it)
        }
        return list
    }
}
