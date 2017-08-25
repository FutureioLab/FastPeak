package com.binlly.fastpeak.base.mvp

import android.content.Intent
import android.os.Bundle
import com.binlly.fastpeak.base.widget.LoadingProgressDialog
import dagger.android.support.DaggerAppCompatActivity
import org.greenrobot.eventbus.EventBus


/**
 * Created by yy on 2017/8/23.
 */
abstract class BaseActivity: DaggerAppCompatActivity(), BaseView {

    private val loadingDia: LoadingProgressDialog by lazy { LoadingProgressDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeInject()

        super.onCreate(savedInstanceState)

        //http://stackoverflow.com/questions/6356467/activity-stack-ordering-problem-when-launching-application-from
        // -android-app-inst
        //比如我打开应用到C，正常的启动流程是：A -> B ->C，在C界面按HOME键返回到桌面，如果长按HOME
        //，在最近打开应用列表中重新打开该应用，能够恢复到刚才退出的界面，但如果是点击该应用的桌面图标重新打开该应用，
        //则会显示一下A后再才会进入C，这个问题的解决方案如下

        if (isInstallerLaunchAndNeedFinish()) {
            finish()
            return
        }

        if (!handleIntent(intent)) {
            finish()
            return
        }

        if (isNeedEventBus()) EventBus.getDefault().register(this)

        setContentView(getContentView())

        initView(savedInstanceState)
    }

    open fun handleIntent(intent: Intent): Boolean {
        return true
    }

    /**
     * 在注入之前做一些初始化，比如从intent解析注入依赖的数据
     */
    open fun beforeInject() {

    }

    /**
     * 比如我打开应用到C，正常的启动流程是：A -> B ->C，在C界面按HOME键返回到桌面，如果长按HOME
     * ，在最近打开应用列表中重新打开该应用，能够恢复到刚才退出的界面，但如果是点击该应用的桌面图标重新打开该应用，
     * 则会显示一下A后再才会进入C，这个问题的解决方案如下
     *
     * @return
     */
    open fun isInstallerLaunchAndNeedFinish(): Boolean {
        return false
    }

    /**
     * 是否需要注册EventBus
     *
     * @return
     */
    open fun isNeedEventBus(): Boolean {
        return false
    }

    override fun onDestroy() {
        loadingDia.dismiss()
        if (isNeedEventBus()) EventBus.getDefault().unregister(this)
        super.onDestroy()
    }

    abstract fun getContentView(): Int

    /**
     * 初始化数据
     * 根据数据设置view内容
     */
    abstract fun initView(savedInstanceState: Bundle?)

    override fun showLoading(info: String?) {
        if (loadingDia.isShowing) return
        loadingDia.setTextInfo(info)
        loadingDia.setCancelable(true)
        loadingDia.setCanceledOnTouchOutside(false)
        loadingDia.show()
    }

    override fun hideLoading() {
        if (isFinishing) return
        if (loadingDia.isShowing) loadingDia.hide()
    }

    override fun showLoading() {
        showLoading(null)
    }
}