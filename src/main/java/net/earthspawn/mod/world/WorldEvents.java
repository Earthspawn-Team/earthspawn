package net.earthspawn.mod.world;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.world.generation.EntityNaturalGeneration;
import net.earthspawn.mod.world.generation.FlowerGeneration;
import net.earthspawn.mod.world.generation.OreGeneration;
import net.earthspawn.mod.world.generation.TreeGeneration;
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
        EntityNaturalGeneration.onEntitySpawn(event);
    }

}
