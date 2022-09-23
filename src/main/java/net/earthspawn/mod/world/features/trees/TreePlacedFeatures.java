package net.earthspawn.mod.world.features.trees;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TreePlacedFeatures {

    public static final Holder<PlacedFeature> HALLOW_TREE = PlacementUtils.register("hallow_tree_placed",
            TreeConfiguredFeatures.HALLOW_TREE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.5f, 1)));
}
