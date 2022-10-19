package net.earthspawn.mod.init;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.EntityRegister;
import net.earthspawn.mod.entities.classes.AcphinesEntity;
import net.earthspawn.mod.entities.classes.CrystalStalkerEntity;
import net.earthspawn.mod.entities.classes.GoblinEntity;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.earthspawn.mod.items.ModItemProperties;
import net.earthspawn.mod.world.biomes.RegionData;
import net.earthspawn.mod.world.biomes.SurfaceRuleData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEventBusSubscriber {

    public static void commonRegisterSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //biome region setup
            Regions.register(new RegionData(new ResourceLocation(Earthspawn.MOD_ID, "overworld"), RegionType.OVERWORLD, 10));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Earthspawn.MOD_ID, SurfaceRuleData.makeRules());

            //entity spawnpoints setup
            SpawnPlacements.register(EntityRegister.OULISK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(EntityRegister.ACPHINES.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AcphinesEntity::checkLeFisheSpawnRules);
            SpawnPlacements.register(EntityRegister.GOBLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
        });

        //mod item properties setup (for custom bow)
        ModItemProperties.addCustomItemProperties();
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntityRegister.OULISK.get(), OuliskEntity.setAttributes());
        event.put(EntityRegister.ACPHINES.get(), AcphinesEntity.setAttributes());
        event.put(EntityRegister.GOBLIN.get(), GoblinEntity.setAttributes());
        event.put(EntityRegister.CRYSTAL_STALKER.get(), CrystalStalkerEntity.setAttributes());
    }
}
