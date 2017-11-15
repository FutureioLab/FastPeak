package com.binlly.gankee.di

import com.binlly.gankee.business.demo.activity.DemoActivity
import com.binlly.gankee.business.demo.fragment.DemoFragment
import com.binlly.gankee.business.demo.fragment.DemoFragmentActivity
import com.binlly.gankee.business.girl.GirlFragment
import com.binlly.gankee.business.home.HomeFragment
import com.binlly.gankee.business.web.WebListActivity
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

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(
            PresenterModules::class)) abstract fun contributeHomeFragmentInjector(): HomeFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(
            PresenterModules::class)) abstract fun contributeGirlFragmentInjector(): GirlFragment
}