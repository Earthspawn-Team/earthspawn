package net.earthspawn.mod.world.features.trees.grower;

import net.earthspawn.mod.world.features.trees.TreeConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class HallowTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean b) {
        if (random.nextInt(2) == 0) {
            return TreeConfiguredFeatures.LARGE_HALLOW_TREE;
        } else {
            return TreeConfiguredFeatures.HALLOW_TREE;
        }
    }
}
