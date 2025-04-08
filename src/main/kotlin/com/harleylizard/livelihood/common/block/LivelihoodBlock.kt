package com.harleylizard.livelihood.common.block

import com.harleylizard.livelihood.common.Model
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock
import eu.pb4.polymer.core.api.block.SimplePolymerBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import xyz.nucleoid.packettweaker.PacketContext

class LivelihoodBlock(properties: Properties, block: Block, model: Model) : SimplePolymerBlock(properties, block), PolymerTexturedBlock {
    private val blockState = model.blockState

    override fun getPolymerBlockState(state: BlockState?, context: PacketContext?): BlockState {
        return blockState ?: super.getPolymerBlockState(state, context)
    }
}