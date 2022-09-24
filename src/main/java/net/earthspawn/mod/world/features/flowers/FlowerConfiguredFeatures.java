package net.earthspawn.mod.world.features.flowers;

import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class FlowerConfiguredFeatures {

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> GLADIOLUS =
            FeatureUtils.register("gladiolus_configured", Feature.FLOWER,
                    new RandomPatchConfiguration(100, 6, 6, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockRegister.GLADIOLUS.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> HALLOW_ROOTS =
            FeatureUtils.register("hallow_roots_configured", Feature.FLOWER,
                    new RandomPatchConfiguration(100, 6, 6, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockRegister.HALLOW_ROOTS.get())))));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> AMARYLLIS =
            FeatureUtils.register("amaryllis_configured", Feature.FLOWER,
                    new RandomPatchConfiguration(100, 4, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                            new SimpleBlockConfiguration(BlockStateProvider.simple(BlockRegister.AMARYLLIS.get())))));
}
