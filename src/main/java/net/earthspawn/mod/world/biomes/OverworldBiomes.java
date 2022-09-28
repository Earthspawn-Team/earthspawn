package net.earthspawn.mod.world.biomes;

import net.earthspawn.mod.particles.ParticleRegister;
import net.earthspawn.mod.sounds.SoundRegister;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.*;

import javax.annotation.Nullable;

public class OverworldBiomes {

    @Nullable
    private static final Music NORMAL_MUSIC = null;

    protected static int calculateSkyColor(float color)
    {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(Biome.Precipitation precipitation, Biome.BiomeCategory biomeCategory, float temperature, float downfall, int grassColor, int waterColor, int fogColor, AmbientParticleSettings ambientParticleSettings, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music)
    {
        return (new Biome.BiomeBuilder()).precipitation(precipitation).biomeCategory(biomeCategory).temperature(temperature).downfall(downfall).specialEffects((new BiomeSpecialEffects.Builder()).grassColorOverride(grassColor).waterColor(waterColor).waterFogColor(waterColor).fogColor(fogColor).ambientParticle(ambientParticleSettings).skyColor(calculateSkyColor(fogColor)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder)
    {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }

    //biomes
    public static Biome hallowLands() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);

        return biome(Biome.Precipitation.RAIN, Biome.BiomeCategory.PLAINS, 1F, 1F, 58853, 12198353, 58853, new AmbientParticleSettings(ParticleRegister.HALLOW_BIOME_AMBIENT_PARTICLES.get(), 0.006F), spawnBuilder, biomeBuilder, Musics.createGameMusic(SoundRegister.HALLOW_BIOME_MUSIC.get()));
    }
}
