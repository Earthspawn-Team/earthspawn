package net.earthspawn.mod.entities.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.GoblinEntity;
import net.earthspawn.mod.entities.models.GoblinModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GoblinRenderer  extends GeoEntityRenderer<GoblinEntity> {

    public GoblinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoblinModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinEntity object) {
        return new ResourceLocation(Earthspawn.MOD_ID, "textures/entities/goblin.png");
    }

    @Override
    public RenderType getRenderType(GoblinEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.7f, 0.7f, 0.7f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
