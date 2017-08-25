package com.binlly.fastpeak.base.mvp

import android.os.Bundle
import javax.inject.Inject

/**
 * Created by yy on 2017/8/25.
 */
abstract class BaseMvpFragment<P: BaseFragmentPresenter>: BaseFragment(), BaseMvpView<P> {

    @Inject lateinit var P: P

    override fun P(): P {
        return P
    }

    override fun handleArguments(arg: Bundle?) {
        P.handleArgument(arg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        P.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        P.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        P.onSaveInstanceState(outState)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        P.setUserVisibleHint(isVisibleToUser)
    }

    override fun onPause() {
        super.onPause()
        P.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        P.onDestroy()
    }
}