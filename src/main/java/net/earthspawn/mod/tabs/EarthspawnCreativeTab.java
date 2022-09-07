package net.earthspawn.mod.tabs;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EarthspawnCreativeTab extends CreativeModeTab {

    public static final EarthspawnCreativeTab EARTHSPAWN_CREATIVE_TAB = new EarthspawnCreativeTab(Earthspawn.MOD_ID);

    public EarthspawnCreativeTab(String label) {
        super(label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(BlockRegister.HALLOW_GRASS.get());
    }
}
