package com.binlly.fastpeak.base.mvp

import android.content.Intent
import android.os.Bundle
import javax.inject.Inject


/**
 * Created by yy on 2017/8/24.
 */
abstract class BaseMvpActivity<P: BaseActivityPresenter>: BaseActivity(), BaseMvpView<P> {

    @Inject lateinit var P: P

    override fun P(): P {
        return P
    }

    override fun handleIntent(intent: Intent): Boolean {
        return P.handleIntent(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        P.onCreate()
    }

    override fun onResume() {
        super.onResume()
        P.onResume()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        P.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(inState: Bundle) {
        super.onRestoreInstanceState(inState)
        P.onSaveInstanceState(inState)
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