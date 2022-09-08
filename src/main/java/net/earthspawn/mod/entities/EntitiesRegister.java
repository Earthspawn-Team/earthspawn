package net.earthspawn.mod.entities;

import net.earthspawn.mod.Earthspawn;
import net.earthspawn.mod.entities.classes.OuliskEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntitiesRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Earthspawn.MOD_ID);

    public static final RegistryObject<EntityType<OuliskEntity>> OULISK = ENTITY_TYPES.register("oulisk",
            () -> EntityType.Builder.of(OuliskEntity::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(new ResourceLocation(Earthspawn.MOD_ID, "oulisk").toString()));

    public static void registerSetup(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
