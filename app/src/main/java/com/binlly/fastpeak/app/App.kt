package com.binlly.fastpeak.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import com.binlly.fastpeak.BuildConfig
import com.binlly.fastpeak.base.logger.LogLevel
import com.binlly.fastpeak.base.logger.logLevel
import com.binlly.fastpeak.base.logger.logable
import com.binlly.fastpeak.di.DaggerAppComponent
import com.binlly.fastpeak.service.Services
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * Created by yy on 2017/8/23.
 */
class App: Application(),
        HasActivityInjector,
        HasSupportFragmentInjector,
        Application.ActivityLifecycleCallbacks {

    @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    @Inject lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().create(this).inject(this)
        app = this
        Services.app = app
        initLogger()
    }

    private fun initLogger() {
        logable = BuildConfig.DEBUG
        logLevel = LogLevel.DEBUG
    }

    companion object {
        lateinit var app: App
            private set
        var mIsAppForeground: Boolean = false
    }

    override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityStarted(p0: Activity?) {
    }

    override fun onActivityResumed(p0: Activity?) {
        mIsAppForeground = true
    }

    override fun onActivityPaused(p0: Activity?) {
        mIsAppForeground = false
    }

    override fun onActivityStopped(p0: Activity?) {
    }

    override fun onActivityDestroyed(p0: Activity?) {
    }

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
    }
}