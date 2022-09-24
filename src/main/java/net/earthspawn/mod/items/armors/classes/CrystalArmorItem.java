package net.earthspawn.mod.items.armors.classes;

import net.earthspawn.mod.items.ItemRegister;
import net.earthspawn.mod.tabs.EarthspawnTab;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrystalArmorItem extends GeoArmorItem implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public CrystalArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder.tab(EarthspawnTab.CREATIVE_TAB));
    }

    // Predicate runs every frame
    @SuppressWarnings("unused")
    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        List<EquipmentSlot> slotData = event.getExtraDataOfType(EquipmentSlot.class);
        List<ItemStack> stackData = event.getExtraDataOfType(ItemStack.class);
        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.crystal_armor.new", true));

        // If the living entity is an armorstand just play the animation nonstop
        if (livingEntity instanceof ArmorStand) {
            return PlayState.CONTINUE;
        }

        List<Item> armorList = new ArrayList<>(4);
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                if (livingEntity.getItemBySlot(slot) != null) {
                    armorList.add(livingEntity.getItemBySlot(slot).getItem());
                }
            }
        }

        // Make sure the player is wearing all the armor. If they are, continue playing
        // the animation, otherwise stop
        boolean isWearingAll = armorList.containsAll(Arrays.asList(ItemRegister.CRYSTAL_BOOTS.get(),
                ItemRegister.CRYSTAL_LEGGINGS.get(), ItemRegister.CRYSTAL_CHESTPLATE.get(), ItemRegister.CRYSTAL_HELMET.get()));
        return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
    }

    // All you need to do here is add your animation controllers to the
    // AnimationData
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}