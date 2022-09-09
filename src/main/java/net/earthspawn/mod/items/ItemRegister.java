package net.earthspawn.mod.items;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.items.armors.ArmorTiers;
import net.earthspawn.mod.items.armors.classes.TopazArmorItem;
import net.earthspawn.mod.tabs.EarthspawnTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.example.item.PotatoArmorItem;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegister {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Earthspawn.MOD_ID);

    public static void registerSetup(IEventBus bus) {
        ITEMS.register(bus);
    }

    //items
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(EarthspawnTab.itemTabProperties()));
    public static final RegistryObject<Item> CRYSTAL = ITEMS.register("crystal", () -> new Item(EarthspawnTab.itemTabProperties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> CRYSTAL_SHARD = ITEMS.register("crystal_shard", () -> new Item(EarthspawnTab.itemTabProperties()));
    public static final RegistryObject<Item> ASTRAL_DUST = ITEMS.register("astral_dust", () -> new Item(EarthspawnTab.itemTabProperties()));
    public static final RegistryObject<Item> CHARGED_CRYSTAL = ITEMS.register("charged_crystal", () -> new Item(EarthspawnTab.itemTabProperties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> UNICORN_HORN = ITEMS.register("unicorn_horn", () -> new Item(EarthspawnTab.itemTabProperties()));

    //topaz tier
    public static final RegistryObject<Item> TOPAZ_SWORD = ITEMS.register("topaz_sword",
            () -> new SwordItem(ItemTiers.TOPAZ, 3, -2.4F, EarthspawnTab.itemTabProperties()));
    public static final RegistryObject<Item> TOPAZ_PICKAXE = ITEMS.register("topaz_pickaxe",
            () -> new PickaxeItem(ItemTiers.TOPAZ, 1, -2.8F, EarthspawnTab.itemTabProperties()));
    public static final RegistryObject<Item> TOPAZ_AXE = ITEMS.register("topaz_axe",
            () -> new AxeItem(ItemTiers.TOPAZ, 5.0F, -3.0F, EarthspawnTab.itemTabProperties()));
    public static final RegistryObject<Item> TOPAZ_SHOVEL = ITEMS.register("topaz_shovel",
            () -> new ShovelItem(ItemTiers.TOPAZ, 1.5F, -3.0F, EarthspawnTab.itemTabProperties()));

    public static final RegistryObject<TopazArmorItem> TOPAZ_HELMET = ITEMS.register("topaz_helmet",
            () -> new TopazArmorItem(ArmorTiers.TOPAZ, EquipmentSlot.HEAD, new Item.Properties()));

    public static final RegistryObject<TopazArmorItem> TOPAZ_CHESTPLATE = ITEMS.register("topaz_chestplate",
            () -> new TopazArmorItem(ArmorTiers.TOPAZ, EquipmentSlot.CHEST, new Item.Properties()));

    public static final RegistryObject<TopazArmorItem> TOPAZ_LEGGINGS = ITEMS.register("topaz_leggings",
            () -> new TopazArmorItem(ArmorTiers.TOPAZ, EquipmentSlot.LEGS, new Item.Properties()));

    public static final RegistryObject<TopazArmorItem> TOPAZ_BOOTS = ITEMS.register("topaz_boots",
            () -> new TopazArmorItem(ArmorTiers.TOPAZ, EquipmentSlot.FEET, new Item.Properties()));
}
