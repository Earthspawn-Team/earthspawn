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
            10,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0f,
            0.0f,
            () -> Ingredient.of(ItemRegister.TOPAZ.get()));

    public static final ArmorMaterial CRYSTAL = new ArmorMaterialsRecord(
            "crystal",
            850,
            new int[] {5, 9, 8, 5},
            10,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            1.0f,
            0.5f,
            () -> Ingredient.of(ItemRegister.CRYSTAL.get()));
}
