package net.earthspawn.mod.world.generation;

import net.earthspawn.mod.world.biomes.BiomeRegister;
import net.earthspawn.mod.world.features.ores.OrePlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class OreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        if (event.getName().equals(BiomeRegister.HALLOW_LANDS.get().getRegistryName())) {
            base.add(OrePlacedFeatures.ASTRAL_ORE_GENERATION);
        }

        base.add(OrePlacedFeatures.TOPAZ_ORE_GENERATION);
    }
}
