package net.earthspawn.mod.init;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.entities.EntityRegister;
import net.earthspawn.mod.entities.renderers.AcphinesRenderer;
import net.earthspawn.mod.entities.renderers.CrystalStalkerRenderer;
import net.earthspawn.mod.entities.renderers.GoblinRenderer;
import net.earthspawn.mod.entities.renderers.OuliskRenderer;
import net.earthspawn.mod.items.armors.classes.CrystalArmorItem;
import net.earthspawn.mod.items.armors.classes.TopazArmorItem;
import net.earthspawn.mod.items.armors.renderers.CrystalArmorRenderer;
import net.earthspawn.mod.items.armors.renderers.TopazArmorRenderer;
import net.earthspawn.mod.particles.ParticleRegister;
import net.earthspawn.mod.particles.classes.HallowAmbientBiomeParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSubscriber {

    public static void clientRegisterSetup(final FMLClientSetupEvent event) {
        //entity render setup
        EntityRenderers.register(EntityRegister.OULISK.get(), OuliskRenderer::new);
        EntityRenderers.register(EntityRegister.ACPHINES.get(), AcphinesRenderer::new);
        EntityRenderers.register(EntityRegister.GOBLIN.get(), GoblinRenderer::new);
        EntityRenderers.register(EntityRegister.CRYSTAL_STALKER.get(), CrystalStalkerRenderer::new);

        //transparent block render setup
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.GLADIOLUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_ROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.AMARYLLIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.GREEN_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_SAPLING.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerArmorRenderer(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(TopazArmorItem.class, TopazArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(CrystalArmorItem.class, CrystalArmorRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ParticleRegister.HALLOW_BIOME_AMBIENT_PARTICLES.get(), HallowAmbientBiomeParticles.Provider::new);
    }
}
