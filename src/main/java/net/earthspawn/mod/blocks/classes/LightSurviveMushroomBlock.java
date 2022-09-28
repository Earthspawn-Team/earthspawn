package net.earthspawn.mod.blocks.classes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.function.Supplier;

public class LightSurviveMushroomBlock extends MushroomBlock {
    public LightSurviveMushroomBlock(Properties p_153983_, Supplier<Holder<? extends ConfiguredFeature<?, ?>>> p_153984_) {
        super(p_153983_, p_153984_);
    }

    @Override
    public boolean canSurvive(BlockState p_54880_, LevelReader p_54881_, BlockPos p_54882_) {
        BlockPos blockpos = p_54882_.below();
        BlockState blockstate = p_54881_.getBlockState(blockpos);
        return blockstate.is(BlockTags.DIRT);
    }
}
