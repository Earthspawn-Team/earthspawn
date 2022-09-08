package net.earthspawn.mod;

import com.mojang.logging.LogUtils;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.setup.ClientEventBusSubscriber;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

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
        MinecraftForge.EVENT_BUS.register(this);
    }
}
