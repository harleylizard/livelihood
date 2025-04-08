@file:Suppress("MemberVisibilityCanBePrivate")

package com.harleylizard.livelihood.common

import com.harleylizard.livelihood.common.Livelihood.Companion.resourceLocation
import com.harleylizard.livelihood.common.block.LivelihoodBlock
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

    val smallGrass = LivelihoodBlock(Blocks.SHORT_GRASS.properties.setId("small_grass".resourceKey), Blocks.SHORT_GRASS, LivelihoodModels.shortGrass)
    val mediumGrass = LivelihoodBlock(Blocks.SHORT_GRASS.properties.setId("medium_grass".resourceKey), Blocks.SHORT_GRASS, LivelihoodModels.mediumGrass)

    fun registerAll() {
        register("small_grass", smallGrass)
        register("medium_grass", mediumGrass)

    }

    private fun register(name: String, block: Block) {
        Registry.register(BuiltInRegistries.BLOCK, name.resourceLocation, block)
    }
}