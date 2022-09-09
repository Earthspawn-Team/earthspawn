package net.earthspawn.mod.world.features;

import com.google.common.base.Suppliers;
import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class FeatureRegister {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Earthspawn.MOD_ID);

    public static void registerSetup(IEventBus bus) {
        FEATURES.register(bus);
    }

    private static final Supplier<List<OreConfiguration.TargetBlockState>> TOPAZ_OVERWORLD_REPLACEMENT = Suppliers.memoize(() ->
            List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockRegister.TOPAZ_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockRegister.TOPAZ_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TOPAZ_ORE_GENERATION = FEATURES.register("topaz.generation.ore", () ->
            new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TOPAZ_OVERWORLD_REPLACEMENT.get(), 8)));

}
