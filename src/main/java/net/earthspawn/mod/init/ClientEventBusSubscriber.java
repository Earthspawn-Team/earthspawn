package net.earthspawn.mod.init;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.entities.EntitiesRegister;
import net.earthspawn.mod.entities.renderers.AcphinesRenderer;
import net.earthspawn.mod.entities.renderers.CrystalStalkerRenderer;
import net.earthspawn.mod.entities.renderers.GoblinRenderer;
import net.earthspawn.mod.entities.renderers.OuliskRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSubscriber {

    public static void clientRegisterSetup(final FMLClientSetupEvent event) {
        //entity render setup
        EntityRenderers.register(EntitiesRegister.OULISK.get(), OuliskRenderer::new);
        EntityRenderers.register(EntitiesRegister.ACPHINES.get(), AcphinesRenderer::new);
        EntityRenderers.register(EntitiesRegister.GOBLIN.get(), GoblinRenderer::new);
        EntityRenderers.register(EntitiesRegister.CRYSTAL_STALKER.get(), CrystalStalkerRenderer::new);

        //transparent block render setup
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.GLADIOLUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_ROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.AMARYLLIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.GREEN_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_SAPLING.get(), RenderType.cutout());
    }
}
