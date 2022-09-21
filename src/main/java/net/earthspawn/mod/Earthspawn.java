package net.earthspawn.mod;

import com.mojang.logging.LogUtils;
import net.earthspawn.mod.entities.EntitiesRegister;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.items.ItemRegister;
import net.earthspawn.mod.init.ClientEventBusSubscriber;
import net.earthspawn.mod.particles.ParticleRegister;
import net.earthspawn.mod.world.biomes.BiomeRegister;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

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

        GeckoLib.initialize();
        BlockRegister.registerSetup(bus);
        EntitiesRegister.registerSetup(bus);
        ItemRegister.registerSetup(bus);
        ParticleRegister.registerSetup(bus);
        BiomeRegister.registerSetup(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
