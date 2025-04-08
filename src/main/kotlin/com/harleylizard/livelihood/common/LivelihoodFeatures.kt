package com.harleylizard.livelihood.common

import com.harleylizard.livelihood.common.Livelihood.Companion.resourceLocation
import com.harleylizard.livelihood.common.feature.WeedPatchFeature
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration

object LivelihoodFeatures {
    val weedPatch = WeedPatchFeature()

    fun registerAll() {
        register("weed_patch", weedPatch)
    }

    private fun register(name: String, feature: Feature<out FeatureConfiguration>) {
        Registry.register(BuiltInRegistries.FEATURE, name.resourceLocation, feature)
    }
}