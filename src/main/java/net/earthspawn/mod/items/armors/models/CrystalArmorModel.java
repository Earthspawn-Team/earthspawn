package net.earthspawn.mod.items.armors.models;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.items.armors.classes.CrystalArmorItem;
import net.earthspawn.mod.items.armors.classes.TopazArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrystalArmorModel extends AnimatedGeoModel<CrystalArmorItem> {
    @Override
    public ResourceLocation getModelLocation(CrystalArmorItem object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/crystal_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalArmorItem object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/models/armor/crystal_armor.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CrystalArmorItem animatable) {
        return new ResourceLocation(Earthspawn.MOD_ID, "animations/crystal_armor.animation.json");
    }
}
