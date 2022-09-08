package net.earthspawn.mod.entities.models;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OuliskModel extends AnimatedGeoModel<OuliskEntity> {
    @Override
    public ResourceLocation getModelLocation(OuliskEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/oulisk.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(OuliskEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/oulisk.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(OuliskEntity animatable) {
        return new ResourceLocation(Earthspawn.MOD_ID, "animations/oulisk.animation.json");
    }
}
