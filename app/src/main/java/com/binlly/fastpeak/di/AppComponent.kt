package com.binlly.fastpeak.di

import com.binlly.fastpeak.app.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by yy on 2017/8/24.
 * Application 依赖注入器
 */
@Singleton
@Component(modules = arrayOf(AllModules::class, AndroidSupportInjectionModule::class))
interface AppComponent: AndroidInjector<App> {
    @Component.Builder abstract class Builder: AndroidInjector.Builder<App>()
}