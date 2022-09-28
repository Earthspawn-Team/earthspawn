package net.earthspawn.mod.blocks.classes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class OreParticleBlock extends OreBlock {

    private final ParticleOptions particleOptions;
    private final UniformInt xpRange;

    public OreParticleBlock(Properties p_55140_, ParticleOptions particleOptions, UniformInt xpRange) {
        super(p_55140_);
        this.particleOptions = particleOptions;
        this.xpRange = xpRange;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, Random random) {
        if (particleOptions != null)
            level.addParticle(particleOptions, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5,
                0.5, 0.5, 0.5);
        super.animateTick(blockState, level, blockPos, random);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.xpRange.sample(RANDOM) : 0;
    }
}
