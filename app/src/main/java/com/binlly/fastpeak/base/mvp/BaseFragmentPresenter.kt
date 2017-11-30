package com.binlly.fastpeak.base.mvp

import android.os.Bundle

interface BaseFragmentPresenter: BasePresenter {

    fun handleArgument(bundle: Bundle?)

    fun onCreate(inState: Bundle?)

    fun onResume()

    fun onSaveInstanceState(outState: Bundle?)

    fun setUserVisibleHint(isVisibleToUser: Boolean)

    fun onPause()

    fun onDestroy()
}
