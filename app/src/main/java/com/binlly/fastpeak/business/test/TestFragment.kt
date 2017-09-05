package com.binlly.fastpeak.business.test

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.binlly.fastpeak.Build
import com.binlly.fastpeak.Build.ENV_DEBUG
import com.binlly.fastpeak.Build.ENV_ONLINE
import com.binlly.fastpeak.BuildConfig
import com.binlly.fastpeak.R
import com.binlly.fastpeak.base.Device
import com.binlly.fastpeak.base.mvp.BaseFragment
import com.binlly.fastpeak.base.net.RetrofitConfig
import com.binlly.fastpeak.business.test.adapter.TestAdapter
import com.binlly.fastpeak.business.test.model.TestModel
import com.binlly.fastpeak.service.Services
import kotlinx.android.synthetic.main.fragment_test.*
import java.util.*

/**
 * 工程模式
 * Created by songshimin on 3/13/17.
 */

class TestFragment: BaseFragment() {
    private lateinit var mAdapter: TestAdapter

    override fun handleArguments(arg: Bundle?) {

    }

    override fun getContentViewId(): Int {
        return R.layout.fragment_test
    }

    override fun initView() {
        mAdapter = TestAdapter(context, null)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = mAdapter

        mAdapter.setNewData(testData)
        setPageSucceed()
    }

    private val testData: List<TestModel>
        get() {
            val datas = ArrayList<TestModel>()
            datas.add(getSection("选择环境"))

            datas.add(getEnvModel(ENV_DEBUG, "测试环境"))
            datas.add(getEnvModel(ENV_ONLINE, "线上环境"))

            datas.add(getSection("版本信息"))
            datas.add(getBuildModel("ApplicationId", BuildConfig.APPLICATION_ID))
            datas.add(getBuildModel("Version", BuildConfig.VERSION_NAME))
            datas.add(getBuildModel("BuildType", BuildConfig.BUILD_TYPE))
            datas.add(getBuildModel("APIV", Device.getAPIV(Services.app)))
            datas.add(getBuildModel("Host", RetrofitConfig.getBaseUrl()))
            datas.add(getBuildModel("IMSI", Device.getIMSI(Services.app)))
            datas.add(getBuildModel("IP", Device.getIpAddress(Services.app)))
            datas.add(getBuildModel("mac", Device.getLocalMacAddress(Services.app)))

            return datas
        }

    private fun getSection(text: String): TestModel {
        val model = TestModel()
        model.section = text
        model.item_type = TestModel.TYPE_SECTION
        return model
    }

    private fun getEnvModel(key: String, value: String): TestModel {
        val env = Build.env
        val model = TestModel()
        val envModel = TestModel.EnvModel(key, value, env == key)
        model.env = envModel
        model.item_type = TestModel.TYPE_ENV
        return model
    }

    private fun getBuildModel(key: String, value: String): TestModel {
        val model = TestModel()
        val buildModel = TestModel.BuildModel(key, value)
        model.valueColor = Color.parseColor("#222222")
        model.build = buildModel
        model.item_type = TestModel.TYPE_BUILD
        return model
    }
}
