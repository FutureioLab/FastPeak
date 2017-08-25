package com.binlly.fastpeak.business.demo.fragment

import dagger.Module
import dagger.Provides

/**
 * Created by yy on 2017/8/24.
 */

@Module
class DemoFragmentActivityModule {

    @Provides
    fun provideFragment(): DemoFragment {
        return DemoFragment()
    }
}