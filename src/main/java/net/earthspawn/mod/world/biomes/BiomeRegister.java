package net.earthspawn.mod.world.biomes;

import net.earthspawn.mod.Earthspawn;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeRegister {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Earthspawn.MOD_ID);

    public static void registerSetup(IEventBus bus) {
        BIOMES.register(bus);
    }

    public static final RegistryObject<Biome> HALLOW_LANDS = BIOMES.register("hallow_lands", OverworldBiomes::hallowLands);
}
