package net.earthspawn.mod.particles;

import net.earthspawn.mod.Earthspawn;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ParticleRegister {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Earthspawn.MOD_ID);

    public static void registerSetup(IEventBus bus) {
        PARTICLE_TYPES.register(bus);
    }

    public static final RegistryObject<SimpleParticleType> HALLOW_BIOME_AMBIENT_PARTICLES = PARTICLE_TYPES.register("hallow_ambient_particles", () -> new SimpleParticleType(true));
}
