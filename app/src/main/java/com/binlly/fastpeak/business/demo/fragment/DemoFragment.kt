package com.binlly.fastpeak.business.demo.fragment

import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.mvp.BaseMvpFragment
import com.binlly.fastpeak.base.rx.RxObserver
import com.binlly.fastpeak.business.demo.model.DemoModel
import kotlinx.android.synthetic.main.fragment_demo.*
import org.jetbrains.anko.toast

/**
 * Created by yy on 2017/8/25.
 */
class DemoFragment: BaseMvpFragment<DemoFragmentPresenter>(), DemoFragmentContract.View {

    override fun getContentViewId(): Int {
        return R.layout.fragment_demo
    }

    override fun initView() {
        setPageEmpty()

        button.setOnClickListener {
            refresh()
        }

        refresh()
    }

    private fun refresh() {
        setPageLoading()
        P.requestDemo(object: RxObserver<DemoModel>() {
            override fun onNext(model: DemoModel) {
                setPageSucceed()
                context.toast(model.toString())
            }

            override fun onError(e: Throwable) {
                super.onError(e)
                setPageError()
                e.message ?: return
                context.toast(e.message.toString())
            }

            override fun onComplete() {
                super.onComplete()
                context.toast("onComplete")
            }
        })
    }

    override fun onReload() {
        super.onReload()
        context.toast("reload")
        refresh()
    }
}