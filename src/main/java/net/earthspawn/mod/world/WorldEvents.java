package net.earthspawn.mod.world;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.world.generation.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID)
public class WorldEvents {

    @SubscribeEvent
    static void worldSetup(final BiomeLoadingEvent event) {
        OreGeneration.generateOres(event);
        TreeGeneration.generateTrees(event);
        FlowerGeneration.generateFlowers(event);
        GeodeGeneration.generateGeodes(event);
        EntityNaturalGeneration.onEntitySpawn(event);
    }
}
