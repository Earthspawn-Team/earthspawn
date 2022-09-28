package net.earthspawn.mod.world.features.trees;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TreePlacedFeatures {

    public static final Holder<PlacedFeature> HALLOW_TREE = PlacementUtils.register("hallow_tree_placed",
            TreeConfiguredFeatures.HALLOW_TREE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.2f, 1)));

    public static final Holder<PlacedFeature> LARGE_HALLOW_TREE = PlacementUtils.register("large_hallow_tree_placed",
            TreeConfiguredFeatures.LARGE_HALLOW_TREE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.2f, 1)));

    public static final Holder<PlacedFeature> HUGE_GREEN_MUSHROOM = PlacementUtils.register("huge_green_mushroom",
            TreeConfiguredFeatures.HUGE_GREEN_MUSHROOM, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(1, 0.1f, 1)));
}
