package net.earthspawn.mod.items.armors;

import net.earthspawn.mod.items.ItemRegister;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorTiers {
    public static final ArmorMaterial TOPAZ = new ArmorMaterialsRecord(
            "topaz",
            624,
            new int[] {4, 9, 7, 4},
            6,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            0.0f,
            0.0f,
            () -> Ingredient.of(ItemRegister.TOPAZ.get()));
}
