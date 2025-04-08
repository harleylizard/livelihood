@file:Suppress("MemberVisibilityCanBePrivate")

package com.harleylizard.livelihood.common

import com.harleylizard.livelihood.common.Livelihood.Companion.resourceLocation
import com.harleylizard.livelihood.common.block.LivelihoodBlock
import com.harleylizard.livelihood.common.block.PlantBlock
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour.Properties

object LivelihoodBlocks {
    private val String.resourceKey get() = ResourceKey.create(Registries.BLOCK, resourceLocation)

    private val Block.properties get() = Properties.ofFullCopy(this)

    val smallGrass = PlantBlock(Blocks.SHORT_GRASS.properties.setId("small_grass".resourceKey), LivelihoodModels.smallGrass)
    val mediumGrass = PlantBlock(Blocks.SHORT_GRASS.properties.setId("medium_grass".resourceKey), LivelihoodModels.mediumGrass)
    val weeds = PlantBlock(Blocks.SHORT_GRASS.properties.setId("weeds".resourceKey), LivelihoodModels.weeds)
    val peat = LivelihoodBlock(Blocks.DIRT.properties.setId("peat".resourceKey), Blocks.DIRT, LivelihoodModels.peat)
    val giantFlowerStem = LivelihoodBlock(Blocks.WHITE_WOOL.properties.setId("giant_flower_stem".resourceKey), Blocks.WHITE_WOOL, LivelihoodModels.giantFlowerStem)

    fun registerAll() {
        register("small_grass", smallGrass)
        register("medium_grass", mediumGrass)
        register("weeds", weeds)
        register("peat", peat)
        register("giant_flower_stem", giantFlowerStem)

    }

    private fun register(name: String, block: Block) {
        Registry.register(BuiltInRegistries.BLOCK, name.resourceLocation, block)
    }
}