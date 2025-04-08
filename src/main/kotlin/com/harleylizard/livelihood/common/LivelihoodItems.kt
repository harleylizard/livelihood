@file:Suppress("MemberVisibilityCanBePrivate")

package com.harleylizard.livelihood.common

import com.harleylizard.livelihood.common.Livelihood.Companion.resourceLocation
import eu.pb4.polymer.core.api.item.PolymerBlockItem
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.level.block.Block

object LivelihoodItems {
    private val String.resourceKey get() = ResourceKey.create(Registries.ITEM, resourceLocation)

    val smallGrass = LivelihoodBlocks.smallGrass.blockItemOf(Properties().setId("small_grass".resourceKey))
    val mediumGrass = LivelihoodBlocks.mediumGrass.blockItemOf(Properties().setId("medium_grass".resourceKey))
    val weeds = LivelihoodBlocks.weeds.blockItemOf(Properties().setId("weeds".resourceKey))

    fun registerAll() {
        register("small_grass", smallGrass)
        register("medium_grass", mediumGrass)
        register("weeds", weeds)

    }

    private fun register(name: String, item: Item) {
        Registry.register(BuiltInRegistries.ITEM, name.resourceLocation, item)
    }

    private fun Block.blockItemOf(properties: Properties) = PolymerBlockItem(this, properties)
}