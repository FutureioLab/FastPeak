package com.binlly.fastpeak.service.remoteconfig

import com.binlly.fastpeak.config.AppConfigModel

/**
 * Created by binlly on 17/2/20.
 */
interface RemoteConfigService {
    val config: AppConfigModel?

    fun saveConfig(configModel: AppConfigModel)
}
