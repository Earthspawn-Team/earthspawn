package net.earthspawn.mod.items.shields;

import net.earthspawn.mod.Earthspawn;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrystalShieldModel extends AnimatedGeoModel<CrystalShieldItem> {
    @Override
    public ResourceLocation getModelLocation(CrystalShieldItem object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/crystal_shield.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalShieldItem object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/items/crystal_shield.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CrystalShieldItem animatable) {
        return new ResourceLocation(Earthspawn.MOD_ID, "animations/crystal_shield.animation.json");
    }
}
