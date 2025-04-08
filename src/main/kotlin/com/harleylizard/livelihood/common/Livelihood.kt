package com.harleylizard.livelihood.common

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils
import net.fabricmc.api.ModInitializer
import net.minecraft.resources.ResourceLocation

class Livelihood : ModInitializer {

    override fun onInitialize() {
        PolymerResourcePackUtils.markAsRequired()
        PolymerResourcePackUtils.addModAssets(MOD_ID)

    }

    companion object {
        private const val MOD_ID = "livelihood"

        val String.resourceLocation get() = ResourceLocation.fromNamespaceAndPath(MOD_ID, this)

    }
}