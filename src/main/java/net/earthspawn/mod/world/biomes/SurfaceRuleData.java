package net.earthspawn.mod.world.biomes;

import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class SurfaceRuleData {
    private static final SurfaceRules.RuleSource HALLOW_GRASS = makeStateRule(BlockRegister.HALLOW_GRASS.get());
    private static final SurfaceRules.RuleSource HALLOW_DIRT = makeStateRule(BlockRegister.HALLOW_DIRT.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);

    public static SurfaceRules.RuleSource makeRules()
    {
        /*SurfaceRules.RuleSource hallowSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                        SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(0, 0), HALLOW_GRASS)), HALLOW_DIRT);*/

        return SurfaceRules.sequence(
                //SurfaceRules.ifTrue(SurfaceRules.isBiome(BiomeRegister.HALLOW_PLAINS.getKey()), hallowSurface)
        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
