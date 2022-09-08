package net.earthspawn.mod.setup;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.entities.EntitiesRegister;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientRegisterSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.GLADIOLUS.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntitiesRegister.OULISK.get(), OuliskEntity.setAttributes());
    }
}
