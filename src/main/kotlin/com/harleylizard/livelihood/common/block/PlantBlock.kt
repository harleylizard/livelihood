package com.harleylizard.livelihood.common.block

import com.harleylizard.livelihood.common.Model
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.tags.BlockTags
import net.minecraft.util.RandomSource
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.ScheduledTickAccess
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import xyz.nucleoid.packettweaker.PacketContext

class PlantBlock(properties: Properties, model: Model) : Block(properties), PolymerTexturedBlock {
    private val blockState = model.blockState

    override fun canSurvive(blockState: BlockState, levelReader: LevelReader, blockPos: BlockPos): Boolean {
        return blockPos.below().let(levelReader::getBlockState).let {
            it.`is`(BlockTags.DIRT) || it.`is`(Blocks.FARMLAND)
        }
    }

    override fun updateShape(blockState: BlockState, levelReader: LevelReader, scheduledTickAccess: ScheduledTickAccess, blockPos: BlockPos, direction: Direction, blockPos2: BlockPos, blockState2: BlockState, randomSource: RandomSource): BlockState {
        return Blocks.AIR.defaultBlockState().takeUnless { canSurvive(blockState, levelReader, blockPos) } ?: super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource)
    }

    override fun getPolymerBlockState(p0: BlockState?, p1: PacketContext?): BlockState {
        return blockState ?: Blocks.SHORT_GRASS.defaultBlockState()
    }
}