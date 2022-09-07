package net.earthspawn.mod.blocks;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.tabs.EarthspawnCreativeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegister {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Earthspawn.MOD_ID);

    public static void registerBus() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public static void createBlocksItems(final RegistryEvent.Register<Item> event) {
        BlockRegister.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(EarthspawnCreativeTab.EARTHSPAWN_CREATIVE_TAB)).setRegistryName(Objects.requireNonNull(block.getRegistryName()))));
    }

    public static Block getBlockProperty(Block block) {
        return new Block(BlockBehaviour.Properties.copy(block));
    }

    public static final RegistryObject<Block> HALLOW_GRASS = BLOCKS.register("hallow_grass", () -> BlockRegister.getBlockProperty(Blocks.GRASS_BLOCK));
}
