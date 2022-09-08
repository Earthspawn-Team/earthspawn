package net.earthspawn.mod.entities.models;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.example.entity.GeoExampleEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

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

    @Override
    public void setLivingAnimations(OuliskEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
