package com.harleylizard.livelihood.common

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils
import net.fabricmc.api.ModInitializer
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation

class Livelihood : ModInitializer {

    override fun onInitialize() {
        PolymerResourcePackUtils.markAsRequired()
        PolymerResourcePackUtils.addModAssets(MOD_ID)

        LivelihoodBlocks.registerAll()
        LivelihoodItems.registerAll()

        PolymerItemGroupUtils
            .builder()
            .icon(LivelihoodItems.smallGrass::getDefaultInstance)
            .title(Component.translatable("itemGroup.livelihood"))
            .displayItems { itemDisplayParameters, output ->
                output.accept(LivelihoodItems.smallGrass)
                output.accept(LivelihoodItems.mediumGrass)
                output.accept(LivelihoodItems.weeds)

            }
            .build()
            .let {
                PolymerItemGroupUtils.registerPolymerItemGroup("livelihood".resourceLocation, it)
            }

    }

    companion object {
        private const val MOD_ID = "livelihood"

        val String.resourceLocation get() = ResourceLocation.fromNamespaceAndPath(MOD_ID, this)

    }
}