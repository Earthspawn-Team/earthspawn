package net.earthspawn.mod.items;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.tabs.EarthspawnTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegister {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Earthspawn.MOD_ID);

    public static void registerSetup(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(new Item.Properties().tab(EarthspawnTab.CREATIVE_TAB)));
    public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal", () -> new Item(new Item.Properties().tab(EarthspawnTab.CREATIVE_TAB).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CRYSTAL_SHARD = ITEMS.register("crystal_shard", () -> new Item(new Item.Properties().tab(EarthspawnTab.CREATIVE_TAB)));
    public static final RegistryObject<Item> ASTRAL_DUST = ITEMS.register("astral_dust", () -> new Item(new Item.Properties().tab(EarthspawnTab.CREATIVE_TAB)));
    public static final RegistryObject<Item> CHARGED_CRYSTAL = ITEMS.register("charged_crystal", () -> new Item(new Item.Properties().tab(EarthspawnTab.CREATIVE_TAB).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> UNICORN_HORN = ITEMS.register("unicorn_horn", () -> new Item(new Item.Properties().tab(EarthspawnTab.CREATIVE_TAB)));
}
