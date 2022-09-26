package net.earthspawn.mod.entities.models;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.CrystalStalkerEntity;
import net.earthspawn.mod.entities.classes.FlyingMobEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class FlyingMobModel extends AnimatedGeoModel<FlyingMobEntity> {
    @Override
    public ResourceLocation getModelLocation(FlyingMobEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/flying_mob.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(FlyingMobEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/flying_mob.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FlyingMobEntity animatable) {
        return new ResourceLocation(Earthspawn.MOD_ID, "animations/flying_mob.animation.json");
    }

    @Override
    public void setLivingAnimations(FlyingMobEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
