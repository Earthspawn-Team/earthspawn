package net.earthspawn.mod.entities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.FlyingMobEntity;
import net.earthspawn.mod.entities.models.FlyingMobModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FlyingMobRenderer extends GeoEntityRenderer<FlyingMobEntity> {

    public FlyingMobRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FlyingMobModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FlyingMobEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/flying_mob.png");
    }

    @Override
    protected float getDeathMaxRotation(FlyingMobEntity entityLivingBaseIn) {
        return 90;
    }


    @Override
    public RenderType getRenderType(FlyingMobEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.7f, 0.7f, 0.7f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
