package com.binlly.gankee.di

import com.binlly.gankee.business.demo.activity.DemoActivity
import com.binlly.gankee.business.demo.activity.DemoPresenter
import com.binlly.gankee.business.demo.fragment.DemoFragment
import com.binlly.gankee.business.demo.fragment.DemoFragmentPresenter
import com.binlly.gankee.business.web.WebListActivity
import com.binlly.gankee.business.web.WebListPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by yy on 2017/8/24.
 */

@Module
class PresenterModules {

    //    @Binds abstract fun provideActivity(activity: DemoActivity): DemoActivity

    //    @Module companion object {
    //    @ActivityScope
    //    @JvmStatic
    //    }

    @Provides
    fun provideDemoPresenter(activity: DemoActivity): DemoPresenter {
        return DemoPresenter(activity, activity)
    }

    @Provides
    fun provideDemoFragmentPresenter(fragment: DemoFragment): DemoFragmentPresenter {
        return DemoFragmentPresenter(fragment.context, fragment)
    }

    @Provides
    fun provideWebListPresenter(activity: WebListActivity): WebListPresenter {
        return WebListPresenter(activity, activity)
    }
}