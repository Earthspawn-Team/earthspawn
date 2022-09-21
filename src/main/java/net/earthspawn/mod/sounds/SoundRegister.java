package net.earthspawn.mod.sounds;

import net.earthspawn.mod.Earthspawn;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegister {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Earthspawn.MOD_ID);

    public static void registerSetup(IEventBus bus) {
        SOUND_EVENTS.register(bus);
    }

    public static RegistryObject<SoundEvent> HALLOW_BIOME_MUSIC = SOUND_EVENTS.register("hallow_biome_music", () -> new SoundEvent(new ResourceLocation(Earthspawn.MOD_ID, "hallow_biome_music")));
}
