package com.binlly.fastpeak.business.demo.fragment

import android.content.Context
import android.os.Bundle
import com.binlly.fastpeak.base.mvp.BaseFragmentPresenterImpl
import com.binlly.fastpeak.base.rx.RxObserver
import com.binlly.fastpeak.business.demo.model.DemoModel
import com.binlly.fastpeak.repo.DemoRepo

/**
 * Created by yy on 2017/8/25.
 */
class DemoFragmentPresenter(context: Context, view: DemoFragmentContract.View):
        BaseFragmentPresenterImpl<DemoFragmentContract.View>(context, view),
        DemoFragmentContract.Presenter {

    override fun handleArgument(bundle: Bundle?) {
        super.handleArgument(bundle)
        val arg = bundle?.getString("ahah")
        println("我接收到了参数ahah：$arg")
    }

    override fun requestDemo(observer: RxObserver<DemoModel>) {
        DemoRepo.requestDemo(observer)
    }

    override fun requestImageList(observer: RxObserver<DemoFragmentModel>) {
        DemoRepo.requestImageList(observer)
    }
}