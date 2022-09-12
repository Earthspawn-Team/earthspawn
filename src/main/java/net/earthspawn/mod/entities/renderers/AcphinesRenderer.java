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
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AcphinesRenderer extends GeoEntityRenderer<AcphinesEntity> {

    public AcphinesRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AcphinesModel());
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
}
