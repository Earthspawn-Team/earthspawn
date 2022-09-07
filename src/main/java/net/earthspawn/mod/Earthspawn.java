package net.earthspawn.mod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Earthspawn.MOD_ID)
public class Earthspawn {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "earthspawn";

    public Earthspawn() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("[Earthspawn] Pre-init mod loading");
    }
}
