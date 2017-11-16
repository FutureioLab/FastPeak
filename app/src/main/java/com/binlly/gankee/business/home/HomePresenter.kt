package com.binlly.gankee.business.home

import android.content.Context
import com.binlly.gankee.base.mvp.BaseFragmentPresenterImpl
import com.binlly.gankee.base.rx.RxObserver
import com.binlly.gankee.repo.HomeRepo

class HomePresenter(
        context: Context, mView: HomeContract.View
): BaseFragmentPresenterImpl<HomeContract.View>(context, mView), HomeContract.Presenter {

    private var page = 0

    override fun requestFeedAll(page: Int, observer: RxObserver<List<FeedAll>?>) {
        HomeRepo.requestFeedAll(page, observer)
    }

    fun refresh() {
        page = 0
        requestFeedAll(0, object: RxObserver<List<FeedAll>?>() {
            override fun onNext(list: List<FeedAll>?) {
                if (list == null || list.isEmpty()) {
                    V().setPageEmpty()
                    return
                }
                V().setPageSuccess()
                V().refresh(list)
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                V().loadFail()
            }
        })
    }

    fun loadmore() {
        ++page
        requestFeedAll(page, object: RxObserver<List<FeedAll>?>() {
            override fun onNext(list: List<FeedAll>?) {
                if (list == null || list.isEmpty()) {
                    V().loadEnd()
                    return
                }
                V().loadMore(list)
                V().loadComplete()
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                V().loadFail()
            }
        })
    }
}
