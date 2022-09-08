package net.earthspawn.mod;

import com.mojang.logging.LogUtils;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.entities.EntitiesRegister;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.earthspawn.mod.entities.renderers.OuliskRenderer;
import net.earthspawn.mod.setup.ClientEventBusSubscriber;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import javax.swing.text.html.parser.Entity;

@Mod(Earthspawn.MOD_ID)
public class Earthspawn {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "earthspawn";

    public Earthspawn() {
        LOGGER.debug("Earthspawn Pre-init Setup");
        registerContent();
    }

    private void registerContent() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ClientEventBusSubscriber::clientRegisterSetup);

        BlockRegister.registerSetup(bus);
        EntitiesRegister.register(bus);

        bus.addListener(this::clientSetup);

        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(EntitiesRegister.OULISK.get(), OuliskRenderer::new);
    }
}
