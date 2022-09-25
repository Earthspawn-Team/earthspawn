package net.earthspawn.mod.world.generation;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.world.biomes.BiomeRegister;
import net.earthspawn.mod.world.features.trees.TreePlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID)
public class TreeGeneration {

    public static void generateTrees(final BiomeLoadingEvent event) {

        if(event.getName().equals(BiomeRegister.HALLOW_LANDS.get().getRegistryName())) {
            List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(TreePlacedFeatures.HALLOW_TREE);
            base.add(TreePlacedFeatures.LARGE_HALLOW_TREE);
        }
    }
}
