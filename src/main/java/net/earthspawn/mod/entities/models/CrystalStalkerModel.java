package net.earthspawn.mod.entities.models;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.CrystalStalkerEntity;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CrystalStalkerModel extends AnimatedGeoModel<CrystalStalkerEntity> {
    @Override
    public ResourceLocation getModelLocation(CrystalStalkerEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/crystal_stalker.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalStalkerEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/crystal_stalker.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CrystalStalkerEntity animatable) {
        return new ResourceLocation(Earthspawn.MOD_ID, "animations/crystal_stalker.animation.json");
    }

    @Override
    public void setLivingAnimations(CrystalStalkerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
