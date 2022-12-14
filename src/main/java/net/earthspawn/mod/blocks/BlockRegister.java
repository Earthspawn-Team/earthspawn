package net.earthspawn.mod.blocks;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.classes.FlammableLeaveBlock;
import net.earthspawn.mod.blocks.classes.FlammableRotatedPillarBlock;
import net.earthspawn.mod.tabs.EarthspawnTab;
import net.earthspawn.mod.world.features.trees.TreeConfiguredFeatures;
import net.earthspawn.mod.world.features.trees.grower.HallowTreeGrower;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegister {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Earthspawn.MOD_ID);

    public static void registerSetup(IEventBus bus) {
        BLOCKS.register(bus);
    }

    @SubscribeEvent
    public static void createBlocksItems(final RegistryEvent.Register<Item> event) {
        BlockRegister.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
                event.getRegistry().register(new BlockItem(block, EarthspawnTab.itemTabProperties()).setRegistryName(Objects.requireNonNull(block.getRegistryName()))));
    }

    public static final RegistryObject<Block> HALLOW_GRASS = BLOCKS.register("hallow_grass", () -> BlockProperties.getBlockProperties(Blocks.GRASS_BLOCK));
    public static final RegistryObject<Block> HALLOW_DIRT = BLOCKS.register("hallow_dirt", () -> BlockProperties.getBlockProperties(Blocks.DIRT));
    public static final RegistryObject<Block> HALLOW_LOG = BLOCKS.register("hallow_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM)));
    public static final RegistryObject<Block> HALLOW_LEAVES = BLOCKS.register("hallow_leaves", () -> new FlammableLeaveBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> GREEN_MUSHROOM_BLOCK = BLOCKS.register("green_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK)));
    public static final RegistryObject<Block> HALLOW_SAPLING = BLOCKS.register("hallow_sapling", () -> new SaplingBlock(new HallowTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> TOPAZ_ORE = BLOCKS.register("topaz_ore", () -> BlockProperties.setOreBlockProperties(Material.STONE, 6f, SoundType.DEEPSLATE, null));
    public static final RegistryObject<Block> ASTRAL_ORE = BLOCKS.register("astral_ore", () -> BlockProperties.setOreBlockProperties(Material.STONE, 7f, SoundType.DEEPSLATE, ParticleTypes.WITCH));
    public static final RegistryObject<Block> GLADIOLUS = BLOCKS.register("gladiolus", () -> BlockProperties.setFlowerBlockProperties(Blocks.RED_TULIP, MaterialColor.COLOR_CYAN, 8, true));
    public static final RegistryObject<Block> HALLOW_ROOTS = BLOCKS.register("hallow_roots", () -> BlockProperties.setFlowerBlockProperties(Blocks.WARPED_ROOTS, MaterialColor.COLOR_LIGHT_GRAY, 4, false));
    public static final RegistryObject<Block> AMARYLLIS = BLOCKS.register("amaryllis", () -> BlockProperties.setFlowerBlockProperties(Blocks.PINK_TULIP, MaterialColor.COLOR_PINK, 0, false));
    public static final RegistryObject<MushroomBlock> GREEN_MUSHROOM = BLOCKS.register("green_mushroom", () -> BlockProperties.setMushroomBlockProperties(Blocks.RED_MUSHROOM, MaterialColor.COLOR_GREEN, 6, true, TreeConfiguredFeatures.HUGE_GREEN_MUSHROOM));
}
