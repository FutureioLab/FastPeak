package com.binlly.fastpeak.service.remoteconfig

import com.binlly.fastpeak.config.AppConfigModel


/**
 * Created by binlly on 16/8/18.
 * 拉取的远程通用配置的解析并提供相关服务
 */
class RemoteConfigServiceImpl private constructor(): RemoteConfigService {

    override var config: AppConfigModel? = null

    override fun saveConfig(configModel: AppConfigModel) {
        config = configModel
    }

    companion object {
        private var INSTANCE: RemoteConfigServiceImpl? = null

        fun registerInstance(): RemoteConfigServiceImpl {
            return INSTANCE?.let { INSTANCE } ?: RemoteConfigServiceImpl()
        }
    }
}
