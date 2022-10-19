package net.earthspawn.mod.world.generation;

import net.earthspawn.mod.world.biomes.BiomeRegister;
import net.earthspawn.mod.world.features.trees.TreePlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class TreeGeneration {

    public static void generateTrees(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

        if(event.getName().equals(BiomeRegister.HALLOW_LANDS.get().getRegistryName())) {
            base.add(TreePlacedFeatures.HALLOW_TREE);
            base.add(TreePlacedFeatures.LARGE_HALLOW_TREE);
            base.add(TreePlacedFeatures.HUGE_GREEN_MUSHROOM);
        }
    }
}
