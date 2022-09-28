package net.earthspawn.mod;

import com.mojang.logging.LogUtils;
import net.earthspawn.mod.entities.EntitiesRegister;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.entities.classes.AcphinesEntity;
import net.earthspawn.mod.items.ItemRegister;
import net.earthspawn.mod.init.ClientEventBusSubscriber;
import net.earthspawn.mod.particles.ParticleRegister;
import net.earthspawn.mod.sounds.SoundRegister;
import net.earthspawn.mod.utils.KeyInit;
import net.earthspawn.mod.world.biomes.BiomeRegister;
import net.earthspawn.mod.world.biomes.RegionData;
import net.earthspawn.mod.world.biomes.SurfaceRuleData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

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
        bus.addListener(this::setup);

        GeckoLib.initialize();
        BlockRegister.registerSetup(bus);
        EntitiesRegister.registerSetup(bus);
        ItemRegister.registerSetup(bus);
        ParticleRegister.registerSetup(bus);
        SoundRegister.registerSetup(bus);
        BiomeRegister.registerSetup(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        //biome region setup
        event.enqueueWork(() ->
        {
            //biome region setup
            Regions.register(new RegionData(new ResourceLocation(Earthspawn.MOD_ID, "overworld"), RegionType.OVERWORLD, 10));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Earthspawn.MOD_ID, SurfaceRuleData.makeRules());

            //entity spawnpoints setup
            SpawnPlacements.register(EntitiesRegister.OULISK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(EntitiesRegister.ACPHINES.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AcphinesEntity::checkLeFisheSpawnRules);
            SpawnPlacements.register(EntitiesRegister.GOBLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
        });
    }
}
