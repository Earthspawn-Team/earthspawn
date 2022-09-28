package net.earthspawn.mod.world.features.trees;

import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
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

    //tree configuration
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> HALLOW_TREE =
            FeatureUtils.register("hallow_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(BlockRegister.HALLOW_LOG.get()),
                    new FancyTrunkPlacer(4, 2, 4),
                    BlockStateProvider.simple(BlockRegister.HALLOW_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 3),
                    new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(2))).build());

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> LARGE_HALLOW_TREE =
            FeatureUtils.register("large_hallow_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(BlockRegister.HALLOW_LOG.get()),
                    new FancyTrunkPlacer(8, 6, 8),
                    BlockStateProvider.simple(BlockRegister.HALLOW_LEAVES.get()),
                    new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4),
                    new TwoLayersFeatureSize(1, 0, 1, OptionalInt.of(4))).build());

    public static final Holder<ConfiguredFeature<HugeMushroomFeatureConfiguration, ?>> HUGE_GREEN_MUSHROOM =
            FeatureUtils.register("huge_green_mushroom", Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfiguration(
                    BlockStateProvider.simple(BlockRegister.GREEN_MUSHROOM_BLOCK.get().defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                    BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.FALSE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)), 1));

    //trees placement check
    public static final Holder<PlacedFeature> HALLOW_TREE_CHECK = PlacementUtils.register("hallow_tree_check", TreeConfiguredFeatures.HALLOW_TREE,
            PlacementUtils.filteredByBlockSurvival(BlockRegister.HALLOW_SAPLING.get()));

    public static final Holder<PlacedFeature> LARGE_HALLOW_TREE_CHECK = PlacementUtils.register("large_hallow_tree_check", TreeConfiguredFeatures.LARGE_HALLOW_TREE,
            PlacementUtils.filteredByBlockSurvival(BlockRegister.HALLOW_SAPLING.get()));

    //trees spawn
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> HALLOW_TREE_SPAWN =
            FeatureUtils.register("hallow_tree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(
                            new WeightedPlacedFeature(HALLOW_TREE_CHECK, 1f)),
                            HALLOW_TREE_CHECK));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LARGE_HALLOW_TREE_SPAWN =
            FeatureUtils.register("large_hallow_tree_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(
                            new WeightedPlacedFeature(LARGE_HALLOW_TREE_CHECK, 1f)),
                            HALLOW_TREE_CHECK));
}
