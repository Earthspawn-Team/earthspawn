package net.earthspawn.mod.world.features.ores;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class OrePlacedFeatures {

    private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }

    public static final Holder<PlacedFeature> TOPAZ_ORE_GENERATION = PlacementUtils.register("topaz_ore_placed",
            OreConfiguredFeatures.TOPAZ_ORE_GENERATION, commonOrePlacement(2, HeightRangePlacement.triangle(
                            VerticalAnchor.aboveBottom(-80),
                            VerticalAnchor.aboveBottom(80))));

    public static final Holder<PlacedFeature> ASTRAL_ORE_GENERATION = PlacementUtils.register("astral_ore_placed",
            OreConfiguredFeatures.ASTRAL_ORE_GENERATION, commonOrePlacement(3, HeightRangePlacement.triangle(
                    VerticalAnchor.aboveBottom(-80),
                    VerticalAnchor.aboveBottom(80))));
}
