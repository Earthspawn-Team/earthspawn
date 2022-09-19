package net.earthspawn.mod.world.features.flowers;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class FlowerPlacedFeatures {

    public static final Holder<PlacedFeature> GLADIOLUS = PlacementUtils.register("gladiolus_placed",
            FlowerConfiguredFeatures.GLADIOLUS, RarityFilter.onAverageOnceEvery(18),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> HALLOW_ROOTS = PlacementUtils.register("hallow_roots_placed",
            FlowerConfiguredFeatures.HALLOW_ROOTS, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

    public static final Holder<PlacedFeature> AMARYLLIS = PlacementUtils.register("amaryllis_placed",
            FlowerConfiguredFeatures.AMARYLLIS, RarityFilter.onAverageOnceEvery(18),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
}
