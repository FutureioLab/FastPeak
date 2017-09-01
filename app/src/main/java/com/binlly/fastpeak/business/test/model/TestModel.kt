package com.binlly.fastpeak.business.test.model

import com.chad.library.adapter.base.entity.MultiItemEntity

import java.io.Serializable

class TestModel: MultiItemEntity, Serializable {
    var item_type: Int = 0

    val isSectionType: Boolean
        get() = item_type == TYPE_SECTION

    val isEnvType: Boolean
        get() = item_type == TYPE_ENV

    val isBuildType: Boolean
        get() = item_type == TYPE_BUILD


    override fun getItemType(): Int {
        return item_type
    }

    lateinit var section: String
    lateinit var env: EnvModel
    lateinit var build: BuildModel

    var valueColor: Int = 0

    data class EnvModel(var key: String, var value: String, var isSelected: Boolean = false)

    data class BuildModel(var key: String, var value: String)

    companion object {
        private const val serialVersionUID = -4241242337755076267L

        val TYPE_SECTION = 0
        val TYPE_ENV = 1
        val TYPE_BUILD = 2
    }
}