package net.earthspawn.mod.entities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.earthspawn.mod.entities.models.OuliskModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OuliskRenderer extends GeoEntityRenderer<OuliskEntity> {

    public OuliskRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OuliskModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(OuliskEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/oulisk.png");
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
}
