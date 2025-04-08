package com.harleylizard.livelihood.common

import com.harleylizard.livelihood.common.Livelihood.Companion.resourceLocation
import eu.pb4.polymer.blocks.api.BlockModelType
import eu.pb4.polymer.blocks.api.PolymerBlockModel
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils

class Model private constructor(private val type: BlockModelType, private val model: PolymerBlockModel) {
    val blockState get() = PolymerBlockResourceUtils.requestBlock(type, model)

    companion object {

        fun modelOf(name: String, type: BlockModelType) = Model(type, PolymerBlockModel.of(name.resourceLocation))
    }
}