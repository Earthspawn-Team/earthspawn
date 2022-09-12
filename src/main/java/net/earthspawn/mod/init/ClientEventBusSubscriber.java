package net.earthspawn.mod.init;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.entities.EntitiesRegister;
import net.earthspawn.mod.entities.classes.AcphinesEntity;
import net.earthspawn.mod.entities.classes.GoblinEntity;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.earthspawn.mod.entities.renderers.AcphinesRenderer;
import net.earthspawn.mod.entities.renderers.GoblinRenderer;
import net.earthspawn.mod.entities.renderers.OuliskRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientRegisterSetup(FMLClientSetupEvent event) {
        //entity render setup
        EntityRenderers.register(EntitiesRegister.OULISK.get(), OuliskRenderer::new);
        EntityRenderers.register(EntitiesRegister.ACPHINES.get(), AcphinesRenderer::new);
        EntityRenderers.register(EntitiesRegister.GOBLIN.get(), GoblinRenderer::new);

        //transparent block render setup
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.GLADIOLUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_ROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.AMARYLLIS.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntitiesRegister.OULISK.get(), OuliskEntity.setAttributes());
        event.put(EntitiesRegister.ACPHINES.get(), AcphinesEntity.setAttributes());
        event.put(EntitiesRegister.GOBLIN.get(), GoblinEntity.setAttributes());
    }
}
