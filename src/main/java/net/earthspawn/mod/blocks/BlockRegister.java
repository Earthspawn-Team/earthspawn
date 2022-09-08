package net.earthspawn.mod.blocks;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.tabs.EarthspawnCreativeTab;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(EarthspawnCreativeTab.EARTHSPAWN_CREATIVE_TAB)).setRegistryName(Objects.requireNonNull(block.getRegistryName()))));
    }

    public static final RegistryObject<Block> HALLOW_GRASS = BLOCKS.register("hallow_grass", () -> BlockProperties.getBlockProperties(Blocks.GRASS_BLOCK));
    public static final RegistryObject<Block> HALLOW_DIRT = BLOCKS.register("hallow_dirt", () -> BlockProperties.getBlockProperties(Blocks.DIRT));
    public static final RegistryObject<Block> GLADIOLUS = BLOCKS.register("gladiolus", () -> BlockProperties.setFlowerBlockProperties(Blocks.RED_TULIP, MaterialColor.COLOR_CYAN, 2, true));
}
