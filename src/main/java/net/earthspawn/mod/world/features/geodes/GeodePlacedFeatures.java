package net.earthspawn.mod.world.features.geodes;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class GeodePlacedFeatures {

    public static final Holder<PlacedFeature> CRYSTAL_ROOM = PlacementUtils.register("crystal_room_placed",
            GeodeConfiguredFeatures.CRYSTAL_ROOM, List.of(
                    RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                    BiomeFilter.biome()));
}
