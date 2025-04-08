package com.harleylizard.livelihood.common.block

import eu.pb4.polymer.blocks.api.PolymerBlockModel
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock
import eu.pb4.polymer.core.api.block.SimplePolymerBlock
import net.minecraft.world.level.block.Block

class LivelihoodBlock(properties: Properties, block: Block, private val model: PolymerBlockModel) : SimplePolymerBlock(properties, block), PolymerTexturedBlock {
}