package net.earthspawn.mod.items.ranged;

import net.earthspawn.mod.items.ItemRegister;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;

public class CrystalBowItem extends BowItem {
    public CrystalBowItem(Properties p_40660_) {
        super(p_40660_);
        this.setDamage(new ItemStack(ItemRegister.CRYSTAL_BOW.get()), 80);
    }
}
