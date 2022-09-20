package net.earthspawn.mod.world.generation;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.world.biomes.BiomeRegister;
import net.earthspawn.mod.world.features.flowers.FlowerPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID)
public class FlowerGeneration {

    public static void generateFlowers(final BiomeLoadingEvent event) {

        if(event.getName().equals(BiomeRegister.HALLOW_PLAINS.get().getRegistryName())) {
            List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(FlowerPlacedFeatures.GLADIOLUS);
            base.add(FlowerPlacedFeatures.HALLOW_ROOTS);
            base.add(FlowerPlacedFeatures.AMARYLLIS);
        }
    }

    @SubscribeEvent
    static void biomeSetup(final BiomeLoadingEvent event) {
        FlowerGeneration.generateFlowers(event);
    }
}
