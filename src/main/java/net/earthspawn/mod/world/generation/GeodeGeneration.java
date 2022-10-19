package net.earthspawn.mod.world.generation;

import net.earthspawn.mod.world.biomes.BiomeRegister;
import net.earthspawn.mod.world.features.geodes.GeodePlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class GeodeGeneration {

    public static void generateGeodes(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        if(event.getName().equals(BiomeRegister.HALLOW_LANDS.get().getRegistryName())) {
            base.add(GeodePlacedFeatures.CRYSTAL_ROOM);
        }
    }
}
