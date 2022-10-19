package net.earthspawn.mod;

import com.mojang.logging.LogUtils;
import net.earthspawn.mod.entities.EntityRegister;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.init.CommonEventBusSubscriber;
import net.earthspawn.mod.items.ItemRegister;
import net.earthspawn.mod.init.ClientEventBusSubscriber;
import net.earthspawn.mod.particles.ParticleRegister;
import net.earthspawn.mod.sounds.SoundRegister;
import net.earthspawn.mod.world.biomes.BiomeRegister;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

@Mod(Earthspawn.MOD_ID)
public class Earthspawn {

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "earthspawn";

    public Earthspawn() {
        Loader.initialize();
    }

    public static class Loader {
        static IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        public static void initialize() {
            LOGGER.debug("Earthspawn Pre-init Setup");
            bus.addListener(ClientEventBusSubscriber::clientRegisterSetup);
            bus.addListener(CommonEventBusSubscriber::commonRegisterSetup);

            GeckoLib.initialize();
            BlockRegister.registerSetup(bus);
            EntityRegister.registerSetup(bus);
            ItemRegister.registerSetup(bus);
            ParticleRegister.registerSetup(bus);
            SoundRegister.registerSetup(bus);
            BiomeRegister.registerSetup(bus);
        }
    }
}
