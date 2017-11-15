package com.binlly.gankee.business.home

import android.content.Context
import com.binlly.gankee.base.mvp.BaseFragmentPresenterImpl
import com.binlly.gankee.base.rx.RxObserver
import com.binlly.gankee.repo.HomeRepo

class HomePresenter(
        context: Context, mView: HomeContract.View
): BaseFragmentPresenterImpl<HomeContract.View>(context, mView), HomeContract.Presenter {

    override fun requestFeedAll(page: Int, observer: RxObserver<List<FeedAll>?>) {
        HomeRepo.requestFeedAll(page, observer)
    }
}
