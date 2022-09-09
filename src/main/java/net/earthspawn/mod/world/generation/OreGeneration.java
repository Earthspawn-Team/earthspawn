package net.earthspawn.mod.world.generation;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.world.features.ores.OrePlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID)
public class OreGeneration {

    @SubscribeEvent
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(OrePlacedFeatures.TOPAZ_ORE_GENERATION);
    }
}
