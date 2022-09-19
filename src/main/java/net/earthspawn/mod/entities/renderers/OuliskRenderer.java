package net.earthspawn.mod.entities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.earthspawn.mod.entities.models.OuliskModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class OuliskRenderer extends GeoEntityRenderer<OuliskEntity> {

    private float rotationAngle;

    public OuliskRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OuliskModel());
        this.addLayer(new OuliskGlowLayer<>(this));
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(OuliskEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/oulisk.png");
    }

    public ResourceLocation getModelLocation(OuliskEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/oulisk.geo.json");
    }

    @Override
    public RenderType getRenderType(OuliskEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if (animatable.isBaby()) {
            stack.scale(0.5f, 0.5f, 0.5f);
        } else {
            stack.scale(1.0f, 1.0f, 1.0f);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    public static class OuliskGlowLayer<T extends OuliskEntity> extends GeoLayerRenderer<T> {

        private final ResourceLocation OULISK_GLOW;

        private final ResourceLocation OULISK_MODEL;

        public OuliskGlowLayer(IGeoRenderer<T> entityRendererIn) {
            super(entityRendererIn);
            OULISK_GLOW = new ResourceLocation(Earthspawn.MOD_ID,"textures/entities/layers/oulisk_glow.png");
            OULISK_MODEL = new ResourceLocation(Earthspawn.MOD_ID, "geo/oulisk.geo.json");
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLightIn, T entity, float limbSwing,
                           float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getRenderer().render(getEntityModel().getModel(OULISK_MODEL), entity, partialTicks, RenderType.eyes(OULISK_GLOW),
                    matrixStack, buffer, buffer.getBuffer(RenderType.eyes(OULISK_GLOW)), packedLightIn, OverlayTexture.pack(
                            0, OverlayTexture.v(entity.hurtTime > 0)), 1f, 1f, 1f, 1f);
        }

    }
}
