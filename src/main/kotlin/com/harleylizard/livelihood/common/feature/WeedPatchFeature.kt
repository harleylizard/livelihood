package com.harleylizard.livelihood.common.feature

import com.harleylizard.livelihood.common.Livelihood
import com.harleylizard.livelihood.common.LivelihoodBlocks
import net.minecraft.util.RandomSource
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
import kotlin.math.ceil

class WeedPatchFeature : Feature<NoneFeatureConfiguration>(NoneFeatureConfiguration.CODEC) {
    private val weedBlocks = listOf(
        arrayOf(Blocks.SHORT_GRASS),
        arrayOf(Blocks.SHORT_GRASS, LivelihoodBlocks.weeds, ),
        arrayOf(LivelihoodBlocks.mediumGrass, LivelihoodBlocks.smallGrass),
        arrayOf(LivelihoodBlocks.smallGrass)
    )

    private fun <T> Array<T>.random(random: RandomSource) = this[random.nextInt(size)]

    override fun place(context: FeaturePlaceContext<NoneFeatureConfiguration>): Boolean {
        val blockPos = context.origin()
        val level = context.level()
        val random = context.random()

        val r = 4
        for (i in -r .. r) {
            for (j in -r .. r) {
                for (k in -r .. r) {
                    val offset = blockPos.offset(i, j, k)

                    val size = weedBlocks.size
                    val distance = ceil(offset.distManhattan(blockPos).toDouble() / size.toDouble()).toInt().coerceAtMost(size - 1)

                    if (random.nextBoolean()) {
                        val blocks = weedBlocks[distance]
                        Livelihood.set(level, offset, blocks.random(random).defaultBlockState())
                    }
                }
            }
        }
        return true
    }
}