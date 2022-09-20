package net.earthspawn.mod.entities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.CrystalStalkerEntity;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.earthspawn.mod.entities.models.CrystalStalkerModel;
import net.earthspawn.mod.entities.models.OuliskModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class CrystalStalkerRenderer extends GeoEntityRenderer<CrystalStalkerEntity> {

    public CrystalStalkerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalStalkerModel());
        this.addLayer(new CrystalStalkerGlowLayer<>(this));
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalStalkerEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/crystal_stalker.png");
    }

    public ResourceLocation getModelLocation(CrystalStalkerEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "geo/crystal_stalker.geo.json");
    }

    @Override
    public RenderType getRenderType(CrystalStalkerEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if (animatable.isBaby()) {
            stack.scale(0.5f, 0.5f, 0.5f);
        } else {
            stack.scale(1.0f, 1.0f, 1.0f);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    public static class CrystalStalkerGlowLayer<T extends CrystalStalkerEntity> extends GeoLayerRenderer<T> {

        private final ResourceLocation CRYSTAL_STALKER_GLOW;

        private final ResourceLocation CRYSTAL_STALKER_MODEL;

        public CrystalStalkerGlowLayer(IGeoRenderer<T> entityRendererIn) {
            super(entityRendererIn);
            CRYSTAL_STALKER_GLOW = new ResourceLocation(Earthspawn.MOD_ID,"textures/entities/layers/crystal_stalker_glow.png");
            CRYSTAL_STALKER_MODEL = new ResourceLocation(Earthspawn.MOD_ID, "geo/crystal_stalker.geo.json");
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLightIn, T entity, float limbSwing,
                           float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            this.getRenderer().render(getEntityModel().getModel(CRYSTAL_STALKER_MODEL), entity, partialTicks, RenderType.eyes(CRYSTAL_STALKER_GLOW),
                    matrixStack, buffer, buffer.getBuffer(RenderType.eyes(CRYSTAL_STALKER_GLOW)), packedLightIn, OverlayTexture.pack(
                            0, OverlayTexture.v(entity.hurtTime > 0)), 1f, 1f, 1f, 1f);
        }

    }
}

