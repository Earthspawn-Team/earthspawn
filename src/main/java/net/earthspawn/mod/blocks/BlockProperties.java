package net.earthspawn.mod.blocks;

import net.earthspawn.mod.blocks.classes.LightSurviveMushroomBlock;
import net.earthspawn.mod.blocks.classes.OreParticleBlock;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BlockProperties {

    public static Block getBlockProperties(Block block) {
        return new Block(BlockBehaviour.Properties.copy(block));
    }

    public static FlowerBlock setFlowerBlockProperties(Block block, MaterialColor materialColor, int lightLevel, boolean isEmissiveRendering) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(block);
        properties.color(materialColor);
        properties.lightLevel(value -> lightLevel);
        properties.emissiveRendering((p_61036_, p_61037_, p_61038_) -> isEmissiveRendering);
        return new FlowerBlock(MobEffects.GLOWING, 0, properties);
    }

    public static LightSurviveMushroomBlock setMushroomBlockProperties(Block block, MaterialColor materialColor, int lightLevel, boolean isEmissiveRendering, Holder<ConfiguredFeature<HugeMushroomFeatureConfiguration, ?>> hugeMushroom) {
        BlockBehaviour.Properties properties = BlockBehaviour.Properties.copy(block);
        properties.color(materialColor);
        properties.lightLevel(value -> lightLevel);
        properties.emissiveRendering((p_61036_, p_61037_, p_61038_) -> isEmissiveRendering);
        return new LightSurviveMushroomBlock(properties, () -> hugeMushroom);
    }

    public static OreParticleBlock setOreBlockProperties(Material material, float strength, SoundType soundType, ParticleOptions particleOptions) {
        return new OreParticleBlock(BlockBehaviour.Properties.of(material)
                .strength(strength)
                .sound(soundType)
                .requiresCorrectToolForDrops(), particleOptions, UniformInt.of(3, 7));
    }
}