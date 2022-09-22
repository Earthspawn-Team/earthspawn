package net.earthspawn.mod.world.features.trees;

import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.OptionalInt;

public class TreeConfiguredFeatures {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> HALLOW_TREE =
            FeatureUtils.register("hallow_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(BlockRegister.HALLOW_LOG.get()),
                    new FancyTrunkPlacer(7, 6, 7),
                    BlockStateProvider.simple(BlockRegister.HALLOW_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(5), 3),
                    new TwoLayersFeatureSize(1, 0, 1, OptionalInt.of(4))).build());

    public static final Holder<PlacedFeature> HALLOW_TREE_CHECK = PlacementUtils.register("hallow_tree_check", TreeConfiguredFeatures.HALLOW_TREE,
            PlacementUtils.filteredByBlockSurvival(BlockRegister.HALLOW_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> HALLOW_TREE_SPAWN =
            FeatureUtils.register("hallow_tree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(HALLOW_TREE_CHECK,
                            0.5F)), HALLOW_TREE_CHECK));
}
