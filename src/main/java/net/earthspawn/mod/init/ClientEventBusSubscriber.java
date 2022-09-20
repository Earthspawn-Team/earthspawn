package net.earthspawn.mod.init;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.blocks.BlockRegister;
import net.earthspawn.mod.entities.EntitiesRegister;
import net.earthspawn.mod.entities.classes.AcphinesEntity;
import net.earthspawn.mod.entities.classes.GoblinEntity;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.earthspawn.mod.entities.renderers.AcphinesRenderer;
import net.earthspawn.mod.entities.renderers.CrystalStalkerRenderer;
import net.earthspawn.mod.entities.renderers.GoblinRenderer;
import net.earthspawn.mod.entities.renderers.OuliskRenderer;
import net.earthspawn.mod.items.ItemRegister;
import net.earthspawn.mod.items.armors.classes.CrystalArmorItem;
import net.earthspawn.mod.items.armors.classes.TopazArmorItem;
import net.earthspawn.mod.items.armors.renderers.CrystalArmorRenderer;
import net.earthspawn.mod.items.armors.renderers.TopazArmorRenderer;
import net.earthspawn.mod.world.biomes.RegionData;
import net.earthspawn.mod.world.biomes.SurfaceRuleData;
import net.earthspawn.mod.world.generation.FlowerGeneration;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Earthspawn.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientRegisterSetup(FMLClientSetupEvent event) {
        //entity render setup
        EntityRenderers.register(EntitiesRegister.OULISK.get(), OuliskRenderer::new);
        EntityRenderers.register(EntitiesRegister.ACPHINES.get(), AcphinesRenderer::new);
        EntityRenderers.register(EntitiesRegister.GOBLIN.get(), GoblinRenderer::new);
        EntityRenderers.register(EntitiesRegister.CRYSTAL_STALKER.get(), CrystalStalkerRenderer::new);

        //transparent block render setup
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.GLADIOLUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.HALLOW_ROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.AMARYLLIS.get(), RenderType.cutout());

        //biome region setup
        event.enqueueWork(() ->
        {
            Regions.register(new RegionData(new ResourceLocation(Earthspawn.MOD_ID, "overworld"), RegionType.OVERWORLD, 5));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Earthspawn.MOD_ID, SurfaceRuleData.makeRules());
        });
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(EntitiesRegister.OULISK.get(), OuliskEntity.setAttributes());
        event.put(EntitiesRegister.ACPHINES.get(), AcphinesEntity.setAttributes());
        event.put(EntitiesRegister.GOBLIN.get(), GoblinEntity.setAttributes());
        event.put(EntitiesRegister.CRYSTAL_STALKER.get(), GoblinEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerArmorRenderer(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(TopazArmorItem.class, TopazArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(CrystalArmorItem.class, CrystalArmorRenderer::new);
    }
}
