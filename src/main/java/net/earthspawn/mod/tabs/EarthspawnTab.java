package net.earthspawn.mod.tabs;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EarthspawnTab extends CreativeModeTab {

    public static final EarthspawnTab CREATIVE_TAB = new EarthspawnTab(Earthspawn.MOD_ID);

    public EarthspawnTab(String label) {
        super(label);
    }

    public static Item.Properties itemTabProperties() {
        return new Item.Properties().tab(EarthspawnTab.CREATIVE_TAB);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(BlockRegister.HALLOW_GRASS.get());
    }
}
