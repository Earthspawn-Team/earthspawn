package net.earthspawn.mod.particles;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

public class ParticleOptionsGenerator {

    public ParticleOptions generate(ParticleType<?> particleType, String toString) {
        return new ParticleOptions() {
            @Override
            public @NotNull ParticleType<?> getType() {
                return particleType;
            }

            @Override
            public void writeToNetwork(@NotNull FriendlyByteBuf p_123732_) {

            }

            @Override
            public @NotNull String writeToString() {
                return toString;
            }
        };
    }
}
