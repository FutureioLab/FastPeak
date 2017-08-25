package com.binlly.fastpeak.business.demo.activity

import dagger.Module
import dagger.Provides


/**
 * Created by yy on 2017/8/24.
 */

@Module
class DemoActivityModule {

    //    @Binds abstract fun provideActivity(activity: DemoActivity): DemoActivity

    //    @Module companion object {
    //    @ActivityScope
    //    @JvmStatic
    @Provides
    fun providePresenter(activity: DemoActivity): DemoPresenter {
        return DemoPresenter(activity, activity)
    }
    //    }
}