package net.earthspawn.mod.items;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemTiers {
    public static final Tier TOPAZ = new ForgeTier(
            3,
            1873,
            8.5F,
            3.5F,
            8,
            null,
            () -> Ingredient.of(ItemRegister.TOPAZ.get()));
}