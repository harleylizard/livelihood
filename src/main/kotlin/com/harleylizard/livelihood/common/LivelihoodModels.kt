package com.harleylizard.livelihood.common

import eu.pb4.polymer.blocks.api.BlockModelType

object LivelihoodModels {
    val smallGrass = Model.modelOf("block/small_grass", BlockModelType.BIOME_PLANT_BLOCK)
    val mediumGrass = Model.modelOf("block/medium_grass", BlockModelType.BIOME_PLANT_BLOCK)
    val weeds = Model.modelOf("block/weeds", BlockModelType.BIOME_PLANT_BLOCK)
    val peat = Model.modelOf("block/peat", BlockModelType.FULL_BLOCK)
    val giantFlowerStem = Model.modelOf("block/giant_flower_stem", BlockModelType.FULL_BLOCK)

}