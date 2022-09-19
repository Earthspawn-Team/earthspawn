package net.earthspawn.mod.entities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.AcphinesEntity;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.earthspawn.mod.entities.models.AcphinesModel;
import net.earthspawn.mod.entities.models.OuliskModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class AcphinesRenderer extends GeoEntityRenderer<AcphinesEntity> {

    public AcphinesRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AcphinesModel());
        this.addLayer(new AcphinesGlowLayer<>(this));
        this.shadowRadius = 0.25f;
    }

    @Override
    public ResourceLocation getTextureLocation(AcphinesEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/acphines.png");
    }

    @Override
    public RenderType getRenderType(AcphinesEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.0f, 1.0f, 1.0f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    public static class AcphinesGlowLayer<T extends AcphinesEntity> extends GeoLayerRenderer<T> {

        private final ResourceLocation ACPHINES_GLOW;

        private final ResourceLocation ACPHINES_MODEL;

        public AcphinesGlowLayer(IGeoRenderer<T> entityRendererIn) {
            super(entityRendererIn);
            ACPHINES_GLOW = new ResourceLocation(Earthspawn.MOD_ID,"textures/entities/layers/acphines_glow.png");
            ACPHINES_MODEL = new ResourceLocation(Earthspawn.MOD_ID, "geo/acphines.geo.json");
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLightIn, T entity, float limbSwing,
                           float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getRenderer().render(getEntityModel().getModel(ACPHINES_MODEL), entity, partialTicks, RenderType.eyes(ACPHINES_GLOW),
                    matrixStack, buffer, buffer.getBuffer(RenderType.eyes(ACPHINES_GLOW)), packedLightIn, OverlayTexture.pack(
                            0, OverlayTexture.v(entity.hurtTime > 0)), 1f, 1f, 1f, 1f);
        }
    }
}
