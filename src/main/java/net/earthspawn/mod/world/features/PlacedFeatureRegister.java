package net.earthspawn.mod.world.features;

import net.earthspawn.mod.Earthspawn;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class PlacedFeatureRegister {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Earthspawn.MOD_ID);

    private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }

    public static final RegistryObject<PlacedFeature> TOPAZ_ORE_GENERATION = PLACED_FEATURES.register("topaz.generation.ore",
            () -> new PlacedFeature(FeatureRegister.TOPAZ_ORE_GENERATION.getHolder().get(),
                    commonOrePlacement(3, HeightRangePlacement.triangle(
                            VerticalAnchor.absolute(10),
                            VerticalAnchor.aboveBottom(6)))));
}
