package com.binlly.gankee.business.girl

import android.content.Context
import android.os.Bundle
import com.binlly.gankee.base.mvp.BaseFragmentPresenterImpl
import com.binlly.gankee.base.rx.RxObserver
import com.binlly.gankee.repo.GirlRepo

class GirlPresenter(context: Context,
                    mView: GirlContract.View): BaseFragmentPresenterImpl<GirlContract.View>(context,
        mView), GirlContract.Presenter {

    override fun handleArgument(bundle: Bundle?) {
        super.handleArgument(bundle)
    }

    override fun requestGirls(observer: RxObserver<List<FeedGirl>?>) {
        GirlRepo.requestGirls(observer)
    }
}
