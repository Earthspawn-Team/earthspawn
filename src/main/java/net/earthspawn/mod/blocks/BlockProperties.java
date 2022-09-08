package net.earthspawn.mod.blocks;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
}