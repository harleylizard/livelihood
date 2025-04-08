package com.harleylizard.livelihood.common

import com.harleylizard.livelihood.common.Livelihood.Companion.resourceLocation
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey

class LivelihoodBiomes {
    private val String.resourceKey get() = ResourceKey.create(Registries.BIOME, resourceLocation)

    val giantFlowers = "giant_flowers".resourceKey

}