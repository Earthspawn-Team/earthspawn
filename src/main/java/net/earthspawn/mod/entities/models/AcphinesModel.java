package net.earthspawn.mod.entities.models;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.AcphinesEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AcphinesModel extends AnimatedGeoModel<AcphinesEntity> {
    @Override
    public ResourceLocation getModelLocation(AcphinesEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/acphines.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AcphinesEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/acphines.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AcphinesEntity animatable) {
        return new ResourceLocation(Earthspawn.MOD_ID, "animations/acphines.animation.json");
    }
}
