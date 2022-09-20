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
import net.earthspawn.mod.items.armors.classes.CrystalArmorItem;
import net.earthspawn.mod.items.armors.classes.TopazArmorItem;
import net.earthspawn.mod.items.armors.renderers.CrystalArmorRenderer;
import net.earthspawn.mod.items.armors.renderers.TopazArmorRenderer;
import net.earthspawn.mod.world.biomes.RegionData;
import net.earthspawn.mod.world.biomes.SurfaceRuleData;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

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
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_SAPLING.get(), RenderType.cutout());

        event.enqueueWork(() ->
        {
            //biome region setup
            Regions.register(new RegionData(new ResourceLocation(Earthspawn.MOD_ID, "overworld"), RegionType.OVERWORLD, 8));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Earthspawn.MOD_ID, SurfaceRuleData.makeRules());

            //entity spawnpoints setup
            SpawnPlacements.register(EntitiesRegister.OULISK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(EntitiesRegister.ACPHINES.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AcphinesEntity::checkLeFisheSpawnRules);
            SpawnPlacements.register(EntitiesRegister.GOBLIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
        });

    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntitiesRegister.OULISK.get(), OuliskEntity.setAttributes());
        event.put(EntitiesRegister.ACPHINES.get(), AcphinesEntity.setAttributes());
        event.put(EntitiesRegister.GOBLIN.get(), GoblinEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerArmorRenderer(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(TopazArmorItem.class, new TopazArmorRenderer());
        GeoArmorRenderer.registerArmorRenderer(CrystalArmorItem.class, new CrystalArmorRenderer());
    }
}
