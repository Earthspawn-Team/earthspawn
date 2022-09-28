package net.earthspawn.mod.world.features.ores;

import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class OreConfiguredFeatures {

    private static final List<OreConfiguration.TargetBlockState> TOPAZ_ORE_OVERWORLD_REPLACEMENT = List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockRegister.TOPAZ_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TOPAZ_ORE_GENERATION = FeatureUtils.register("topaz_ore_configured",
            Feature.ORE, new OreConfiguration(TOPAZ_ORE_OVERWORLD_REPLACEMENT, 5));

    private static final List<OreConfiguration.TargetBlockState> ASTRAL_ORE_OVERWORLD_REPLACEMENT = List.of(
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockRegister.ASTRAL_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ASTRAL_ORE_GENERATION = FeatureUtils.register("astral_ore_configured",
            Feature.ORE, new OreConfiguration(ASTRAL_ORE_OVERWORLD_REPLACEMENT, 4));


}
