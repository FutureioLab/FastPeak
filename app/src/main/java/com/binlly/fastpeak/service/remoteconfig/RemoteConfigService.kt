package com.binlly.fastpeak.service.remoteconfig

import com.binlly.fastpeak.config.AppConfigModel

/**
 * Created by binlly on 17/2/20.
 */
interface RemoteConfigService {
    val config: AppConfigModel?
    val mockRouter: Map<String, Int>

    fun saveConfig(configModel: AppConfigModel)

    fun pullMockConfig(listener: () -> Unit)

    fun getRouter(): Map<String, Int>

    fun isMock(key: String): Boolean
}
