package net.earthspawn.mod.items.armors.models;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.items.armors.classes.TopazArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TopazArmorModel extends AnimatedGeoModel<TopazArmorItem> {
    @Override
    public ResourceLocation getModelLocation(TopazArmorItem object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/topaz_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TopazArmorItem object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/models/armor/topaz_armor.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TopazArmorItem animatable) {
        return new ResourceLocation(Earthspawn.MOD_ID, "animations/topaz_armor.animation.json");
    }
}
