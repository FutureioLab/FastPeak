package com.binlly.fastpeak.di

import com.binlly.fastpeak.business.demo.activity.DemoActivity
import com.binlly.fastpeak.business.demo.fragment.DemoFragment
import com.binlly.fastpeak.business.demo.fragment.DemoFragmentActivity
import com.binlly.fastpeak.business.web.WebListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by yy on 2017/8/24.
 */
@Module abstract class AllModules {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(
            PresenterModules::class)) abstract fun contributeDemoActivityInjector(): DemoActivity

    @ActivityScope
    @ContributesAndroidInjector() abstract fun contributeDemoFragmentActivityInjector(): DemoFragmentActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(
            PresenterModules::class)) abstract fun contributeDemoFragmentInjector(): DemoFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(
            PresenterModules::class)) abstract fun contributeWebListActivityInjector(): WebListActivity
}