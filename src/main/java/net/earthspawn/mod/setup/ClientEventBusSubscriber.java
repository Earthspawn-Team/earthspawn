package net.earthspawn.mod.setup;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientRegisterSetup(FMLClientSetupEvent event) {

        //transparent block render
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.GLADIOLUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_ROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.AMARYLLIS.get(), RenderType.cutout());
    }

}
